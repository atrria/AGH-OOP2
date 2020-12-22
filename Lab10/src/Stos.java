public class Stos<T>
{
	private StosElement<T> topElement = null;
	
	public void push(T value)
	{
		StosElement<T> newElement = new StosElement<>(value);
		newElement.setNextElement(topElement);
		topElement = newElement;
	}
	
	public void pop()
	{
		topElement = topElement.getNextElement();
	}
	
	@Override
	public String toString()
	{
		StosElement<T> topElementCopy = topElement;
		StringBuilder stringBuilder = new StringBuilder();
		
		while (topElementCopy != null)
		{
			stringBuilder.append("{" + topElementCopy.getValue() + "} ");
			topElementCopy = topElementCopy.getNextElement();
		}
		
		return stringBuilder.toString();
	}
}

class StosElement<T>
{
	private final T value;
	private StosElement<T> nextElement;
	
	public StosElement(T value)
	{
		this.value = value;
		nextElement = null;
	}
	
	public T getValue()
	{
		return value;
	}
	
	public void setNextElement(StosElement<T> nextElement)
	{
		this.nextElement = nextElement;
	}
	
	StosElement<T> getNextElement()
	{
		return nextElement;
	}
}
