package model;

public class RecyclableWaste extends Waste
{
	////////////////////////////////////////
	//            Attributes              //
	////////////////////////////////////////
	public final static int PAPER = 1;
	public final static int CARDBOARD = 2;
	public final static int GLASS = 3;
	public final static int PLASTIC = 4;
	public final static int METAL = 5;
	private int type;
	private String throwAwayDesc;

	////////////////////////////////////////
	//           Constructor              //
	////////////////////////////////////////
	public RecyclableWaste (String identifier, String name, int origin, String color, int decompositionTime, int type, String throwAwayDesc)
	{
		super (identifier, name, origin, color, decompositionTime);
		this.type = type;
		this.throwAwayDesc = throwAwayDesc;
	}

	////////////////////////////////////////
	//               Methods              //
	////////////////////////////////////////
	public int getType ()
	{
		return this.type;
	}

	public String getThrowAwayDesc ()
	{
		return this.throwAwayDesc;
	}
}