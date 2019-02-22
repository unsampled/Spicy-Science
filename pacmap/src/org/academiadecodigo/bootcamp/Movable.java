package org.academiadecodigo.bootcamp;

public interface Movable {

    boolean comparePos(Position that);

    boolean hasCollided();

    void moveUp(CurrentImageType currentImage);

    void moveLeft(CurrentImageType currentImage);

    void moveRight(CurrentImageType currentImage);

    void moveDown(CurrentImageType currentImage);
}
