package zhewuzhou.me;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

import static edu.princeton.cs.algs4.StdRandom.uniform;
import static java.lang.Math.sqrt;

public class PercolationStats {

    private final int width;
    private double[] thresholds;
    private double mean;
    private double stddev;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) throws Exception {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        width = n;
        thresholds = new double[trials];
        for (int i = 0; i < trials; i++) {
            performIteration(i);
        }
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
        return mean - ((1.96 * stddev) / sqrt(width));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + ((1.96 * stddev) / sqrt(width));
    }

    // test client (see below)
    public static void main(String[] args) throws Exception {
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }

    private void performIteration(int i) throws Exception {
        Percolation percolation = new Percolation(width);
        while (!percolation.percolates()) {
            int randomRow = uniform(1, width + 1);
            int randomCol = uniform(1, width + 1);
            percolation.open(randomRow, randomCol);
        }
        thresholds[i] = percolation.numberOfOpenSites() / (double) (width * width);
        this.mean = StdStats.mean(thresholds);
        this.stddev = StdStats.stddev(thresholds);
    }
}
