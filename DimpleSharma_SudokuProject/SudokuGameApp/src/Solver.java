/*
 * Solver class implements backtracking algorithm.
 * This class implements methods that helps solve sudoku puzzle
 * 
 */

import java.util.ArrayList;

public class Solver implements SudokuConstants{

	public Solver()
	{
		
	}
	
	//This method initiates solving sudoku using backtracking algorithm
	public void SolvePuzzle(Square[][] squares)
	{		
		boolean result = solve(squares, 0, 0);
		
		if(result)
			System.out.println("Sudoku puzzle successfully solved");
		else
			System.out.println("Sudoku puzzle does not have a solution");
		
	}
	
	//This finds unassigned squares and try to find a number that solves the puzzle
	private boolean solve(Square[][] squares, int rowNum, int colNum)
	{		
		//find unassigned squares in the puzzle
		int[] result = findUnassignedSquare(squares);
		
		if(result[0] == ROWS && result[1] == COLS)
			return true; //Solved
		else
		{
			rowNum = result[0];
			colNum = result[1];
		}
		
		//Find a number that solves the current square
		 if(findNumber(squares, rowNum, colNum))
			 return true;
		
		return false;
		
	}
	
	//This method finds unassigned squares
	private int[] findUnassignedSquare(Square[][] squares)
	{
		int[] result = {0, 0};
		
		//find unassigned value
		for(int j = 0; j < COLS; j++)
		{
			for(int i = 0; i < ROWS; i++)
			{
				if(squares[i][j].getValue() == 0)
				{
					result[0] = i;
					result[1] = j;
					return result;
				}						
			}					
		}
		
		result[0] = ROWS;
		result[1] = COLS;

		return result;
	}
	
	//This method considers digits 1 to 9
	private boolean findNumber(Square[][] squares, int rowNum, int colNum )
	{			
		int maxNum = ROWS;
		
		for(int i = 1; i <= maxNum; i++)
		{
			if(isValid(squares, rowNum, colNum, i))
			{
				//If this number looks promising then try to solve the puzzle using this number
				squares[rowNum][colNum].setValue(i);				
				if(solve(squares, rowNum, colNum)) 			
					return true; 					//Solved
				
				//If the a solution is not found then backtrack the number and continue to try other values
				squares[rowNum][colNum].setValue(0); //unassign the current value as it does not solve the puzzle
			}			
		}		
		return false;
	}
	
	//This method validates to ensure no duplicate value in that row, column, and 3x3 region
	private boolean isValid(Square[][] squares, int rowNum, int colNum, int value)
	{

	    return !isUsedInRow(squares, colNum, value) &&
	    	   !isUsedInCol(squares, rowNum, value) &&
	    	   !isUsedInRegion(squares, rowNum, colNum, value);
		
	}
	
	//This method validates for no duplicate value in the current row
	private boolean isUsedInRow(Square[][] squares, int colNum, int value)
	{
		int num = value;
		
		//check row, for duplicate value. the number should not repeat in that row
		for(int i = 0; i < ROWS; i++)
		{
			//if(i != rowNum)
				if(squares[i][colNum].getValue() == num)
					return true;
		}
		
		return false;
	}
	
	//This method validates for no duplicate value in the current column
	private boolean isUsedInCol(Square[][] squares, int rowNum, int value)
	{
		int num = value;
		
		//check column, the number should not repeat in that column
		for(int j = 0; j < COLS; j++)
		{
			//if(j != colNum)
				if(squares[rowNum][j].getValue() == num)
					return true;
		}
		
		return false;
	}
	
	//This method validates for no duplicate value in the current region
	private boolean isUsedInRegion(Square[][] squares, int rowNum, int colNum, int value)
	{
		int num = value;
		
		//Check the 3 X 3 region, the number should not repeat in the region
		int xSection = rowNum/3;
	    int ySection = colNum/3; 
		
	    for(int iRegion = 3 * xSection; iRegion < 3 * xSection + 3; iRegion++)
	     {
	         for(int jRegion = 3*ySection; jRegion < 3 * ySection + 3; jRegion++)
	         {
	             if(squares[iRegion][jRegion].getValue() == num)
	            	 return true;         
	         }
	     }
	    
	    return false;
	}		
	
}
