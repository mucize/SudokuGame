import static org.junit.Assert.*;

import org.junit.Test;


public class BoxTest {

	@Test
	public void testBox() {             //Box s�n�f�n�n cell'lerinin kontrolu yap�ld�.. 
		Box box=new Box();
		
		for (int i = 0; i < box.cells.length; i++) {
			box.cells[i].setNumber(i);
		}
		
		for (int i = 0; i < box.cells.length; i++) {
			assertEquals(i,box.cells[i].getNumber());
		}

	}

}
