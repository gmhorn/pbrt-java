package org.gmhorn.pbrt.integrators;

import org.gmhorn.pbrt.core.Scene;

public interface Integrator {
    void render(Scene scene);
}
