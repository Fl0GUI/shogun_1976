package shogun_logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
  @Test public void testBoardConstructorNotNull() {
    Board board = new Board();
    assertNotNull(board);
  }

}
