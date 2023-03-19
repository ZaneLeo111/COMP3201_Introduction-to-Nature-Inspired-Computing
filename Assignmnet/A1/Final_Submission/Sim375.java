/******************************************************************************
 *  Compilation:  javac Sim375.java
 *  Execution:    java Sim375 N
 *  Author: Ze Liu
 *  Student ID: 201767167
 ******************************************************************************/

import java.awt.Color;


public class Sim375 {
    private int N = 120;                     // N-by-N grid of cells
    private boolean[][] cells;         // cell[i][j] = true if alive, false if dead
    private Picture pic;
    private char pattern;
    private int magnification = 6;

    public Sim375(char pattern) {
        this.pattern = pattern;
        this.cells = new boolean[N][N];
        pic = new Picture(N*magnification, N*magnification);

        if (pattern == 'R') {
            // initialize with random pattern
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    cells[i][j] = Math.random() < 0.5;
        }
        // Tumber pattern
        else if (pattern == 'T') {
            // first number column then row
            this.cells[2][1] = true;
            this.cells[8][1] = true;
            this.cells[1][2] = true;
            this.cells[3][2] = true;
            this.cells[9][2] = true;
            this.cells[7][2] = true;

            this.cells[1][3] = true;
            this.cells[4][3] = true;
            this.cells[6][3] = true;
            this.cells[9][3] = true;

            this.cells[3][4] = true;
            this.cells[7][4] = true;

            this.cells[3][5] = true;
            this.cells[7][5] = true;
            this.cells[4][5] = true;
            this.cells[6][5] = true;
        }
        // Loafer pattern
        else if (pattern == 'L') {
            cells[1][2] = true;
            cells[2][1] = true;
            cells[2][3] = true;
            cells[3][1] = true;
            cells[3][4] = true;
            cells[4][2] = true;
            cells[4][3] = true;
            cells[6][1] = true;
            cells[6][7] = true;
            cells[7][2] = true;
            cells[7][6] = true;
            cells[7][8] = true;
            cells[8][1] = true;
            cells[8][2] = true;
            cells[8][6] = true;
            cells[8][9] = true;
            cells[9][1] = true;
            cells[9][5] = true;
            cells[9][6] = true;
            cells[9][9] = true;
        }
    }

    public void update() {
        // create new generation
        boolean[][] newCells = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)  {
                int count = 0;

                for (int ii = i - 1; ii <= i + 1; ii++) {
                    for (int jj = j - 1; jj <= j + 1; jj++) {

                        // wrap around
                        if (cells[(ii + N) % N][(jj + N) % N]) {
                            count++;
                        }
                    }
                }
                // subtract self if alive
                if (cells[i][j] && (count -1  < 2 || count -1  > 3) ) {
                    newCells[i][j] = false;
                }
                else if (!cells[i][j] && count == 3) {
                    newCells[i][j] = true;
                }
                else {
                    newCells[i][j] = cells[i][j];
                }
            }
        }

        cells = newCells;

    }

    // draw cells
    public void draw() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int offsetX = 0; offsetX < magnification; offsetX++)
                {
                    for (int offsetY = 0; offsetY < magnification; offsetY++)
                    {
                        if (cells[i][j]) {
                            pic.set((i*magnification)+offsetX, (j*magnification)+offsetY, Color.black);
                        }
                        else {
                            pic.set((i*magnification)+offsetX, (j*magnification)+offsetY, Color.white);
                        }
                    }
                }
            }
        }
        pic.show();
    }

    // test client
    public static void main(String[] args) {
        int IterationNumber = Integer.parseInt(args[0]);
        char pattern = args[1].charAt(0);
        Sim375 sim375 = new Sim375(pattern);
        sim375.draw();

        for (int i = 0; i < IterationNumber; i++) {
            try { Thread.sleep(100); }
            catch (Exception ex) { /* ignore */ }

            sim375.update();
            sim375.draw();
        }
    }

}
