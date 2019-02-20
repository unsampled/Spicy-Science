package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Position;

public interface Movable {

    void comparePos(Position that);

    boolean hasCollided();

    void moveUp(CurrentImageType currentImage);

    void moveLeft(CurrentImageType currentImage);

    void moveRight(CurrentImageType currentImage);

    void moveDown(CurrentImageType currentImage);
}
