import java.util.Collection;
 
public interface IView
{
    /**
     * Display an information message in this view.
     * By convention this should not require
     * user-interaction, i.e., no modal dialog.
     * @param s is the message displayed
     */
    public void showMessage(String s);
    
    /**
     * Display an error message in this view. For GUI views
     * this could pop up an error dialog.
     * @param s is the error message displayed
     */
    public void showError(String s);
    
    /**
     * Display s in some way.
     */
    public void update(String s);
    
    /**
     * Clear the view.
     */
    public void clear();
}
