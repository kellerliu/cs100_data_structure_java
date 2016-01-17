

public class RecurrenceRelationProblems {

    
    public int treeA(TreeNode root)
    {
        if(root == null)
            return 2;
        else
            return treeA(root.myLeft) / treeA(root.myRight);
    }
    // 1. what is the big O of treeA on an N node tree that is height-balanced?
    // T(N)=o(1)+2* T(N/2)=o(N)
    // 2. what is the big O of treeA on an N node Tree that is *not* height-balanced?
    //   T(N)=o(1)+T(N-1)=o(N)
    
    
    
    
    public int treeB(TreeNode root)
    {
        if(root == null) return 0;
        
        int result = 0;
        
        if(treeA(root) > 1)
            result++;
        
        return result + treeB(root.myLeft) + treeB(root.myRight);
    }
    // 3. what is the big O of treeB on an N node Tree that is height-balanced?
    // T(Nb)=o(Na)+2*T(Nb/2)      O(nlogN)
    
    
    
    public int treeC(TreeNode root) {
        if(root == null) return 77;
        if(root.myValue == 77)
            return treeC(root.myRight);
        else
            return treeC(root.myLeft);
    }
    // 4. what is the big O of treeC on an N node tree that is height-balanced?
    // T(N)=T(N/2)+O(1)       O(logN)
    // 5. what is the big O of treeC on an N node Tree that is *not* height-balanced?
    
   // T(N)=T(N-1)+O(1)        o(N)
    
}
