package zhewuzhou.me;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private int width;
    private int openCount = 0;
    private boolean[] statuses;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) throws Exception {
        if (n > 0) {
            width = n;
            statuses = new boolean[n * n];
            for (int i = 0; i < n * n - 1; i++) {
                statuses[i] = false;
            }
            weightedQuickUnionUF = new WeightedQuickUnionUF(n * n);
        } else {
            throw new IllegalArgumentException("N must be positive number");
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        int rowIndex = row - 1;
        int colIndex = col - 1;
        int current = rowIndex * width + colIndex;
        if (!statuses[current]) {
            int left = getLeftItem(rowIndex, colIndex);
            int right = getRightItem(rowIndex, colIndex);
            int top = getTopItem(rowIndex, colIndex);
            int down = getDownItem(rowIndex, colIndex);

            statuses[current] = true;
            openCount++;
            connectNeighbor(current, top);
            connectNeighbor(current, left);
            connectNeighbor(current, right);
            connectNeighbor(current, down);
        }
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return statuses[(row - 1) * width + col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        int current = (row - 1) * width + col - 1;
        for (int i = 0; i < width; i++) {
            if (statuses[i]) {
                if (weightedQuickUnionUF.connected(i, current)) {
                    return true;
                }
            }
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = 0; i < width; i++) {
            if (statuses[(width - 1) * width + i] && isFull(width - 1, i)) {
                return true;
            }
        }
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {

    }

    private void validate(int row, int col) {
        if (row > 0 && row <= width && col > 0 && col <= width) {
            System.out.println("Valid row and col");
        } else {
            throw new IllegalArgumentException("Row or Col is not valid");
        }
    }

    private void connectNeighbor(int current, int neighbor) {
        if (neighbor != -1 && statuses[neighbor]) {
            weightedQuickUnionUF.union(current, neighbor);
        }
    }

    private int getDownItem(int row, int col) {
        int down = -1;
        if (row < width - 1) {
            down = (row + 1) * width + col;
        }
        return down;
    }

    private int getTopItem(int row, int col) {
        int top = -1;
        if (row > 0) {
            top = (row - 1) * width + col;
        }
        return top;
    }

    private int getRightItem(int row, int col) {
        int right = -1;
        if (col == width - 1) {
            if (row < width - 1) {
                right = (row + 1) * width;
            }
        } else {
            right = row * width + col + 1;
        }
        return right;
    }

    private int getLeftItem(int row, int col) {
        int left = -1;
        if (col == 0) {
            if (row > 0) {
                left = (row - 1) * width - 1;
            }
        } else {
            left = row * width + col - 1;
        }
        return left;
    }
}
