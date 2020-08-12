package utils;

import java.lang.RuntimeException;

public class LimitedPoint {

  private int x = 0;
  private int y = 0;

  private int x_limit;
  private int y_limit;

  public LimitedPoint(int x_limit, int y_limit) {
    this.setLimit(x_limit, y_limit);
  }

  public LimitedPoint(int x, int y, int x_limit, int y_limit) {
    this.setLimit(x_limit, y_limit);
    this.setLocation(x, y);
  }

  public LimitedPoint(LimitedPoint p, int x_limit, int y_limit) {
    this.setLimit(x_limit, y_limit);
    this.setLocation(p);
  }

  public int getX() {
    return this.x;
  }

  public int getXLimit() {
    return this.x_limit;
  }

  public int getYLimit() {
    return this.y_limit;
  }

  public int getY() {
    return this.y;
  }

  public void move(int x, int y) {
    if (this.inLimit(x, y)) {
      this.setLocation(x, y);
    } else {
      throw new RuntimeException("New Point not in limits");
    }
  }

  public void setLocation(int x, int y) {
    if (this.inLimit(x, y)) {
      this.x = x;
      this.y = y;
    } else {
      throw new RuntimeException("New Point not in limits");
    }
  }

  public void setLocation(LimitedPoint p) {
    if (this.inLimit(p.getX(), p.getY())) {
      this.setLocation(x, y);
    } else {
      throw new RuntimeException("New Point not in limits");
    }
  }

  public void translate(int dx, int dy) {
    int new_x = this.getX() + dx;
    int new_y = this.getY() + dy;
    if (this.inLimit(new_x, new_y)) {
      this.setLocation(new_x, new_y);
    } else {
      throw new RuntimeException("New Point not in limits");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (getClass() != o.getClass()){
      return false;
    }
    LimitedPoint point = (LimitedPoint) o;
    return this.getX() == point.getX() && this.getY() == point.getY();
  }

  public boolean equals(int x, int y) {
    return this.getX() == x && this.getY() == y;
  }
  
  private boolean inLimit(int x, int y) {
    return 0 <= x && x <= this.x_limit && 0 <= y && y <= y_limit;
  }

  private void setLimit(int x, int y) {
    this.x_limit = x;
    this.y_limit = y;
  }

}
