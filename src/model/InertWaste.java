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

	/**Stores the information of the waste in a message.<br>
	<b>Post:</b>The information of the waste was stored in a message.<br>
	@return Message with the information of the waste.<br>
	*/
	@Override
	public String toString ()
	{
		String information = super.toString() + "\nTips for usage reduction: " + reductionTips + ".";
		return information;
	}

	/**Sets the usability of the waste as false.<br>
	*<b>Post:</b>The usability of the waste is determined as false.<br>
	*@return Boolean determining the waste's usability as false.<br>
	*/
	@Override
	public boolean determineUsability ()
	{
		return false;
	}
	////////////////////////////////////////
	//            Get Methods             //
	////////////////////////////////////////
	public String getUseReduction ()
	{
		return this.reductionTips;
	}
}