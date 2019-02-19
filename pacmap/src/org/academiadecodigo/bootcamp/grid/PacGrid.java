package org.academiadecodigo.bootcamp.grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PacGrid implements Grid {

        public static final int PADDING = 10;
        public static final int CELLSIZE = 25;

        private int cols;
        private int rows;
        private Rectangle field;

        public PacGrid(int cols, int rows) {
            this.rows = rows;
            this.cols = cols;
        }

        /**
         * @see PacGrid#init()
         */
        @Override
        public void init() {
            field = new Rectangle(PADDING, PADDING, cols * getCellSize(), rows * getCellSize());
            field.setColor(Color.BLACK);
            field.fill();

        }

        /**
         * @see PacGrid#getCols()
         */
        @Override
        public int getCols() {
            return cols;
        }

        /**
         * @see PacGrid#getRows()
         */
        @Override
        public int getRows() {
            return rows;
        }

        /**
         * Obtains the width of the grid in pixels
         *
         * @return the width of the grid
         */
        public int getWidth() {
            return field.getWidth();
        }

        /**
         * Obtains the height of the grid in pixels
         *
         * @return the height of the grid
         */
        public int getHeight() {
            return field.getHeight();
        }

        /**
         * Obtains the grid X position in the SimpleGFX canvas
         *
         * @return the x position of the grid
         */
        public int getX() {
            return field.getX();
        }

        /**
         * Obtains the grid Y position in the SimpleGFX canvas
         *
         * @return the y position of the grid
         */
        public int getY() {
            return field.getY();
        }

        /**
         * Obtains the pixel width and height of a grid position
         *
         * @return
         */
        public int getCellSize() {
            return CELLSIZE;
        }


        public Position makePosition() {

            return new Position(this);
        }

        public Position makePosition(int col, int row) {
            return new Position(col, row, this);
        }

        /**
         * Auxiliary method to compute the y value that corresponds to a specific row
         *
         * @param row index
         * @return y pixel value
         */
        public int rowToY(int row) {
            return row * CELLSIZE + PADDING;
        }

        /**
         * Auxiliary method to compute the x value that corresponds to a specific column
         *
         * @param column index
         * @return x pixel value
         */
        public int columnToX(int column) {
            return column * CELLSIZE + PADDING;
        }
    }
