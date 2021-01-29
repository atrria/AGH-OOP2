public class lab12
{
	public static void main(String[] args)
	{
		handleInput(args);
	}
	
	private static void handleInput(String[] args)
	{
		try
		{
			Dic dic = new Dic();
			dic.loadDic("dic.txt");
			
			switch (args.length)
			{
				case 1:
					System.out.println(dic.getTranslation(args[0]));
					break;
				case 2:
					dic.deleteTranslation(args[1]);
					break;
				case 3:
					dic.addTranslation(new Translation(args[1], args[2]));
					break;
				default:
					System.out.println("Bledna ilosc argumentow wywolania.");
					break;
			}
			dic.printTranslation();
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
		}
	}
}
