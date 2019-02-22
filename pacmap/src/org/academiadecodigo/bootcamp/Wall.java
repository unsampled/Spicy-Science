package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall {

    private Picture pic;
    private int x;
    private int y;

    private Cell cell;
    private Map map;


    public Wall(Cell cell, Map map) {
        this.cell = cell;
        this.map = map;
        this.x = map.colToX(cell.getCol());
        this.y = map.rowToY(cell.getRow());
        wallPic(cell);

    }


    private void wallPic(Cell cell) {

        if (cell.getCol() > 0 && cell.getCol() < (map.getTOTAL_COLS() - 1) && (cell.getRow() == 0 || (cell.getRow() == (map.getTOTAL_ROWS() - 1)))) {
            pic = new Picture(x, y, "Walls/horizontalWall.png");
            pic.draw();
            return;
        }
        if ((cell.getCol() == 0 || cell.getCol() == (map.getTOTAL_COLS() - 1)) && cell.getRow() > 0 && cell.getRow() < (map.getTOTAL_ROWS() - 1)) {
            pic = new Picture(x, y, "Walls/verticalWall.png");
            pic.draw();
            return;
        }

        if (cell.getCol() == 0 && cell.getRow() == 0) {
            pic = new Picture(x, y, "Walls/TLCorner.png");
            pic.draw();
            return;
        }

        if (cell.getRow() == 0 && cell.getCol() == (map.getTOTAL_COLS() - 1)) {
            pic = new Picture(x, y, "Walls/TRCorner.png");
            pic.draw();
            return;
        }
        if (cell.getCol() == 0 && cell.getRow() == (map.getTOTAL_ROWS() - 1)) {
            pic = new Picture(x, y, "Walls/BLCorner.png");
            pic.draw();
            return;
        }
        if (cell.getCol() == (map.getTOTAL_COLS() - 1) && cell.getRow() == (map.getTOTAL_ROWS() - 1)) {
            pic = new Picture(x, y, "Walls/BRCorner.png");
            pic.draw();
        }

        pic = new Picture(x,y,"/Users/codecadet/dev/testdm/drunk-man/pacmap/resources/Walls/horizontalWall.png");
        pic.draw();

    }


    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
