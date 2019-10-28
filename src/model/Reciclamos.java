package model;

import java.util.ArrayList;

public class Reciclamos 
{
	//////////////////////////////////////////////
	//                 Attributes               //
	//////////////////////////////////////////////
	private ArrayList<Waste> wastes;
	private ArrayList<ProducerProduct> products;

	////////////////////////////////////////////////
	//                 Constructor                //
	////////////////////////////////////////////////
	public Reciclamos ()
	{
		wastes = new ArrayList<Waste>();
		products = new ArrayList<ProducerProduct>();
	} 

	///////////////////////////////////////////////////////////////////////
	//                            Methods 	                             //
	///////////////////////////////////////////////////////////////////////
	
	/**Adds a biodegradable waste to the wastes list.<br>
	*<b>Post:</b>A biodegradable waste is added to the wastes list.<br>
	*@param identifier The waste's identifier number in String. Cannot have letters or spaces.<br>
	*@param name The waste's name. Cannot have numbers.<br>
	*@param origin Integer number representing the origin of the waste. Must be between 1 and 5.<br>
	*@param color The waste's color. Cannot have letters.<br>
	*@param decompositionTime Days the waste takes to decompose. Has to be a positive integer. Cannot be 0.<br>
	*@param canCompost boolean indicating if the waste is compostable or not.<br>
	*/
	public void addWaste (String identifier, String name, int origin, String color, int decompositionTime, boolean canCompost)
	{
		ProducerProduct producerProduct = null;
		
		Waste waste = new BiodegradableWaste(identifier, name, origin, color, decompositionTime, producerProduct, canCompost);
		wastes.add(waste);
	}

	/**Adds a recyclable waste to the wastes list.<br>
	*<b>Post:</b>A recyclable waste is added to the wastes list.<br>
	*@param identifier The waste's identifier number in String. Cannot have letters or spaces.<br>
	*@param name The waste's name. Cannot have numbers.<br>
	*@param origin Integer number representing the origin of the waste. Must be between 1 and 5.<br>
	*@param color The waste's color. Cannot have letters.<br>
	*@param decompositionTime Days the waste takes to decompose. Has to be a positive integer. Cannot be 0.<br>
	*@param type Integer number representing the type of recyclable waste it is.<br>
	*@param throwAwayDesc Description for the correct disposure of the waste.<br>
	*/
	public void addWaste (String identifier, String name, int origin, String color, int decompositionTime, int type, String throwAwayDesc)
	{
		ProducerProduct producerProduct = null;

		Waste waste = new RecyclableWaste(identifier, name, origin, color, decompositionTime, producerProduct, type, throwAwayDesc);
		wastes.add(waste);
	}

	/**Adds an inert waste to the wastes list.<br>
	*<b>Post:</b>An inert waste is added to the wastes list.<br>
	*@param identifier The waste's identifier number in String. Cannot have letters or spaces.<br>
	*@param name The waste's name. Cannot have numbers.<br>
	*@param origin Integer number representing the origin of the waste. Must be between 1 and 5.<br>
	*@param color The waste's color. Cannot have letters.<br>
	*@param decompositionTime Days the waste takes to decompose. Has to be a positive integer. Cannot be 0.<br>
	*@param reductionTips Tips for use reduction of the waste. Cannot be empty.<br>
	*/
	public void addWaste (String identifier, String name, int origin, String color, int decompositionTime, String reductionTips)
	{
		ProducerProduct producerProduct = null;

		Waste waste = new InertWaste(identifier, name, origin, color, decompositionTime, producerProduct, reductionTips);
		wastes.add(waste);
	}

