package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Map {

    int LEVEL = 1;


    private final int TOTAL_COLS = 33;
    private final int TOTAL_ROWS = 21;
    private final int CELL_SIZE = 25;
    private final int PADDING = 10;
    private Cell[][] grid;
    private Rectangle field;


    private Text score;
    private Text life;
    private Rectangle scoreField;
    private Picture p1;
    private Text label;

    private int TOTALSCORE;
    private int LIVES = 3;


    public Map() {
        field = new Rectangle(PADDING, PADDING, colToX(TOTAL_COLS) - PADDING, rowToY(TOTAL_ROWS) - PADDING);
        field.setColor(Color.BLACK);
        field.fill();
        grid = new Cell[TOTAL_COLS][TOTAL_ROWS];


        scoreField = new Rectangle(PADDING, rowToY(TOTAL_ROWS), colToX(TOTAL_COLS) - PADDING, rowToY(1));
        scoreField.setColor(Color.BLACK);
        scoreField.fill();
        TOTALSCORE = 0;

        int growSize = 8;
        score = new Text(PADDING + 2 * growSize, rowToY(TOTAL_ROWS) + growSize, "Score: " + TOTALSCORE);
        score.grow(growSize, growSize);
        score.setColor(Color.WHITE);
        score.draw();

        life = new Text(colToX(TOTAL_COLS) - 6 * growSize, rowToY(TOTAL_ROWS) + growSize, "Lives: "+ LIVES);
        life.grow(growSize, growSize);
        life.setColor(Color.WHITE);
        life.draw();

        label = new Text(colToX(TOTAL_COLS / 2), rowToY(TOTAL_ROWS) + growSize, "    SPICY  SCIENCE");
        int tranlX = -(label.getWidth()/2)+ (CELL_SIZE/2);
        label.translate(tranlX, 0);
        label.grow(growSize, growSize);
        label.setColor(Color.WHITE);
        label.draw();


        popCells();

        try {
            load("/Users/codecadet/dev/testdm/drunk-man/pacmap/resources/Saves/save");
        } catch (IOException e) {
            System.out.println("Error while loading file");
            e.getMessage();
        }

    }

    public void increaseScore(int score) {
        TOTALSCORE += score;
        this.score.setText("Score: " + TOTALSCORE);
    }

    public void decreaseLife(int life) {
        LIVES-= life;
        this.life.setText("Lives: " + LIVES);
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

    public int getPADDING() {
        return PADDING;
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

        FileReader fileReader = new FileReader(file+LEVEL+".txt");
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