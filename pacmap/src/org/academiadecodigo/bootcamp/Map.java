package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.PacGrid;

public class Map {
    private Wall[] walls;
    private PacGrid pacGrid;

    public Map(){
        this.walls = new Wall[50];
        this.pacGrid = new PacGrid(20,20);
        pacGrid.init();
    }




}
