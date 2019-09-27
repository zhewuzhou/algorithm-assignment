package zhewuzhou.me;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF virtualTopBottomUF;
    private WeightedQuickUnionUF virtualTopUF;
    private int width;
    private int square;
    private int openCount = 0;
    private boolean[] openStatuses;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be positive number");
        } else {
            width = n;
            square = width * width;
            openStatuses = new boolean[square + 2];
            for (int i = 0; i < square - 1; i++) {
                openStatuses[i] = false;
            }
            openStatuses[square] = true;
            openStatuses[square + 1] = true;
            virtualTopBottomUF = new WeightedQuickUnionUF(square + 2);
            virtualTopUF = new WeightedQuickUnionUF(square + 1);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        int rowIndex = row - 1;
        int colIndex = col - 1;
        int current = rowIndex * width + colIndex;
        if (!openStatuses[current]) {
            if (rowIndex == 0) {
                connectNeighbor(current, square);
            }
            if (rowIndex == width - 1) {
                virtualTopBottomUF.union(current, square + 1);
            }
            openStatuses[current] = true;
            openCount++;
            connectNeighbor(current, getLeftItem(rowIndex, colIndex));
            connectNeighbor(current, getTopItem(rowIndex, colIndex));
            connectNeighbor(current, getRightItem(rowIndex, colIndex));
            connectNeighbor(current, getDownItem(rowIndex, colIndex));
        }
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return openStatuses[(row - 1) * width + col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        int current = (row - 1) * width + col - 1;
        return virtualTopUF.connected(square, current);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return virtualTopBottomUF.connected(square, square + 1);
    }

    // test client (optional)
    public static void main(String[] args) {

    }

    private void validate(int row, int col) {
        boolean validRowCol = (row > 0 && row <= width && col > 0 && col <= width);
        if (!validRowCol) {
            throw new IllegalArgumentException("Row or Col is not valid");
        }
    }

    private void connectNeighbor(int current, int neighbor) {
        if (neighbor != -1 && openStatuses[neighbor]) {
            virtualTopBottomUF.union(current, neighbor);
            virtualTopUF.union(current, neighbor);
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
