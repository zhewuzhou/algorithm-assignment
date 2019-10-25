package zhewuzhou.me.week7;

import edu.princeton.cs.algs4.Picture;

import java.awt.*;

public class SeamCarver {
    private int[][] colors;
    private double[][] energies;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (null == picture) {
            throw new IllegalArgumentException("Picture for constructor can't be null");
        }
        this.colors = new int[picture.width()][picture.height()];
        this.energies = new double[picture.width()][picture.height()];
        for (int c = 0; c < width(); c++) {
            for (int r = 0; r < height(); r++) {
                colors[c][r] = picture.get(c, r).getRGB();
                energies[c][r] = energy(c, r);
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
        return findHorizontalSeam(3).pixelTo;
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {

    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {

    }

    private SP findHorizontalSeam(int column) {
        SP sp = new SP(this.height());
        double[][] distances = initEnergyTo();
        sp.pixelTo[0] = column;
        for (int row = 0; row < this.height() - 1; row++) {
            int nextColumn = relax(column, distances, row);
            sp.pixelTo[row + 1] = nextColumn;
            column = nextColumn;
        }
        sp.pixelTo[this.height() - 1] = sp.pixelTo[this.height() - 2];
        return sp;
    }

    private int relax(int column, double[][] distances, int row) {
        int nextChooseColumn = -1;
        double down = distances[column][row] + this.energies[column][row + 1];
        double leftDown;
        double rightDown;
        if (distances[column][row + 1] > down) {
            distances[column][row + 1] = down;
            nextChooseColumn = column;
        }
        if (column - 1 >= 0) {
            leftDown = distances[column][row] + this.energies[column - 1][row + 1];
            if (distances[column - 1][row + 1] > leftDown) {
                distances[column - 1][row + 1] = leftDown;
            }
            if (distances[column - 1][row + 1] < distances[column][row + 1]) {
                nextChooseColumn = column - 1;
            }
        }
        rightDown = distances[column][row] + this.energies[column + 1][row + 1];
        if (distances[column + 1][row + 1] > rightDown) {
            distances[column + 1][row + 1] = rightDown;
            if (distances[column + 1][row + 1] < distances[column - 1][row + 1]) {
                nextChooseColumn = column + 1;
            }
        }
        return nextChooseColumn;
    }

    private double[][] initEnergyTo() {
        double[][] distances = new double[this.width()][this.height()];
        for (int c = 0; c < this.width(); c++) {
            for (int r = 1; r < this.height(); r++) {
                distances[c][r] = Double.MAX_VALUE;
            }
        }
        return distances;
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

    private class SP {
        int[] pixelTo;
        double distance;

        public SP(int steps) {
            this.pixelTo = new int[steps];
        }
    }
}
