package org.gmhorn.pbrt.geometry;

import java.util.Objects;

public final class Vector3i {

    public final int x;
    public final int y;
    public final int z;

    public Vector3i() {
        this(0,0,0);
    }

    public Vector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3i plus(Vector3i w) {
        return new Vector3i(x+w.x, y+w.y, z+w.z);
    }

    public Vector3i minus(Vector3i w) {
        return new Vector3i(x-w.x, y-w.y, z-w.z);
    }

    public Vector3i mult(int t) {
        return new Vector3i(x *t, y *t, z *t);
    }

    public Vector3f mult(float t) {
        return new Vector3f(x *t, y *t, z *t);
    }

    public Vector3i abs() {
        return new Vector3i(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    public int dot(Vector3i v) {
        return x*v.x + y*v.y + z*v.z;
    }

    public Vector3f normalize() {
        return this.mult(1/this.length());
    }

    public int minComponent() {
        return Math.min(x, Math.min(y, z));
    }

    public int maxComponent() {
        return Math.max(x, Math.max(y, z));
    }

    public Vector3i cross(Vector3i v) {
        return new Vector3i(
                (y*v.z) - (z*v.y),
                (z*v.x) - (x*v.z),
                (x*v.y) - (y*v.x));
    }

    public int lengthSquared() {
        return x * x + y * y + z * z;
    }

    public float length() {
        return (float)Math.sqrt(lengthSquared());
    }

    @Override
    public String toString() {
        return "Vector3i{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3i vector3i = (Vector3i) o;
        return x == vector3i.x &&
                y == vector3i.y &&
                z == vector3i.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
