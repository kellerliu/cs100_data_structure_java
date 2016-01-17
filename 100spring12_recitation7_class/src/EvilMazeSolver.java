import java.util.*;
import java.util.Random;


public class EvilMazeSolver {

    
    private int distanceToExit(MikesEvilMaze maze) {
        
        // hint: you'll want a queue
        Queue<MikesEvilMaze.EvilNode> queue = new LinkedList<MikesEvilMaze.EvilNode>();
        
        // hint: you'll want to keep track of how far each node is from the start
        HashMap<MikesEvilMaze.EvilNode, Integer> distance = new HashMap<MikesEvilMaze.EvilNode, Integer>();
        
        // to get the starting node of the maze: maze.getStartingNode());
        // to check if a node is the exit node.isExit()
        // to get all the nodes reachable from a given node node.getPaths()
        
        queue.add(maze.getStartingNode());
        distance.put(maze.getStartingNode(), 0);
        
        while(!queue.isEmpty()){
        	MikesEvilMaze.EvilNode e=queue.remove();
        	if(e.isExit()) return distance.get(e);
        	for(MikesEvilMaze.EvilNode tmp: e.getPaths()){
            	queue.add(tmp);
            	distance.put(tmp,distance.get(e)+1);
        		
        	}
        	
        }
        
        
        return 0;
        
    }

    public static void main(String[] args)
    {
        EvilMazeSolver solver = new EvilMazeSolver();
        
        System.out.println("Distance for evil maze 78: " + solver.distanceToExit(new MikesEvilMaze(78)));
        System.out.println("Distance for evil maze 942: " + solver.distanceToExit(new MikesEvilMaze(942)));
        System.out.println("Distance for evil maze 6: " + solver.distanceToExit(new MikesEvilMaze(6)));
        // Correct output:
        //Distance for evil maze 78: 2
        //Distance for evil maze 942: 5
        //Distance for evil maze 6: 7
    
    }

}
