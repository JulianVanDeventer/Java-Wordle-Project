//Created By Julian VanDeventer
import java.util.Scanner;	//the scanner is required to accept user inputs
class Wordle
{
	public static void main(String[] args)
	{
	playGame();
	}
		
	//the playGame method was created so the user has the option to play again after they run out of turns or win
	//i cannot call the main method again so I used the playGame method instead
	public static void playGame()
		{
			//these are ANSI codes to change the color of the background so the user can understand which letters are correct
			final String BG_GREEN = "\u001b[42m";
			final String BG_YELLOW = "\u001b[43m";
			final String RESET= "\u001b[0m";
			
			//this calls on the introduction method that displays the welcome screen and instructions
			introduction();
			
			//this line of code fetches the string array and getWords method from the WordBank class
			String[]words = WordBank.getWords();
			
			//this chooses a random word from my WordBank class
			int wIndex = (int)(Math.random() * words.length);
			
			//this assigns the word that will be guessed from the WordBank Class
			String correct = words[wIndex];
			
			Scanner sc = new Scanner(System.in);
			String guess = "";
			
			//Loop for six guesses
			for(int round = 0; round < 6 ; round ++)
			{	
			
			//this string creates the message that shows every time you make an attempt
			String message = "Attempt " + (round + 1) + " of 6: ";
			System.out.println(message);
			guess = sc.nextLine().toUpperCase();
			//this is the for loop that tests and changes the background of each letter
			for(int i = 0; i<5; i++)
			{	
			if(guess.substring(i,i+1).equals(correct.substring(i,i+1)))
			{
				//this changes the background to green if the letters match exactly
				System.out.print(BG_GREEN + guess.substring(i,i+1) + RESET);
				
			}//end of if
			else if(correct.indexOf(guess.substring(i,i+1)) > -1)
			{
				//this changes the background if the letters match but different location
				System.out.print(BG_YELLOW + guess.substring(i,i+1) + RESET);
			}//end of else if
			else
			{
				System.out.print(guess.substring(i,i+1));
			}//end of else
			}//end of for statement
				System.out.println();
				
				
				//this if statement displays the WIN message when 
				if(guess.equals(correct))
				{
					System.out.println("YOU WIN! You solved the word " + correct + " in " + (round + 1) + " trys! ");
					playAgain();
					break;
					
				}//end of if
			}//end of outer for
			
			//print correct answer if player fails
			if(!guess.equals(correct))
			{
				System.out.println("Wrong! The correct word is: " + correct + "!");
				playAgain();
			}//end of if statement
		}//end of playGame
	
		
		public static void introduction()
		{
			//this is the wordle message when you first run the game
			System.out.println("***********");
			System.out.println("* WORDLE! *");					
			System.out.println("***********");
			System.out.println("Your objective is to guess the 5 letter word in 6 guesses. ");
			System.out.println("Letters in the corect spot will appear green. ");
			System.out.println("The correct letter in the wrong spot will appear yellow.");
		}
		
		public static void playAgain()
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Do you want to play again? (y/n): ");
			String restart = sc.nextLine();
			
			if(restart.equalsIgnoreCase("y"))
			{
				//if the user entered "y" to the question thank the playGame() method is called and the game plays again
				playGame();
			}//end of if statement restart
			else
			{
				//This is the message that displays when the user hits "n" and does not want to play again
				System.out.println("Thank you for playing WORDLE!");
			}//end of else
		}//end of playAgain
		
	
	}//end of class
	
		