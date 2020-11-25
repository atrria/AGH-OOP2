public interface Item
{
	void setParams(String name, double wholesalePrice, double detailPrice);
	void print();
	Boolean nextDay();
	double getWholesalePrice();
	double getDetailPrice();
	void markAsSold();
	Boolean isSoldOrDateExpired();
}
