
package tictactoe;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class GameTest {
    

    public void testEmptyBoard(){
        Game g = new Game();

        assertEquals("empty board is incorrect", " ...\n...\n...\n",g.toString());

    }

    public void testOneMove(){
        Game g = new Game();
        assertEquals("x",g.getCurrentPlayer());
        g.move(0);
        assertEquals("O",g.getCurrentPlayer());

    }



}
