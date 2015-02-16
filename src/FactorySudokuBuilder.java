// Sudoku oyunu için parçalarý factory yardýmýyla inþa eder.
public class FactorySudokuBuilder implements SudokuBuilder {
	
	protected SudokuFactory factory;
	protected Sudoku sudoku;
	protected Board board;

    public FactorySudokuBuilder(SudokuFactory factory) {
		    this.factory = factory; 
		  }
	@Override
	public void newSudoku() {
		sudoku=factory.makeSudoku();		
	}

	@Override
	public Sudoku getSudoku() {		
		return sudoku;
	}

	@Override
	public void buildBoard() {
		if(sudoku==null)
			newSudoku();
		
		board=factory.makeBoard();
		for(int i=0;i<9;i++){
			board.addItem(factory.makeBox());     // board'a 9 tane box ekler.
		}	
		sudoku.addBoard(board);
	}
	@Override
	public void buildButton(String str) {
		if(sudoku==null)
			newSudoku();
		
		Button button =factory.makeButton(str);
		
		board.addItem(button);
		
	}
	
}
