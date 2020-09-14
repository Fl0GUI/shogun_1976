package shogun_logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardMovesTest {

  @Test public void testValidMovesCount() {
    Board b;
    Piece p;
    int[] nums = new int[4];

    b = BoardFactory.emptyBoard(8);
    nums = getVariation(0);
    p = new Piece(nums, false, Color.WHITE);
    b.putPiece(p, 4, 4);
    assertEquals(0, b.getValidMoves(4, 4).size());


    b = BoardFactory.emptyBoard(8);
    nums = getVariation(1);
    p = new Piece(nums, false, Color.WHITE);
    b.putPiece(p, 4, 4);
    assertEquals(4, b.getValidMoves(4, 4).size());

    b = BoardFactory.emptyBoard(8);
    nums = getVariation(2);
    p = new Piece(nums, false, Color.WHITE);
    b.putPiece(p, 4, 4);
    assertEquals(8, b.getValidMoves(4, 4).size());

    b = BoardFactory.emptyBoard(8);
    nums = getVariation(3);
    p = new Piece(nums, false, Color.WHITE);
    b.putPiece(p, 4, 4);
    assertEquals(12, b.getValidMoves(4, 4).size());
  }

  @Test public void testValidMovesEdge() {
    Board b;
    Piece p;
    int[] nums = new int[4];

    b = BoardFactory.emptyBoard(8);
    nums = getVariation(1);
    p = new Piece(nums, false, Color.WHITE);
    b.putPiece(p, 0, 0);
    assertEquals(2, b.getValidMoves(0, 0).size());

    b = BoardFactory.emptyBoard(8);
    nums = getVariation(2);
    p = new Piece(nums, false, Color.WHITE);
    b.putPiece(p, 0, 0);
    assertEquals(3, b.getValidMoves(0, 0).size());
  }

  @Test public void testValidMovesBlocked() {
    Board b;
    Piece p1, p2, p3, p4;
    int[] nums = new int[4];
  
    b = BoardFactory.emptyBoard(8);
    nums = getVariation(4);

    p1 = new Piece(nums, false, Color.RED);
    p2 = new Piece(nums, false, Color.RED);
    p3 = new Piece(nums, false, Color.RED);
    p4 = new Piece(nums, false, Color.RED);

    b.putPiece(p1, 1, 5);
    b.putPiece(p2, 5, 5);
    b.putPiece(p3, 6, 2);
    b.putPiece(p4, 3, 3);

    assertEquals(6, b.getValidMoves(1, 5).size());
    assertEquals(7, b.getValidMoves(5, 5).size());
    assertEquals(6, b.getValidMoves(6, 2).size());
    assertEquals(11, b.getValidMoves(3, 3).size());
  }

  @Test public void testValidMovesTake() {
    Board b;
    Piece red, white;
    int[] nums = new int[4];

    b = BoardFactory.emptyBoard(8);
    nums = getVariation(4);

    red = new Piece(nums, false, Color.RED);
    white = new Piece(nums, false, Color.WHITE);

    b.putPiece(red, 2, 2);
    b.putPiece(white, 3, 5);

    assertTrue(b.isValidMove(2, 2, 3, 5));
    assertTrue(b.isValidMove(3, 5, 2, 2));
  }

  @Test public void testMakeValidMove() {
    Board b;
    Piece p;
    int[] nums = new int[4];

    b = BoardFactory.emptyBoard(8);
    nums = getVariation(2);

    p = new Piece(nums, false, Color.RED);

    b.putPiece(p, 0, 0);
    assertTrue(b.makeMove(0, 0, 1, 1));
    assertTrue(b.makeMove(1, 1, 1, 3));
    assertTrue(b.makeMove(1, 3, 3, 3));
    assertTrue(b.makeMove(3, 3, 3, 1));
  }

  @Test public void testMakeInvalidMove() {
    Board b;
    Piece p1, p2;
    int[] nums = new int[4];

    b = BoardFactory.emptyBoard(8);
    nums = getVariation(2);

    p1 = new Piece(nums, false, Color.RED);
    p2 = new Piece(nums, false, Color.RED);

    b.putPiece(p1, 0, 0);
    b.putPiece(p2, 1, 1);

    assertFalse(b.makeMove(0, 0, 1, 1));
    assertFalse(b.makeMove(0, 0, -1, 0));
    assertFalse(b.makeMove(1, 1, 4, 1));
    assertFalse(b.makeMove(1, 1, 0, 0));
  }

  @Test public void testMakeValidMoveTake() {
    Board b;
    Piece p1, p2;
    int[] nums = new int[4];

    b = BoardFactory.emptyBoard(8);
    nums = getVariation(2);

    p1 = new Piece(nums, false, Color.RED);
    p2 = new Piece(nums, false, Color.WHITE);

    b.putPiece(p1, 0, 0);
    b.putPiece(p2, 1, 1);

    assertTrue(b.makeMove(0, 0, 1, 1));
    assertTrue(b.getPiece(0, 0).isEmpty());
    assertTrue(b.getPiece(1, 1).isPresent());

    b.putPiece(p2, 1, 3);
    assertTrue(b.makeMove(1, 1, 1, 3));
  
    b.putPiece(p2, 2, 4);
    assertTrue(b.makeMove(1, 3, 2, 4));

    b.putPiece(p2, 4, 4);
    assertTrue(b.makeMove(2, 4, 4, 4));
  }

  private int[] getVariation(int steps) {
    int[] s = {steps,steps,steps,steps};
    return s;
  }
}
