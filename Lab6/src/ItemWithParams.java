public abstract class ItemWithParams implements Item
{
	protected String name;
	protected double wholesalePrice;
	protected double detailPrice;
	protected Boolean isSold = false;
	
	@Override
	public void setParams(String name, double wholesalePrice, double detailPrice)
	{
		this.name = name;
		this.wholesalePrice = wholesalePrice;
		this.detailPrice = detailPrice;
	}
	
	@Override
	public void print()
	{
		System.out.println(name + " cena zakupu: " + wholesalePrice + ", cena sprzedaży: " + detailPrice + ",");
	}
	
	@Override
	public double getWholesalePrice()
	{
		return wholesalePrice;
	}
	
	@Override
	public double getDetailPrice()
	{
		return detailPrice;
	}
	
	@Override
	public Boolean nextDay()
	{
		return false;
	}
	
	@Override
	public void markAsSold()
	{
		isSold = true;
	}
	
	@Override
	public Boolean isSoldOrDateExpired()
	{
		return isSold;
	}
}
