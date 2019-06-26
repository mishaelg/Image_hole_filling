package com.hole_filler.converter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TwoRgbConverter implements IConverter {

    /**
     * This function reads Two RGB picture, the origin picture and mask picture which denotes where
     * the hole in the picture is, and return the picture in gray scale with -1 in hole.
     * @param imageSource: what address the original picture is located at.
     * @param maskSource: what address the mask is located at.
     * @return imageInFloatsArray: image with -1 where the hole should be
     */
    public float[][] convert(String imageSource, String maskSource) throws IOException {
        // reads the image and convert it to floats array
        BufferedImage image = ImageIO.read(new File(imageSource));
        float[][] imageInFloatsArray = new float[image.getHeight()][image.getWidth()];
        for (int i = 0; i < imageInFloatsArray.length; i++) {
            for (int j = 0; j < imageInFloatsArray[0].length; j++) {
                imageInFloatsArray[i][j] = (float) image.getRaster().getSample(j, i, 1) / 255; // converting from RGB
                // scale to grayscale, with normalization.
            }
        }
        // reads the mask in RGB and converts it to grayscale
        BufferedImage mask = ImageIO.read(new File(imageSource));
        int[][] maskIntArray = new int[mask.getHeight()][mask.getWidth()];
        for (int i = 0; i < maskIntArray.length; i++) {
            for (int j = 0; j < maskIntArray[0].length; j++) {
                maskIntArray[i][j] =  image.getRaster().getSample(j, i, 1) ; // converting from RGB
                // scale to grayscale
            }
        }
        // applying mask to the image array
        for (int i = 0; i < imageInFloatsArray.length; i++) {
            for (int j = 0; j < imageInFloatsArray[0].length; j++) {
                if (maskIntArray[i][j] == 0) {
                    imageInFloatsArray[i][j] = -1;
                }
            }
        }
    return imageInFloatsArray; //final result: image with -1 where the hole should be
    }
}
