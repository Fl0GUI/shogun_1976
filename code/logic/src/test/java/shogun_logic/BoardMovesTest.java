package shogun_logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardMovesTest {

  @Test public void testValidMoves() {
    Board b = BoardFactory.emptyBoard(8);
    b.putPiece(new Piece(0, false, Color.WHITE), 0, 0);
    assertTrue(b.isValidMove(0, 0, 1, 1));
    assertTrue(b.isValidMove(0, 0, 0, 7));
    assertTrue(b.isValidMove(0, 0, 7, 0));
    assertTrue(b.isValidMove(0, 0, 7, 7));

    b.putPiece(new Piece(0, false, Color.RED), 4, 4);
    assertTrue(b.isValidMove(0, 0, 1, 1));
    assertTrue(b.isValidMove(0, 0, 7, 7));
    assertTrue(b.isValidMove(0, 0, 4, 7));
    assertTrue(b.isValidMove(0, 0, 7, 4));
    assertTrue(b.isValidMove(0, 0, 4, 4));

    assertTrue(b.isValidMove(4, 4, 1, 1));
    assertTrue(b.isValidMove(4, 4, 6, 6));
    assertTrue(b.isValidMove(4, 4, 1, 6));
    assertTrue(b.isValidMove(4, 4, 6, 1));

    b.putPiece(new Piece(0, false, Color.WHITE), 0, 1);
    b.putPiece(new Piece(0, false, Color.WHITE), 1, 0);
    b.putPiece(new Piece(0, false, Color.WHITE), 7, 0);
    b.putPiece(new Piece(0, false, Color.WHITE), 0, 7);
    assertTrue(b.isValidMove(4, 4, 0, 7));
    assertTrue(b.isValidMove(4, 4, 7, 0));
  }

  @Test public void testInvalidMoves() {
    Board b = BoardFactory.emptyBoard(8);
    assertFalse(b.isValidMove(0, 0, 0, 1));

    b.putPiece(new Piece(0, false, Color.WHITE), 4, 4);
    assertFalse(b.isValidMove(0, 0, 0, 9));
    assertFalse(b.isValidMove(0, 0, -1, 0));
    assertFalse(b.isValidMove(0, 0, 0, 0));

    b.putPiece(new Piece(0, false, Color.WHITE), 0, 1);
    assertFalse(b.isValidMove(0, 0, 0, 1));

    b.putPiece(new Piece(0, false, Color.WHITE), 1, 0);
    assertFalse(b.isValidMove(0, 0, 0, 0));

    b.putPiece(new Piece(0, false, Color.WHITE), 7, 0);
    b.putPiece(new Piece(0, false, Color.WHITE), 0, 7);
    assertFalse(b.isValidMove(0, 0, 7, 7));
  }
}
