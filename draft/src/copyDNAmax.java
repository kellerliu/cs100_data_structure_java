
public class copyDNAmax {

	public String max(String[] strands, String n) 
	{ 
		// max number of nucleotides found so far
		int maxNumber = 0; 
		
		// string with max number of nucleotides "n" found so far
		String maxString = "";
		
		// convert nucleotide string to a character
		char nucleotide = n.charAt(0);
		
		//for each DNA strand do the following
		for (String temp: strands)
		{
			// for each string, count number of n's
			// write another method named 'count' similar to prev problem
			int number = count(temp,nucleotide);
			if (number > maxNumber)
			{
				maxNumber = count(temp, nucleotide);
				maxString = temp;
			}
			else if (number == maxNumber && maxString.length() < temp.length())
			{
				maxString = temp;
			}
			else
			{
				// do nothing in this case - can leave this off
			}
		}
		return maxString;
	}


    // can write other methods in the same class.
	// count returns the number of a particular nucleotide in a dna string
	public int count(String dna, char nucleotide) 
	{ 
		int countOfNucleotide = 0;    //create and initialize variable to store count
		// loop over string
		for (char ch: dna.toCharArray())
		{
			if (ch == nucleotide)
			{
				countOfNucleotide = countOfNucleotide + 1;
			}
		}
		return countOfNucleotide;
	}
}

