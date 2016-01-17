import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JMenu;



/**
 * SimpleViewer augmented with menus and controls
 * for user-guesses computer's word Jotto game.
 * @author Owen Astrachan
 * @version Sep 12, 2004
 */
public class BlobViewer extends SimpleViewer{

    /**
     * Constructor simply calls super, nothing unique here.
     * @param title
     * @param prompt
     */
    public BlobViewer(String title, String prompt) {
        super(title, prompt);
        myOutput.setFont(new Font("Monospaced", Font.PLAIN,10));
    }
    
    /**
     * Override menu-maker so as to add a new menu
     * to the standard/default menu. Note: constructs
     * parent menu and adds new game menu to it.
     */
    protected JMenu makeFileMenu(){
        JMenu fileMenu = super.makeFileMenu();
        fileMenu.add(new AbstractAction("count blobs"){
        		public void actionPerformed(ActionEvent ev){
        			BlobModel bm = (BlobModel) myModel;	
    			    doCount(bm);
        		}
        });
        fileMenu.add(new AbstractAction("new blobs"){
			public void actionPerformed(ActionEvent ev){
			    BlobModel bm = (BlobModel) myModel;	
			    initialize(bm);
			}
		    });
        return fileMenu;
    }
    
    private void doCount(BlobModel bm){
    	String size = JOptionPane.showInputDialog("blob size? ","5");
		bm.process(size);
    }

    private void initialize(BlobModel bm){

    		String rows = JOptionPane.showInputDialog("# rows", "20");
    		String cols = JOptionPane.showInputDialog("# columns", "40");
    		int nrows = 0, ncols=0, nblobs=0;
    		try{
    			nrows = Integer.parseInt(rows);
	    	    ncols = Integer.parseInt(cols);
	    		int dim = nrows*ncols;
	    		String blobs = JOptionPane.showInputDialog("# blobs out "+dim,""+dim/5);
	    		nblobs = Integer.parseInt(blobs);
	    		bm.initialize(nrows,ncols,nblobs);
    		}
    		catch (NumberFormatException e){
    			// number format problem
    		} 
    }

}
