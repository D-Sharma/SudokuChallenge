import java.util.ArrayList;


public class Square  
{	
	private Integer value;
	private boolean isPreset;
	private ArrayList<Integer> possibleValues;
	
	public Square()
	{
		
	}
	
	public Square(int value, boolean isPreset)
	{
		this.value = value;
		this.isPreset = isPreset;
		
	}
	
	public Integer getValue()
	{
		return value;
	}
	
	public void setValue(Integer value)
	{
		this.value = value;
	}
	
	public boolean getIsPreset()
	{
		return this.isPreset;
	}
	
	public void setIsPreset(boolean isPreset)
	{
		this.isPreset = isPreset;
	}
	
	public ArrayList<Integer> getPossibleValue()
	{
		return this.possibleValues;
	}
	
	public void setPossibleValue(ArrayList<Integer> possibleValues)
	{
		this.possibleValues = possibleValues;
	}

}
