package com.hole_filler.fillImageHoles;

import com.hole_filler.additionalClasses.PixelLoc;
import com.hole_filler.weightFunction.IWeightFunction;

import java.util.List;

public class ImageHoleFiller implements IFillImageHoles {


    /**
     * This function receives an image with hole and "fixes" the image using the appropriate algorithm inplace
     * @param boundariesList: Arraylist of all the boundary pixels in the image
     * @param holesList: Arraylist of all the hole pixels in the image
     * @param epsilon: provided by the user to prevent division by zero(see Weight function for more info)
     * @param z: the power of the euclidean distance in the weight function(see Weight function for more info)
     * @param image: the image with the hole
     */
    public  void fixImageHoles(List<PixelLoc> boundariesList, List<PixelLoc> holesList, float epsilon, int z, float[][] image, IWeightFunction weightFunc) {
        for (PixelLoc u : boundariesList) {
            float newHoleValue = holeIntensity(boundariesList, u, epsilon, z, image, weightFunc);
            image[u.getx()][u.gety()] = newHoleValue;
        }
    }

    /**
     * this function finds the hold Intensity of a "fixed" hole, using the algorithm to determine it's value
     * @param boundariesList: list of all the boundary pixels
     * @param hole: list of all the hole pixels
     * @param epsilon: provided by the user, to prevent division by 0
     * @param z: provided by the user, the power factor of the euclidean distance
     * @param image: the image float array
     * @param weightFunction: the function used to determine the wight of two pixels
     * @return the intensity of the "fixed" hole
     */
    private static float holeIntensity(List<PixelLoc> boundariesList, PixelLoc hole, float epsilon, int z, float[][] image, IWeightFunction weightFunction){
        float dividendSum = 0; // the sum of the dividend
        float divisorSum = 0; // the sum of the divisor
        for (PixelLoc v : boundariesList) {
            double weight = weightFunction.getWeightVal(hole, v, epsilon, z);
            dividendSum += weight * image[v.getx()][v.gety()];
            divisorSum += weight;
        }
        return dividendSum / divisorSum;
    }

}
