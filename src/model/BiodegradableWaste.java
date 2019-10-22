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
	public BiodegradableWaste (String identifier, String name, int origin, String color, int decompositionTime, boolean canCompost)
	{
		super (identifier, name, origin, color, decompositionTime);
		this.canCompost = canCompost;
	}

	////////////////////////////////////////
	//               Methods              //
	////////////////////////////////////////
	public boolean getCanCompost ()
	{
		return this.canCompost;
	}
}