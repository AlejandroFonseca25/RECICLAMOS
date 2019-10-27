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

	////////////////////////////////////////
	//            Get Methods             //
	////////////////////////////////////////
	public boolean getCanCompost ()
	{
		return this.canCompost;
	}
}