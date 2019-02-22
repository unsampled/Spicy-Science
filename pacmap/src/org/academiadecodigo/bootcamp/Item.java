package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Position;

public abstract class Item {

    private Position position;

    public Item(Position position) {
        this.position = position;
    }

    public Item(int col, int row){
      //  position = new Position(col, row, Map.pacGrid);

    }

    public Position getPosition() {
        return position;
    }

}