	/**Adds a product to the products list.<br>
	*<b>Post:</b>A product is added to the products list.<br>
	*@param identifier Product's identifier number as String. Cannot have letters or spaces.<br>
	*@param name Product's name. Cannot contain numbers.<br>
	*@param description Brief description of the product.<br>
	*/
	public void addProduct (String identifier, String name, String description)
	{
		ProducerProduct product = new ProducerProduct(identifier, name, description);
		products.add(product);
	}
	/**Assgins a product to a waste.<br>
	*<b>Pre:</b>Both product and waste must be stored in their respective lists.<br>
	*<b>Post:</b>A product is assigned to a waste.<br>
	*@param wasteIdentifier Waste's identifier number as String. Cannot have letters or spaces.<br>
	*@param productIdentifier Product's identifier number as String. Cannot have letters or spaces.<br>
	*/
	public void assignProduct(String wasteIdentifier, String productIdentifier)
	{
		ProducerProduct product = null;
		Waste waste = null;
		boolean done = false;

		for (int i = 0; i < products.size() && done == false;i++)
		{
			if (productIdentifier.equals(products.get(i).getIdentifier()))
			{
				product = products.get(i);
				done = true;
			}
		}

		done = false;

		for (int i = 0; i < wastes.size() && done == false;i++)
		{
			if (wasteIdentifier.equals(wastes.get(i).getIdentifier()))
			{
				waste = wastes.get(i);

				waste.setProducerProduct(product);

				wastes.set(i,waste);
				done = true;
			}
		}
	}
	/**Stores the complete information of a waste in a message.<br>
	<b>Pre:</b>The waste must be stored in the wastes list.<br>
	<b>Post:</b>The information of the waste is stored in a message.<br>
	@param keyword Waste's name. Cannot have numbers.<br>
	@return A message containing the waste's iformation.<br>
	*/
	public String printWasteInfo (String keyword)
	{
		String information = "";
		Waste waste = null;
		boolean found = false;

		for (int i = 0;i < wastes.size() && found == false;i++)
		{
			if (keyword.equalsIgnoreCase(wastes.get(i).getName()))
			{
				waste = wastes.get(i);
				found = true;
			}
		}

		information = waste.toString() + "\n\n" + "~Product information~ \n" + printProductInfo(waste.getProducerProduct().getIdentifier());

		return information;
	}

	/**Stores the complete information of a product in a message.<br>
	*<b>Pre:</b>The product must be stored in the products list.<br>
	*<b>Post:</b>The information of the product was stored in a message.<br>
	*@param keyword Product's identifier number. Cannot have letters. <br>
	*@return A message with the complete information of the product.<br>
	*/
	public String printProductInfo (String keyword)
	{
		String information = "";
		ProducerProduct product = null;
		boolean found = false;

		for (int i = 0;i < products.size() && found == false;i++)
		{
			if (keyword.equals(products.get(i).getIdentifier()))
			{
				product = products.get(i);
				found = true;
			}
		}

		information = product.toString();

		return information;
	}

	/**Stores the information of all products in a message.<br>
	*<b>Post</b>:The information of all products were stored in a message.<br>
	*@return A message containing the information of all the products.<br>
	*/
	public String printProducts ()
	{
		String allProducts = "";
		
		for (int i=0; i < products.size();i++)
		{
			allProducts += "\n~Product #" + (i+1) + "~ " + products.get(i).toString() + "\n";
		}

		return allProducts;
	}

	/**Stores the information of all wastes in a message, sorted by their waste type.<br>
	*<b>Post</b>:The information of all wastes were stored in a message.<br>
	*@return A message containing the information of all the wastes.<br>
	*/
	public String printWastes ()
	{
		int counter = 0;
		String allWastes = "\n$$$$| Biodegradables |$$$$\n";
		
		for (int i=0; i < wastes.size();i++)
		{
			if (wastes.get(i) instanceof BiodegradableWaste)
			{
				++counter;
				allWastes += "\n" + counter + ".\n" + wastes.get(i).toString() + "\n\n~Product information~ \n" + printProductInfo(wastes.get(i).getProducerProduct().getIdentifier()) + "\n";
			}
		}

		counter = 0;
		allWastes += "\n$$$$| Recyclables |$$$$\n";

		for (int i=0;i < wastes.size();i++)
		{
			if (wastes.get(i) instanceof RecyclableWaste)
			{
				++counter;
				allWastes += "\n" + counter + ".\n" + wastes.get(i).toString() + "\n\n~Product information~ \n" + printProductInfo(wastes.get(i).getProducerProduct().getIdentifier()) + "\n";
			} 
		}

		counter = 0;
		allWastes += "\n$$$$| Inerts |$$$$\n";

		for (int i=0;i < wastes.size();i++)
		{
			if (wastes.get(i) instanceof InertWaste)
			{
				++counter;
				allWastes += "\n" + counter + ".\n" + wastes.get(i).toString() + "\n\n~Product information~ \n" + printProductInfo(wastes.get(i).getProducerProduct().getIdentifier()) + "\n";
			}
		}

		return allWastes;
	}

