
public class BSTtoLinkedList {
		
	private static TreeNode prev = null;
	private static TreeNode head = null;
	
	private static void flattenInorder_impl(TreeNode root) {
	  if (root == null) 
	  {
		  return;
	  }
	  
	  flattenInorder_impl(root.left);
	  
	  if (head == null) 
	  {
		  head = root;
	  }
	  if (prev != null) 
	  {
		  prev.next = root;
	  }
	  prev = root;
	  
	  flattenInorder_impl(root.right);
	}
	
	public TreeNode flattenInorder(TreeNode root) {
		prev = null;
		head = null;
		flattenInorder_impl(root);
		TreeNode ret = head;
		prev = null;
		head = null;
		return ret;		
	}
	
}
