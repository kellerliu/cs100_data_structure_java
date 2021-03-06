import java.util.*;

/**
 * This is the base class for a Jotto model. The idea is that you (the student)
 * will implement the stub methods that are currently marked TODO to create a
 * program that plays Jotto. You'll likely need to add state or instance
 * variables, and perhaps helper methods as well.
 * <P>
 * <OL>
 * <LI>
 * The method <code>newGame</code> clears/initializes state so that the computer
 * can begin to guess the user's word.</LI>
 * <P>
 * <LI>
 * The method <code>processResponse</code> is called by the view-controller when
 * the model is guessing the human's secret word and the human responds with the
 * number of letters in common with the last word guessed by the computer. The
 * model then generates a new guess or decides the game is over, e.g., when the
 * computer has guessed correctly (number sent is 6) or there are no more words
 * to guess.</LI>
 * <P>
 * <LI>
 * You may want to implement some private, helper methods that are called in the
 * code below to avoid duplicate code, that will depend on what you write.</LI>
 * </OL>
 * 
 * @author ola
 * @version 1.2, 2011, revised from Abstract class last used in 2006, now
 *          concrete with stubs students implement
 */

public class JottoModel {
	private JottoViewer myView; // view and controller
	private ArrayList<String> myWordList; // dictionary of legal words
	// TODO: add state as appropriate
	private ArrayList<String> tempList; // updating copy
	private ArrayList<String> guessList;
	private ArrayList<Integer> scoreList;
	private Set<Character> badletterList; //
	private String badletters;// for commonCount convenience
	private Set<Character> goodletterList; //

	Random random;
	String guess;
	int guesscounter;
	boolean smart = false;

	/**
	 * Initialize the model appropriately.
	 */
	public JottoModel() {
		myWordList = new ArrayList<String>();
	}

	/**
	 * Associate a view with this model.
	 * 
	 * @param view
	 *            is view that's notified when model changes
	 */
	public void addView(JottoViewer view) {
		myView = view;
	}

	/**
	 * Display a dialog box the user must dismiss as part of the view, e.g.,
	 * when the game is over.
	 * 
	 * @param s
	 *            is the string displayed in the modal dialog
	 */

	private void showModalMessage(String s) {
		myView.showModalInfo(s);
	}

	/**
	 * Display a small message in the view's message area.
	 * 
	 * @param s
	 *            is message displayed
	 */
	private void messageViews(String s) {
		myView.showMessage(s);
	}

	/**
	 * Communicate the guess to the view.
	 * 
	 * @param s
	 *            is the guess
	 */
	private void doGuess(String s) {
		myView.processGuess(s);
	}

	/**
	 * Read words and store them for guessing and validation when user guessing
	 * secret word.
	 * 
	 * @param s
	 *            is scanner that is source of words
	 */
	public void initialize(Scanner s) {
		myWordList.clear();
		while (s.hasNext()) {
			myWordList.add(s.next());
		}
		messageViews("choose new game menu");
	}

	/**
	 * Process input from the user. The input is the number of letters in common
	 * with the user's secret word. This method does rudimentary analysis of
	 * response for legality e.g., number in range, and then calls unimplemented
	 * methods that students must write.
	 * 
	 * @param o
	 *            is the response from the user. This is a String representing
	 *            an int that's the number of letters in common with last word
	 *            guessed by computer.
	 */
	public void process(Object o) {
		String response = (String) o;
		if (response.length() == 0) {
			myView.badUserResponse("not a number");
			messageViews(response + " is not a number");
			return;
		}
		try {
			int n = Integer.parseInt(response);
			if (n < 0 || n > 6) {
				myView.badUserResponse("out of range " + n);
				messageViews(response + " is out of range");
				return;
			}
			processResponse(n);
		} catch (NumberFormatException e) {
			myView.badUserResponse("not a number: " + response);
			messageViews(response + " is not a number");

		}
	}

	/**
	 * Make the view not respond to user input except by choosing new game or
	 * quit (call view method that disables user input).
	 */
	public void stopGame() {
		myView.setStopped();
		smart = false;
	}