	/**Stores the information of all the wastes of one product, sorted by their nocivity from major to minor.<br>
	*<b>Post</b>:The information of all the wastes of a product was stored in a message.<br>
	*@param identifier Product's identifier number. Cannot have letters or spaces.<br>
	*@return A message containing the information of all the wastes of a product.<br>
	*/
	public String printWastesOfAProduct (String identifier)
	{
		String wastesForPrint = "";
		int counter = 0;
		double comparator = 0;

		for (int i=0;i < products.size();i++)
		{
			if (identifier.equals(products.get(i).getIdentifier()))
			{
				wastesForPrint += "\n~Product information~ \n" + printProductInfo(products.get(i).getIdentifier());
			}
		}

		wastesForPrint += "\n\n~Wastes~\n";
		
		Waste temp = null;

		for (int i=0;i < wastes.size();i++)
		{
			for (int j=0;j < wastes.size() - i - 1;j++)
			{
				if (wastes.get(j).calculateNocivity() < wastes.get(j+1).calculateNocivity())
				{
					temp = wastes.get(j);
					wastes.set(j, wastes.get(j+1));
					wastes.set(j+1,temp);
				}
			}
		}
		
		for (int i=0;i < wastes.size();i++)
		{	
			if (identifier.equals(wastes.get(i).getProducerProduct().getIdentifier()))
			{
				++counter;
				wastesForPrint += "\n" + counter + ".\n" + wastes.get(i).toString() + "\nNocivity: " + wastes.get(i).calculateNocivity() + "\n";
			}
		}
		
		if (counter == 0)
		{
			wastesForPrint += "\nThis product doesn't have wastes assigned yet.";
		}

		return wastesForPrint;
	}

	/**Calculates the nocivity of a specific waste.<br>
	*<b>Pre:</b> The waste list must contain at least 1 waste.<br>
	*<b>Post:</b> The result of the calculation is stored.<br>
	*@param name Waste's name. Must exist in the list.<br>
	*@return A double with the calculation of the nocivity.<br>
	*/
	public double calculateNocivity (String name)
	{
		double nocivity = 0;
		boolean found = false;

		for (int i=0; i < wastes.size() && !found;i++)
		{
			if (name.equalsIgnoreCase(wastes.get(i).getName()))
			{
				nocivity = wastes.get(i).calculateNocivity();
				found = true;
			}
		}

		return nocivity;
	}

