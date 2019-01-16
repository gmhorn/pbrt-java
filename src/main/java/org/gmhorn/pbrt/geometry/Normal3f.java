package org.gmhorn.pbrt.geometry;

import java.util.Objects;

public final class Normal3f {

    public final float x;
    public final float y;
    public final float z;

    public Normal3f() {
        this(0,0,0);
    }

    public Normal3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Normal3f(Vector3f v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public boolean hasNaNs() {
        return Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z);
    }

    public Normal3f plus(Normal3f w) {
        return new Normal3f(x+w.x, y+w.y, z+w.z);
    }

    public Normal3f mult(float t) {
        return new Normal3f(x *t, y *t, z *t);
    }

    public float lengthSquared() {
        return x * x + y * y + z * z;
    }

    public float length() {
        return (float)Math.sqrt((double) lengthSquared());
    }

    public float dot(Vector3f v) {
        return x*v.x + y*v.y + z*v.z;
    }

    public float dot(Normal3f n) {
        return x*n.x + y*n.y + z*n.z;
    }

    public Normal3f faceForward(Vector3f v) {
        if (this.dot(v) < 0) {
            return this.mult(-1);
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return "Normal3f{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Normal3f normal3f = (Normal3f) o;
        return Float.compare(normal3f.x, x) == 0 &&
                Float.compare(normal3f.y, y) == 0 &&
                Float.compare(normal3f.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
