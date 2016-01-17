import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class DirectoryExample {

    public File getEclipseRoot() throws IOException
    {
        File startingDirectory = new File (".").getCanonicalFile();
        File current = startingDirectory;
        while(!current.getName().equals("workspace") && current.getParentFile() != null) {
            current = current.getParentFile();
        }
        return current;
    }
    
    // for BONUS version
    // takes a file to print, and the number of levels you want it indented
    public void dumpIndentedDirectoryName(int indentLevel, File file)
    {
        for(int i = 0; i < indentLevel*3; i++)
            System.out.print(' ');
        System.out.println(file.getName());
    }
    
    public void dumpDirectoryName(File file) throws IOException
    {
        System.out.println(file.getCanonicalPath());
    }
    
    // BONUS!
    public void dumpIndentedEclipseDirectories() throws IOException
    {
        // only try this one once you've finished dumpEclipseDirectories
        //
        // this one should work the same way as dumpEclipseDirectories
        // EXCEPT you use dumpIndentedDirectoryName (see above)
        // the output looks like:
        //
        //  workspace
        //     100fall11_recitation8_classwork
        //        src
        //        bin
        //     100fall11_recitation8
        //        src
        //        bin
        //
        // To do this successfully you'll need to store a marker in your stack
        // to know when to decrease the indent level

    }
    
    public void dumpEclipseDirectories() throws IOException
    {
        
        //to get what you need you need to know about 2 file functions
        // 
        // file.isDirectory() returns true if the file is a directory
        // file.listFiles() returns an array of File[] that's all the
        //     files and subdirectories within a particular directory
        //
        // To print out the name of a particular directory, use
        //     dumpDirectoryName(aFile)
        
        File startingPoint = getEclipseRoot();
        Stack <File> s= new Stack <File>();
        HashMap<File, Integer> m=new HashMap<File, Integer>();
        s.add(startingPoint);
        m.put(startingPoint, 0);
        
        while(!s.isEmpty()){
        	File current=s.pop();       	
        	
        	//dumpDirectoryName(current);
        	dumpIndentedDirectoryName(m.get(current), current);
        	
        		for(File f: current.listFiles() ){
        			if(f.isDirectory()){
        				s.add(f);
        				m.put(f, m.get(current)+1);
        			}
        		}
        		
        		
        	}
        	
        
        
        
        
        // your code goes here
        
    }
    
    public static void main(String[] args) throws IOException
    {
        DirectoryExample d = new DirectoryExample(); 
        d.dumpEclipseDirectories();
    }
}
