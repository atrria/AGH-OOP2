public class Translation
{
	private final String key;
	private final String value;
	
	Translation(String key, String value)
	{
		this.key = key;
		this.value = value;
	}
	
	public String getKey()
	{
		return key;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public boolean exists(String word)
	{
		return word.equals(this.value) || word.equals(this.key);
	}
	
	public String getTranslation(String word)
	{
		if (word.equals(this.key))
		{
			return this.value;
		}
		else if (word.equals(this.value))
		{
			return this.key;
		}
		return null;
	}
	
	@Override
	public String toString()
	{
		return key + " " + value + "\n";
	}
}
