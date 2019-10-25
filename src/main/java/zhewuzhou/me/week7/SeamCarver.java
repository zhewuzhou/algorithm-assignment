package zhewuzhou.me.week7;

import edu.princeton.cs.algs4.Picture;

import java.awt.*;

public class SeamCarver {
    private Picture picture;
    private int width;
    private int height;
    private double[][] cache;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (null == picture) {
            throw new IllegalArgumentException("Picture for constructor can't be null");
        }
        this.picture = picture;
        this.width = picture.width();
        this.height = picture.height();
        this.cache = new double[height][width];
    }

    // current picture
    public Picture picture() {
        return picture;
    }

    // width of current picture
    public int width() {
        return this.width;
    }

    // height of current picture
    public int height() {
        return this.height;
    }

    // energy of pixel at column x and row y
    public double energy(int column, int row) {
        checkCoordinate(column, row);
        if (cache[row][column] == 0D) {
            calculateEnergy(column, row);
        }
        return cache[row][column];
    }

    private void calculateEnergy(int column, int row) {
        if (column == 0 || column == width - 1 || row == 0 || row == height - 1) {
            cache[row][column] = 1000D;
        } else {
            double deltaX = getDelta(picture.get(column - 1, row), picture.get(column + 1, row));
            double deltaY = getDelta(picture.get(column, row - 1), picture.get(column, row + 1));
            cache[row][column] = Math.sqrt(deltaX + deltaY);
        }
    }

    private double getDelta(Color s, Color t) {
        int redDiff = t.getRed() - s.getRed();
        int greenDiff = t.getGreen() - s.getGreen();
        int blueDiff = t.getBlue() - s.getBlue();
        return redDiff * redDiff + greenDiff * greenDiff + blueDiff * blueDiff;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        return null;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        return null;
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {

    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {

    }

    private void checkCoordinate(int column, int row) {
        boolean invalidColumn = column < 0 || column >= this.width;
        boolean invalidRow = row < 0 || row >= this.height;
        if (invalidColumn || invalidRow) {
            throw new IllegalArgumentException("Column or row out of range");
        }
    }
}
