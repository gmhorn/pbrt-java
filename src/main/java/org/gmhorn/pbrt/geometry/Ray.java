package org.gmhorn.pbrt.geometry;

import org.gmhorn.pbrt.core.Medium;
import org.gmhorn.pbrt.core.Pbrt;

public class Ray {

    public final Point3f o;
    public final Vector3f d;
    public float tMax;
    public final float time;
    public final Medium medium;

    public Ray() {
        this(new Point3f(), new Vector3f());
    }

    public Ray(Point3f o, Vector3f d) {
        this(o, d, Pbrt.Infinity, 0, null);
    }

    public Ray(Point3f o, Vector3f d, float tMax, float time, Medium medium) {
        this.o = o;
        this.d = d;
        this.tMax = tMax;
        this.time = time;
        this.medium = medium;
    }

    public Point3f eval(float t) {
        return o.plus(d.mult(t));
    }

    public boolean hasNaNs() {
        return o.hasNaNs() || d.hasNaNs() || Float.isNaN(tMax);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "o=" + o +
                ", d=" + d +
                ", tMax=" + tMax +
                ", time=" + time +
                ", medium=" + medium +
                '}';
    }
}
