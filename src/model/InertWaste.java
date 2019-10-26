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

	////////////////////////////////////////
	//            Get Methods             //
	////////////////////////////////////////
	public String getUseReduction ()
	{
		return this.reductionTips;
	}
}