
public class Rec9Prep {
	class StringTreeNode {
		String info;
		StringTreeNode left;
		StringTreeNode right;
		StringTreeNode (String s, StringTreeNode lt, StringTreeNode rt) { 
			info = s;
			left = lt;
			right = rt;
		}
	}

	/**
	 * Returns number of nodes at specified level in t, where level >= 0.
	 * @param level specifies the level, >= 0
	 * @param t is the tree whose level-count is determined
	 * @return number of nodes at given level in t
	 */
	public int levelCount(StringTreeNode t, int level){
		// Your code goes here...
		

		if(t==null)
			return 0;
		
		if (level==0)
		return 1;
		
		
		return levelCount(t.left, level-1)+levelCount(t.right,level-1);
		
	}
	

	public static void main(String[] args) {
		Rec9Prep r = new Rec9Prep();
		
		StringTreeNode eg1 = r.makeExample1();
		StringTreeNode eg2 = r.makeExample2();


		System.out.println(r.levelCount(eg1, 2));
		System.out.println(r.levelCount(eg1, 4));
		System.out.println(r.levelCount(eg2, 2));
		System.out.println(r.levelCount(eg2, 4));
		System.out.println(r.levelCount(eg2, 5));
		
		// Output should be 3,0,2,6,1
	}

	
	
	// Ignore anything below here...
	// ----------------------------------
	
	public StringTreeNode makeExample1() {
		StringTreeNode black = new StringTreeNode("black", null, null);
		StringTreeNode garbanzo = new StringTreeNode("garbanzo", null, null);
		StringTreeNode chickpea = new StringTreeNode("chickpea", black, garbanzo);
		StringTreeNode pinto = new StringTreeNode("pinto", null, null);
		StringTreeNode navy = new StringTreeNode("navy", null, pinto);
		StringTreeNode lima = new StringTreeNode("lima", chickpea, navy);
		return lima;
	}
	
	public StringTreeNode makeExample2() {
		StringTreeNode marlins = new StringTreeNode("Marlins", null, null);
		StringTreeNode redsox = new StringTreeNode("Red Sox", null, null);
		StringTreeNode orioles = new StringTreeNode("Orioles", marlins, null);
		StringTreeNode mets = new StringTreeNode("Mets", null, null);
		StringTreeNode phillies = new StringTreeNode("Phillies", null, null);
		StringTreeNode padres = new StringTreeNode("Padres", null, null);
		StringTreeNode giants = new StringTreeNode("Giants", null, null);
		StringTreeNode astros = new StringTreeNode("Astros", redsox, orioles);
		StringTreeNode royals = new StringTreeNode("Royals", null, mets);
		StringTreeNode angels = new StringTreeNode("Angels", phillies, null);
		StringTreeNode dodgers = new StringTreeNode("Dodgers", padres, giants);
		StringTreeNode reds = new StringTreeNode("Reds", astros, angels);
		StringTreeNode braves = new StringTreeNode("Braves", royals, dodgers);
		StringTreeNode nationals = new StringTreeNode("Nationals", braves, reds);
		StringTreeNode cubs = new StringTreeNode("Cubs", null, null);
		StringTreeNode yankees = new StringTreeNode("Yankees", cubs, nationals);
		
		return yankees;
	}
}
