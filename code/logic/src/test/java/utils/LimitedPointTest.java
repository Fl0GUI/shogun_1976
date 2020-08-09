package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LimitedPointTest {
  @Test public void pointEqualTest() {
    LimitedPoint p1 = new LimitedPoint(0, 0, 8, 8);
    LimitedPoint p2 = new LimitedPoint(0, 0, 8, 8);
    assertTrue(p1.equals(p2));
    assertTrue(p2.equals(p1));

    assertTrue(p1.equals(0,0));
  }
}
