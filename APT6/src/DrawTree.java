import java.util.ArrayList;

public class DrawTree {
          ArrayList<String> ls = new ArrayList<String>();
          int[] par;
          String[] ns;
          
          public String[] draw(int[] parents, String[] names) {
            par = parents; 
            ns = names;
            addChildren(-1, "");
            return ls.toArray(new String[ls.size()]);
          }
          
          public void addChildren(int p, String prefix) {
            int n = 0;
            for(int i=0; i<par.length;i++) 
            	if(par[i]==p) n++;
            for(int j=0; j<par.length;j++) {
              if(par[j] != p) 
            	  continue;
              ls.add(prefix + "+-" + ns[j]);
              n--;
              
              if(n==0)
               addChildren(j, prefix + "  ");
              else
            	  addChildren(j, prefix + "| ");
            }
          }
}


