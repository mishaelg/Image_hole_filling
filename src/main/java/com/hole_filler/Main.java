package com.hole_filler;

import com.hole_filler.additionalClasses.BoundariesAndHoles;
import com.hole_filler.additionalClasses.PixelLoc;
import com.hole_filler.converter.IConverter;
import com.hole_filler.converter.TwoRgbConverter;
import com.hole_filler.fillImageHoles.IFillImageHoles;
import com.hole_filler.fillImageHoles.ImageHoleFiller;
import com.hole_filler.imageSavers.IimageSaver;
import com.hole_filler.imageSavers.ImageSaver;
import com.hole_filler.isconnected.IIsBoundary;
import com.hole_filler.isconnected.IsConnectedByEight;
import com.hole_filler.isconnected.IsConnectedByFour;
import com.hole_filler.weightFunction.DefaultWeightFunction;
import com.hole_filler.weightFunction.IWeightFunction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * @param image: the image with the hole in it, as float 2 dim , with -1 in "hole" pixels
     * @return 2 lists, boundariesList which contain the locations of all the boundaries pixels, and holesList, which contain
     * all the locations of the holes in the pictures, wrapped in objects array.
     */
    public static BoundariesAndHoles findBoundariesAndHoles(float[][] image, IIsBoundary boundaryrule) {
        List<PixelLoc> boundariesList = new ArrayList<PixelLoc>();
        List<PixelLoc> holesList = new ArrayList<PixelLoc>();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == -1) {
                    holesList.add(new PixelLoc(i, j)); // if it's a hole, add to holes list
                    continue;
                }
                if (boundaryrule.isBoundary(image, i, j)) {
                    boundariesList.add(new PixelLoc(i, j));// if it's a boundary, add to boundaries list
                }

            }
        }

        return new BoundariesAndHoles(boundariesList, holesList);
    }

    /** this program receives an image with an hole, and fill the hole using an designated algorithm and then writes
     * the corrected image to memory
     *
     * @param args: args[0]: input image in RGB
     *              args[1]:  hole mask in RGB
     *              args[2]: z for weight function
     *              args[3]: e for weight function
     *              args[4]: connectivity type
     *              args[5]: destination of the "fixed" imaged
     */
    public static void main(String[] args) throws IOException {
        IIsBoundary boundaryRule = new IsConnectedByFour(); // default is connected by four
        IWeightFunction weightFunc  = new DefaultWeightFunction(); // default weight function
        IimageSaver imageSave = new ImageSaver(); // default image saver(saves in default format)
        if(args[4].equals("eight")){ // if we want to check boundary by 8 connected
            boundaryRule = new IsConnectedByEight();
        }
        IConverter converter = new TwoRgbConverter(); // default converter
        float[][] image = converter.convert(args[0], args[1]);
        IFillImageHoles imageFiller = new ImageHoleFiller(); // default algorithm for hole filling
        BoundariesAndHoles lists = findBoundariesAndHoles(image, boundaryRule);
        imageFiller.fixImageHoles(lists.getBoundariesList(), lists.getHolesList(), Integer.valueOf(args[2]),
                Integer.valueOf(args[3]), image, weightFunc); //fixing the holes
        imageSave.saveImage(image, args[5]); //saving the corrected image back to memory

    }
}











