package com.hole_filler.imageSavers;

import java.io.IOException;

public interface IimageSaver {
    void saveImage(float[][] image, String destination) throws IOException;
}
