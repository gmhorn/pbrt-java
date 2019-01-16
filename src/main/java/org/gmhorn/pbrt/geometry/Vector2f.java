package org.gmhorn.pbrt.geometry;

import java.util.Objects;

public final class Vector2f {

    public final float x;
    public final float y;

    public Vector2f() {
        this(0,0);
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean hasNaNs() {
        return Float.isNaN(x) || Float.isNaN(y);
    }


    public Vector2f plus(Vector2f w) {
        return new Vector2f(x+w.x, y+w.y);
    }

    public Vector2f minus(Vector2f w) {
        return new Vector2f(x-w.x, y-w.y);
    }

    public Vector2f mult(float t) {
        return new Vector2f(x *t, y *t);
    }

    public Vector2f abs() {
        return new Vector2f(Math.abs(x), Math.abs(y));
    }

    public float dot(Vector2f v) {
        return x*v.x + y*v.y;
    }

    public Vector2f normalize() {
        return this.mult(1/this.length());
    }

    public float minComponent() {
        return Math.min(x, y);
    }

    public float maxComponent() {
        return Math.max(x, y);
    }

    public float lengthSquared() {
        return x * x + y * y;
    }

    public float length() {
        return (float)Math.sqrt(lengthSquared());
    }

    @Override
    public String toString() {
        return "Vector2f{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2f vector2f = (Vector2f) o;
        return Float.compare(vector2f.x, x) == 0 &&
                Float.compare(vector2f.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
