//Sudoku oyununun builder ile üretildiði sýnýf.
public class SudokuGameBuilder {
	
	public SudokuGameBuilder(){}

	public Sudoku createSudoku(SudokuBuilder builder){
		
		builder.newSudoku();
		
		builder.buildBoard();
		
		builder.buildButton("Check");
		builder.buildButton("Easy");
		builder.buildButton("Medium");
		builder.buildButton("Hard");
		builder.buildButton("Exit");
		
		return builder.getSudoku();
	}	
}