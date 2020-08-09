package shogun_logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardFactoryTest {

  @Test public void testDefaultBoardNotNull() {
    Board defaultBoard = BoardFactory.defaultBoard();
    assertNotNull(defaultBoard);
  }
}
