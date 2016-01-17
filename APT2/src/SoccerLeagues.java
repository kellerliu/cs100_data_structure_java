
public class SoccerLeagues {
     public int[] points(String[] matches) {

    	 int team=matches.length;
    	 int [] scores=new int[team];
    	 
    	 for(int i=0;i<team ;i++)
    	 
    	 {
        	 String home=matches[i];
        	 
        	 String away="";
        	 
        	 for(int j=0;j<team;j++)
          		 away+=matches[j].charAt(i);
        	 String away1=away.replace('W','b');
        	 String away2=away1.replace('L','W');
        	 
        	
        	 String total=home+away2;
        	 int Wnum=0;
        	 int Dnum=0;
        	 
        	 for(char temp:total.toCharArray())
        		 
        	 {if (temp=='W')Wnum++;
        	 if (temp=='D')Dnum++;
        	 }
        	 
        	 scores[i]=3*Wnum+Dnum;
        	 
    	 }
    		 
    	 return scores;
    	 
   }
 }