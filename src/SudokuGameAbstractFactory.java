//Sudoku oyununun factory ile üretildiði sýnýf
public class SudokuGameAbstractFactory {
	
	public SudokuGameAbstractFactory(){		}
	
	public Sudoku createSudoku(SudokuFactory factory){
		
		Sudoku sudoku=factory.makeSudoku();
		
		Board board=factory.makeBoard();
		
		Box box1= factory.makeBox();
		Box box2= factory.makeBox();
		Box box3= factory.makeBox();
		Box box4= factory.makeBox();
		Box box5= factory.makeBox();
		Box box6= factory.makeBox();
		Box box7= factory.makeBox();
		Box box8= factory.makeBox();
		Box box9= factory.makeBox();
		
		Button button1=factory.makeButton("Check");
		Button button2=factory.makeButton("Easy");
		Button button3=factory.makeButton("Medium");
		Button button4=factory.makeButton("Hard");
		Button button5=factory.makeButton("Exit");
		
		board.addItem(box1);
		board.addItem(box2);
		board.addItem(box3);
		board.addItem(box4);
		board.addItem(box5);
		board.addItem(box6);
		board.addItem(box7);
		board.addItem(box8);
		board.addItem(box9);
		
		board.addItem(button1);
		board.addItem(button2);
		board.addItem(button3);
		board.addItem(button4);
		board.addItem(button5);
		
		sudoku.addBoard(board);
		
		return sudoku;

	}

}
