package org.gmhorn.pbrt.geometry;

import org.gmhorn.pbrt.core.Medium;

public class RayDifferential extends Ray {

    public boolean hasDifferentials = false;
    public Point3f rxOrigin, ryOrigin;
    public Vector3f rxDirection, ryDirection;

    public RayDifferential() {
        super();
    }

    public RayDifferential(Point3f o, Vector3f d) {
        super(o, d);
    }

    public RayDifferential(Point3f o, Vector3f d, float tMax, float time, Medium medium) {
        super(o, d, tMax, time, medium);
    }

    public boolean hasNaNs() {
        return super.hasNaNs() ||
                (hasDifferentials && (rxOrigin.hasNaNs() || ryOrigin.hasNaNs() ||
                rxDirection.hasNaNs() || ryDirection.hasNaNs()));
    }

    public void scaleDifferentials(float s) {
        rxOrigin = o.plus(rxOrigin.minus(o).mult(s));
        ryOrigin = o.plus(ryOrigin.minus(o).mult(s));
        rxDirection = d.plus(rxDirection.minus(d).mult(s));
        ryDirection = d.plus(ryDirection.minus(d).mult(s));
        // TODO: Why not set hasDifferentials=true?
    }

    @Override
    public String toString() {
        if (hasDifferentials) {
            return "RayDifferential{" + super.toString() + " has differentials: true" +
            ", xo=" +rxOrigin + ", xd=" + rxDirection + ", yo=" + ryOrigin + ", yd=" + this.ryDirection + "}";
        } else {
            return "RayDifferential{" + super.toString() + " has differentials: false}";
        }
    }
}
