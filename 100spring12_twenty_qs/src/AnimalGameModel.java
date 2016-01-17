/**
 * @author Junfei Liu
 * @date TOMORROW
 */
import java.io.*;
import java.util.*;

public class AnimalGameModel implements IAnimalModel {
	private AnimalGameViewer myView;
	private AnimalNode myRoot, myCurrentNode;
	private int myNodeCount;
	private ArrayList<String> myPath;
	private String knowledge;

	@Override
	public void setView(AnimalGameViewer view) {
		// TODO Auto-generated method stub, DONE!
		myView = view;
	}

	@Override
	public void initialize(Scanner s) {
		// TODO Auto-generated method stub
		myView.setEnabled(true); // Enable myClickables
		myNodeCount = 0;
		myRoot = readAll(s);
		newGame();
	}

	// help method to read tree and return root;
	public AnimalNode readAll(Scanner s) {
		if (s.hasNextLine()) {
			myNodeCount++;// count nodes
			AnimalNode addNode;
			String line = s.nextLine();
			// process line
			if (line.startsWith("#Q:")) {
				AnimalNode left = readAll(s);
				AnimalNode right = readAll(s);
				addNode = new AnimalNode(line.substring(3), left, right);
				return addNode;
			} else {
				addNode = new AnimalNode(line, null, null);
				return addNode;
			}
		}
		return null;
	}

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		myView.showMessage("nodes in tree read: " + myNodeCount);
		myCurrentNode = myRoot;
		myView.update(myCurrentNode.info);
		myPath = new ArrayList<String>();
		String s = "Please phrase as a question, e.g., \n"
				+ "Are you a rhinoceros?\n"
				+ "Are you 'The Grapes of Wrath'\n\n" + "Your path so far:";
		myPath.add(s);
	}

	@Override
	public void processYesNo(boolean yes) {
		// TODO Auto-generated method stub, yes or no, left or right
		if (yes) {
			if (myCurrentNode.yesLink == null && myCurrentNode.noLink == null) {
				myView.showDialog("I win !!!");
			} else {
				myPath.add("You answered Yes to " + myCurrentNode.info);
				myCurrentNode = myCurrentNode.yesLink;
				myView.update(myCurrentNode.info);
			}
		} else {
			myPath.add("You answered No to " + myCurrentNode.info);
			if (myCurrentNode.noLink != null) {
				myCurrentNode = myCurrentNode.noLink;
				myView.update(myCurrentNode.info);
			}

			else {
				myView.update(myPath);
				myView.getNewInfoLeaf();
				knowledge = "To add new knowledge to this game\n"
						+ "you must create a new question that differentiates\n"
						+ "from my guess and what you were thinking of.\n\n"
						+ "What has an YES answer for:\n "
						+ myCurrentNode.yesLink.info
						+ "\nAnd a No answer for:\n"
						+ myCurrentNode.noLink.info;

				myView.update(knowledge);
				myView.getDifferentiator();
				newGame();

			}
		}
	}

	@Override
	public void addNewKnowledge(String question) {
		// TODO Auto-generated method stub

		myCurrentNode.info = question;

	}

	@Override
	public void addNewQuestion(String noResponse) {
		// TODO Auto-generated method stub
		// help method for getNewInfoLeaf
		myCurrentNode.yesLink = new AnimalNode(myCurrentNode.info, null, null);
		myCurrentNode.noLink = new AnimalNode(noResponse, null, null);
		myNodeCount = myNodeCount + 2;
		
	}

	@Override
	public void write(FileWriter writer) {
		// TODO Auto-generated method stub
		doWrite(writer, myRoot);
	}

	private void doWrite(FileWriter writer, AnimalNode root) {
		// add help method for write()
		try {
			if (root.yesLink == null && root.noLink == null) {
				writer.write(root.info + "\n");
			} else {
				writer.write("#Q:" + root.info + "\n");
				doWrite(writer, root.yesLink);
				doWrite(writer, root.noLink);
			}
		} catch (IOException e) {
			myView.showError("Couldn't write to file.");
		}
	}

}
