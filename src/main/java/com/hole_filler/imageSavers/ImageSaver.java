package com.hole_filler.imageSavers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageSaver implements IimageSaver {
    /**
     * saves the final product to a destination location
     * @param image: fixed image in float array
     * @param destination: location, where to save the image, in string
     */
    public void saveImage(float[][] image, String destination) throws IOException {
        float[] flattenedArray = new float[image.length*image[0].length];
        for (int i=0; i<image.length; i++){
            System.arraycopy(image[i], 0, flattenedArray, i * image[i].length, image[i].length);
        }
        BufferedImage outputImage = new BufferedImage(image.length,image[0].length , BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = outputImage.getRaster();
        raster.setSamples(0, 0, image.length, image[0].length, 1, flattenedArray);
        ImageIO.write(outputImage, "jpeg", new File(destination));
    }


}
