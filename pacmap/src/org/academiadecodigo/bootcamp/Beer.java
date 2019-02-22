package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Beer extends Item implements Shape {

    private Picture picture;

    public Beer(Position position) {
        super(position);
        picture = new Picture(position.getRow(), position.getCol(), "beer.jpg");
    }

    @Override
    public int getX() {
        return picture.getX();
    }

    @Override
    public int getY() {
        return picture.getY();
    }

    @Override
    public int getWidth() {
        return picture.getWidth();
    }

    @Override
    public int getHeight() {
        return picture.getHeight();
    }

    @Override
    public void draw() {
        picture.draw();
    }

    @Override
    public void delete() {
        picture.delete();
    }

    @Override
    public void grow(double v, double v1) {
        picture.grow(v, v1);
    }

    @Override
    public void paintShape(Graphics2D graphics2D) {
        picture.paintShape(graphics2D);
    }

}
