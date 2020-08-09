package shogun_logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.RuntimeException;

public class BoardTest {
  @Test public void testBoardConstructorNotNull() {

    MoveNumberGenerator m = new MoveNumberGenerator();
    Board board = new Board(0, m);
    assertNotNull(board);
  }

  @Test public void testBoardPutPieceCorrect() {
    MoveNumberGenerator numGen = new MoveNumberGenerator();
    Board board = new Board(8, numGen);
    // Correct placements
    Piece p1 = new Piece(1, true, Color.WHITE);
    board.putPiece(p1, 0, 0);
    Piece p2 = new Piece(1, false, Color.WHITE);
    board.putPiece(p2, 1, 0);
    Piece p3 = new Piece(1, true, Color.RED);
    board.putPiece(p3, 0, 7);
    Piece p4 = new Piece(1, false, Color.RED);
    board.putPiece(p4, 5, 5);
    // Incorrect placements
    Piece p5 = new Piece(5, false, Color.WHITE);
    assertThrows(RuntimeException.class, () -> {
      board.putPiece(p5, 0, 0);
    });
    Piece p6 = new Piece(123, true, Color.WHITE);
    assertThrows(RuntimeException.class, () -> {
      board.putPiece(p6, 1, 1);
    });
  }

  @Test public void testBoardPutGet() {
    Board b1 = BoardFactory.emptyBoard(1);
    b1.putPiece(new Piece(0, true, Color.RED), 0, 0);
    assertTrue(b1.getPiece(0, 0).isPresent());
    assertEquals(b1.getPiece(0,0).get().getColor(), Color.RED);
    assertFalse(b1.getPiece(1, 2).isPresent());

    Board b2 = BoardFactory.emptyBoard(2);
    b2.putPiece(new Piece(0, true, Color.RED), 0, 1);
    assertFalse(b2.getPiece(1, 0).isPresent());
  }

}
