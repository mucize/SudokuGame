//Sudokunun inþasý için interface
public interface SudokuBuilder {
	
	public void newSudoku();
	
	public Sudoku getSudoku();
	
	public void buildBoard();
	
	public void buildButton(String str);
}
