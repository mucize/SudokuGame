import java.util.*;
import java.text.*;

public class Sudoku {
	Board sudokuBoard = new Board();
	public static final int BOARD_WIDTH = 9;
	public static final int BOARD_HEIGHT = 9;
	private int[][] solved = new int[BOARD_WIDTH][BOARD_HEIGHT];

	public Sudoku() {
		board = new int[BOARD_WIDTH][BOARD_HEIGHT];
	}

	public int[][] nextBoard(int difficulty) {
		board = new int[BOARD_WIDTH][BOARD_HEIGHT];
		nextCell(0, 0); // sudokuyu oluþturan method
		copyBoard(); // sudoku oyunu bittiðinde kontrol edilmesi için çözümünün
						// kopyasý alýnýr.
		makeHoles(difficulty); // boþluklarý oluþturan method
		return board;
	}

	public boolean nextCell(int x, int y) // hücreye atanacak sayýyý belirler.
	{
		int nextX = x;
		int nextY = y;
		int[] toCheck = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random r = new Random();
		int tmp = 0;
		int current = 0;
		int top = toCheck.length;

		for (int i = top - 1; i > 0; i--) {
			current = r.nextInt(i); // rastgele yerini seçiyor.
			tmp = toCheck[current]; // seçtiði yerdeki elemaný atýyor.
			toCheck[current] = toCheck[i]; // swap iþlemi
			toCheck[i] = tmp;
		}

		for (int i = 0; i < toCheck.length; i++) {
			if (legalMove(x, y, toCheck[i])) // hücreye atanan sayý uygunsa if'e
												// girer.
			{
				board[x][y] = toCheck[i];
				if (x == 8) {
					if (y == 8)
						return true; // sudoku tamamlandýðýnda buraya girer
					else {
						nextX = 0;
						nextY = y + 1;
					}
				} else {
					nextX = x + 1;
				}
				if (nextCell(nextX, nextY)) // recursive: her cell için ayný
											// þekilde iþlem tamamlanýr.
					return true;
			}
		}
		board[x][y] = 0;
		return false;
	}

	private boolean legalMove(int x, int y, int current) { // hücreye atanan sayý uygun mu diye kontrol edilir.
		for (int i = 0; i < 9; i++) { // yatayda kontrol edilir.
			if (current == board[x][i])
				return false;
		}
		for (int i = 0; i < 9; i++) { // dikeyde kontrol edilir.
			if (current == board[i][y])
				return false;
		}
		int cornerX = 0;
		int cornerY = 0;
		if (x > 2)
			if (x > 5)
				cornerX = 6;
			else
				cornerX = 3;
		if (y > 2)
			if (y > 5)
				cornerY = 6;
			else
				cornerY = 3;
		for (int i = cornerX; i < 10 && i < cornerX + 3; i++)
			// kendi içinde 3*3lük kontrol yapýlýr.
			for (int j = cornerY; j < 10 && j < cornerY + 3; j++)
				if (current == board[i][j])
					return false;
		return true;
	}

	public void makeHoles(int holesToMake) // sudoku tamamen üretildikten sonra
											// rastgele boþluk oluþturulur.
	{
		double remainingSquares = 81;
		double remainingHoles = (double) holesToMake;

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				double holeChance = remainingHoles / remainingSquares;
				if (Math.random() <= holeChance) {
					board[i][j] = 0;
					remainingHoles--;
				}
				remainingSquares--;
			}
	}

	public void copyBoard() { // çözülmüþ olan board kopyalanýr.
		for (int i = 0; i < BOARD_WIDTH; i++) {
			for (int j = 0; j < BOARD_HEIGHT; j++) {
				solved[i][j] = board[i][j];
			}
		}
	}

	public void addBoard(Board sudokuBoard) { // üretilen sudokuboard'unu ekler.
		this.sudokuBoard = sudokuBoard;
	}

	public boolean checkOrprint(int isCheck) {
		int a = 0, b = 0, x = 0;
		int[] temp = new int[9];

		for (int i = 0; i < 9; i++) // i---->BOX'larý gezmek için
		{
			x = 0;
			if (i < 3)
				a = 0;
			else if (i < 6)
				a = 3;
			else if (i < 9)
				a = 6;

			if (i == 0 || i == 3 || i == 6)
				b = 0;
			else if (i == 1 || i == 4 || i == 7)
				b = 3;
			else if (i == 2 || i == 5 || i == 8)
				b = 6;

			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (isCheck == 1)
						temp[x] = solved[a][b];
					else
						temp[x] = board[a][b];
					x++;
					b++;
				}
				a++;
				b = b - 3;
			}
			if (isCheck == 1) {
				for (int t = 0; t < 9; t++) {
					try {
						if (Integer.parseInt(sudokuBoard.boxes[i].cells[t]
								.getText()) != temp[t])
							return false;
					} catch (Exception e) {
					}
				}
			} else if (isCheck == 0) {
				for (int t = 0; t < 9; t++) {
					sudokuBoard.boxes[i].cells[t].setEditable(true);
					sudokuBoard.boxes[i].cells[t].setNumber(temp[t]);
					if (temp[t] != 0)
						sudokuBoard.boxes[i].cells[t].setEditable(false); // oyunda dolu yerlerin deðiþtirilmesini engeller.
				}
			}
		}
		return true;

	}

	int[][] board;
}
