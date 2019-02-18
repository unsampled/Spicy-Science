package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.PacGrid;
import org.academiadecodigo.bootcamp.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall {

    private Rectangle pic;
    private Position pos;


    public Wall(){
        Rectangle pic = new Rectangle(0,0, PacGrid.CELLSIZE,PacGrid.CELLSIZE);
        pic.setColor(Color.RED);
        pic.fill();
    }
}
