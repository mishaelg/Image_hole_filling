package com.hole_filler.fillImageHoles;

import com.hole_filler.additionalClasses.PixelLoc;
import com.hole_filler.weightFunction.IWeightFunction;

import java.util.List;

/**
 * interface to implement generic classes to fill hole in the image
 */
public interface IFillImageHoles {
     void fixImageHoles(List<PixelLoc> boundariesList, List<PixelLoc> holesList, float epsilon, int z, float[][] image, IWeightFunction weightFunction);
}
