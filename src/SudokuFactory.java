//sudoku oluþturulmasý için parça üretir.
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
