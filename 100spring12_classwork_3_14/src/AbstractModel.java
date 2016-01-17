import java.util.*;
import java.io.Reader;

/**
 * This class supplies a bare minimum model implementation,
 * basically allowing views to be added, removed, and
 * notified of messages, errors, and other model information.
 * 
 * @author Owen Astrachan
 *
 */
public abstract class AbstractModel implements IModel
{
    private ArrayList<IView> myViews;
    
    public AbstractModel(){
        myViews = new ArrayList<IView>();
    }
    
    public void addView(IView view){
        myViews.add(view);
    }
    
    public void removeView(IView view){
        myViews.remove(view);
    }
    
    public void showViewsError(String s){
        for(IView view : myViews){
            view.showError(s);
        }
    }
    
    
    /**
     * Clear all views.
     */
    public void clear(){
        for(IView view : myViews){
            view.clear();
        } 
    }
    
    /**
     * Notify all views by sending a string to each view's update method.
     * @param s is the string sent to each view
     */
    public void notifyViews(String s){
        for(IView view : myViews){
            view.update(s);
        }
    }
    
    public void messageViews(String s){
        for(IView view : myViews){
            view.showMessage(s);
        }
    }
    
    public void initialize(Reader r){
        initialize(new Scanner(r));
    }
}
