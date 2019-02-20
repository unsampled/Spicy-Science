package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.PacGrid;
import org.academiadecodigo.bootcamp.grid.Position;

import java.util.HashMap;

public class Map {
    private HashMap<Position, Wall> walls;
    private PacGrid pacGrid;


    public Map() {
        walls = new HashMap();
        this.pacGrid = new PacGrid(53, 31);
        //pacGrid.init();
        outsideWalls();
        centerWalls();
    }

    private void outsideWalls() {
        for (int i = 0; i <= pacGrid.getCols(); i++) {

            Wall topWall = new Wall(i, 0, pacGrid);
            walls.put(topWall.getPos(), topWall);
            Wall downWall = new Wall(i, pacGrid.getRows(), pacGrid);
            walls.put(downWall.getPos(), downWall);
        }

        for (int x = 1; x <= pacGrid.getRows() - 1; x++) {
            Wall leftWall = new Wall(0, x, pacGrid);
            walls.put(leftWall.getPos(), leftWall);
            Wall rightWall = new Wall(pacGrid.getCols(), x, pacGrid);
            walls.put(rightWall.getPos(), rightWall);
        }

    }

    private void centerWalls() {
        for (int i = 25; i <= 30; i++) {

            Wall topWall = new Wall(i, 14, pacGrid);
            walls.put(topWall.getPos(), topWall);
            Wall downWall = new Wall(i, 17, pacGrid);
            walls.put(downWall.getPos(), downWall);
        }
/*
        for (int x = 1; x <= pacGrid.getRows() - 1; x++) {
            Wall leftWall = new Wall(0, x, pacGrid);
            walls.put(leftWall.getPos(), leftWall);
            Wall rightWall = new Wall(pacGrid.getCols(), x, pacGrid);
            walls.put(rightWall.getPos(), rightWall);
        }
        */


    }

    public PacGrid getPacGrid() {
        return pacGrid;
    }

    public HashMap<Position, Wall> getWalls() {
        return walls;
    }

}
