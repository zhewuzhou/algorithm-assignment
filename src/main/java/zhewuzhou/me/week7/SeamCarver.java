package zhewuzhou.me.week7;

import edu.princeton.cs.algs4.Picture;

import java.awt.*;

public class SeamCarver {
    private int[][] colors;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (null == picture) {
            throw new IllegalArgumentException("Picture for constructor can't be null");
        }
        colors = new int[picture.width()][picture.height()];
        for (int i = 0; i < width(); i++) {
            for (int j = 0; j < height(); j++) {
                colors[i][j] = picture.get(i, j).getRGB();
            }
        }
    }

    // current picture
    public Picture picture() {
        Picture picture = new Picture(colors.length, colors[0].length);
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[0].length; j++) {
                Color color = new Color(this.colors[i][j]);
                picture.set(i, j, color);
            }
        }
        return picture;
    }

    // width of current picture
    public int width() {
        return this.colors.length;
    }

    // height of current picture
    public int height() {
        return this.colors[0].length;
    }

    // energy of pixel at column x and row y
    public double energy(int column, int row) {
        checkCoordinate(column, row);
        if (column == 0 || column == this.width() - 1 || row == 0 || row == this.height() - 1) {
            return 1000D;
        } else {
            double deltaX = getDelta(colors[column - 1][row], colors[column + 1][row]);
            double deltaY = getDelta(colors[column][row - 1], colors[column][row + 1]);
            return Math.sqrt(deltaX + deltaY);
        }
    }

    private double getDelta(int s, int t) {
        int redDiff = red(t) - red(s);
        int greenDiff = green(t) - green(s);
        int blueDiff = blue(t) - blue(s);
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
        boolean invalidColumn = column < 0 || column >= this.width();
        boolean invalidRow = row < 0 || row >= this.height();
        if (invalidColumn || invalidRow) {
            throw new IllegalArgumentException("Column or row out of range");
        }
    }

    private int red(int rgb) {
        return (rgb >> 16) & 0xFF;
    }

    private int green(int rgb) {
        return (rgb >> 8) & 0xFF;
    }

    private int blue(int rgb) {
        return (rgb >> 0) & 0xFF;
    }
}
