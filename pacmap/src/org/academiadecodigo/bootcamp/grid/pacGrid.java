package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class pacGrid implements Grid {


        public static final int PADDING = 10;
        private int CELLSIZE = 10;

        private int cols;
        private int rows;
        private Rectangle field;

        public pacGrid(int cols, int rows) {
            this.rows = rows;
            this.cols = cols;
        }

        /**
         * @see pacGrid#init()
         */
        @Override
        public void init() {
            field = new Rectangle(PADDING, PADDING, cols * getCellSize(), rows * getCellSize());
            field.setColor(Color.BLACK);
            field.fill();

        }

        /**
         * @see pacGrid#getCols()
         */
        @Override
        public int getCols() {
            return cols;
        }

        /**
         * @see pacGrid#getRows()
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

        /**
         * @see pacGrid#makeGridPosition()
         */
       // @Override
        //public GridPosition makeGridPosition() {

        //    return new SimpleGfxGridPosition(this);
        //}

        /**
         * @see pacGrid#makeGridPosition(int, int)
         */
        //@Override
      //  public GridPosition makeGridPosition(int col, int row) {
      //      return new SimpleGfxGridPosition(col, row, this);
      //  }

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
