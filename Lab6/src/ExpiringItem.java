public abstract class ExpiringItem extends ItemWithParams
{
	protected int bestBefore;
	
	public Boolean nextDay()
	{
		bestBefore--;
		return bestBefore == 0;
	}
	
	public Boolean isSoldOrDateExpired()
	{
		return isSold || (bestBefore <= 0);
	}
	
	@Override
	public void print()
	{
		super.print();
		System.out.println(" przeterminuje się za: " + bestBefore + " dni.");
	}
}
