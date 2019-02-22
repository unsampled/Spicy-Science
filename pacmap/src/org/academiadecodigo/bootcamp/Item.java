package org.academiadecodigo.bootcamp;

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
