/**
* This is the farmer game where three animals and a human have to get to the other side without leaving the sheep and wolf alone, or the sheep and cabbot alone
* @author Joseph Beatty
* @version 1
*
*/


import java.util.Scanner;



public class FarmerGame
{
	
	
	public static boolean Cabb;
	public static boolean Sheep;
	public static boolean Wolf;
	public static boolean Human;
	
	
	/**
	*This is the main method that just calls the other methods. It first calls the welcome method and hen the game method.
	*@param arguments
	*@return none
	*/
	public static void main(String[] args)
	{
		welcome();
		game();
		
	
	
	}
	
	/**
	*This is the game function which holds the game itself
	*It uses recursion to continuously play itself. It will ask the user who they want to move. 
	*The answer they choose will then be looked at with C, S, W, and H because those are the only letters that the user can guess.
	*if none of these were guessed then the computer would prompt the user to pick a new letter that is one of the four. Also if the 
	*Human is not on the same side as the animal picked the computer will tell the user and then ask them to repick by use of recursion.
	*When a correct animal or the human was chosen by the user, that animal/human will be switched to the not animal/human meaning that
	*in the displayGameStatus method the animal/human will now be on the other side. The code will also check to see if the user has won
	*seeing if all of the boolean variables are true meaning they are on bank 1.
	*@param none
	*@return nothing, this just ends the code
	*/
	public static void game()
	{
		Scanner jb = new Scanner(System.in);
		System.out.print("who would you like to move:");
		String move= jb.nextLine();
		if(move.equals("C"))
		{
			if(!((Cabb && Human) || (!Cabb && !Human)))
			{
				System.out.println("The human needs to be on the same side as your choice");
				game();
			}
			Cabb =!Cabb;
			Human =!Human;
		}
		else if(move.equals("S"))
		{
			if(!((Sheep && Human) || (!Sheep && !Human)))
			{
				System.out.println("The human needs to be on the same side as your choice");
				game();
			}
			Sheep =!Sheep;
			Human =!Human;
		}
		else if(move.equals("W"))
		{
			if(!((Wolf && Human) || (!Wolf && !Human)))
			{
				System.out.println("The human needs to be on the same side as your choice");
				game();
			}
			Wolf =!Wolf;
			Human =!Human;
		}
		else if(move.equals("H"))
			Human=!Human;
		else
		{
			System.out.println("You have to pick either C S or W or H");
			game();
		}
		if(check() == 1)
		{
			displayGameStatus();
			//System.out.println(!Cabb && !Human && !Sheep && !Wolf);
			if(Cabb && Human && Sheep && Wolf)
			{
				System.out.println("You win");
				return;
			}
			game();
		}
		else
			System.out.println("You Lose");
	}
	
	/**
	*This method checks to see if the sheep was left alone with the cabbot or the wolf which 
	*would then prompt the game method that the user has lost. It uses boolean to determine weather 
	*statements are true or false. this method returns 1 if the cabbot or the wolf were not left alone with the sheep.
	*It returns 0 if the sheep was left alone with either of these two animals.
	*@param none
	*@return 0 if the sheep was left alone with the cabbot or the wolf and 1 if it was not
	*/
	public static int check()
	{
		
		if((Cabb && Sheep && !Human && !Wolf)|| (!Cabb && !Sheep && Human && Wolf))
		{
			return 0;
		}
		
		else if((Wolf && Sheep && !Human && !Cabb)||(!Wolf && !Sheep && Human && Cabb))
		{
			return 0;
		}
		else
		{
			return 1;
		}
	
	}
	/**
	*This is the starting method that describes the game to the user and gives the instructions of the game. 
	*It will print out the instructions and then call the displayGameStatus method to show the board to the user.
	*@param none
	*@return none
	*/
	public static void welcome()
	{
		System.out.println("Farmer's Game");
		System.out.println("This game works as follows. The goal is to get all of the animals and the human to the other bank.");
		System.out.println("The catch is that if you leave the Sheep alone with the wold, or the sheep alone with the cabbot, they will eat the sheep an you will lose.");
		System.out.println("The human can only hold one animal in his boat at a time and also you cannot move an animal if the human is not on the same bank as itself");
		displayGameStatus();
	
	}
	
	/**
	*This method displays the game itself. It shows the two banks which are made of strings and also will show 
	*where all of the animals and human are. It works so that if the animals are false then they are on bank 0 but if
	*they are true then they are on bank 1
	*@param none
	*@return none
	*/
	public static void displayGameStatus()
	{
		String bank0 = "   ";
		String bank1 = "   ";
		
		if(!Cabb)
			bank0 += "C ";
		else
			bank1 += "C ";
		if(!Sheep)
			bank0 += "S ";
		else
			bank1 += "S ";
		if(!Wolf)
			bank0 += "W ";
		else
			bank1 += "W ";
		if(!Human)
			bank0 += "H ";
		else
			bank1 += "H ";
			
		
		System.out.println(bank0);
		System.out.println("--------------------");
		System.out.println("\n\n\n");
		System.out.println("---------------------");
		System.out.println(bank1);
		
	
	}

}