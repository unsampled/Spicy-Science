package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Position;

public abstract class Item {

    private Position position;

    public Item(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract void draw();

    public abstract boolean isSpecial();
}
