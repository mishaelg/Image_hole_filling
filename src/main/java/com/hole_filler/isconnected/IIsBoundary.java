package com.hole_filler.isconnected;

public interface IIsBoundary {
    /**
     * generic interface to determine whether a pixel is an boundary pixel
     * @param image: the image in float array
     * @param i: x location of the pixel
     * @param j: y location of the pixel
     * @return: boolean whether the pixel is a boundary pixel or not
     */
    boolean isBoundary(float[][] image, int i, int j);
}
