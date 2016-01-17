



public class RecurrenceRelationProblems {

    public class TreeNode {
        public int myValue;
        public TreeNode myLeft; // holds smaller tree nodes
        public TreeNode myRight; // holds larger tree nodes
    
        public TreeNode(int val) { myValue = val; }
    }
    
    public int treeA(TreeNode root)
    {
        if(root == null)
            return 2;
        else
            return treeA(root.myLeft) / treeA(root.myRight);
    }
    // 1. what is the big O of treeA on an N node tree that is height-balanced?
    // 2. what is the big O of treeA on an N node Tree that is *not* height-balanced?
    
    public int treeB(TreeNode root)
    {
        if(root == null) return 0;
        
        int result = 0;
        
        if(treeA(root) > 1)
            result++;
        
        return result + treeB(root.myLeft) + treeB(root.myRight);
    }
    // 3. what is the big O of treeB on an N node Tree that is height-balanced?

    public int treeC(TreeNode root) {
        if(root == null) return 77;
        if(root.myValue == 77)
            return treeC(root.myRight);
        else
            return treeC(root.myLeft);
    }
    // 4. what is the big O of treeC on an N node tree that is height-balanced?
    // 5. what is the big O of treeC on an N node Tree that is *not* height-balanced?
    
}
