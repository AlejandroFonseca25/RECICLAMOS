package model;

public class RecyclableWaste extends Waste
{
	////////////////////////////////////////
	//            Attributes              //
	////////////////////////////////////////
	public final static int PAPER = 1;
	public final static int CARDBOARD = 2;
	public final static int GLASS = 3;
	public final static int PLASTIC = 4;
	public final static int METAL = 5;
	private int type;
	private String throwAwayDesc;

	////////////////////////////////////////
	//           Constructor              //
	////////////////////////////////////////
	public RecyclableWaste (String identifier, String name, int origin, String color, int decompositionTime, ProducerProduct producerProduct, int type, String throwAwayDesc)
	{
		super (identifier, name, origin, color, decompositionTime, producerProduct);
		this.type = type;
		this.throwAwayDesc = throwAwayDesc;
	}

	@Override
	public String toString ()
	{
		String information = super.toString() + "\nType: " + typeIntToString() + "\nDescription for correct disposure: " + throwAwayDescForToString() + ".";
		return information;
	}

	public String typeIntToString ()
	{
		String typeString;

		switch (this.type)
		{
			case 1:
			{
				typeString = "Paper.";
				break;
			}

			case 2:
			{
				typeString = "Cardboard.";
				break;
			}

			case 3:
			{
				typeString = "Glass.";
				break;
			}

			case 4:
			{
				typeString = "Plastic.";
				break;
			}

			case 5:
			{
				typeString = "Metal.";
				break;
			}

			default:
			{
				typeString = "";
			}
		}
		return typeString;
	}

	public String throwAwayDescForToString ()
	{
		String newThrowAwayDesc = "";

		if (throwAwayDesc.equals(""))
		{
			newThrowAwayDesc = "No Description";
		}

		else
		{
			newThrowAwayDesc = throwAwayDesc;
		}

		return newThrowAwayDesc;
	}

	@Override
	public double calculateNocivity ()
	{
		double nocivity = 0;

		nocivity = super.calculateNocivity() - (getDecompositionTime() * 0.02);

		return nocivity;
	}

	@Override
	public boolean determineUsability ()
	{
		if (throwAwayDesc != "")
		{
			return true;
		}

		else 
		{
			return false;
		}
	}

	////////////////////////////////////////
	//            Get Methods             //
	////////////////////////////////////////
	public int getType ()
	{
		return this.type;
	}

	public String getThrowAwayDesc ()
	{
		return this.throwAwayDesc;
	}
}