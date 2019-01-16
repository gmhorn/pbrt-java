package org.gmhorn.pbrt.geometry;

import java.util.Objects;

public final class Vector3f {

    public final float x;
    public final float y;
    public final float z;

    public Vector3f() {
        this(0,0,0);
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean hasNaNs() {
        return Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z);
    }

    public Vector3f plus(Vector3f w) {
        return new Vector3f(x+w.x, y+w.y, z+w.z);
    }

    public Vector3f minus(Vector3f w) {
        return new Vector3f(x-w.x, y-w.y, z-w.z);
    }

    public Vector3f mult(float t) {
        return new Vector3f(x *t, y *t, z *t);
    }

    public Vector3f abs() {
        return new Vector3f(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    public float dot(Vector3f v) {
        return x*v.x + y*v.y + z*v.z;
    }

    public float dot(Normal3f n) {
        return x*n.x + y*n.y + z*n.z;
    }

    public Vector3f cross(Vector3f v) {
        double x1 = this.x, y1 = this.y, z1 = this.z;
        double x2 = v.x, y2 = v.y, z2 = v.z;
        return new Vector3f(
                (float)((y1*z2) - (z1*y2)),
                (float)((z1*x2) - (x1*z2)),
                (float)((x1*y2) - (y1*x2)));
    }

    public Vector3f normalize() {
        return this.mult(1/this.length());
    }

    public float minComponent() {
        return Math.min(x, Math.min(y, z));
    }

    public float maxComponent() {
        return Math.max(x, Math.max(y, z));
    }

    public float lengthSquared() {
        return x * x + y * y + z * z;
    }

    public float length() {
        return (float)Math.sqrt((double) lengthSquared());
    }

    public static CoordinateSystem coordinateSystem(Vector3f v) {
        // C++ Impl in 2.2.4
        return null;
    }

    @Override
    public String toString() {
        return "Vector3f{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3f vector3f = (Vector3f) o;
        return Float.compare(vector3f.x, x) == 0 &&
                Float.compare(vector3f.y, y) == 0 &&
                Float.compare(vector3f.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
