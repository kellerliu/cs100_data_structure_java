import java.util.*;

public class Dirsort {
	

	public static class DirName implements Comparable<DirName>{
		
		private String myDir;
		private String[] myDirComponent;
		
		public DirName(String dir){
			myDir = dir;
			myDirComponent = dir.split("/");					
		}
		
		public String printDir(){
			return myDir;
		}
		
		public int compareTo (DirName other){
			
			if (myDirComponent.length < other.myDirComponent.length)
				return -1;
			if (myDirComponent.length > other.myDirComponent.length)
				return 1;
			for (int i=0; i<myDirComponent.length; i++){
				if (!myDirComponent[i].equals(other.myDirComponent[i])){
					return myDirComponent[i].compareTo(other.myDirComponent[i]);
				}
					
			}
			return 0;			
		}
	}
	
	
	public String[] sort(String[] dirs) {
		ArrayList<DirName> DirList = new ArrayList<DirName>();
		String[] sortedDirs = new String[dirs.length];
		for (int j=0; j<dirs.length; j++){
			DirList.add(new DirName(dirs[j]));
			}
		Collections.sort(DirList);
		for (int k=0; k<dirs.length; k++){
			sortedDirs[k] = DirList.get(k).printDir();
		}
		return sortedDirs;
		}
	
}
