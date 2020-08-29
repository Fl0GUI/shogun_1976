package shogun_logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.LimitedPoint;

public class MoveNumberGeneratorTest {
  @Test public void testMoveNumberGeneratorConstructorNotNull() {
    MoveNumberGenerator moveGen = new MoveNumberGenerator();
    assertNotNull(moveGen);
  }

  @Test public void testMoveNumberGeneratorNoRotation() {
    MoveNumberGenerator moveGen = new MoveNumberGenerator(0);

    int[] numbers = {1, 4, 2, 3};
    int[] numbers_rotated = {2, 3, 1, 4};
    Piece piece_red = new Piece(numbers, false, Color.RED);
    Piece piece_white = new Piece(numbers, false, Color.WHITE);

    this.testMoveNumberGeneratorNumbers(piece_red, numbers);
    this.testMoveNumberGeneratorNumbers(piece_white, numbers_rotated);

  }

  public void testMoveNumberGeneratorNumbers(Piece piece, int[] numbers) {
    MoveNumberGenerator moveGen = new MoveNumberGenerator(0);
    int[] macro_offset = {0, 4};
    int[] micro_offset = {0, 2};
    int[][] mili_offset = {{0, 0}, {1, 0}, {1, 1}, {0, 1}};
    int x, y, value;

    LimitedPoint p = new LimitedPoint(8, 8);

    for( int o_x1 :macro_offset) {
      for( int o_y1 :macro_offset) {
        for( int o_x2 :micro_offset) {
          for( int o_y2 :micro_offset) {
            for(int i = 0; i < 4; i++) {
              x = mili_offset[i][0] + o_x1 + o_x2;
              y = mili_offset[i][1] + o_y1 + o_y2;
              p.setLocation(x, y);

              if( o_x1 == o_y1 ) {
                value = numbers[i];
              } else {
                value = numbers[(i+2)%4];
              }
              assertEquals(value, moveGen.genMoveNumber(piece, p));
            
            }
          }
        }
      }
    }
  }
}
