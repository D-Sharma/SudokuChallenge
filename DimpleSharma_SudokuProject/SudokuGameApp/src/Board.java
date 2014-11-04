
public class Board implements SudokuConstants
{

	private Square[][] squares;
	private boolean stateChanged;
	
	public Board()
	{
		
	}
	
	public Board(int[][] contents)
	{
		this.NewGame(contents);
	}
	
	//This method creates a new sudoku board game.
	public void NewGame(int[][] contents)
	{
		boolean isPrefilled = false;
		int value = 0;
		
		//Create squares for sudoku board game
		squares = new Square[ROWS][COLS];
		
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLS; j++)
			{
				value = contents[i][j];
				if(value != 0)
					isPrefilled = true;
				else
					isPrefilled = false;
					
				Square square = new Square(value, isPrefilled);
				squares[i][j] = square;
			}
			
		}
		
		stateChanged = false;
	}
	
	//Getter method that returns square
	public Square[][] getSquares()
	{
		return this.squares;
	}
	
	//This method prints sudoku puzzle as string
	@Override
	public String toString()
	{
		String result = "";
		
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLS; j++)
			{
				result += squares[i][j].getValue().toString() + ",";
			}
			
			result += "\n";
		}
		
		return result;
	}
	
	
	
}
