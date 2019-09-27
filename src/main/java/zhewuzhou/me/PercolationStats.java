package zhewuzhou.me;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_FACTOR = 1.96;

    private final int width;
    private double[] thresholds;
    private double mean;
    private double stddev;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("N or Trials is invalid");
        }
        width = n;
        thresholds = new double[trials];
        for (int i = 0; i < trials; i++) {
            performIteration(i);
        }
        this.mean = StdStats.mean(thresholds);
        this.stddev = StdStats.stddev(thresholds);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - ((CONFIDENCE_FACTOR * stddev) / Math.sqrt(width));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + ((CONFIDENCE_FACTOR * stddev) / Math.sqrt(width));
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }

    private void performIteration(int i) {
        Percolation percolation = new Percolation(width);
        while (!percolation.percolates()) {
            int randomRow = StdRandom.uniform(1, width + 1);
            int randomCol = StdRandom.uniform(1, width + 1);
            percolation.open(randomRow, randomCol);
        }
        thresholds[i] = percolation.numberOfOpenSites() / (double) (width * width);
    }
}
