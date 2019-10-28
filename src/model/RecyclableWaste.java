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

	/**Stores the information of the waste in a message.<br>
	<b>Post:</b>The information of the waste was stored in a message.<br>
	@return Message with the information of the waste.<br>
	*/
	@Override
	public String toString ()
	{
		String information = super.toString() + "\nType: " + typeIntToString() + "\nDescription for correct disposure: " + throwAwayDescForToString() + ".";
		return information;
	}

	/**Transforms the type value to its String equivalent.<br>
	<b>Post:</b>The String equivalent of type was stored as String.<br>
	@return Message with the String equivalent of type.<br>
	*/
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

	/**Changes an empty description of disposure to "No description".<br>
	<b>Post:</b>The changes was made or not.<br>
	@return Message with the correct description.<br>
	*/
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

	/**Calculates the nocivity of the waste.<br>
	*<b>Post:</b>The nocivity was calculated.<br>
	*@return The result of the calculation.<br>
	*/
	@Override
	public double calculateNocivity ()
	{
		double nocivity = 0;

		nocivity = super.calculateNocivity() - (getDecompositionTime() * 0.02);

		return nocivity;
	}

	/**Determines the usability of the waste.<br>
	*<b>Post:</b>The usability of the waste is determined.<br>
	*@return Boolean determining the waste's usability.<br>
	*/
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