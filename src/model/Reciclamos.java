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
	//                            Add Methods                            //
	///////////////////////////////////////////////////////////////////////
	
	//THESE METHODS ARE FOR ADDING WASTE WHEN A PRODUCT HAS BEEN CREATED PREVIOUSLY
	//For biodegradable waste
	public String addWaste (String identifier, String name, int origin, String color, int decompositionTime, ProducerProduct producerProduct, boolean canCompost)
	{
		Waste temp = new BiodegradableWaste(identifier, name, origin, color, decompositionTime, producerProduct, canCompost);
		wastes.add(temp);

		String msg = "++++| The waste has been successfully added |++++";
		return msg;
	}

	//For recyclable waste
	public String addWaste (String identifier, String name, int origin, String color, int decompositionTime, ProducerProduct producerProduct, int type, String throwAwayDesc)
	{
		Waste temp = new RecyclableWaste(identifier, name, origin, color, decompositionTime, producerProduct, type, throwAwayDesc);
		wastes.add(temp);

		String msg = "++++| The waste has been successfully added |++++";
		return msg;
	}

	//For intert waste
	public String addWaste (String identifier, String name, int origin, String color, int decompositionTime, ProducerProduct producerProduct, String useReduction)
	{
		Waste temp = new InertWaste(identifier, name, origin, color, decompositionTime, producerProduct, useReduction);
		wastes.add(temp);

		String msg = "++++| The waste has been successfully added |++++";
		return msg;
	}

	//THESE METHODS ARE FOR ADDING WASTE WHEN THE USER HAS TO CREATE THE PRODUCT TOO
	//For biodegradable waste
	public String addWaste (String identifier, String name, int origin, String color, int decompositionTime, boolean canCompost, String productIdentifier, String productName, String description)//Add method for biodegradable w/o product
	{
		ProducerProduct pTemp = new ProducerProduct(productIdentifier, productName, description);
		products.add(pTemp);
		Waste temp = new BiodegradableWaste(identifier, name, origin, color, decompositionTime, pTemp, canCompost);
		wastes.add(temp);

		String msg = "++++| The waste has been successfully added |++++";
		return msg;
	}

	//For recyclable waste
	public String addWaste (String identifier, String name, int origin, String color, int decompositionTime, int type, String throwAwayDesc, String productIdentifier, String productName, String description)//Add method for biodegradable w/o product
	{
		ProducerProduct pTemp = new ProducerProduct(productIdentifier, productName, description);
		products.add(pTemp);
		Waste temp = new RecyclableWaste(identifier, name, origin, color, decompositionTime, pTemp, type, throwAwayDesc);
		wastes.add(temp);

		String msg = "++++| The waste has been successfully added |++++";
		return msg;
	}

	//For inert waste
	public String addWaste (String identifier, String name, int origin, String color, int decompositionTime, String useReduction, String productIdentifier, String productName, String description)//Add method for biodegradable w/o product
	{
		ProducerProduct pTemp = new ProducerProduct(productIdentifier, productName, description);
		products.add(pTemp);
		Waste temp = new InertWaste(identifier, name, origin, color, decompositionTime, pTemp, useReduction);
		wastes.add(temp);

		String msg = "++++| The waste has been successfully added |++++";
		return msg;
	}

	//THIS METHOD IS FOR WHEN A PRODUCT IS ADDED WITHOUT WASTES
	public String addProduct (String identifier, String name, String description)
	{
		boolean ok = true;
		
		if (!identifier.matches("[0-9]+") || !name.matches("[a-zA-Z]+"))
		{
			String msg = "xxxx| Error: Invalid entries. Make sure that you're obeying the instructions. |xxxx";
			return msg;
		}

		else
		{
			ProducerProduct temp = new ProducerProduct(identifier, name, description);
			products.add(temp);
			String msg = "++++| The product has been successfully added |++++";
			return msg;
		}
	}
}
