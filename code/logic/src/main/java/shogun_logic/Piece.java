package shogun_logic;

public class Piece {

  private int moves;
  public final int variation;
  private final boolean shogun;
  private final Color color;

  public Piece(int variation, boolean shogun, Color color) {
    this.moves = 0;
    this.variation = variation;
    this.shogun = shogun;
    this.color = color;
  }

  public int getMoves() {
    return this.moves;
  }

  public void setMoves(int moves) {
    this.moves = moves;
  }

  public boolean isShogun() {
    return this.shogun;
  }

  public Color getColor() {
    return this.color;
  }

  public boolean canTake(Piece enemy) {
    return this.color != enemy.color;
  }
}
