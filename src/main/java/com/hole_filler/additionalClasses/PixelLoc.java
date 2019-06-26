package com.hole_filler.additionalClasses;

public class PixelLoc {
    public int x;
    public int y;

    public PixelLoc(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getx(){
        return this.x;
    }

    public int gety(){
        return this.y;
    }

    /**
     * computes the euclidean distance between two points
     * @param u: first additionalClasses location
     * @param v: second additionalClasses location
     * @return: the euclidean distance between the two points
     */
    public static double euclideanDistance(PixelLoc u, PixelLoc v){
        return  Math.sqrt(Math.pow(u.getx() -  v.gety(), 2) + Math.pow(u.gety() - v.gety(), 2));
    }
}
