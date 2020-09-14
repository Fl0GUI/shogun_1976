package shogun_logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class BoardFactoryTest {

  @Test public void testRandomBoardAllPieces() {
    Board b = BoardFactory.randomBoard();

    for( int i=0; i<8; i++) {
      assertTrue(b.getPiece(0, i).isPresent());
      assertTrue(b.getPiece(0, i).get().getColor() == Color.RED);
      assertTrue(b.getPiece(7, i).isPresent());
      assertTrue(b.getPiece(7, i).get().getColor() == Color.WHITE);
    }
  }

}
