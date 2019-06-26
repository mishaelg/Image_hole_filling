package com.hole_filler.weightFunction;

import com.hole_filler.additionalClasses.PixelLoc;

public class DefaultWeightFunction implements IWeightFunction {

    /**
     *
     * @param u: location of the hole additionalClasses in PixelLoc object.
     * @param v: location of the Boundary additionalClasses in PixelLoc object.
     * @param epsilon:  provided by the user, to prevent division by zero.
     * @param z: provided by to user, the power of the euclidian distance
     * @return weight of two pixels.
     */
    public double getWeightVal(PixelLoc u, PixelLoc v, float epsilon, int z){
        return 1 / (Math.pow(PixelLoc.euclideanDistance(u, v), z) + epsilon) ; // standard weight function, just an arithmetic operation
    }
}