	/**
	 * A human has entered the number of letters in common for a
	 * computer-generated guess, likely the last guess generated by the model
	 * and sent to the view. Process the number of letters in common and then
	 * generate a new guess or otherwise notify the view of the state of the
	 * game.
	 * 
	 * @param n
	 *            is the number of letters in common with the last
	 *            computer-generated guess
	 */

	public void processResponse(int n) {
		// TODO: you implement this

		if (n == 6) {
			showModalMessage("I guessed your word! it is " + guess);
			stopGame();
			return;
		} else {
			tempList.remove(guess);
			for (int i = 0; i < tempList.size(); i++) {
				if (n != commonCount(guess, tempList.get(i))) {
					tempList.remove(i);
					i--;
				}
			}
			if (smart) {

				guessList.add(guess);
				scoreList.add(n);
				if (n == 0) {
					badletters += guess;
					char[] bad = badletters.toCharArray();
					for (char temp : bad)
						badletterList.add(temp);
				}

				for (int i = 0; i < guessList.size(); i++) {
					if (commonCount(guessList.get(i), badletters)
							+ scoreList.get(i) == 5) {
						char[] candidate = guessList.get(i).toCharArray();
						for (char temp : candidate) {
							if (!badletterList.contains(temp))
								goodletterList.add(temp);
						}
					}
				}
				int smartremove=0;
				
				for (int i = 0; i < tempList.size(); i++) {

					ArrayList<Character> tempcharlist = new ArrayList<Character>();

					char[] temp = tempList.get(i).toCharArray();
					for (char a : temp)
						tempcharlist.add(a);

					for (char good : goodletterList) {
						if (!tempcharlist.contains(good)) {
							tempList.remove(i);
							i--;
							smartremove++;
						}
					}
				}
				if(smartremove>0)
					showModalMessage(smartremove+" smart word removal");
				
			}

		}

		if (tempList.isEmpty()) {
			showModalMessage("give up! either I do not know your word or there were conflicting inputs");
			stopGame();
		}
		guesscounter--;
		if (guesscounter == 0) {
			showModalMessage("you win! computer runs out of guesses!");
			stopGame();
		}
		random = new Random();
		guess = tempList.get(random.nextInt(tempList.size()));

		doGuess(guess);

		smartmessage();
	}

	/**
	 * Start a new game -- set up state and generate first guess made by
	 * computer.
	 */
	public void newGame() {
		// TODO: you implement this
		guesscounter = myView.GUESSES;
		badletterList = new HashSet<Character>();
		goodletterList = new HashSet<Character>();
		badletters = "";
		guessList = new ArrayList<String>();
		scoreList = new ArrayList<Integer>();
		tempList = new ArrayList<String>();
		tempList.addAll(myWordList);
		random = new Random();
		guess = myWordList.get(random.nextInt(myWordList.size()));

		if (smart) {
			showModalMessage("you chose a smarter mode for guessing this word");
		}
		doGuess(guess);
		smartmessage();
	}

	/**
	 * message report on the current mode of guessing and the guesses left.
	 * 
	 */
	public void smartmessage() {
		if (smart)
			messageViews(guesscounter - 1 + " guesses left in smart guess");
		else
			messageViews(guesscounter - 1 + " guesses left in normal guess");
	}

	/**
	 * Called by View/Menu to play a smarter game than the naive, eliminate
	 * words from list version of the game. For Compsci 100 in Fall 2011 this is
	 * an extra credit function
	 */
	public void playSmarter() {
		// TODO: extra credit

		smart = true;
		if (smart) {
			showModalMessage("you chose a smarter mode");
		}

	}

	/**
	 * Returns number of letters in common to a and b, ensuring each common
	 * letter only counts once in total returned.
	 * 
	 * @param a
	 *            is one string being compared
	 * @param b
	 *            is other string being compared
	 * @return number of letters in common to a and b
	 * Note by Junfei: k&j redefined,b is the standard for a to compare
	 */
	
	private int commonCount(String a, String b) {
		char[] aletters = a.toCharArray();
		char[] bletters = b.toCharArray();
		int count = 0;
		for (int k = 0; k < bletters.length; k++) {
			for (int j = 0; j < aletters.length; j++) {
				if (aletters[j] == bletters[k]) {
					aletters[j] = '*'; // don't use this again
					count++;
					break;
				}
			}
		}
		return count;
	}
}
