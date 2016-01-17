public class DNAMaxNucleotide {
	public String max(String[] strands, String nuc) 
	{ 
		int maxNumber = 0; 
		String maxString = "";
		char nucleotide = nuc.charAt(0);

		for (String temp: strands)
		{
			int number = count(temp,nucleotide);
			if (number > maxNumber)
			{
				maxNumber = number;
				maxString = temp;
			}
			else if ((number!=0) && number == maxNumber &&  maxString.length() < temp.length())
				maxString = temp;
			
		}
		return maxString;
	}

	public int count(String dna, char nucleotide) 
	{ 
		int countnumber = 0;    
		for (char ch: dna.toCharArray())
		{
			if (ch == nucleotide)
				countnumber++;
		}
		return countnumber;
	}
}

