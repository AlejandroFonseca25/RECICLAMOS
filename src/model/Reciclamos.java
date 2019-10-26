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

		for (int i = 0; i < products.size() && done == true;i++)
		{
			if (productIdentifier.equals(products.get(i).getIdentifier()))
			{
				product = products.get(i);
				done = true;
			}
		}

		done = false;

		for (int i = 0; i < wastes.size() && done == true;i++)
		{
			if (wasteIdentifier.equals(wastes.get(i).getIdentifier()))
			{
				wastes.get(i).setProducerProduct(product);

			}
		}
	}

	public String printWasteInfo (String keyword)
	{
		String information = "";
		
		return information; 
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

		else if (name.matches("^[A-Za-z]*$") == true) 
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
		if (name.contains("[0-9]+") == true)
		{
			return false;
		}

		else 
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

	public boolean wasteExists (String keyword)
	{
		if (keyword.equals(""))
		{
			return false;
		}

		else 
		{
			boolean found = false;

			for (int i = 0;i < wastes.size() && found == false;i++)
			{
				if (keyword.equalsIgnoreCase(wastes.get(i).getName()))
				{
					found = true;
				}

				else if (keyword.equalsIgnoreCase(wastes.get(i).getIdentifier()))
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
