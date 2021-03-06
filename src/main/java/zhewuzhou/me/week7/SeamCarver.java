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
        initColors(picture);
        this.energies = calculateEnergies();
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
        int[][] path = initSP();
        double[][] distances = initEnergyTo(1, 0);
        for (int r = 0; r < height() - 1; r++) {
            relaxHorizontally(r, 0, distances, path);
        }
        return retrieveHorizontalSP(path, distances);
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        int[][] path = initSP();
        double[][] distances = initEnergyTo(0, 1);
        for (int c = 0; c < width() - 1; c++) {
            relaxVertically(0, c, distances, path);
        }
        return retrieveVerticalSP(path, distances);
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (null == seam || seam.length != this.width() || this.height() <= 1) {
            throw new IllegalArgumentException("Invalid seam or can not remove seam.");
        }
        int[][] newColors = new int[this.width()][this.height() - 1];
        for (int c = 0; c < this.width() - 1; c++) {
            System.arraycopy(this.colors[c], 0, newColors[c], 0, seam[c]);
            System.arraycopy(this.colors[c], seam[c] + 1, newColors[c], seam[c], this.height() - seam[c] - 1);
        }
        this.colors = newColors;
        this.energies = calculateEnergies();
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (null == seam || seam.length != this.height() || this.width() <= 1) {
            throw new IllegalArgumentException("Invalid seam or can not remove seam.");
        }
        int[][] newColors = new int[this.width() - 1][this.height()];
        for (int c = 0; c < this.width() - 2; c++) {
            for (int r = 0; r < this.height() - 1; r++) {
                if (seam[r] < c) {
                    newColors[c][r] = this.colors[c][r];
                } else if (seam[r] > c) {
                    newColors[c][r] = this.colors[c + 1][r];
                }
            }
        }
        this.colors = newColors;
        this.energies = calculateEnergies();
    }

    private void relaxVertically(int row, int column, double[][] distances, int[][] path) {
        if (row < height() - 1) {
            for (int k = -1; k <= 1; k++) {
                int newColumn = column + k;
                if (newColumn >= 0 && newColumn < this.width()) {
                    double currentSP = distances[newColumn][row + 1];
                    double newSP = distances[column][row] + energies[newColumn][row + 1];
                    if (currentSP > newSP) {
                        distances[newColumn][row + 1] = newSP;
                        path[newColumn][row + 1] = column;
                    }
                    relaxVertically(row + 1, newColumn, distances, path);
                }
            }
        }
    }

    private void relaxHorizontally(int row, int column, double[][] distances, int[][] path) {
        if (column < width() - 1) {
            for (int k = -1; k <= 1; k++) {
                int newRow = row + k;
                int nextColumn = column + 1;
                if (newRow >= 0 && newRow < this.height()) {
                    double currentSP = distances[nextColumn][newRow];
                    double newSP = distances[column][row] + energies[nextColumn][newRow];
                    if (currentSP > newSP) {
                        distances[nextColumn][newRow] = newSP;
                        path[nextColumn][newRow] = row;
                    }
                    relaxHorizontally(newRow, nextColumn, distances, path);
                }
            }
        }
    }

    private double[][] initEnergyTo(int colStart, int rowStart) {
        double[][] distances = new double[this.width()][this.height()];
        for (int c = colStart; c < this.width(); c++) {
            for (int r = rowStart; r < this.height(); r++) {
                distances[c][r] = Double.MAX_VALUE;
            }
        }
        return distances;
    }

    private int[][] initSP() {
        int[][] prev = new int[this.width()][this.height()];
        for (int c = 0; c < this.width(); c++) {
            for (int r = 1; r < this.height(); r++) {
                prev[c][r] = -1;
            }
        }
        return prev;
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

    private double[][] calculateEnergies() {
        double[][] result = new double[this.width()][this.height()];
        for (int c = 0; c < width(); c++) {
            for (int r = 0; r < height(); r++) {
                result[c][r] = this.energy(c, r);
            }
        }
        return result;
    }

    private void initColors(Picture picture) {
        for (int c = 0; c < width(); c++) {
            for (int r = 0; r < height(); r++) {
                colors[c][r] = picture.get(c, r).getRGB();
            }
        }
    }

    private int[] retrieveVerticalSP(int[][] path, double[][] distances) {
        int lastRow = height() - 1;
        int[] result = new int[lastRow + 1];
        double minDistance = Double.MAX_VALUE;
        int chooseColumn = -1;
        for (int c = 0; c < width() - 1; c++) {
            if (distances[c][lastRow] < minDistance) {
                minDistance = distances[c][lastRow];
                chooseColumn = c;
            }
        }
        result[lastRow] = chooseColumn;
        int prev = chooseColumn;
        for (int row = lastRow; row > 0; row--) {
            prev = path[prev][row];
            result[row - 1] = prev;
        }
        return result;
    }

    private int[] retrieveHorizontalSP(int[][] path, double[][] distances) {
        int lastColumn = width() - 1;
        int[] result = new int[lastColumn + 1];
        double minDistance = Double.MAX_VALUE;
        int chooseRow = -1;
        for (int r = 0; r < height() - 1; r++) {
            if (distances[lastColumn][r] < minDistance) {
                minDistance = distances[lastColumn][r];
                chooseRow = r;
            }
        }
        result[lastColumn] = chooseRow;
        int prev = chooseRow;
        for (int column = lastColumn; column > 0; column--) {
            prev = path[column][prev];
            result[column - 1] = prev;
        }
        return result;
    }
}
