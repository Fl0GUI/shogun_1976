package shogun_logic;

import java.util.ArrayList;
import java.lang.RuntimeException;

import utils.LimitedPoint;

public class Board {
  
  private ArrayList<PlacedPiece> board = new ArrayList();

  class PlacedPiece {
    public LimitedPoint point;
    public Piece piece;
    public PlacedPiece(LimitedPoint point, Piece piece) {
      this.point = point;
      this.piece = piece;
    }
  }

  private int rotation = 0;
  private int boardSize;

  private MoveNumberGenerator moveNumGen;


  public Board(int boardSize, MoveNumberGenerator moveNumGen) {
    this.boardSize = boardSize;
    this.moveNumGen = moveNumGen;
  }

  public boolean putPiece(Piece piece, int x, int y) {
    LimitedPoint p = new LimitedPoint(x, y, this.boardSize-1, this.boardSize-1);
    boolean occupied = this.board.stream().anyMatch((e) -> {
      return p.equals(e.point);
    });

    if (occupied) {
      throw new RuntimeException("A piece was already on this place");
    } 

    boolean shogunExists = this.board.stream().anyMatch((e) -> {
      return e.piece.getColor().equals(piece.getColor()) && e.piece.isShogun() && piece.isShogun();
    });
    if (shogunExists) {
      throw new RuntimeException("There already is a shogun of this color on the board");
    }

    int moves = this.moveNumGen.genMoveNumber(piece, p);
    piece.setMoves(moves);
    this.board.add(new PlacedPiece(p, piece));
    return true;
  }
}

