import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader {
	
	public Reader()
	{
		
	}

	//This method reads sudoku puzzle from csv file
	public Board readCsv(String filePath)
	{
		int[][] intContents = new int[9][9];
		Board board = null;
		
		Path path = Paths.get(filePath);
		System.out.println(path.getFileName());
		
		if(Files.exists(path))
		{		
			File file = path.toFile();
			try (BufferedReader in =
					new BufferedReader(
					new FileReader(file)))
					{					
						String line = in.readLine();
						int i = 0;
						String seperator = ",";
						while(line != null)
						{	
							String[] content = line.split(seperator);
							
							int j = 0;
							for(String str : content)
							{
								intContents[i][j] = Integer.parseInt(str);
								j++;
							}
							line = in.readLine();
							i++;
						}
						
						board = new Board(intContents);						
					}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		else
		{
			System.out.println(path.toAbsolutePath() + " doesn't exist");
		}
		
		return board;
		
	}
	
	//This method saves solved sudoku puzzle as csv file
	public void writeCsv(Board board, String fileName)
	{
		String sudoku = board.toString();
		try
		{
			File file = new File(fileName);  
	        if ( !file.exists() )
	            file.createNewFile();
	        
	        FileWriter fileWriter = new FileWriter(file);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	        bufferedWriter.write(sudoku);
	        bufferedWriter.close();
		}		
		catch(IOException e)
		{
			System.out.println(e);
		}
		
	}
}
