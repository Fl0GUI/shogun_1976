package shogun_logic;

import utils.LimitedPoint;

public class MoveNumberGenerator {
  
  private final int rotation;

  public MoveNumberGenerator() {
    this.rotation = 0;
  }

  public MoveNumberGenerator(int rotation) {
    this.rotation = rotation;
  }

  
  public int genMoveNumber(Piece piece, LimitedPoint point, int board_size) {
    int x = point.getX();
    int y = point.getY();
    return this.genMoveNumber(piece, x, y, board_size);
  }

  public int genMoveNumber(Piece piece, int x, int y, int board_size) {
    int[][] indices = {{0, 3},{1, 2}};
    boolean samesign = (((x + 0.5) - board_size/2) * ((y + 0.5) - board_size/2)) >= 0;

    int x_index = x % 2;
    int y_index = y % 2;
    if( !samesign )  {
      x_index = 1 - x_index;
      y_index = 1 - y_index;
    }

    if( this.rotation % 2 == 1 ) {
      x_index = 1 - x_index;
      y_index = 1 - y_index;
    }
    int index = indices[x_index][y_index];
    if( piece.getColor() == Color.WHITE ) {
      index = (index + 2) % 4;
    }

    return piece.getVariation()[index];
  }
}
