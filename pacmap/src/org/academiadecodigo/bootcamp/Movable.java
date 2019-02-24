package org.academiadecodigo.bootcamp;

public interface Movable {

    boolean samePos(Cell that);

    boolean hasCollided();

    boolean moveUp();

    boolean moveLeft();

    boolean moveRight();

    boolean moveDown();

    void setCollided(boolean collided);
}
