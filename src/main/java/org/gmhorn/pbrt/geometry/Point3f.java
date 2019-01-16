package org.gmhorn.pbrt.geometry;

import java.util.Objects;

public final class Point3f {

    public final float x;
    public final float y;
    public final float z;

    public Point3f() {
        this(0,0,0);
    }

    public Point3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean hasNaNs() {
        return Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z);
    }

    public Point3f plus(Vector3f v) {
        return new Point3f(x + v.x, y + v.y, z + v.z);
    }

    private Point3f plus(Point3f p) {
        return new Point3f(x+p.x, y+p.y, z+p.z);
    }

    public Vector3f minus(Point3f p) {
        return new Vector3f(x-p.x, y-p.y, z-p.z);
    }

    public float distanceTo(Point3f p) {
        return this.minus(p).length();
    }

    private Point3f mult(float f) {
        return new Point3f(f*x, f*y, f*z);
    }

    public static Point3f lerp(float t, Point3f p0, Point3f p1) {
        return p0.mult(1-t).plus(p1.mult(t));
    }

    @Override
    public String toString() {
        return "Point3f{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3f point3f = (Point3f) o;
        return Float.compare(point3f.x, x) == 0 &&
                Float.compare(point3f.y, y) == 0 &&
                Float.compare(point3f.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
