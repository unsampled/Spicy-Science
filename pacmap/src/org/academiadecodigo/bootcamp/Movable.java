package org.academiadecodigo.bootcamp;

public interface Movable {

    boolean samePos(Cell that);

    boolean hasCollided();

    void moveUp();

    void moveLeft();

    void moveRight();

    void moveDown();

    void setCollided();
}
