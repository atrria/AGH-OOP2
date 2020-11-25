import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Command
{
	public final String keyWord;
	public final double value;
	
	public Command(String keyWord, double value)
	{
		this.keyWord = keyWord;
		this.value = value;
	}
	
	public Command(String keyWord)
	{
		this(keyWord, 0.0);
	}
}

public class turtle
{
	private double x;
	private double y;
	private double angle;
	private final List<Command> commands = new ArrayList<>();
	
	public turtle(double x, double y, String fileName)
	{
		this.x = x;
		this.y = y;
		this.angle = 0.0;
		
		try
		{
			File file = new File(fileName);
			//System.out.println(file.getAbsolutePath());
			Scanner readFile = new Scanner(file);
			while (readFile.hasNextLine())
			{
				String[] line = readFile.nextLine().split(" ");
				if (line.length == 1)
				{
					commands.add(new Command(line[0]));
				}
				else
				{
					commands.add(new Command(line[0], Integer.parseInt(line[1])));
				}
			}
		} catch (FileNotFoundException e)
		{
			System.out.println("Błąd otwierania pliku.");
			System.exit(1);
		}
	}
	
	private void move(int i)
	{
		this.x += commands.get(i).value * Math.cos(2.0 * Math.PI * this.angle / 360.0);
		this.y += commands.get(i).value * Math.sin(2.0 * Math.PI * this.angle / 360.0);
	}
	
	private void draw(int i)
	{
		System.out.println(this.x + " " + this.y);
		move(i);
		System.out.println(this.x + " " + this.y);
	}
	
	public void generate()
	{
		int repeats = 0;
		int iJump = 0;
		
		for (int i = 0; i < commands.size(); i++)
		{
			switch (commands.get(i).keyWord)
			{
				case "DRAW":
					draw(i);
					break;
				case "MOVE":
					move(i);
					break;
				case "RIGHT":
					this.angle -= commands.get(i).value;
					break;
				case "LEFT":
					this.angle += commands.get(i).value;
					break;
				case "HOME":
					this.angle = 90.0;
					this.x = 0.0;
					this.y = 0.0;
					break;
				case "REPEAT":
					repeats = (int)commands.get(i).value - 1;
					iJump = i;
					break;
				case "NEXT":
					if (repeats > 0)
					{
						i = iJump;
						repeats--;
					}
					break;
				case "END":
					break;
			}
		}
	}
}
