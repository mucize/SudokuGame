import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JFrame implements SudokuInterface, ActionListener{
	public final int BOX_COUNT = 9;
	public Box [] boxes = new Box[BOX_COUNT];
	JPanel p1 = new JPanel(new GridLayout(3,3));
	JPanel p2 = new JPanel(new GridLayout(5,1));
	static int i=0;
	
	public Board(){             
		this.setTitle("Sudoku");
		this.setSize(600,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,2));
		
		this.add(p1);
		this.add(p2);
	}
	
	public void addItem(SudokuInterface item){  //board'a box'larý  ve button'larý ekler.
		if(item instanceof Box){
			boxes[i]=(Box)item;
			p1.add(boxes[i]);
			i++;
			}
		else{
			((Button)item).addActionListener(this);
			p2.add((Button)item);	
		}
	}	

	public void actionPerformed(ActionEvent e){		   //buttonlarýn yapacaðý iþlemlerin tanýmlandýðý yer.
		if (e.getActionCommand()=="Check")
		{
			if(SudokuGame.sudoku.checkOrprint(1)==false)
				JOptionPane.showMessageDialog(null,"Yanlýs!!","Title",JOptionPane.ERROR_MESSAGE);
			else if(SudokuGame.sudoku.checkOrprint(1)==true)
				JOptionPane.showMessageDialog(null,"Dogru","Title",JOptionPane.INFORMATION_MESSAGE);
			
		}
		if (e.getActionCommand()=="Easy")
		{
			SudokuGame.sett(new Context(new Easy()).executeStrategy()); 
		}
		if (e.getActionCommand()=="Medium")
		{
			SudokuGame.sett(new Context(new Medium()).executeStrategy());
		}
		if (e.getActionCommand()=="Hard")
		{
			SudokuGame.sett(new Context(new Hard()).executeStrategy());
		}
		if (e.getActionCommand()=="Exit")
		{
			processEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}