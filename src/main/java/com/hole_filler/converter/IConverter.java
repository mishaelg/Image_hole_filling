package com.hole_filler.converter;

import java.io.IOException;

/**
 * interface which converts input image into the grayscale image with values of [0-1], and -1 in hole
 */
public interface IConverter {
    float[][] convert(String imageSource, String maskSource) throws IOException;
}
