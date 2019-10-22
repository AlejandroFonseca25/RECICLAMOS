package model;

import java.util.ArrayList;
public class Reciclamos
{
	////////////////////////////////////////
	//            Attributes              //
	////////////////////////////////////////
	private ArrayList<Waste> wastes;
	private ArrayList<ProducerProduct> products;

	////////////////////////////////////////
	//           Constructor              //
	////////////////////////////////////////
	public Reciclamos ()
	{
		wastes = new ArrayList<Waste>();
		products = new ArrayList<ProducerProduct>();
	} 

	////////////////////////////////////////
	//               Methods              //
	////////////////////////////////////////
	public String addWaste (String identifier, String name, int origin, String color, int decompositionTime, boolean canCompost)//Add method for biodegradable
	{
		Waste temp = new BiodegradableWaste(identifier, name, origin, color, decompositionTime, canCompost);
		wastes.add(temp);
	}

	public String addWaste (String identifier, String name, int origin, String color, int decompositionTime, int type, String throwAwayDesc)//Add method for recyclable
	{
		Waste temp = new RecyclableWaste(identifier, name, origin, color, decompositionTime, type, throwAwayDesc);
		wastes.add(temp);
	}

	public String addWaste (String identifier, String name, int origin, String color, int decompositionTime, String useReduction)//Add method for inert
	{
		Waste temp = new InertWaste(identifier, name, origin, color, decompositionTime, useReduction);
		wastes.add(temp);
	}

	public 
}
