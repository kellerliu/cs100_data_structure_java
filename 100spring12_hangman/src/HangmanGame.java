import java.io.*;
import java.util.*;

/**
 * You write code here to play a game of Hangman.
 * Some sample code provided at the start, you'll likely not
 * keep it in your final game except for readString
 * @author Junfei Liu
 *
 */

public class HangmanGame {

	Scanner myInput;
	public HangmanGame(){
		myInput = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	}
	/**
	 * Get a line from the user and return the line as a String
	 * @param prompt is printed as an instruction to the user
	 * @return entire line entered by the user
	 */
	public String readString(String prompt) {
		System.out.printf("%s ",prompt);
		String entered = myInput.nextLine();
		return entered;
	}
	/**
	 * Play one game of hangman. This should prompt
	 * user for parameters and then play a complete game
	 * You'll likely want to call other functions from this one.
	 */
	public void play() {
		
		 HangmanFileLoader data = new HangmanFileLoader();
		 data.readFile("lowerwords.txt");
		 
		 String input1 = readString("letters in word:");
		 int wordlength = Integer.parseInt(input1);
	 	 String secretWord = data.getRandomWord(wordlength);
	 	 
	 	 char[] secretArray=secretWord.toCharArray();
	 	 ArrayList<Character> secretlist=new ArrayList<Character>();
		 	 for(char temp:secretArray)   
		 		 secretlist.add(temp);
		 			 
	 	 char[] guessArray=new char[wordlength];
		 	 for(int a=0;a<wordlength;a++)
		 		 guessArray[a]='_';
		 	 
	 	 
		 String input2 = readString("Please enter the number of guesses to hanging:");
		 int guessCount = Integer.parseInt(input2);

		 String display="";
		 for (int l=0;l<wordlength;l++){
			 display=display+"_ ";
		 }
		 	 
		//System.out.println(wordlength+" letter secret word is " + secretWord);
	 
		 System.out.println(wordlength+" letter secret word is " + display);

		 
		 boolean gameWon = false;
		 //String guessesSoFar="";
		 
		 ArrayList<Character> guessesSoFar=new ArrayList<Character>();
		 
		 
		 for(int k=0; k < guessCount; k += 1) {
			 
			 String guessleft=Integer.toString(guessCount-k);
			 
			 System.out.println("misses left:" +guessleft);
			 System.out.println("guesses so far: " +guessesSoFar);
			
			 String guess = readString("guess letter: ");
			 char guessletter=guess.charAt(0);
			 
						
			 						 
			 						if(secretlist.contains(guessletter))
			 							k--;
			 						else {
			 							
			 							if(guessesSoFar.contains(guessletter))
			 								{k--;
			 								System.out.println("no "+guessletter+" and you have guessed it!");
			 								System.out.println(display);
				 							continue;}
			 							
				 							else
				 							{
				 							guessesSoFar.add(guessletter);
				 							System.out.println("no "+guessletter);
				 							if(k+1<guessCount) {System.out.println(display);}
				 							continue;
				 							}
			 						}
			 							
			 							
			 
			 
			 						for(int g=0;g<wordlength;g++)
									 	{
										 if(guessletter==secretArray[g])
											 guessArray[g]=guessletter;
										 
										 }
			 						
			 						 display="";
			 						
									for(int d=0;d<wordlength;d++)
										{
										if(guessArray[d]!='_')
										display=display+guessArray[d]+' ';
										else display=display+"_ ";
										
										}
									System.out.println(display);
			 
			 
			 
		 	
					 
					
			 		
			 		
			 		String answer=new String(guessArray);
			 		
			 		
			 		if(answer.equals(secretWord)) {
						 System.out.println("You guessed my word!");
						 gameWon = true;
						 break;
					 } 
					 
					

		 
		 }
		
		 
		
		 
		 
		 
		 if (! gameWon) {
			 System.out.printf("you are hung :-(, secret word was %s\n",secretWord);
		 }	 
	}

}