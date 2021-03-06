package shogun_logic;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.RuntimeException;
import java.util.Optional;
import java.lang.Math;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.System;

import utils.LimitedPoint;
import utils.Point;

public class Board {
  
  private List<PlacedPiece> board = new ArrayList();

  class PlacedPiece {
    public LimitedPoint point;
    public Piece piece;
    public PlacedPiece(LimitedPoint point, Piece piece) {
      this.point = point;
      this.piece = piece;
    }
  }

  private int board_size;
  private Color currentTurn;

  private MoveNumberGenerator moveNumGen;

  public Board(int board_size, MoveNumberGenerator moveNumGen) {
    this.board_size = board_size;
    this.currentTurn = Color.RED;
    this.moveNumGen = moveNumGen;
  }

  public Color getTurn() {
    return this.currentTurn;
  }

  public boolean putPiece(Piece piece, Point point) {
    return this.putPiece(piece, point.x, point.y);
  }

  public boolean isValidMove(Point from, Point to) {
    return this.isValidMove(from.x, from.y, to.x, to.y);
  }

  public List<Point> getValidMoves(Point point) {
    return this.getValidMoves(point.x, point.y);
  }

  public boolean makeMove(Point from, Point to) {
    return this.makeMove(from.x, from.y, to.x, to.y);
  }

  public Optional<Piece> getPiece(Point point) {
    return this.getPiece(point.x, point.y);
  }

  public boolean putPiece(Piece piece, int x, int y) {
    LimitedPoint p = new LimitedPoint(x, y, this.board_size-1, this.board_size-1);
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

    this.board.add(new PlacedPiece(p, piece));
    return true;
  }

  public boolean isValidMove(int from_x, int from_y, int to_x, int to_y) {
    int[] points = {from_x, from_y, to_x, to_y};
    boolean outside_board = Arrays.stream(points).anyMatch((v) -> {
      return v < 0 || v >= this.board_size;
    });
    if( outside_board ) {
      return false;
    }


    Optional<Piece> toBeMoved = this.getPiece(from_x, from_y);
    Optional<Piece> toBeTaken = this.getPiece(to_x, to_y);

    if( toBeMoved.isEmpty() ) {
      return false;
    } // There is a piece to be moved

    if ( toBeMoved.get().getColor() != this.currentTurn ) {
      return false;
    }

    int moveDistance = Math.abs(from_x - to_x) + Math.abs(from_y - to_y);
    int moves = this.moveNumGen.genMoveNumber(toBeMoved.get(), from_x, from_y, this.board_size);
    if( moveDistance != moves ){
      return false;
    }

    if( toBeTaken.isPresent() ) {
      if (toBeMoved.get().getColor() == toBeTaken.get().getColor()) {
        return false;
      }
    } // Piece can be placed on to spot

    int start_x = Math.min(from_x, to_x);
    int end_x = Math.max(from_x, to_x);

    int start_y = Math.min(from_y, to_y);
    int end_y = Math.max(from_y, to_y);

    List<LimitedPoint> important_points = this.board.stream().map(
      (p) -> {return p.point;}
    ).filter((p) -> {
      boolean x_band = start_x <= p.getX() && p.getY() <= end_x;
      boolean y_band = start_y <= p.getY() && p.getY() <= end_y;
      return x_band && y_band;
    }).filter((p) -> {
      boolean x_eq = from_x == p.getX() || to_x == p.getX();
      boolean y_eq = from_y == p.getY() || to_y == p.getY();
      return x_eq || y_eq;
    }).filter((p) -> {
      boolean is_from = p.getX() == from_x && p.getY() == from_y;
      boolean is_to = p.getX() == to_x && p.getY() == to_y;
      return ! (is_from || is_to);
    }).collect(Collectors.toList());

    boolean vertical_path_clear = important_points.stream()
      .filter((p) -> {
        return p.getY() == start_y && p.getX() == end_x;
      }
    ).count() == 0;

    boolean horizontal_path_clear = important_points.stream()
      .filter((p) -> {
        return p.getX() == start_x && p.getY() == end_y;
      }
    ).count() == 0;
    return (vertical_path_clear || horizontal_path_clear);
  }

  public List<Point> getValidMoves(int from_x, int from_y) {
    int[] vals = {from_x, from_y};
    boolean allvalid = ! Arrays.stream(vals).filter((v) -> {
      return v >= 0 && v < this.board_size;
    }).findAny().isEmpty();
    if( ! allvalid ) {
      return new ArrayList();
    }

    Stream.Builder<Point> sb = Stream.builder();
    for(int row = 0; row < this.board_size; row++) {
      for(int col = 0; col < this.board_size; col++) {
        sb.add(new Point(row, col));
      }
    }
    return sb.build().filter((p) -> {
      return this.isValidMove(from_x, from_y, p.x, p.y);
    }).collect(Collectors.toList());
  }

  public boolean makeMove(int from_x, int from_y, int to_x, int to_y) {
    if( ! this.isValidMove(from_x, from_y, to_x, to_y)) {
      return false;
    }

    this.board = this.board.stream().filter((e) -> {
      return ! e.point.equals(to_x, to_y);
    }).map((e) -> {
      if(e.point.equals(from_x, from_y)) {
        e.point.move(to_x, to_y);
      }
      return e;
    }).collect(Collectors.toList());

    this.currentTurn = this.currentTurn.next();

    return true;
  };

  public Optional<Piece> getPiece(int x, int y) {
    return this.board.stream().filter((e) -> {
      return e.point.equals(x, y);
    }).findAny().map((o) -> {
      return o.piece;
    });
  }
}

