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

}
