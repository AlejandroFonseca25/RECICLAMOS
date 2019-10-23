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
	public InertWaste (String identifier, String name, int origin, String color, int decompositionTime, ProducerProduct producerProduct, String useReduction)
	{
		super (identifier, name, origin, color, decompositionTime, producerProduct);
		this.useReduction = useReduction;
	}

	////////////////////////////////////////
	//            Get Methods             //
	////////////////////////////////////////
	public String getUseReduction ()
	{
		return this.useReduction;
	}
}