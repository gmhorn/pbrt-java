package org.gmhorn.pbrt.geometry;

public class Bounds3f {

    public final Point3f pMin;
    public final Point3f pMax;

    public Bounds3f(Point3f p) {
        this.pMin = p;
        this.pMax = p;
    }

    public Vector3f diagonal() {
        return pMax.minus(pMin);
    }

    public

}
