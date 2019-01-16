package org.gmhorn.pbrt.geometry;

import java.util.Objects;

public final class Vector2i {

    public final int x;
    public final int y;

    public Vector2i() {
        this(0,0);
    }

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2i plus(Vector2i w) {
        return new Vector2i(x+w.x, y+w.y);
    }

    public Vector2i minus(Vector2i w) {
        return new Vector2i(x-w.x, y-w.y);
    }

    public Vector2i mult(int t) {
        return new Vector2i(x *t, y *t);
    }

    public Vector2f mult(float t) {
        return new Vector2f(x *t, y *t);
    }

    public Vector2i abs() {
        return new Vector2i(Math.abs(x), Math.abs(y));
    }

    public int dot(Vector2i v) {
        return x*v.x + y*v.y;
    }

    public int minComponent() {
        return Math.min(x, y);
    }

    public int maxComponent() {
        return Math.max(x, y);
    }

    @Override
    public String toString() {
        return "Vector2i{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2i vector2i = (Vector2i) o;
        return x == vector2i.x &&
                y == vector2i.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
