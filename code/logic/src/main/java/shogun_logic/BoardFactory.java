package shogun_logic;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

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
      int[] zeros = {0,0,0,0};
      Piece red = new Piece(zeros, i==4, Color.RED);
      Piece white = new Piece(zeros, i==5, Color.WHITE);
      board.putPiece(red, i, 0);
      board.putPiece(white, 7-i, 7);
    }
    return board;
  }

  public static Board randomBoard() {
    Random rng = new Random();
    int size = 8;
    int rotation = rng.nextInt(4);
    MoveNumberGenerator mng = new MoveNumberGenerator(rotation);
    Board board = new Board(8, mng);
    ArrayList<Piece> red_pieces = new ArrayList();
    ArrayList<Piece> white_pieces = new ArrayList();

    int[] t_a = {1, 4, 2, 3};
    int[] t_b = {1, 3, 4, 2};
    int[] t_c = {2, 3, 1, 4};
    int[] t_s = {2, 2, 1, 1};

    for( int i=0; i<2; i++) {
      red_pieces.add(new Piece(t_a, false, Color.RED));
      white_pieces.add(new Piece(t_a, false, Color.WHITE));
      red_pieces.add(new Piece(t_b, false, Color.RED));
      white_pieces.add(new Piece(t_b, false, Color.WHITE));
      red_pieces.add(new Piece(t_c, false, Color.RED));
      white_pieces.add(new Piece(t_c, false, Color.WHITE));
    }
    red_pieces.add(new Piece(t_b, false, Color.RED));
    white_pieces.add(new Piece(t_b, false, Color.WHITE));

    Collections.shuffle(red_pieces);
    Collections.shuffle(white_pieces);

    red_pieces.add(4, new Piece(t_s, true, Color.RED));
    white_pieces.add(3, new Piece(t_s, true, Color.WHITE));

    for( int i=0; i<8; i++) {
      board.putPiece(red_pieces.get(i), 0, i);
      board.putPiece(white_pieces.get(i), 7, i);
    }

    return board;
  }
}
