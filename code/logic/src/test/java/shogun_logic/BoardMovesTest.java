package shogun_logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardMovesTest {

  @Test public void testValidMoves() {
    Board b = BoardFactory.emptyBoard(8);
    Piece p1 = new Piece(0, false, Color.WHITE);
    b.putPiece(p1, 0, 0);
    p1.setMoves(2);
    assertTrue(b.isValidMove(0, 0, 1, 1));
    p1.setMoves(7);
    assertTrue(b.isValidMove(0, 0, 0, 7));
    assertTrue(b.isValidMove(0, 0, 7, 0));
    p1.setMoves(14);
    assertTrue(b.isValidMove(0, 0, 7, 7));

    Piece p2 = new Piece(0, false, Color.RED);
    b.putPiece(p2, 4, 4);
    p1.setMoves(2);
    assertTrue(b.isValidMove(0, 0, 1, 1));
    p1.setMoves(14);
    assertTrue(b.isValidMove(0, 0, 7, 7));
    p1.setMoves(11);
    assertTrue(b.isValidMove(0, 0, 4, 7));
    assertTrue(b.isValidMove(0, 0, 7, 4));
    p1.setMoves(8);
    assertTrue(b.isValidMove(0, 0, 4, 4));

    p2.setMoves(6);
    assertTrue(b.isValidMove(4, 4, 1, 1));
    p2.setMoves(4);
    assertTrue(b.isValidMove(4, 4, 6, 6));
    p2.setMoves(5);
    assertTrue(b.isValidMove(4, 4, 1, 6));
    assertTrue(b.isValidMove(4, 4, 6, 1));

    b.putPiece(new Piece(0, false, Color.WHITE), 0, 1);
    b.putPiece(new Piece(0, false, Color.WHITE), 1, 0);
    b.putPiece(new Piece(0, false, Color.WHITE), 7, 0);
    b.putPiece(new Piece(0, false, Color.WHITE), 0, 7);
    p2.setMoves(7);
    assertTrue(b.isValidMove(4, 4, 0, 7));
    assertTrue(b.isValidMove(4, 4, 7, 0));
  }

  @Test public void testInvalidMoves() {
    Board b = BoardFactory.emptyBoard(8);
    assertFalse(b.isValidMove(0, 0, 0, 1));

    Piece p1 = new Piece(0, false, Color.WHITE);
    b.putPiece(p1, 0, 0);
    p1.setMoves(9);
    assertFalse(b.isValidMove(0, 0, 0, 9));
    p1.setMoves(8);
    assertFalse(b.isValidMove(0, 0, 0, 0));
    p1.setMoves(10);
    assertFalse(b.isValidMove(0, 0, -1, 0));

    b.putPiece(new Piece(0, false, Color.WHITE), 0, 1);
    p1.setMoves(1);
    assertFalse(b.isValidMove(0, 0, 0, 1));

    b.putPiece(new Piece(0, false, Color.WHITE), 1, 0);
    p1.setMoves(1);
    assertFalse(b.isValidMove(0, 0, 1, 0));

    b.putPiece(new Piece(0, false, Color.WHITE), 7, 0);
    b.putPiece(new Piece(0, false, Color.WHITE), 0, 7);
    p1.setMoves(14);
    assertFalse(b.isValidMove(0, 0, 7, 7));
  }

  @Test public void testGetValidMoves() {
    Board b = BoardFactory.emptyBoard(8);
    assertEquals(0, b.getValidMoves(0, 0).size());
    Piece p1 = new Piece(0, false, Color.WHITE);
    p1.setMoves(1);
    b.putPiece(p1, 0, 0);
    assertEquals(2, b.getValidMoves(0, 0).size());
  }

}
