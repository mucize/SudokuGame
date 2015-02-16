//Sudoku oyununun main s�n�f�.
public class SudokuGame {
	/**
	 * @param args
	 */
	static Sudoku sudoku;
	public static void main(String[] args) {
		
		SudokuFactory factory=new SudokuFactory();
		SudokuBuilder builder=new FactorySudokuBuilder(factory);
		
		//sudoku=new SudokuGameAbstractFactory().createSudoku(factory);           //  FactoryPattern kullan�larak sudoku �retme //
		sudoku=new SudokuGameBuilder().createSudoku(builder);
		sudoku.checkOrprint(0);
		sudoku.sudokuBoard.setVisible(true);
	}
	static public void sett(int a){
		sudoku.nextBoard(a);
		sudoku.checkOrprint(0);
	}
}
