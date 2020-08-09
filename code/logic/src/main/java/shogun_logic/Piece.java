package shogun_logic;

public class Piece {

  public final int variation;
  private final boolean shogun;
  private final Color color;

  public Piece(int variation, boolean shogun, Color color) {
    this.variation = variation;
    this.shogun = shogun;
    this.color = color;
  }

  public boolean canTake(Piece enemy) {
    return this.color != enemy.color;
  }
}
