import java.io.*;
import java.util.ArrayList;

public class Dic
{
	private final ArrayList<Translation> dic = new ArrayList<>();
	private String fileName;
	
	public void loadDic(String fileName)
	{
		this.fileName = fileName;
		
		File file = new File(this.fileName);
		
		if (file.exists())
		{
			BufferedReader bufferedReader;
			try
			{
				bufferedReader = new BufferedReader(new FileReader(fileName));
				String line = bufferedReader.readLine();
				
				while (line != null)
				{
					String[] splitLine = line.split(" ");
					Translation newTranslation = new Translation(splitLine[0], splitLine[1]);
					dic.add(newTranslation);
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
			}
			catch (IOException ioException)
			{
				ioException.printStackTrace();
			}
		}
		else
		{
			try
			{
				file.createNewFile();
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	public String getTranslation(String word)
	{
		for (Translation translation : this.dic)
		{
			String translated = translation.getTranslation(word);
			if (translated != null)
			{
				return translated;
			}
		}
		return "Brak slowa " + word + " w slowniku.";
	}
	
	public void deleteTranslation(String word)
	{
		int i = 0, idx = -1;
		for (Translation translation : this.dic)
		{
			if (translation.exists(word))
			{
				idx = i;
				break;
			}
			i++;
		}
		if (idx != -1)
		{
			this.dic.remove(idx);
		}
	}
	
	public void addTranslation(Translation translation)
	{
		boolean canAdd = true;
		for (Translation translation2 : this.dic)
		{
			if (translation2.exists(translation.getValue()) || translation2.exists(translation.getKey()))
			{
				canAdd = false;
				System.out.println("Slowo " + translation2 + " znajduje sie juz w slowniku.");
				break;
			}
		}
		if (canAdd)
		{
			System.out.println("Slowo " + translation + " zostalo dodane do slownika.");
			this.dic.add(translation);
		}
	}
	
	public void printTranslation()
	{
		try
		{
			PrintWriter writer = new PrintWriter(fileName);
			for (Translation translation : this.dic)
			{
				writer.print(translation);
			}
			writer.close();
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			fileNotFoundException.printStackTrace();
		}
	}
}
