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

	/**Stores the information of the product in a message.<br>
	<b>Post:</b>The information of the product was stored in a message.<br>
	@return Message with the information of the product.<br>
	*/
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