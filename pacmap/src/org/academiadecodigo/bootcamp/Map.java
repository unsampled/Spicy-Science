package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Map {

    private final int TOTAL_COLS = 33;
    private final int TOTAL_ROWS = 21;
    private final int CELL_SIZE = 25;
    private final int PADDING = 10;
    private Cell[][] grid;
    private Rectangle field;


    public Map() {
        field = new Rectangle(PADDING, PADDING, colToX(TOTAL_COLS) - PADDING, rowToY(TOTAL_ROWS) - PADDING);
        field.setColor(Color.BLACK);
        field.fill();
        grid = new Cell[TOTAL_COLS][TOTAL_ROWS];
        popCells();

        try {
            load("/Users/codecadet/dev/testdm/drunk-man/pacmap/resources/Saves/save.txt");
        } catch (IOException e) {
            System.out.println("Error while loading file");
            e.getMessage();
        }

    }

    public void popCells() {
        for (int o = 0; o < TOTAL_COLS; o++) {
            for (int i = 0; i < TOTAL_ROWS; i++) {
                grid[o][i] = new Cell(o, i);
            }
        }

    }

    public int getCELL_SIZE() {
        return CELL_SIZE;
    }

    public int getTOTAL_COLS() {
        return TOTAL_COLS;
    }

    public int getTOTAL_ROWS() {
        return TOTAL_ROWS;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int rowToY(int row) {
        return row * CELL_SIZE + PADDING;
    }

    public int colToX(int col) {
        return col * CELL_SIZE + PADDING;
    }


    public void load(String file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader buffRead = new BufferedReader(fileReader);
        String loadedCell = buffRead.readLine();

        field = new Rectangle(PADDING, PADDING, colToX(TOTAL_COLS) - PADDING, rowToY(TOTAL_ROWS) - PADDING);
        field.setColor(Color.BLACK);
        field.fill();

        int x = 0;
        for (int o = 0; o < TOTAL_COLS; o++) {
            for (int i = 0; i < TOTAL_ROWS; i++) {
                grid[o][i].setEmpty();

                if (loadedCell.charAt(x++) == '1') {

                    grid[o][i].setFull();
                }
            }
        }

        for (int o = 0; o < TOTAL_COLS; o++) {
            for (int i = 0; i < TOTAL_ROWS; i++) {
                if (!grid[o][i].isEmpty()) {
                    new Wall(grid[o][i], this);
                }
            }
        }
        System.out.println("File Loaded");
    }
}
