import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

class Add
{
	public static void add(int... vals)
	{
		int sum = vals[0];
		System.out.printf("%d", vals[0]);
		for (int i = 1; i < vals.length; i++)
		{
			sum += vals[i];
			System.out.printf("+%d", vals[i]);
		}
		System.out.printf("=%d%n", sum);
	}
}

public class lab07
{
	public static double calculate(DoubleBinaryOperator doubleBinaryOperator, double val1, double val2)
	{
		return doubleBinaryOperator.applyAsDouble(val1, val2);
	}
	
	public static double calculate(DoubleUnaryOperator doubleUnaryOperator, double val)
	{
		return doubleUnaryOperator.applyAsDouble(val);
	}
	
	//Tej metody nie wolno zmieniaÄ!!!! (ResztÄ pliku wolno).
	public static void main(String[] args)
	{
		System.out.printf("2.2 + 2.2 = %f%n", calculate((double v1, double v2) -> v1 + v2, 2.2, 2.2));
		System.out.printf("44 / 2.0 = %f%n", calculate((v1, v2) -> v1 / v2, 44, 2.0));
		System.out.printf("-66 = %f%n", calculate(v -> -v, 66));
		System.out.printf("8 * 8 = %f%n", calculate((double v) -> v * v, 8));
		
		//Uwaga! Klasa Add MUSI zawieraÄ tylko jednÄ funkcjÄ!!!!
		Add oblicz = new Add();
		oblicz.add(1, 2);
		oblicz.add(1, 2, 3);
		oblicz.add(1, 2, 3, 4, 5);
		oblicz.add(1, 2, 3, 4, 5, 6);
	}
}

/*
WyjĹcie z programu wyglÄda tak:

2.2 + 2.2 = 4,400000
44 / 2.0 = 22,000000
-66 = -66,000000
8 * 8 = 64,000000
1+2=3
1+2+3=6
1+2+3+4+5=15
1+2+3+4+5+6=21
*/