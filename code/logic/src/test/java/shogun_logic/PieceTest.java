package shogun_logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
  @Test public void testPieceConstructorNotNull() {
    int[] zeros = {0,0,0,0};
    Piece piece = new Piece(zeros, true, Color.RED);
    assertNotNull(piece);
    int[] ones = {1,1,1,1};
    piece = new Piece(ones, false, Color.WHITE);
    assertNotNull(piece);
  }

  @Test public void testPieceTakes() {
    int[] zeros = {0,0,0,0};
    Piece a = new Piece(zeros, true, Color.RED);
    int[] ones = {1,1,1,1};
    Piece b = new Piece(ones, false, Color.WHITE);

    assertTrue(a.canTake(b));
    assertTrue(b.canTake(a));
  }
}
