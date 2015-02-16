import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

//Sudoku oyunu için 3*3'lük box kullanıldı. her box 3*3lük cell'lerden oluşur.
public class Box extends JPanel implements SudokuInterface{

	public final int CELL_COUNT = 9;
	public class Cell extends JTextField implements KeyListener {
		private int number;
		public Cell() {  }
		public void setNumber(int number) {          //cell'in 1 ile 9 arasında sayı üretildiğinden emin olur.
			this.addKeyListener(this);
			this.number = number;
			if(number>0 && number<10)
				this.setText(Integer.toString(number));
			else
				this.setText(null);
			
		}
		public int getNumber() { return number; }
		@Override
		public void keyPressed(KeyEvent arg0) {}
		@Override
		public void keyReleased(KeyEvent arg0) {}
		@Override
		public void keyTyped(KeyEvent arg0) {                          //oyunda herbir hücreye sadece sayı girilmesini sağlar.
			if(Character.isDigit(arg0.getKeyChar())==false)
				arg0.consume();		
		}
	}
	
	public Cell [] cells = new Cell[CELL_COUNT];
	
	public Box(){
		this.setLayout(new GridLayout(3,3));               
		this.setBorder(new LineBorder(Color.BLACK,2));
		for(int i=0; i<CELL_COUNT; i++){        //cell'ler box'a eklenir.
			cells[i] = new Cell();
			this.add(cells[i]);
		}
	}
}
