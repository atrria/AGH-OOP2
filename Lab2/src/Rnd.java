import java.util.Arrays;
import java.util.Random;

public class Rnd
{
	double[] randomNumberArray;
	
	public Rnd(int N, int k)
	{
		randomNumberArray = new double[N];
		Random randomGenerator = new Random();
		
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < k; j++)
			{
				randomNumberArray[i] += randomGenerator.nextDouble();
			}
		}
	}
	
	public void Print()
	{
		for (int i = 0; i < randomNumberArray.length; i++)
		{
			System.out.println("[" + i + "]=" + randomNumberArray[i]);
		}
	}
	
	public double Min()
	{
		return Arrays.stream(randomNumberArray).min().orElse(-1);
	}
	
	public double Max()
	{
		return Arrays.stream(randomNumberArray).max().orElse(-1);
	}
	
	public double Average()
	{
		return Arrays.stream(randomNumberArray).sum() / randomNumberArray.length;
	}
	
	public void Draw()
	{
		for (int i = 0; i < randomNumberArray.length; i++)
		{
			System.out.println("[" + i + "]:" + printAsterisks((int)((randomNumberArray[i] - Min()) / ((Max() - Min()) / 50.))));
		}
	}
	
	public static String printAsterisks(int numberOfAsterisks)
	{
		char[] chars = new char[numberOfAsterisks];
		Arrays.fill(chars, '*');
		return new String(chars);
	}
}
