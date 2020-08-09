package shogun_logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
  @Test public void testPieceConstructorNotNull() {
    Piece piece = new Piece(0, true, Color.RED);
    assertNotNull(piece);
    piece = new Piece(1, false, Color.WHITE);
    assertNotNull(piece);
  }

  @Test public void testPieceTakes() {
    Piece a = new Piece(0, true, Color.RED);
    Piece b = new Piece(1, false, Color.WHITE);

    assertTrue(a.canTake(b));
    assertTrue(b.canTake(a));
  }
}
