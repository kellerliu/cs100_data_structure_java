import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TreePractice {
	
	class TreeNode {
		int info;
		TreeNode left;
		TreeNode right;
		TreeNode (int s, TreeNode lt, TreeNode rt) { 
			info = s;
			left = lt;
			right = rt;
		}
	}

	
	/**
	 * Return true if and only if t has a root-to-leaf path that sums to target.
	 * @param t is a binary tree
	 * @param target is the value whose sum is searched for on some root-to-leaf path
	 * @return true if and only if t has a root-to-leaf path summing to target
	 */
	public boolean hasPathSum(TreeNode t, int target) {
		//Code goes here...
		
		return false;
	}
	
	/**
	 * Writes out a tree to a file in pre-order format.
	 * @param writer The FileWriter object
	 * @param root the root of the tree
	 */
	public void writeTree(FileWriter writer, TreeNode root) {
		try {
			writer.write(writeHelper(root));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Traverses a tree using pre-order traversal (root, left subtree, right subtree)
	 * @param node
	 * @return The information in the tree
	 */
	private String writeHelper(TreeNode node)
	{
		//Code goes here...
		return "";
	}	


	public static void main(String[] args) {
		TreePractice t = new TreePractice();

		TreeNode root = t.makeExample();

		System.out.println(t.hasPathSum(root, 27));
		System.out.println(t.hasPathSum(root, 28));
		System.out.println(t.hasPathSum(root, 22));
		System.out.println(t.hasPathSum(root, 18));
		System.out.println(t.hasPathSum(root, 19));

		// Output should be true, false, true, true, false
		
		try {
			FileWriter w = new FileWriter(new File("output.txt"));
			t.writeTree(w, root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//output.txt should match what is written in Output_Solution.txt
	}



	// Ignore anything below here...
	// ----------------------------------

	public TreeNode makeExample() {
		TreeNode leaf1 = new TreeNode(7, null, null);
		TreeNode leaf2 = new TreeNode(2, null, null);
		TreeNode leaf3 = new TreeNode(1, null, null);
		TreeNode parent1 = new TreeNode(11, leaf1, leaf2);
		TreeNode leaf4 = new TreeNode(13, null, null);
		TreeNode parent2 = new TreeNode(4, null, leaf3);
		TreeNode parent3 = new TreeNode(4, parent1, null);
		TreeNode parent4 = new TreeNode(8, leaf4, parent2);
		TreeNode root = new TreeNode(5, parent3, parent4);

		return root;
	}

}
