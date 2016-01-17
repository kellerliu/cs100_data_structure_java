import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class MikesVerboseHuffProcessor implements IHuffProcessor {
    
    private HuffViewer myViewer;
    
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
        
        BitOutputStream bitsOut = new BitOutputStream(out);
        myViewer.update("Outputting 101");
        
        //look at the comments in BitOutputStream to see how writeBits works
        bitsOut.writeBits(1, 1);
        bitsOut.writeBits(1, 1);
        bitsOut.writeBits(1, 1);
        
        // your code is supposed to return the number of bits processed
        // but mine doesn't do that
        return 0;
    }


    // Takes in an input stream
    // Returns an array of size IHuffConstants.ALPH_SIZE
    // each element of the array corresponds to to the number 
    // of that letter that occur in the file
    public int[] countLetters(InputStream raw) throws IOException
    {
       //Here's how you read one character from a file
        int[] result = new int[IHuffConstants.ALPH_SIZE];
        BitInputStream in = new BitInputStream(raw);
        int currentWord = in.readBits(IHuffConstants.BITS_PER_WORD);                        
        //TODO: ...your code here
           
        while(currentWord!= -1){
        	result[currentWord]++;
            currentWord = in.readBits(IHuffConstants.BITS_PER_WORD);                        

        }
        
        return result;
    }
    
    public String treeToString(TreeNode root) {
//    	String str="";
//    	LinkedList<TreeNode> q = new LinkedList<TreeNode>();
//    	q.add(root);
//    	while(!q.isEmpty()){
//    		TreeNode e = q.remove(0);
//    		str+=e.myValue+"\n";
//    		if (e.myLeft!=null)
//    			q.add(e.myLeft);
//    		if (e.myRight!=null)
//    			q.add(e.myRight);
//    	}
//    	return String.format(root.myValue + " \n"+ treeToString(root.myLeft)+" "+ treeToString(root.myRight));
    	
    	if(root==null)
    		return "*";
    	
    	return root.myValue + " L"+ treeToString(root.myLeft)+" R"+ treeToString(root.myRight);
    	
    	
    	
    	
        
        // hey, you know what...I bet I could probably modify the
        // algorithm I used to solve DrawTree to print this tree
        // (But any reasonably understandable way to print a tree would work)
        //  return "I don't know how to print a tree!";
    }
    
    public int preprocessCompress(InputStream in) throws IOException {
        //This is probably where you want to generate your Map of character to codes
        //Step 1: Count number of each character in the file
        int[] letterCount = countLetters(in);
        for(int i = 0; i < letterCount.length; i++) {
            if(letterCount[i] > 0)
                myViewer.update("Letter " + i + "(" + (char) i + "): " + letterCount[i]);
        }
        //Step 2: Generate the Huffman tree
        TreeNode root = null;
        PriorityQueue<TreeNode> q = new PriorityQueue<TreeNode>();
        // Your code goes here
        for(int i = 0; i < letterCount.length; i++) {
            if(letterCount[i] > 0)
            	q.add(new TreeNode(i, letterCount[i]));
        }
        
        q.add(new TreeNode(256,1));        
        while(q.size()>1){
        	TreeNode t1=q.poll();
        	TreeNode t2=q.poll();       	
        	q.add(new TreeNode(-1, t1.myWeight+t2.myWeight, t1,t2));       	
        }        
        root=q.poll();
        
        
        myViewer.update("\n\nHUFF TREE LOOKS LIKE: \n\n" + treeToString(root));
        
        //Step 3: Use the tree to generate the mapping of character to encoding
        
        //I personally found it easiest to map a character to a string of 0s and 1s
        //Then when I output I just output the 1 or 0 one bit at a time
        Map<Integer,String> mapping = new TreeMap<Integer, String>();
        
        //just an example
       // mapping.put(97, "1001");
        doMap(mapping, root, "");
                
        myViewer.update("\n\nTHE CODE TABLE LOOKS LIKE: \n\n");
        for(Integer character : mapping.keySet()) {
            myViewer.update("Letter " + character + "(" + (char) character.intValue() + "): " + mapping.get(character));
        }        
        
        // the final step of the process is implemented in the compress method       
        //throw new IOException("preprocess not implemented");        
        // your code is supposed to return the number of bits processed
        // but mine doesn't do that
        return 0;
    }

    private void doMap(Map<Integer, String> m, TreeNode r, String s) {
		// TODO Auto-generated method stub
    	if (r==null) return;
    	if(r.myLeft==null&&r.myRight==null)
    	m.put(r.myValue, s);    	
    	if	(r.myLeft!=null)
    		doMap(m, r.myLeft, s+'0');
    	if (r.myRight!=null)
    		doMap(m, r.myRight, s+'1');
	}


	public void setViewer(HuffViewer viewer) {
        myViewer = viewer;
    }

    // The first thing you'll want to do is check to see if IHuffConstants.MAGIC_NUMBER 
    // is the first number in the file.  (hint: IHuffConstants.MAGIC_NUMBER is 
    // IHuffConstants.BITS_PER_INT bits long)
    public int uncompress(InputStream in, OutputStream out) throws IOException {
        //Step 1: Check for magic number
        //Step 2: Load the counts for each character
        // hint: once you're finished, I would print out those counts so you can verify
        // everything is right
        //Step 3: Create the tree
        //  Couldn't hurt to print out the tree too
        //Step 4: Use the tree to generate the mapping of bits to characters
        //  Yep, print that out too
        //Step 5: Uncompress that file
       
        //throw new IOException("uncompress not implemented");
        return 0;
    }
    
    private void showString(String s){
        myViewer.update(s);
    }

}
