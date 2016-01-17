public class DNAstrand {

	private String myData;
	
	public String setStrandData(){
		return myData;
	}

	public void setStrandData(String newData){
		myData=newData;
	}
		
	public void addBasePair(String newPair){
		myData=myData+newPair;
	}

	public boolean is3rdBasePairCytosine(){
		
	if('c'==myData.charAt(2))
	{System.out.println("cytosine!");}
	return true;
}
	}



