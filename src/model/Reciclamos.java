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
	
	//For biodegradable waste
	public void addWaste (String identifier, String name, int origin, String color, int decompositionTime, boolean canCompost)
	{
		ProducerProduct producerProduct = null;
		
		Waste waste = new BiodegradableWaste(identifier, name, origin, color, decompositionTime, producerProduct, canCompost);
		wastes.add(waste);
	}

	//For recyclable waste
	public void addWaste (String identifier, String name, int origin, String color, int decompositionTime, int type, String throwAwayDesc)
	{
		ProducerProduct producerProduct = null;

		Waste waste = new RecyclableWaste(identifier, name, origin, color, decompositionTime, producerProduct, type, throwAwayDesc);
		wastes.add(waste);
	}

	//For intert waste
	public void addWaste (String identifier, String name, int origin, String color, int decompositionTime, String reductionTips)
	{
		ProducerProduct producerProduct = null;

		Waste waste = new InertWaste(identifier, name, origin, color, decompositionTime, producerProduct, reductionTips);
		wastes.add(waste);
	}

	public void addProduct (String identifier, String name, String description)
	{
		ProducerProduct product = new ProducerProduct(identifier, name, description);
		products.add(product);
	}

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

	public String printProducts ()
	{
		String allProducts = "";
		
		for (int i=0; i < products.size();i++)
		{
			allProducts += "\n~Product #" + (i+1) + "~ " + products.get(i).toString() + "\n";
		}

		return allProducts;
	}

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
