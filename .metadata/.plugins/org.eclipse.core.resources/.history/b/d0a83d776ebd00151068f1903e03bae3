
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;
	
    public TreeNode(int v) {
        val = v;
    }
    
    public boolean addNode(int newNodeValue)
    {    
		if(this == null)
		{
			return false;
		}
		
		boolean ret = false;	
		
    		if(newNodeValue == val)
    		{
    			ret = false;
    		}
    		else if(newNodeValue < val)
    		{
    			if(left == null)
    			{
    				left = new TreeNode(newNodeValue);
    				ret = true;
    			}
    			else
    			{
    				left.addNode(newNodeValue);
    			}
    		}
    		else
    		{
    			if(right == null)
    			{
    				right = new TreeNode(newNodeValue);
    				ret = true;
    			}
    			else
    			{
    				right.addNode(newNodeValue);
    			}
    		}    		
    		return ret;
    }
    
}
