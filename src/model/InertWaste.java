package model;

public class InertWaste extends Waste
{
	////////////////////////////////////////
	//            Attributes              //
	////////////////////////////////////////	
	private String reductionTips;

	////////////////////////////////////////
	//           Constructor              //
	////////////////////////////////////////	
	public InertWaste (String identifier, String name, int origin, String color, int decompositionTime, ProducerProduct producerProduct, String reductionTips)
	{
		super (identifier, name, origin, color, decompositionTime, producerProduct);
		this.reductionTips = reductionTips;
	}

	@Override
	public String toString ()
	{
		String information = super.toString() + "\nTips for usage reduction: " + reductionTips + ".";
		return information;
	}
	////////////////////////////////////////
	//            Get Methods             //
	////////////////////////////////////////
	public String getUseReduction ()
	{
		return this.reductionTips;
	}
}