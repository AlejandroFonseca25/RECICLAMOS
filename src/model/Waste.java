package model;

public abstract class Waste 
{
	////////////////////////////////////////
	//            Attributes              //
	////////////////////////////////////////
	public final static int INDUSTRIAL = 1;
	public final static int DOMICILIARY = 2;
	public final static int MUNICIPAL = 3;
	public final static int CONSTRUCTION = 4; 
	public final static int HOSPITALARY = 5;
	private String identifier;
	private String name;
	private int origin;
	private String color;
	private int decompositionTime;
	private ProducerProduct producerProduct;

	////////////////////////////////////////
	//            Constructor             //
	////////////////////////////////////////
	public Waste (String identifier, String name, int origin, String color, int decompositionTime, ProducerProduct producerProduct)
	{
		this.identifier = identifier;
		this.name = name;
		this.origin = origin;
		this.color = color;
		this.decompositionTime = decompositionTime;
		this.producerProduct = producerProduct;
	}

	/**Calculates the nocivity of the waste.<br>
	*<b>Post:</b>The nocivity was calculated.<br>
	*@return The result of the calculation.<br>
	*/
	public double calculateNocivity ()
	{
		double nocivity = 0; 

		switch (origin)
		{
			case 1:
			nocivity = decompositionTime * 0.10;
			break;

			case 2:
			nocivity = decompositionTime * 0.05;
			break;

			case 3:
			nocivity = decompositionTime * 0.12;
			break;

			case 4:
			nocivity = decompositionTime * 0.08;
			break;

			case 5:
			nocivity = decompositionTime * 0.15; 
			break;
		}

		return nocivity;
	}

	/**Determines the usability of the waste.<br>
	*<b>Post:</b>The usability of the waste is determined.<br>
	*@return Boolean determining the waste's usability.<br>
	*/
	public abstract boolean determineUsability ();

	////////////////////////////////////////
	//            Get methods             //
	////////////////////////////////////////
	public String getIdentifier ()
	{
		return this.identifier;
	}

	public String getName ()
	{
		return this.name;
	}

	public int getOrigin ()
	{
		return this.origin;
	}

	public String getColor ()
	{
		return this.color;
	}	

	public int getDecompositionTime ()
	{
		return this.decompositionTime;
	}	

	public ProducerProduct getProducerProduct ()
	{
		return this.producerProduct;
	}

	public void setProducerProduct (ProducerProduct producerProduct)
	{
		this.producerProduct = producerProduct;
	}

	/**Stores the information of the waste in a message.<br>
	<b>Post:</b>The information of the waste was stored in a message.<br>
	@return Message with the information of the waste.<br>
	*/
	public String toString ()
	{
		String toString = "Name: " + name + "." + "\nIdentifier: " + identifier + ".\nOrigin: " + originIntToString() + "\nColor: " + color + ".\nDecomposition time: " + decompositionTime + " days.";
		return toString;
	}

	/**Transforms the origin value to its String equivalent.<br>
	<b>Post:</b>The String equivalent of origin was stored as String.<br>
	@return Message with the String equivalent of origin.<br>
	*/
	public String originIntToString ()
	{
		String originString;

		switch (this.origin)
		{
			case 1:
			{
				originString = "Industrial.";
				break;
			}

			case 2:
			{
				originString = "Domiciliary.";
				break;
			}

			case 3:
			{
				originString = "Municipal.";
				break;
			}

			case 4:
			{
				originString = "Construction.";
				break;
			}

			case 5:
			{
				originString = "Hospitalary.";
				break;
			}

			default:
			{
				originString = "";
			}
		}

		return originString;
	}
}