package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Dot;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.PacGrid;
import org.academiadecodigo.bootcamp.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;

import javax.swing.*;
import java.awt.*;

public class ItemTest {
    public static void main(String[] args) {
        PacGrid grid = new PacGrid(20,20);
        Position position = new Position(2,2, grid);
        grid.init();
        Dot dot = new Dot(position);
        dot.setColor(Color.WHITE);
        dot.fill();
        Canvas.getInstance().getShapes().add(dot);
    }
}
