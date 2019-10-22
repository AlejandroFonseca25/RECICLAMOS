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

	}

	public void init ()
	{
		
	}
}