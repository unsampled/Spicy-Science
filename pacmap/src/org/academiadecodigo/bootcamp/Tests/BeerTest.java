package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Beer;
import org.academiadecodigo.bootcamp.Dot;
import org.academiadecodigo.bootcamp.grid.PacGrid;
import org.academiadecodigo.bootcamp.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class BeerTest {
    public static void main(String[] args) {
        PacGrid grid = new PacGrid(20,20);
        Position position = new Position(2,2, grid);
        grid.init();
        Beer beer = new Beer(position);
        Canvas.getInstance().getShapes().add(beer);
    }
}
