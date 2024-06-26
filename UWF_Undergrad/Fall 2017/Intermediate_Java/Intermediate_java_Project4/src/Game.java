import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game 
{
	public static void main(String[] args) throws IOException
	{
		runGame();
	}

public static void runGame() throws IOException
{
	Scanner in = new Scanner(System.in);
	int done = 0; //Used to check if the user is finished with the game
	while(!(done == 1))
	{
		done = 0;      //Resets done to 0, The loop at the end can change the value of done. This is just a safety feature
		System.out.println("Welcome, Please make a selection\n"
				+ "1.) Returning Player\n2.) New Player");       //Print statement to give instructions to the user
		String response = in.nextLine();                        //Stores user response
		Player p = new Player();                                //Creates a user class
		//playerData play = new playerData();                     //Creates player data

		if(response.equals("1"))     //If the user is a returning user
		{
			while(!response.equals("2") && !response.equals("3"))  //While loop for if the user data can not be found
			{                                                      //done = 2 means user elected to create an account, done = 3 user account was found 
				System.out.println("What is your name?");          //Ask user for their name
				response = in.nextLine();
				File check = new File(response+".bat");            //Looks for file associated with user
				if(!check.exists())                                //Checks if file exists
				{
					System.out.println("Sorry user not found\nWould you like to try again?");  //If not found, asks if user would like to retry
					response = in.nextLine();
					while(!response.equals("y") && !response.equals("Y") && response.equals("n") && response.equals("N"))  //Loop makes sure user responds with either Y or N
					{
						if(response.equals("n") || response.equals("n"))
						{
							response = "2";   //If user does not want to retry, user will be taken to create screen
						}
					}
				}
				else
				{
					p.open(response+".bat");  //If file does exist, the user data id retieved
					p.read();
					response = "3";
					Game(p);
				}
			}

		}
		else if (response.equals("2"))  //user elected to create a new user
		{
			/*Asks for name and nick name */
			System.out.println("What is your name?");
			String name = in.nextLine();
			System.out.println("Please create a nick name.");
			String nickName = in.nextLine();
			p.setName(name);
			p.setNickName(nickName);
			p.setTotalScore(0);      //Since user is new, total score = 0
			p.open(name+".bat");  //opens file(Actually creates file if does not exist)
			p.write();           //Writes initial values to file
			Game(p);          //Launches game
		}
		else   //Checks if user input is valid
		{
			System.out.println("Invalid Response");
			done = -1;
		}
		if(done == 0) //Checks to see if the user has finished the game or just inputed an invalid input
		{
			System.out.println("1.) Quit\n2.) Switch User");  //ask user whether they are done or want to long in with a new user.
			done = in.nextInt();
		}
	}
	in.close();
}

	public static void Game(Player p) throws IOException
	{
		Trivia_Game game = new Trivia_Game(); //creates trivia game
		Scanner in2 = new Scanner(System.in);  //Scanner for user resonses
		try
		{
			game.open("Questions.bat");  //opens question file
			Question q = new Question(); //new question object
			Random rand = new Random(); //Random variable for getting questions
			int done = 0, current = 0;  //done is used for when the user is finished playing, current keeps track of the user current score
			while(done != 1)
			{
				for(int i = 0; i <5;i++)
				{
					int position = game.find(rand.nextInt(game.size())); //finds the position of a question fromthe random variable
					q = game.read(position); //sets q to the question and displays it
					if(q.getID() == -1)
					{
						i--;	
					}
					else
					{
						System.out.println(q.getQuestion());
						String answer = in2.nextLine();  //Retieves repsonse from the user
						if(answer.equals(q.getAnswer())) //Checks if the user is correct
						{
							System.out.println("Correct!");
							current += q.getValue();       //adds question value to current cscore
							p.setTotalScore((p.getTotalScore() + q.getValue())); //Also adds question value to total score
							System.out.println("Your score is: " + current);
							p.write();
						}
						else
						{
							System.out.println("Incorrect. The correct answer is " + q.getAnswer());
							System.out.println("Your score is: " + current + "\n");
						}
					}
				}
				System.out.println("Would you like to play again? (y/n)"); //Asks if the user would like to plahy again
				String response = in2.nextLine();
				if(response.equals("n") || response.equals("N")) //if user chooses not to, The users information is displayed
				{
					System.out.println(p.toString() + " Current Score :" + current);
					done = 1;  //Done is set to 1
				}

			}
		}
		finally
		{
		}
	}
}
