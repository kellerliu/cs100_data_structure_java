import java.util.HashSet;

public class CDPlayer{
      public int isRandom(String[] songlist, int n){
        // you write code here
      
      String onelist="";
      for(String temp:songlist){
    	  onelist+=temp;
      }
      
      
      int len = onelist.length();
		
		if (len >= n){

			for (int i=0; i<n; i++){
				int j = 0;
              boolean isWholeList = true;
              String prechunk = onelist.substring(0,i);
              if (uniqueNum(prechunk)!=i)
              	continue;                                
				for (; i+(j+1)*n<len; j++){
					String chunk = onelist.substring(i+j*n, i+(j+1)*n);
					if (uniqueNum(chunk)!=n){
						isWholeList = false;
		     			break;
					}
				}
				if (isWholeList){
					String postchunk = onelist.substring(i+j*n);
					if (uniqueNum(postchunk)==len-i-j*n)
						return i;
				}				    
			}
			return -1;
		}
		else{
			for (int m = 0; m < len; m++){
				String permutation1 = onelist.substring(0,m);
				String permutation2 = onelist.substring(m);
				if ((uniqueNum(permutation1)==m)&&(uniqueNum(permutation2)==len-m))
					return m;
			}
			return -1;
		}
		
	}
	
	private int uniqueNum(String s){
		HashSet<Character> songSet = new HashSet<Character>();
		for (char c:s.toCharArray()){
			songSet.add(c);
		}
		return songSet.size();
	}
}