	/**Determines if an especific waste can be usable or not.<br>
	*<b>Pre:</b>Wastes list must have at least 1 waste.<br>
	*<b>Post:</b>The usability of the waste is determined.<br>
	*@param name Waste's name. Must exist in wastes list.<br>
	*@return A boolean determining waste's usability.<br>
	*/
	public boolean determineUsability (String name)
	{
		boolean found = false;
		boolean usability = true;

		for (int i=0; i < wastes.size() && !found;i++)
		{
			if (name.equalsIgnoreCase(wastes.get(i).getName()))
			{
				usability = wastes.get(i).determineUsability();
				found = true;
			}
		}

		return usability;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	//                                 Validator methods                               //
	/////////////////////////////////////////////////////////////////////////////////////
	/**Determines if an identifier number for a waste is valid or not.
	*<b>Post:</b>The validity of the identifier number is determined.<br>
	*@param identifier Identifier number.<br>
	*@return A boolean determining the identifier number's validity.<br>
	*/
	public boolean identifierValidator (String identifier)
	{
		if (identifier.matches("[0-9]+") == false)
		{
			return false;
		}

		else 
		{
			boolean found = false;
			
			for (int i = 0; i < wastes.size() && !found; i++)
			{
				if (identifier.equals(wastes.get(i).getIdentifier()))
				{
					found = true;
				}
			}

			if (found == true)
			{
				return false;
			}

			else
			{
				return true;
			}
		}
	}

	/**Determines if an identifier number for a product is valid or not.
	*<b>Post:</b>The validity of the identifier number is determined.<br>
	*@param identifier Identifier number.<br>
	*@return A boolean determining the identifier number's validity.<br>
	*/
	public boolean productIdentifierValidator (String identifier)
	{
		if (identifier.matches("[0-9]+") == false)
		{
			return false;
		}

		else 
		{
			boolean found = false;
			
			for (int i = 0; i < products.size() && !found; i++)
			{
				if (identifier.equals(products.get(i).getIdentifier()))
				{
					found = true;
				}
			}

			if (found == true)
			{
				return false;
			}

			else
			{
				return true;
			}
		}	
	}

	/**Determines if a name for a waste is valid or not.
	*<b>Post:</b>The validity of the name is determined.<br>
	*@param name Waste's name.<br>
	*@return A boolean determining the name's validity.<br>
	*/
	public boolean nameValidator (String name)
	{
		if (name.equals(""))
		{
			return false;
		}

		else if (name.matches("^[A-Z a-z]*$")) 
		{
			boolean found = false;
			
			for (int i = 0; i < wastes.size() && !found; i++)
			{
				if (name.equalsIgnoreCase(wastes.get(i).getName()))
				{
					found = true;
				}
			}

			if (found == true)
			{
				return false;
			}

			else
			{
				return true;
			}
		}

		else if (name.contains("[0-9]+") == false && name.contains(" ") == true)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	/**Determines if a name for a product is valid or not.
	*<b>Post:</b>The validity of the name is determined.<br>
	*@param name Product's name.<br>
	*@return A boolean determining the name's validity.<br>
	*/
	public boolean productNameValidator (String name)
	{
		if (name.equals(""))
		{
			return false;
		}

		else if (name.matches("^[A-Z a-z]*$")) 
		{
			boolean found = false;
			
			for (int i = 0; i < products.size() && !found; i++)
			{
				if (name.equalsIgnoreCase(products.get(i).getName()))
				{
					found = true;
				}
			}

			if (found == true)
			{
				return false;
			}

			else
			{
				return true;
			}
		}

		else if (name.contains("[0-9]+") == false && name.contains(" ") == true)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	/**Determines if a color is valid or not.
	*<b>Post:</b>The validity of the color is determined.<br>
	*@param color Waste's color.<br>
	*@return A boolean determining the color's validity.<br>
	*/
	public boolean colorValidator (String color)
	{
		if (color.equals(""))
		{
			return false;
		}

		else if (color.matches("^[A-Za-z]*$") == true)
		{
			return true;
		}

		else 
		{
			return false;
		}
	}

	/**Determines if a product exists in the products list.<br>
	*<b>Post:</b>The existence of the product is confirmed.<br>
	*@param identifier Product's identifier number as String.<br>
	*@return A boolean determining the product's existence.<br>
	*/
	public boolean productExists (String identifier)
	{
		boolean found = false;

		for (int i = 0;i < products.size() && found == false;i++)
		{	
			if (products.get(i) != null)
			{
				if (identifier.equals(products.get(i).getIdentifier()))
				{
					found = true;
				}
			}
		}

		if (found == true)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	/**Determines if a waste exists in the wastes list.<br>
	*<b>Post:</b>The existence of the waste is confirmed.<br>
	*@param name Waste's name.<br>
	*@return A boolean determining the waste's existence.<br>
	*/
	public boolean wasteExists (String name)
	{
		if (name.equals(""))
		{
			return false;
		}

		else 
		{
			boolean found = false;

			for (int i = 0;i < wastes.size() && found == false;i++)
			{
				if (name.equalsIgnoreCase(wastes.get(i).getName()))
				{
					found = true;
				}
			}

			if (found == true)
			{
				return true;
			}

			else 
			{
				return false;
			}
		}
	}
}
