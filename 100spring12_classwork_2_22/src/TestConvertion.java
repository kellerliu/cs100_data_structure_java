
public class TestConvertion {
		
	public static void printAllNodes(TreeNode head) {
		if(head != null){
			System.out.print(head.val);
			head = head.next;
		};
		while (head != null) {
			System.out.print("-->" + head.val );
			head = head.next;
		}
		System.out.println();
	}
    
	public static void main (String[] args) {
		
		BSTtoLinkedList test = new BSTtoLinkedList();
		
		TreeNode root = new TreeNode(10);
		root.addNode(8);
		root.addNode(2);
		root.addNode(9);
		root.addNode(1);
		root.addNode(4);
		root.addNode(3);
		root.addNode(6);
		root.addNode(5);
		root.addNode(7);
		root.addNode(11);
		root.addNode(13);
		root.addNode(12);

		TreeNode root2 = new TreeNode(100);
		root2.addNode(80);
		root2.addNode(20);
		root2.addNode(90);
		root2.addNode(10);
		root2.addNode(40);
		root2.addNode(30);
		root2.addNode(60);
		root2.addNode(50);
		root2.addNode(70);
		root2.addNode(110);
		root2.addNode(130);
		root2.addNode(120);
		
		TreeNode head = test.flattenInorder(root);
		printAllNodes(head);
		
		TreeNode head2 = test.flattenInorder(root2);
		printAllNodes(head2);
			
	}
}
