package org.gmhorn.pbrt.geometry;

import java.util.Objects;

public final class Point2f {

    public final float x;
    public final float y;

    public Point2f() {
        this(0,0);
    }

    public Point2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean hasNaNs() {
        return Float.isNaN(x) || Float.isNaN(y);
    }

    public Point2f plus(Vector3f v) {
        return new Point2f(x + v.x, y + v.y);
    }

    private Point2f plus(Point2f p) {
        return new Point2f(x+p.x, y+p.y);
    }

    public Vector2f minus(Point2f p) {
        return new Vector2f(x-p.x, y-p.y);
    }

    public float distanceTo(Point2f p) {
        return this.minus(p).length();
    }

    private Point2f mult(float f) {
        return new Point2f(f*x, f*y);
    }

    public static Point2f lerp(float t, Point2f p0, Point2f p1) {
        return p0.mult(1-t).plus(p1.mult(t));
    }

    @Override
    public String toString() {
        return "Point3f{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2f point3f = (Point2f) o;
        return Float.compare(point3f.x, x) == 0 &&
                Float.compare(point3f.y, y) == 0
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
