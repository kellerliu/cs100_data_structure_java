import java.util.PriorityQueue;
import java.util.Random;


public class TreeScore {
    public class MikesIntTreeNode implements Comparable<MikesIntTreeNode>{
        public int value;
        public MikesIntTreeNode left;
        public MikesIntTreeNode right;
    
        public MikesIntTreeNode(int val) { value = val; }       
        public int compareTo (MikesIntTreeNode other){    	
            return other.value-value;	            	
            }


    }
    
   
    
    public void printPreorder(MikesIntTreeNode t) {
        if(t == null) {
            System.out.print("X ");
        } else {
            System.out.print(t.value + " ");
            printPreorder(t.left);
            printPreorder(t.right);
        }
    }
    
    public MikesIntTreeNode makeRandomTree(Random r, int size) {
        if(size == 0) return null;
        MikesIntTreeNode root = new MikesIntTreeNode(r.nextInt(10));
        int rightSize = (size - 1)/2; 
        int leftSize = (size - 1)/2 + ((size - 1) % 2);
        root.left = makeRandomTree(r,leftSize);
        root.right = makeRandomTree(r,rightSize);
        return root;
    }


    public int greedyTreeScore(MikesIntTreeNode root, int nodeNum) {
        PriorityQueue <MikesIntTreeNode> myQueue=new PriorityQueue<MikesIntTreeNode>(); 
    	if(nodeNum<=0)
    		return 0;    	
    	int sum=0;    	    	
    	myQueue.add(root);
    	
    	for(int i=0;i<nodeNum;i++){	
    	MikesIntTreeNode bigNode= myQueue.remove();
    	sum+=bigNode.value;

    	if(bigNode.left!=null)
    	myQueue.add(bigNode.left);
    	
    	if(bigNode.right!=null)
    	myQueue.add(bigNode.right);
    	}   	
    	return sum;
    }
    
    public int idealTreeScore(MikesIntTreeNode root, int nodeNum) {
    int sum=0;
    
    
    
    return sum;
    }
    
    
    
    
    public static void main(String[] args)
    {
        Random r = new Random(123);
        TreeScore t = new TreeScore();
        MikesIntTreeNode root = t.makeRandomTree(r,15);
       // uncomment if you want to see the preorder traversal
        t.printPreorder(root);
        
        //should print 19
        System.out.println("\n"+t.greedyTreeScore(root, 4));
        
    }
}




//HINT 1: You'll want a priority queue of MikesIntTreeNodes








//HINT 2: You'll want a priority queue of MikesIntTreeNodes.  
// You'll need to make MikesIntTreeNodes Comparable to do that.
// The thought here is that the biggest element will be on the top
// you'll take it, and add it's children to the queue