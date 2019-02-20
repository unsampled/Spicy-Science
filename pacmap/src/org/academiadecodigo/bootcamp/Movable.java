package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Position;

public interface Movable {

    void comparePos(Position that);

    boolean hasCollided();


}
