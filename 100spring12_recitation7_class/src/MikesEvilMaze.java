import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MikesEvilMaze {

    
    public interface EvilNode
    {
        public List<EvilNode> getPaths();
        public boolean isExit();
    }
    
    public EvilNode getStartingNode()
    {
        return start;
    }
    
    
    
    // THERE IS NO REASON FOR YOU TO LOOK DOWN HERE!
    // THE EVIL OF MIKES EVIL MAZE IS NOT FOR YOUR EYES
    
    EvilNode start;
    
    public MikesEvilMaze(int evilness)
    {
        start = new MostlyEvilNode(evilness % 7 + 1);
    }
    
    Random r = new Random();
    
    private List<EvilNode> pathList()
    {
        int numPaths = r.nextInt(5) + 2;
        ArrayList<EvilNode> result = new ArrayList<EvilNode>();
        for(int i = 0; i < numPaths; i++) {
            result.add(new ReallyEvilNode());
        }
        return result;
    }
    
    private class ReallyEvilNode implements EvilNode
    {

        List<EvilNode> paths;
        
        @Override
        public List<EvilNode> getPaths() {
            if (paths == null)
                paths = pathList();
            return paths;
        }

        @Override
        public boolean isExit() {
            return false;
        }
        
    }
    
    private class MostlyEvilNode implements EvilNode
    {

        int myDistance;
        List<EvilNode> paths;
        
        public MostlyEvilNode(int distance)
        {
            myDistance = distance;
        }
        
        public boolean isExit() {
            if (myDistance == 0) return true;
            return false;
        }

        public List<EvilNode> getPaths() {
            if (paths == null) {
                if (myDistance == 0) {
                    paths = new ArrayList<EvilNode>();
                } else {
                    List<EvilNode> result = pathList();
                    result.set(r.nextInt(result.size()), new MostlyEvilNode(
                            myDistance - 1));
                    paths = result;
                }
            }
            return paths;
        }
        
    }
}
