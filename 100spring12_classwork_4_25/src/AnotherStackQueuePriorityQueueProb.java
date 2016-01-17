import java.util.LinkedList;

public class AnotherStackQueuePriorityQueueProb {

    
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int v, TreeNode l, TreeNode r) {
            left = l;
            right = r;
            value = v;
        }
        
        public TreeNode(int v) {
            
            value = v;
        }
     }
    
    
    //Imagine you have a binary tree with at least one element
    //return the value of the tree's "deepest" leaf (that is the
    //leaf furthest from the root)
    //
    //This problem can be solved with recursion (but it's ugly)
    //It's quite naturally a stack/queue/priority queue problem
    //You could also think of it as a graph traversal problem
    //I would call it "furthest node" in that case
    //
    //If the tree has several equally deep leafs, any one of them
    //is a valid return
    public int valueOfDeepestLeaf(TreeNode root) {
    	LinkedList <TreeNode> q= new LinkedList<TreeNode>();
    	q.add(root);
    	TreeNode last=root;
    	while(!q.isEmpty()){
    		last=q.poll();
    		if (last.left!=null)
    		q.add(last.left);
    		if(last.right!=null)
    		q.add(last.right);    		
    	}
        return last.value;
    }
    

    
    public static void main(String[] args) {
        TreeNode n = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null));
        /** Tree looks like:
         *             1
         *            / \
         *           2   3
         *              /
         *             4
         */
         
        AnotherStackQueuePriorityQueueProb p = new AnotherStackQueuePriorityQueueProb();
        System.out.println(p.valueOfDeepestLeaf(n));
        
    }

}
