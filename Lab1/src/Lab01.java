import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

class Lab01
{
	public static void generate(int n, double rmax)
	{
			Random rnd = new Random();
			double x, y;
			int numOfPoints = 0;
			try
			{
				FileWriter file = new FileWriter("circle.dat");

				while(numOfPoints < n)
				{
					x=rnd.nextDouble() * rmax;
					y=rnd.nextDouble() * rmax;
					if(x*x + y*y <= rmax*rmax)
					{
						System.out.println(x + " " + y);
						file.write(x + " " + y + "\n");
						numOfPoints++;
					}
				}
				file.close();
			}
			catch (IOException e)
			{
				System.out.println("Nie utworzono pliku");
			}
	}

  public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		double rmax = Double.parseDouble(args[1]);

		generate(n, rmax);
  }

}