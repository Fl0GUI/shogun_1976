package shogun_logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class BoardFactoryTest {

  @Test public void testDefaultBoardNotNull() {
    Board defaultBoard = BoardFactory.defaultBoard();
    assertNotNull(defaultBoard);
  }

  @Test public void testSimpleBoardAllPieces() {
    Board simple = BoardFactory.simpleBoard();
  }
}
