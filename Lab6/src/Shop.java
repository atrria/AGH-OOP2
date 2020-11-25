import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shop
{
	private Item[] items;
	private int itemsCount;
	private double gain;
	private BufferedReader bufferedReader;
	
	public Shop(int capacity)
	{
		items = new Item[capacity];
		itemsCount = 0;
		gain = 0;
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void addItem(Item item)
	{
		items[itemsCount] = item;
		fillItemInfo(items[itemsCount]);
		itemsCount++;
	}
	
	public void sellItem()
	{
		for (int i = 0; i < itemsCount; i++)
		{
			if (!items[i].isSoldOrDateExpired())
			{
				System.out.print(i + ") ");
				items[i].print();
				System.out.println();
			}
		}
		
		while (true)
		{
			try
			{
				System.out.println("Wybierz towar do sprzedania:");
				int itemId = Integer.parseInt(bufferedReader.readLine());
				items[itemId].markAsSold();
				gain += items[itemId].getDetailPrice();
				break;
			} catch (IOException | NullPointerException | NumberFormatException e)
			{
				System.out.println("Niepoprawny indeks towaru.");
			}
		}
	}
	
	public void nextDay()
	{
		for (int i = 0; i < itemsCount; i++)
		{
			if (items[i].nextDay())
			{
				gain -= items[i].getWholesalePrice();
			}
		}
	}
	
	public void balance()
	{
		for (int i = 0; i < itemsCount; i++)
		{
			System.out.println("Towary zepsute lub sprzedane:");
			if (items[i].isSoldOrDateExpired())
			{
				System.out.print(i + ") ");
				items[i].print();
				System.out.println();
			}
		}
		System.out.println("Bilans: " + gain);
	}
	
	public Fruit addFruit()
	{
		return new Fruit();
	}
	
	public Vegetable addVegetable()
	{
		return new Vegetable();
	}
	
	public AGD addAGD()
	{
		return new AGD();
	}
	
	private void fillItemInfo(Item item)
	{
		try
		{
			System.out.println("Podaj nazwę:");
			String name = bufferedReader.readLine();
			System.out.println("Podaj cenę zakupu:");
			double wholesalePrice = Double.parseDouble(bufferedReader.readLine());
			System.out.println("Podaj cenę sprzedaży:");
			double detailPrice = Double.parseDouble(bufferedReader.readLine());
			item.setParams(name, wholesalePrice, detailPrice);
		} catch (IOException e)
		{
			System.out.println("Błędne dane wejściowe.");
		}
	}
}
