package org.gmhorn.pbrt.integrators;

import org.gmhorn.pbrt.cameras.Camera;
import org.gmhorn.pbrt.core.Scene;
import org.gmhorn.pbrt.core.Spectrum;
import org.gmhorn.pbrt.geometry.RayDifferential;
import org.gmhorn.pbrt.geometry.SurfaceInteraction;
import org.gmhorn.pbrt.samplers.Sampler;

public abstract class SamplerIntegrator {

    private final Sampler sampler;
    private final Camera camera;

    protected SamplerIntegrator(Camera camera, Sampler sampler) {
        this.sampler = sampler;
        this.camera = camera;
    }

    void preprocess(Scene scene, Sampler sampler) {

    }

    void render(Scene scene) {

    }

    abstract Spectrum li(RayDifferential ray, Scene scene, Sampler sampler, int depth);

    abstract Spectrum specularReflect(RayDifferential ray,
                                      SurfaceInteraction surfaceInteraction,
                                      Scene scene, Sampler sampler, int depth);

    abstract Spectrum specularTransmit(RayDifferential ray, SurfaceInteraction
            surfaceInteraction, Scene scene, Sampler sampler, int depth);

}
