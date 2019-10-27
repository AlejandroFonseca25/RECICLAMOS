package model;

public class ProducerProduct
{
	////////////////////////////////////////
	//            Attributes              //
	////////////////////////////////////////
	private String identifier;
	private String name;
	private String description;

	////////////////////////////////////////
	//           Constructor              //
	////////////////////////////////////////
	public ProducerProduct (String identifier, String name, String description)
	{
		this.identifier = identifier;
		this.name = name;
		this.description = description;
	}

	public String toString ()
	{
		String toString = "\nName: " + name + ".\nIdentifier: " + identifier + ".\nDescription: " + description + ".";
		return toString;
	}

	////////////////////////////////////////
	//             Get Methods            //
	////////////////////////////////////////
	public String getIdentifier ()
	{
		return this.identifier;
	}

	public String getName ()
	{
		return this.identifier;
	}

	public String getDescription ()
	{
		return this.description;
	}
}