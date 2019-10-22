package model;

public class InertWaste extends Waste
{
	////////////////////////////////////////
	//            Attributes              //
	////////////////////////////////////////	
	private String useReduction;

	////////////////////////////////////////
	//           Constructor              //
	////////////////////////////////////////	
	public InertWaste (String identifier, String name, int origin, String color, int decompositionTime, String useReduction)
	{
		super (identifier, name, origin, color, decompositionTime);
		this.useReduction = useReduction;
	}

	////////////////////////////////////////
	//               Methods              //
	////////////////////////////////////////
	public String getUseReduction ()
	{
		return this.useReduction;
	}
}