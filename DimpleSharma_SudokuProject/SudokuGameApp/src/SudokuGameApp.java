
public class SudokuGameApp {

	static Reader reader;
	public static void main(String[] args) {
		
		reader = new Reader();
		
		String input = "sudoku.csv";
		String output = "sudokuSolved.csv";
		
		Board board = reader.readCsv(input);
		
		System.out.println( board.toString());
		Solver solver = new Solver();
		solver.SolvePuzzle(board.getSquares());
		System.out.println( board.toString());
		
		//write sudoku to csv file
		reader.writeCsv(board, output);
	}

}
