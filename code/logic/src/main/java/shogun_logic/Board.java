package shogun_logic;

import java.util.Map;
import java.util.HashMap;
import java.lang.RuntimeException;

public class Board {
  
  private Map<Integer, PlacedPiece> board = new HashMap();

  private class PlacedPiece {
    public int position;
    public Piece piece;
  }

  private int rotation = 0;

  public Board() {
    
  }
}

