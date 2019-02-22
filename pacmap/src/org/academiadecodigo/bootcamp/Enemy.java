package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.PacGrid;
import org.academiadecodigo.bootcamp.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Enemy implements org.academiadecodigo.bootcamp.Movable {

    private Position position;
    private Picture pic;
    private boolean crashed;
    private int col;
    private int row;
    private PacGrid grid;

    public Enemy (int col,int row,PacGrid grid){
        this.row = row;
        this.col = col;
        this.grid = grid;
        this.position = new Position(col,row,grid);
        this.pic = new Picture(grid.columnToX(col),grid.rowToY(row),"Enemies/EnemyO.png");
        pic.draw();
        move();

    }


    @Override
    public void comparePos(Position that) {

    }

    @Override
    public boolean hasCollided() {
        return crashed;
    }

    public void move(){
        moveUp(CurrentImageType.B1);
    }

    @Override
    public void moveUp(CurrentImageType currentImage) {
        this.position.setPos(col,row--);
        this.pic.translate(0,-Map.pacGrid.getCellSize());
    }

    @Override
    public void moveLeft(CurrentImageType currentImage) {

    }

    @Override
    public void moveRight(CurrentImageType currentImage) {

    }

    @Override
    public void moveDown(CurrentImageType currentImage) {

    }
}