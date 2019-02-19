package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.PacGrid;
import org.academiadecodigo.bootcamp.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall {

    private Rectangle pic;
    private Position pos;
    private PacGrid grid;


    public Wall(int col,int row,PacGrid grid){
        this.grid=grid;
        pos = new Position(col,row,grid);
        Rectangle pic = new Rectangle(grid.columnToX(col),grid.rowToY(row), PacGrid.CELLSIZE,PacGrid.CELLSIZE);
        pic.setColor(Color.RED);
        pic.fill();

    }

    public Position getPos() {
        return pos;
    }

    @Override
    public boolean equals(Object obj) {
return false;
    }
}
