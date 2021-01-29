import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class lab08
{
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			System.out.println("Niepoprawna ilość argumentów wywołania, przykład wywołania:\nlab08.java dane.txt wynik.txt");
			System.exit(1);
		}
		
		String input = args[0];
		String output = args[1];
		String result;
		
		double sum = 0;
		int counter = 0;
		
		try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(input), StandardCharsets.UTF_8))
		{
			String string = "";
			while((string = bufferedReader.readLine())!=null)
			{
				sum += Double.parseDouble(string);
				counter++;
			}
		}
		catch (NoSuchFileException | NumberFormatException e)
		{
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
		catch (IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
		
		if(counter <= 0)
		{
			System.out.println("Plik nie zawiera liczb lub jest pusty");
			System.exit(1);
		}
		
		result = String.valueOf(sum/counter);
		
		try(BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(output), StandardCharsets.UTF_8))
		{
			bufferedWriter.write(result, 0, result.length());
		}
		catch (NoSuchFileException e)
		{
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
		catch (IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}
}
