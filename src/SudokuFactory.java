//sudoku olu�turulmas� i�in par�a �retir.
public class SudokuFactory {
	public Sudoku makeSudoku(){
		return new Sudoku();
	}
	public Board makeBoard(){
		return new Board();
	}
	public Box makeBox(){
		return new Box();
	}
	public Button makeButton(String str){
		return new Button(str);
	}
}
