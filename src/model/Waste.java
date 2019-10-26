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

	public void setProducerProduct (ProducerProduct producerProduct)
	{
		this.producerProduct = producerProduct;
	}
}