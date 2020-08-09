package shogun_logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveNumberGeneratorTest {
  @Test public void testMoveNumberGeneratorConstructorNotNull() {
    MoveNumberGenerator moveGen = new MoveNumberGenerator();
    assertNotNull(moveGen);
  }

}
