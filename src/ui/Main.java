package ui;

import model.*;
import java.util.Scanner;

public class Main
{
	////////////////////////////////////////
	//            Attributes              //
	////////////////////////////////////////
	private Scanner stringReader;
	private Scanner intReader;
	private Reciclamos reciclamos;

	////////////////////////////////////////
	//           Constructor              //
	////////////////////////////////////////
	public Main ()
	{
		stringReader = new Scanner(System.in);
		intReader = new Scanner(System.in);
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
	/**Prints the functions the program offers, from which the user can pick entering a number.<br>
	*<b>Post:</b>The functions are printed, and the user either is taken to another menu, or receives a message indicating he entered a wrong number.<br> 
	*/
	public void mainMenu ()
	{
		init();

		int decision = 0;
		boolean on = true;

		while (on)
		{
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("                  <<((| RECICLAMOS : Green App |))>>                  ");
			System.out.println("\nWelcome back. What do you want to do today?.\n");
			System.out.println("1 = Add waste.\n2 = Add waste producer product.\n3 = Display waste information.\n4 = Lists menu.\n5 = Calculate a waste's nocivity for the earth.\n6 = Determine a waste's usability.\n7 = Exit.");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

			decision = intReader.nextInt();

			switch (decision)
			{
				case 1:
				{
					addWasteMenu(0, "");
					break;
				}

				case 2: 
				{
					addProductMenu(0, "");
					break;
				}

				case 3:
				{
					wasteInformationMenu();
					break;
				}

				case 4:
				{
					listMenu();
					break;
				}

				case 5:
				{
					nocivityMenu();
					break;
				}

				case 6:
				{
					usabilityMenu();
					break;
				}

				case 7:
				{
					on = false;
					break;
				}

				default:
				{
					System.out.println("\n!!!!| Wrong number! |!!!!\n");
				}
			}
		}
	}

	/**Prints the indications for creating a waste and reads all the attributes of a waste, given by the user.<br>
	*<b>Post:</b>A message showing the successfulness of the process of creation, or one notyifing that an error occurred.<br>
	*@param version Integer number. Decides if certain instructions are going to be followed. 0 for a procedure of waste then product, 1
	*for when it comes from a procedure of product then wastes.<br>
	*@param productIdentifier String with a product's identifier number. Used when version is 1.<br>
	*/
	public void addWasteMenu (int version, String productIdentifier)
	{
		boolean ok = true;
		boolean canCompost = true; //Attribute of biodegradable
		String throwAwayDesc = ""; //Attribute of recyclable
		String reductionTips = ""; //Attribute of inert
		int path = 0;
		int type = 0; //Attribute of recyclable
		String msg = "";

		System.out.println("                     ++++| Waste adding procedure |++++                     \n");
		
		System.out.println("Select the waste's category.\n1 = Biodegradable.\n2 = Recyclable.\n3 = Inert.");

		path = intReader.nextInt();

		if (path > 3 || path < 1)
		{
			ok = false;
		}

		if (ok)
		{
			System.out.println("\nEnter the waste's identifier number (only numbers, cannot repeat).");
						
			String identifier = stringReader.nextLine();

			ok = reciclamos.identifierValidator(identifier);

			if (ok)
			{
				System.out.println("\nEnter the waste's name (no numbers, cannot repeat).");

				String name = stringReader.nextLine();

				ok = reciclamos.nameValidator(name);

				if (ok)
				{
					System.out.println("\nEnter the waste's origin.\n1 = Industrial.\n2 = Domiciliary.\n3 = Municipal.\n4 = Construction.\n5 = Hospitalary.");

					int origin = intReader.nextInt();

					if (origin > 5 || origin < 1)
					{
						ok = false;
					}

					if (ok)
					{
						System.out.println("\nEnter the waste's color (no numbers).");

						String color = stringReader.nextLine();

						ok = reciclamos.colorValidator (color);

						if (ok)
						{
							System.out.println("\nEnter the waste's time of decomposition (in days).");
							
							int decompositionTime = intReader.nextInt();

							if (decompositionTime < 1)
							{
								ok = false;
							}

							if (ok)
							{
								switch (path)
								{
									case 1:
									{
										System.out.println("\nIs the waste compostable?\n1 = Yes.\n2 = No.");

										int hi = intReader.nextInt();

										if (hi == 1)
										{
											canCompost = true;
										}

										else if (hi == 2)
										{
											canCompost = false;
										}

										else
										{
											ok = false; 
										}

										if (ok)
										{
											reciclamos.addWaste(identifier, name, origin, color, decompositionTime, canCompost);
										}
										break;
									}

									case 2:
									{
										System.out.println("\nEnter the waste's type.\n1 = Paper.\n2 = Cardboard.\n3 = Glass.\n4 = Plastic.\n5 = Metal.");

										type = intReader.nextInt();

										if (type < 1 || type > 5)
										{
											ok = false; 
										}

										if (ok)
										{
											if (origin == 1 || origin == 2)
											{
												System.out.println("\nEnter a brief description of how to correctly dispose this waste.");

												throwAwayDesc = stringReader.nextLine();
											}

											reciclamos.addWaste(identifier, name, origin, color, decompositionTime, type, throwAwayDesc);
										}
										break;
									}

									case 3:
									{
										System.out.println("\nEnter tips to reduce the usage of this waste.");

										reductionTips = stringReader.nextLine();

										reciclamos.addWaste(identifier, name, origin, color, decompositionTime, reductionTips);
										break;
									}
								}
								if (version == 0)
								{
									askForProduct(identifier);
									version = 2;
								}

								else if (version == 1)
								{
									reciclamos.assignProduct(identifier, productIdentifier);
								}
							}
						}
					}
				}
			}
		}
		if (version != 2)
		{
			if (ok)
			{
				System.out.println("\n++++| The waste was successfully added. |++++");
			}

			else 
			{
				System.out.println("\n!!!!| Something went wrong. |!!!!");
			}
		}
	}

	/**Prints the indications for creating a product and reads all the attributes of a product, given by the user.<br>
	*<b>Post:</b> A message showing the successfulness of the process of creation, or one notyifing that an error occurred.<br>
	*@param version Integer number. Decides if certain instructions are going to be followed. 0 for a procedure of product then wastes, 1
	*for when it comes from a procedure of waste then product.<br>
	*@param wasteIdentifier String with a waste's identifier number. Used when version is 1.<br>
	*/
	public void addProductMenu (int version, String wasteIdentifier) // wasteIdentifier can be empty
	{
		boolean ok = false;
		boolean done = false;

		System.out.println("                     ++++| Product adding procedure |++++                     ");
		
		while (done == false)
		{
			System.out.println("\nEnter the product's identifier number (Only numbers, cannot repeat).");

			String identifier = stringReader.nextLine();

			ok = reciclamos.productIdentifierValidator(identifier);

			if (ok)
			{
				System.out.println("\nEnter the product's name (No numbers, cannot repeat).");

				String name = stringReader.nextLine();

				ok = reciclamos.productNameValidator(name);

				if (ok)
				{
					System.out.println("\nEnter a brief description of the product.");

					String description = stringReader.nextLine();

					reciclamos.addProduct(identifier, name, description);
					done = true;

					if (version == 0)
					{
						askForWaste (identifier);
					}

					else if (version == 1)
					{
						reciclamos.assignProduct(wasteIdentifier, identifier);
					}
				}
			}
		

			if (version == 0)
			{
				if (ok)
				{
					System.out.println("\n++++| The product was successfully added. |++++");
				}

				else if (!ok)
				{
					System.out.println("\n!!!!| Something went wrong. |!!!!");
				}
			}

			else if (version == 1)
			{
				if (ok)
				{
					System.out.println("\n++++| The waste was successfully added. |++++");
				}

				else if (!ok)
				{
					System.out.println("\n !!!!| Something went wrong. |!!!!");
				}
			}
		}
	}

	/**Reads a waste's name then show that waste's complete information, product included.<br>
	<b>Post:</b>Prints the information of a waste or a message notyifing the non-existence of said waste.<br>
	*/
	public void wasteInformationMenu ()
	{
		System.out.println("                     dddd| Waste info display |bbbb                     ");
		System.out.println("\nEnter the waste's name.");

		String name = stringReader.nextLine();

		if (reciclamos.wasteExists(name))
		{
			System.out.println("\n                     dddd| Waste information |bbbb                     ");
			System.out.println("\n" + reciclamos.printWasteInfo(name));
		}

		else
		{
			System.out.println("\nXXXX| Waste doesn't exist! |XXXX");
		}
	}

	/**Prints the 3 different options of lists. If it's the "Wastes of a product" option, it reads the desired product's identifier number.<br>
	*<b>Post:</b> All the wastes, products, or wastes of a product are printed, or a message notifying the non-existence of said product
	*is printed if in "Wastes of a product" option.<br>
	*/
	public void listMenu ()
	{
		int decision = 0;

		System.out.println("\nWhat list you want to see?");
		System.out.println("\n1 = All wastes list.\n2 = All products list.\n3 = All wastes of a product.");

		decision = intReader.nextInt();

		if (decision == 1)
		{
			System.out.println("\n                     {{{{| Wastes list |}}}}                     ");
			System.out.print(reciclamos.printWastes());
		}

		else if (decision == 2)
		{
			System.out.println("\n                     [[[[| Products list |]]]]                     ");
			System.out.println(reciclamos.printProducts());
		}

		else if (decision == 3)
		{
			System.out.println("\nEnter the product's identifier number.");

			String identifier = stringReader.nextLine();

			if (reciclamos.productExists(identifier))
			{
			System.out.println("\n                     <<<<| Wastes of product #" + identifier + " |>>>>                     ");			
			System.out.println(reciclamos.printWastesOfAProduct(identifier));
			}

			else
			{
				System.out.println("\nXXXX| Product doesn't exist! |XXXX");
			}
		}
	}

	/**Reads a waste's name, then prints the nocivity of that waste.<br>
	*<b>Post:</b>A message with either the nocivity of the waste or notifying the non-existence of said waste is printed.<br>
	*/
	public void nocivityMenu ()
	{
		System.out.print("\n                     ****| Nocivity calculation |****                     ");
		System.out.println("\nEnter the waste's name.");
		String name = stringReader.nextLine();

		if (reciclamos.wasteExists(name))
		{
			System.out.print("\nThe nocivity of " + name + " is: " + reciclamos.calculateNocivity(name) + ".");
		}

		else
		{
			System.out.println("\nXXXX| Waste doesn't exist |XXXX");
		}
	}

	/**Reads a waste's name, then prints wether the waste is usable or not.<br>
	*<b>Post:</b>The usability or not usability of the waste is printed, or a message notifying the non-existence of a product.<br>
	*/
	public void usabilityMenu ()
	{
		System.out.println("\n                     ####| Usability Determination |####                     ");
		System.out.println("\nEnter the waste's name.");

		String name = stringReader.nextLine();

		if (reciclamos.wasteExists(name))
		{
			if (reciclamos.determineUsability(name))
			{
				System.out.println("\n~" + name + " is usable~");
			}

			else
			{
				System.out.println("\n~" + name + " is not usable~");
			}
		}

		else
		{
			System.out.println("\nXXXX| Waste doesn't exist |XXXX");
		}
	}

	/**Reads wether the user wants to add an already existent product, or if he wants to create a new one.<br>
	<b>Post:</b>A product is added to a waste.<br>
	@param wasteIdentifier The identifier number of the waste that's being created.<br>
	*/
	public void askForProduct (String wasteIdentifier)
	{
		System.out.println("\nSelect one option for the producer product:");
		System.out.println("\n1 = Add an already existent product.\n2 = Create a new product.");

		int decision = intReader.nextInt();

		if (decision == 1)
		{
			System.out.println("\nEnter the product's identifier number.");

			String productIdentifier = stringReader.nextLine();

			boolean exists = reciclamos.productExists(productIdentifier);

			if (exists)
			{
				reciclamos.assignProduct(wasteIdentifier, productIdentifier);
				System.out.println("\n++++| The waste was successfully added. |++++");
			}
		}

		else if (decision == 2)
		{
			addProductMenu(1, wasteIdentifier);
		}
	}

	/**Reads if the user wants to create waste for a product or not.<br>
	<b>Post:</b>A waste or wastes are added to a product or not.<br>
	@param productIdentifier The identifier number of the product previously created.<br>
	*/
	public void askForWaste (String productIdentifier)
	{
		boolean keepGoing = true;
		int count = 0;
		int decision = 0;

		while (keepGoing)
		{
			if (count == 0)
			{
				System.out.println("\nDo you want to create wastes produced by the product?\n1 = Yes.\n2 = No.");
			}

			else 
			{
				System.out.println("\nDo you want to create another one?\n1 = Yes.\n2 = No.");
			}

			decision = intReader.nextInt();

			if (decision == 1)
			{
				addWasteMenu(1, productIdentifier);
				count++;
			}

			else if (decision == 2)
			{
				keepGoing = false;
			}

			else
			{
				System.out.println("\nXXXX| Wrong number! |XXXX");
			}
		}
	}

	/**Initializes products and wastes.<br>
	<b>Post:</b>Some products and wastes are initialized in the program.<br>
	*/
	public void init ()
	{
		reciclamos.addProduct("101", "Avocado", "Delicious fruit");
		reciclamos.addProduct("275", "CPU", "Machine with metal parts");
		reciclamos.addProduct("765", "Chips", "Bag with chips inside");
		reciclamos.addProduct("888", "Animal", "Any mammal");
		reciclamos.addWaste("712", "Bone", 2, "White", 14, false);
		reciclamos.addWaste("656", "Innards", 1, "Red", 4, false);
		reciclamos.addWaste("444", "Feces", 1, "Brown", 8, true);
		reciclamos.addWaste("700", "Avocado's peel", 2, "Green", 7, true);
		reciclamos.addWaste("696", "Avocado's seed", 2, "Brown", 5, false);
		reciclamos.addWaste("500", "Graphic's card", 2, "Gray", 90000, "Don't buy new computers");
		reciclamos.addWaste("499", "Processor", 2, "Black", 100000, "Don't buy new computers");
		reciclamos.addWaste("999", "Bag of chips", 2, "Varied", 30000, 4, "Don't throw the bag at natural spaces, classify your trash");
		reciclamos.assignProduct("700", "101");
		reciclamos.assignProduct("696", "101");
		reciclamos.assignProduct("500", "275");
		reciclamos.assignProduct("499", "275");
		reciclamos.assignProduct("999", "765");
		reciclamos.assignProduct("712", "888");
		reciclamos.assignProduct("656", "888");
		reciclamos.assignProduct("444", "888");
	}
}