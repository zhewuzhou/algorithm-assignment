package zhewuzhou.me.week7.copy;

import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class SeamCarver {
    private static final int RED = 16;
    private static final int GREEN = 8;
    private static final int BLUE = 0;
    private static final int EIGHT_ONE = 0xff;
    private int[] vSeam, hSeam;
    private int[][] colors;
    private double[][] energies;
    private int width, height;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null)
            throw new IllegalArgumentException();
        width = picture.width();
        height = picture.height();
        energies = new double[height][width];
        colors = new int[height][width];
        for (int j = 0; j < height; j++)
            for (int i = 0; i < width; i++)
                colors[j][i] = picture.get(i, j).getRGB();
        for (int j = 0; j < height; j++)
            for (int i = 0; i < width; i++)
                if (i == 0 || i == width - 1 || j == 0 || j == height - 1)
                    energies[j][i] = 1000;
                else
                    calcEnergy(j, i);

    }

    private void calcEnergy(int row, int col) {
        if (row <= 0 || row >= height - 1 || col <= 0 || col >= width - 1)
            return;
        int rx, gx, bx, ry, gy, by;
        rx = getColor(row, col + 1, RED) - getColor(row, col - 1, RED);
        gx = getColor(row, col + 1, GREEN) - getColor(row, col - 1, GREEN);
        bx = getColor(row, col + 1, BLUE) - getColor(row, col - 1, BLUE);
        ry = getColor((row + 1), col, RED) - getColor((row - 1), col, RED);
        gy = getColor((row + 1), col, GREEN) - getColor((row - 1), col, GREEN);
        by = getColor((row + 1), col, BLUE) - getColor((row - 1), col, BLUE);
        energies[row][col] = Math.sqrt(rx * rx + gx * gx + bx * bx
            + ry * ry + gy * gy + by * by);
    }

    private int getColor(int row, int col, int channel) {
        return colors[row][col] >> channel & EIGHT_ONE;
    }

    // current picture
    public Picture picture() {
        Picture pic = new Picture(width, height);
        for (int j = 0; j < height; j++)
            for (int i = 0; i < width; i++)
                pic.set(i, j, new Color(colors[j][i], true));
        return pic;
    }

    // current picture
    public int width() {
        return width;
    }

    // height of current picture
    public int height() {
        return height;
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height)
            throw new IllegalArgumentException();
        return energies[y][x];
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        if (hSeam != null) return hSeam.clone();
        int[] seam = new int[width];
        if (width < 3) {
            for (int i = 1; i < width; i++)
                seam[i] = 0;
            hSeam = seam;
            return seam.clone();
        }

        double[] energyTo = new double[height * width];
        int[] pathTo = new int[height * width];
        for (int i = 0; i < height; i++)
            for (int j = 1; j < width; j++)
                energyTo[i * width + j] = Double.POSITIVE_INFINITY;
        for (int i = 1; i < width; i++) { // Main Loop
            for (int j = 0; j < height; j++) {
                if (j > 0 && energyTo[(j - 1) * width + i] > energies[j - 1][i] + energyTo[j * width + i - 1]) { // Up
                    energyTo[(j - 1) * width + i] = energies[j - 1][i] + energyTo[j * width + i - 1];
                    pathTo[(j - 1) * width + i] = j;
                }
                if (energyTo[j * width + i] > energies[j][i] + energyTo[j * width + i - 1]) { // Middle
                    energyTo[j * width + i] = energies[j][i] + energyTo[j * width + i - 1];
                    pathTo[j * width + i] = j;
                }
                if (j < height - 1 && energyTo[(j + 1) * width + i] > energies[j + 1][i] + energyTo[j * width + i - 1]) { // Down
                    energyTo[(j + 1) * width + i] = energies[j + 1][i] + energyTo[j * width + i - 1];
                    pathTo[(j + 1) * width + i] = j;
                }
            }
        }
        for (int i = 1; i < height - 1; i++)
            if (energyTo[seam[width - 2] * width + width - 2] > energyTo[i * width + width - 2])
                seam[width - 2] = i;
        seam[width - 1] = seam[width - 2];
        for (int i = width - 3; i >= 0; i--)
            seam[i] = pathTo[seam[i + 1] * width + i + 1];

        hSeam = seam;
        return seam.clone();
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        if (vSeam != null) return vSeam.clone();
        int[] seam = new int[height];
        if (height < 3) {
            for (int i = 1; i < height; i++)
                seam[i] = 0;
            vSeam = seam;
            return seam.clone();
        }

        double[] energyTo = new double[height * width];
        int[] pathTo = new int[height * width];
        for (int j = 1; j < height; j++)
            for (int i = 0; i < width; i++)
                energyTo[j * width + i] = Double.POSITIVE_INFINITY;
        for (int j = 1; j < height; j++) { // Main Loop
            for (int i = 0; i < width; i++) {
                if (i > 0 && energyTo[j * width + i - 1] > energies[j][i - 1] + energyTo[(j - 1) * width + i]) { // Left
                    energyTo[j * width + i - 1] = energies[j][i - 1] + energyTo[(j - 1) * width + i];
                    pathTo[j * width + i - 1] = i;
                }
                if (energyTo[j * width + i] > energies[j][i] + energyTo[(j - 1) * width + i]) { // Middle
                    energyTo[j * width + i] = energies[j][i] + energyTo[(j - 1) * width + i];
                    pathTo[j * width + i] = i;
                }
                if (i < width - 1 && energyTo[j * width + i + 1] > energies[j][i + 1] + energyTo[(j - 1) * width + i]) { // Right
                    energyTo[j * width + i + 1] = energies[j][i + 1] + energyTo[(j - 1) * width + i];
                    pathTo[j * width + i + 1] = i;
                }
            }
        }
        for (int i = 1; i < width - 1; i++)
            if (energyTo[(height - 2) * width + seam[height - 2]] > energyTo[(height - 2) * width + i])
                seam[height - 2] = i;
        seam[height - 1] = seam[height - 2];
        for (int i = height - 3; i >= 0; i--)
            seam[i] = pathTo[(i + 1) * width + seam[i + 1]];

        vSeam = seam;
        return seam.clone();
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (height <= 1)
            throw new IllegalArgumentException();
        if (seam == null)
            throw new IllegalArgumentException();
        if (seam.length != width)
            throw new IllegalArgumentException();
        for (int i = 0; i < width; i++) {
            if (i > 0 && Math.abs(seam[i] - seam[i - 1]) > 1)
                throw new IllegalArgumentException();
            if (seam[i] < 0 || seam[i] >= height)
                throw new IllegalArgumentException();
        }

        for (int i = 0; i < width; i++) {
            if (seam[i] == height - 1) {
                energies[height - 2][i] = 1000;
                continue;
            }
            for (int j = seam[i]; j < height - 1; j++) {
                if (j == 0) energies[j][i] = 1000;
                else energies[j][i] = energies[j + 1][i];
                colors[j][i] = colors[j + 1][i];
            }
        }
        height--;
        vSeam = null;
        hSeam = null;
        for (int i = 1; i < width - 1; i++) {
            if (seam[i] > 1) calcEnergy(seam[i] - 1, i); // Up
            if (seam[i] < height - 1) calcEnergy(seam[i], i); // Down
            if (i > 1) calcEnergy(seam[i], i - 1); // Left
            if (i < width - 2) calcEnergy(seam[i], i + 1); // Right
        }
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (width <= 1)
            throw new IllegalArgumentException();
        if (seam == null)
            throw new IllegalArgumentException();
        if (seam.length != height)
            throw new IllegalArgumentException();
        for (int i = 0; i < height; i++) {
            if (i > 0 && Math.abs(seam[i] - seam[i - 1]) > 1)
                throw new IllegalArgumentException();
            if (seam[i] < 0 || seam[i] >= width)
                throw new IllegalArgumentException();
        }

        for (int i = 0; i < height; i++) {
            if (seam[i] == width - 1) {
                energies[i][width - 2] = 1000;
                continue;
            }
            System.arraycopy(energies[i], seam[i] + 1, energies[i], seam[i], width - seam[i] - 1);
            System.arraycopy(colors[i], seam[i] + 1, colors[i], seam[i], width - seam[i] - 1);
            if (seam[i] == 0) energies[i][0] = 1000;
        }
        width--;
        vSeam = null;
        hSeam = null;
        for (int i = 1; i < height - 1; i++) {
            if (seam[i] > 1) calcEnergy(i, seam[i] - 1); // Left
            if (seam[i] < width - 1) calcEnergy(i, seam[i]); // Right
            if (i > 1) calcEnergy(i - 1, seam[i]); // Up
            if (i < height - 2) calcEnergy(i + 1, seam[i]); // Down
        }
    }
}
