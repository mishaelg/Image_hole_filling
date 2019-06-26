package com.hole_filler.additionalClasses;

import java.util.List;

public class BoundariesAndHoles {
    private List<PixelLoc> boundariesList;
    private List<PixelLoc> holesList;

    public BoundariesAndHoles(List<PixelLoc> boundariesList, List<PixelLoc> holesList) {
        this.boundariesList = boundariesList;
        this.holesList = holesList;
    }

    public List<PixelLoc> getBoundariesList() {
        return boundariesList;
    }

    public List<PixelLoc> getHolesList() {
        return holesList;
    }

}
