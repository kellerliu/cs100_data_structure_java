import java.util.*;

public class Dirsort {
	public String[] sort(String[] dirs) {
		ArrayList<DirName> DirList = new ArrayList<DirName>();
		String[] sortedDirs = new String[dirs.length];
		
		for (String temp:dirs){
			DirList.add(new DirName(temp));
			}
		Collections.sort(DirList);
		
		for (int k=0; k<dirs.length; k++){
			sortedDirs[k] = DirList.get(k).myDir;

		}
		return sortedDirs;
		}

	public static class DirName implements Comparable<DirName>{
		
		private String myDir;
		private String[] myDirArray;
		
		public DirName(String dir){
			myDir = dir;
			myDirArray = dir.split("/");					
		}
		
		
		public int compareTo (DirName other){
			
			if (myDirArray.length < other.myDirArray.length)
				return -1;
			if (myDirArray.length > other.myDirArray.length)
				return 1;
			for (int i=0; i<myDirArray.length; i++){
				if (!myDirArray[i].equals(other.myDirArray[i])){
					return myDirArray[i].compareTo(other.myDirArray[i]);
				}
					
			}
			return 0;			
		}
	}
	
	

	
}
