package shogun_logic;

public class BoardFactory {

  public static Board emptyBoard(int size) {
    MoveNumberGenerator numGen = new MoveNumberGenerator();
    return new Board(size, numGen);
  }

  public static Board defaultBoard() {
    return BoardFactory.emptyBoard(8);
  }

  public static Board simpleBoard() {
    int size = 8;
    Board board = BoardFactory.emptyBoard(size);
    for(int i = 0; i < size; i++) {
      Piece red = new Piece(0, i==4, Color.RED);
      Piece white = new Piece(0, i==5, Color.WHITE);
      board.putPiece(red, i, 0);
      board.putPiece(white, 7-i, 7);
    }
    return board;
  }
}
