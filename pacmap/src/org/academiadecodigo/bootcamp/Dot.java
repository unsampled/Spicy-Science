package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Shape;

import java.awt.*;

public class Dot extends Item implements Shape, Colorable, Fillable {

    private Ellipse ellipse;

    public Dot(Position position) {
        super(position);
        ellipse = new Ellipse(position.getRow(), position.getCol(), 5, 5);
    }

    @Override
    public int getX() {
        return ellipse.getX();
    }

    @Override
    public int getY() {
        return ellipse.getY();
    }

    @Override
    public int getWidth() {
        return ellipse.getWidth();
    }

    @Override
    public int getHeight() {
        return ellipse.getHeight();
    }

    public void draw() {
        ellipse.draw();
    }

    @Override
    public void delete() {
        ellipse.delete();
    }

    @Override
    public void grow(double v, double v1) {
        ellipse.grow(v, v1);
    }

    @Override
    public void paintShape(Graphics2D graphics2D) {
        ellipse.paintShape(graphics2D);
    }

    public boolean isSpecial() {
        return false;
    }

    @Override
    public void setColor(Color color) {
        ellipse.setColor(color);
    }

    @Override
    public Color getColor() {
        return ellipse.getColor();
    }

    @Override
    public void fill() {
        ellipse.fill();
    }

    @Override
    public boolean isFilled() {
        return ellipse.isFilled();
    }
}
