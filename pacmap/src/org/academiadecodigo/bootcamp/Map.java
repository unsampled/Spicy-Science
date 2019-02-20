package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.PacGrid;
import org.academiadecodigo.bootcamp.grid.Position;

import java.util.HashMap;

public class Map {
    private HashMap<Position, Wall> walls;
    public static PacGrid pacGrid;


    public Map() {
        walls = new HashMap();
        this.pacGrid = new PacGrid(53, 31);
        //pacGrid.init();
        outsideWalls();
    }

    private void outsideWalls() {
        for (int i = 0; i <= pacGrid.getCols(); i++) {

            Wall wall = new Wall(i, 0, pacGrid);
            walls.put(wall.getPos(), wall);
            Wall wall2 = new Wall(i, pacGrid.getRows(), pacGrid);
            walls.put(wall2.getPos(), wall2);
        }

        for (int x = 1; x <= pacGrid.getRows() - 1; x++) {
            Wall wall = new Wall(0, x, pacGrid);
            walls.put(wall.getPos(), wall);
            Wall wall2 = new Wall(pacGrid.getCols(), x, pacGrid);
            walls.put(wall2.getPos(), wall2);
        }

    }

    public PacGrid getPacGrid() {
        return pacGrid;
    }

    public HashMap<Position, Wall> getWalls() {
        return walls;
    }

}
