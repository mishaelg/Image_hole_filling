package com.hole_filler.weightFunction;

import com.hole_filler.additionalClasses.PixelLoc;

public interface IWeightFunction {
    double getWeightVal(PixelLoc u, PixelLoc v, float epsilon, int z);
}
