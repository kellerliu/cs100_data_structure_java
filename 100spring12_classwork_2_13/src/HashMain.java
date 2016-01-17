import java.io.*;
import java.util.Scanner;

import javax.swing.JFileChooser;


public class HashMain {
	
	 private static JFileChooser ourChooser = new JFileChooser(System
	            .getProperties().getProperty("user.dir"));
	
	
    public static void storeAll(IMapper mapper, Scanner s) {

        double start = System.currentTimeMillis();
        while (s.hasNext()){
            String str = s.next();
            if (mapper.containsKey(str)){
                mapper.put(str, mapper.get(str)+1);
            }
            else {
                mapper.put(str,1);
            }
        }
        double end = System.currentTimeMillis();
        double time = (end-start)/1000.0;
        System.out.printf("%s\t%1.3f\t%d\n", 
        		mapper.getClass().getName(),time,mapper.size());
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        int retval = ourChooser.showOpenDialog(null);

        if (retval == JFileChooser.APPROVE_OPTION) {
            File f = ourChooser.getSelectedFile();
            Scanner s1 = new Scanner(f);
            Scanner s2 = new Scanner(f);
            IMapper hash1 = new ArrayListHash();
            IMapper hash2 = new UtilMapHash();
            HashMain.storeAll(hash1,s1);
            HashMain.storeAll(hash2, s2);
        }
    }

}
