package shogun_logic;

public enum Color {
  RED, WHITE;

  public Color next() {
    if ( this == Color.RED ) {
      return Color.WHITE;
    } else {
      return Color.RED;
    }
  }
}
