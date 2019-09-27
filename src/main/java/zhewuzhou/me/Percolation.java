package zhewuzhou.me;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF virtualTopBottomUF;
    private WeightedQuickUnionUF virtualTopUF;
    private int width;
    private int square;
    private int openSitesCount = 0;
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
        int current = calculateIndex(rowIndex, colIndex);
        if (!openStatuses[current]) {
            if (rowIndex == 0) {
                connectNeighbor(current, square);
            }
            if (rowIndex == width - 1) {
                virtualTopBottomUF.union(current, square + 1);
            }
            openStatuses[current] = true;
            openSitesCount++;
            connectNeighbor(current, getNeighborIndex(rowIndex - 1, colIndex));
            connectNeighbor(current, getNeighborIndex(rowIndex, colIndex - 1));
            connectNeighbor(current, getNeighborIndex(rowIndex, colIndex + 1));
            connectNeighbor(current, getNeighborIndex(rowIndex + 1, colIndex));
        }
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return openStatuses[calculateIndex(row - 1, col - 1)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        int current = calculateIndex(row - 1, col - 1);
        return virtualTopUF.connected(square, current);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSitesCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return virtualTopBottomUF.connected(square, square + 1);
    }

    private void validate(int row, int col) {
        if (!isOnGrid(row - 1, col - 1)) {
            throw new IllegalArgumentException("Row or Col is not valid");
        }
    }

    private void connectNeighbor(int current, int neighbor) {
        if (neighbor != -1 && openStatuses[neighbor]) {
            virtualTopBottomUF.union(current, neighbor);
            virtualTopUF.union(current, neighbor);
        }
    }

    private int getNeighborIndex(int row, int col) {
        if (isOnGrid(row, col)) {
            return calculateIndex(row, col);
        } else {
            return -1;
        }
    }

    private int calculateIndex(int row, int col) {
        return width * row + col;
    }

    private boolean isOnGrid(int row, int col) {
        return (row >= 0 && col >= 0 && row < width && col < width);
    }
}
