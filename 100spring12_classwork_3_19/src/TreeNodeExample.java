public class TreeNodeExample {

	MikesIntTreeNode root = null;

	public class MikesIntTreeNode {
		public int value;
		public MikesIntTreeNode left; // holds smaller tree nodes
		public MikesIntTreeNode right; // holds larger tree nodes

		public MikesIntTreeNode(int val) {
			value = val;
		}
	}

	public void add(int newValue) {
		if (root == null)
			root = new MikesIntTreeNode(newValue);
		else
			add(newValue, root);
	}

	// this add ensures that the node stays a binary search tree
	public void add(int newValue, MikesIntTreeNode current) {
		if (newValue < current.value) {
			if (current.left == null) {
				current.left = new MikesIntTreeNode(newValue);
			} else {
				add(newValue, current.left);
			}
		} else {
			// newValue >= myValue
			if (current.right == null) {
				current.right = new MikesIntTreeNode(newValue);
			} else {
				add(newValue, current.right);
			}
		}
	}

	public String toString() {
		return toString(root);
	}

	public String toString(MikesIntTreeNode current) {
		String leftString = "null";
		String rightString = "null";

		if (current.left != null)
			leftString = toString(current.left);
		if (current.right != null)
			rightString = toString(current.right);

		return current.value + " {L:" + leftString + ",R:" + rightString + "}";
	}

	public int computeHeight() {
		return computeHeight(root);
	}

	private int computeHeight(MikesIntTreeNode current) {
		if (current == null)
			return 0;
		int lResult = computeHeight(current.left);
		int rResult = computeHeight(current.right);
		if (lResult > rResult) {
			return lResult + 1;
		} else {
			return rResult + 1;
		}
	}

	// return the number of nodes in the tree
	public int countNodes() {
		return countNodes(root);
	}

	public int countNodes(MikesIntTreeNode current) {
		if (current == null) {
			return 0;
		}
		int lCount = countNodes(current.left);
		int rCount = countNodes(current.right);
		return lCount + rCount + 1;
	}

	public boolean containsNode(int value) {
		return containsNode(value, root);
	}

	// to start with, do NOT assume this is a binary search tree
	private boolean containsNode(int value, MikesIntTreeNode current) {
		// your code goes here
		// hint: base case...if the node is null, it does not contain the value
		if (current == null)
			return false;
		if (current.value == value)
			return true;
		return (containsNode(value, current.left) || containsNode(value,
				current.right));
	}

	public int findMax() {
		return findMax(root);
	}

	private int findMax(MikesIntTreeNode current) {
//binary search tree;
//		if(current.right!=null)
//			return findMax(current.right);
//		if(current.right==null)
//			return current.value;
//		return -1;
		
//a random tree
		if(current==null)
			return 0;	
		  return Math.max((Math.max(findMax(current.left),current.value)),findMax(current.right));	
		
	}

	// finds the largest value in the tree
	// to start with, do NOT assume this is a binary search tree

	public static void main(String[] args) {
		TreeNodeExample tree = new TreeNodeExample(); // LINE 1
		tree.add(5);
		tree.add(7);
		tree.add(2);
		tree.add(9);
		tree.add(6);
		System.out.println(tree);
		System.out.println("Height " + tree.computeHeight()); // should print 3
		System.out.println("Num nodes " + tree.countNodes()); // should print 5
		System.out.println("Contains 6 " + tree.containsNode(6)); // should
																	// print
																	// true
		System.out.println("Contains 0 " + tree.containsNode(0)); // should
																	// print
																	// false
		System.out.println("Max " + tree.findMax()); // should print 9
	}
}
