package ui;

import model.*;
import java.util.Scanner;

public class Main
{
	////////////////////////////////////////
	//            Attributes              //
	////////////////////////////////////////
	private Scanner reader;
	private Reciclamos reciclamos;

	////////////////////////////////////////
	//           Constructor              //
	////////////////////////////////////////
	public Main ()
	{
		reader = new Scanner(System.in);
		reciclamos = new Reciclamos();
	}

	public static void main (String[] args)
	{
		Main menu = new Main();
		menu.mainMenu();
	}

	////////////////////////////////////////
	//                Menus               //
	////////////////////////////////////////
	public void mainMenu ()
	{
		int decision = 0;
		boolean on = true;

		while (on)
		{
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("                  <<((| RECICLAMOS : Green App |))>>                  \n");
			System.out.println("Welcome back. What do you want to do today?.\n");
			System.out.println("1 = Add waste.\n2 = Add waste producer product.\n3 = Display waste information.\n4 = Lists menu.\n5 = Calculate a waste's nocivity for the earth.\n6 = Determine a waste's usability.\n7 = Exit.");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			decision = reader.nextInt();

			switch (decision)
			{
				case 1:
				{
					menu.addWasteMenu();
				}

				case 2: 
				{
					menu.addProductMenu();
				}

				case 3:
				{
					menu.wasteInformationMenu();
				}

				case 4:
				{
					menu.listMenu();
				}

				case 5:
				{
					menu.nocivityMenu();
				}

				case 6:
				{
					menu.usabilityMenu();
				}

				case 7:
				{
					on = false;
				}

				default:
				{
					System.out.println("xxxx| Wrong number! |xxxx\n");
				}
			}
		}

	}

	public void init ()
	{
		
	}
}