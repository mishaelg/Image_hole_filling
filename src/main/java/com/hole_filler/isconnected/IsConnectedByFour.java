package com.hole_filler.isconnected;

public class IsConnectedByFour implements IIsBoundary {

    /**
     * determines whether a additionalClasses is a boundary additionalClasses or not by 4 connected logic.
     * @param image: the image in floats array
     * @param i: location of additionalClasses
     * @param j: location of additionalClasses
     * @return true if boundary additionalClasses, otherwise false
     */
    public  boolean isBoundary(float[][] image, int i, int j){
        return (image[i - 1][j] == -1) || (image[i + 1][j] == -1) || (image[i][j + 1] == -1) || (image[i][j - 1] == -1);
    }

}
