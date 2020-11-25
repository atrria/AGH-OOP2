import java.util.Scanner;

public class lab06
{
	private static Shop shop = new Shop(10);
	private static Scanner keys = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		while (true)
		{
			System.out.println("Wybierz opcję:\n1) Dodaj towar\n2) Sprzedaj towar\n3) Kolejny dzień\n4) Bilans\nX) Koniec programu");
			char key = keys.next().charAt(0);
			
			if(Character.toLowerCase(key)=='x')
			{
				return;
			}
			else if(key=='1')
			{
				addItem();
			}
			else if(key=='2')
			{
				shop.sellItem();
			}
			else if(key=='3')
			{
				shop.nextDay();
			}
			else if(key=='4')
			{
				shop.balance();
			}
		}
	}
	
	public static void addItem()
	{
		System.out.println("Wybierz opcję:\n1) dodaj owoc\n2) dodaj warzywo\n3) dodaj drobne agd");
		char key = keys.next().charAt(0);
		
		if(key=='1')
		{
			shop.addItem(shop.addFruit());
		}
		else if(key=='2')
		{
			shop.addItem(shop.addVegetable());
		}
		else if(key=='3')
		{
			shop.addItem(shop.addAGD());
		}
	}
}
