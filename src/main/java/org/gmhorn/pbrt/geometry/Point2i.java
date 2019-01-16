package org.gmhorn.pbrt.geometry;

import java.util.Objects;

public final class Point2i {

    public final int x;
    public final int y;

    public Point2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2i{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2i point2i = (Point2i) o;
        return x == point2i.x &&
                y == point2i.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
