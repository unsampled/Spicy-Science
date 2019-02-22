package org.academiadecodigo.bootcamp;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Map {

    private final int TOTAL_COLS = 53;
    private final int TOTAL_ROWS = 31;
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
       // drawWalls();

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


    public void drawWalls() {

        //OUTER LIMITS
        for (int i = 0; i < TOTAL_COLS; i++) {
            Wall topWall = new Wall(grid[i][0], this);
            Wall bottomWall = new Wall(grid[i][TOTAL_ROWS - 1], this);
        }

        for (int i = 0; i < TOTAL_ROWS; i++) {
            Wall leftWall = new Wall(grid[0][i], this);
            Wall rightWall = new Wall(grid[TOTAL_COLS - 1][i], this);
        }


        //set cells to not free
        //draw walls/remove walls

    }

    public void load(String file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader buffRead = new BufferedReader(fileReader);
        String loadedCell = buffRead.readLine();

        field = new Rectangle(PADDING, PADDING, colToX(TOTAL_COLS) - PADDING, rowToY(TOTAL_ROWS) - PADDING);
        field.setColor(Color.BLACK);
        field.fill();
        drawWalls();

        int x = 0;
        for (int o = 0; o < TOTAL_COLS; o++) {
            for (int i = 0; i < TOTAL_ROWS; i++) {
                grid[o][i].setEmpty(true);


                if (loadedCell.charAt(x++) == '1') {
                    Wall wall = new Wall(grid[o][i],this);
                    grid[o][i].setEmpty(false);
                }


            }
        }
        System.out.println("File Loaded");
    }
}
