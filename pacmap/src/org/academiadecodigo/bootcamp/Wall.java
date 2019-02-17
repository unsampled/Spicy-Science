package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Wall {

    private Color color;
    private boolean filled;
    private double x;
    private double y;
    private double width;
    private double height;



    public Wall(){
        Rectangle wall = new Rectangle(0,0,18,18);
        wall.setColor(Color.RED);
        wall.fill();
    }
}
