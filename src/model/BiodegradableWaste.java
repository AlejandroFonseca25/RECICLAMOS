package model;

public class BiodegradableWaste extends Waste
{
	////////////////////////////////////////
	//            Attributes              //
	////////////////////////////////////////
	private boolean canCompost;

	////////////////////////////////////////
	//           Constructor              //
	////////////////////////////////////////
	public BiodegradableWaste (String identifier, String name, int origin, String color, int decompositionTime, ProducerProduct producerProduct, boolean canCompost)
	{
		super (identifier, name, origin, color, decompositionTime, producerProduct);
		this.canCompost = canCompost;
	}

	/**Stores the information of the waste in a message.<br>
	<b>Post:</b>The information of the waste was stored in a message.<br>
	@return Message with the information of the waste.<br>
	*/
	@Override
	public String toString ()
	{
		String compostability;

		if (canCompost == false)
		{
			compostability = "Not compostable.";
		}

		else
		{
			compostability = "Compostable.";
		}
		String information = super.toString() + "\nCompostability: " + compostability;
		return information;
	}

	/**Calculates the nocivity of the waste.<br>
	*<b>Post:</b>The nocivity was calculated.<br>
	*@return The result of the calculation.<br>
	*/
	@Override
	public double calculateNocivity ()
	{
		double nocivity = 0;

		if (canCompost == true)
		{
			nocivity = super.calculateNocivity() - (getDecompositionTime() * 0.01);
		}

		else
		{
			nocivity = super.calculateNocivity();
		}

		return nocivity;
	}

	/**Determines the usability of the waste.<br>
	*<b>Post:</b>The usability of the waste is determined.<br>
	*@return Boolean determining the waste's usability.<br>
	*/
	@Override
	public boolean determineUsability ()
	{
		if (getDecompositionTime() < 365 && canCompost)
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
	public boolean getCanCompost ()
	{
		return this.canCompost;
	}
}