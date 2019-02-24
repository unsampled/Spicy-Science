package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy implements Movable, Consumable {

    private Picture enemyPic;
    private Map map;
    private Cell[][] grid;
    private Cell position;
    private Cell lastPosition;

    private Direction direction;
    private Direction lastDirection;

    private int x;
    private int y;
    private int row;
    private int col;

    private boolean collided;
    private boolean consumable;

    private boolean consumed;


    public Enemy(Map map, Cell[][] grid) {

        this.collided = false;
        this.consumable = false;
        this.consumed = false;


        this.map = map;
        this.grid = grid;
        position = grid[map.getTOTAL_COLS() / 2][map.getTOTAL_ROWS() / 2];
        grid[position.getCol()][position.getRow()].setFull();

        row = position.getRow();
        col = position.getCol();
        chooseDirection();

        x = map.colToX(col);
        y = map.rowToY(row);
        enemyPic = new Picture(x, y, "/Users/codecadet/dev/testdm/drunk-man/pacmap/resources/Enemies/EnemyO.png");
        enemyPic.draw();
    }

    public boolean isConsumable() {
        return consumable;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }

    public Cell getPosition() {
        return position;
    }

    public Cell getLastPosition() {
        return lastPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public Direction getLastDirection() {
        return lastDirection;
    }

    private void chooseDirection() {


        switch ((int) (Math.random() * 4)) {
            case 0:
                direction = Direction.UP;
                break;
            case 1:
                direction = Direction.DOWN;
                break;
            case 2:
                direction = Direction.LEFT;
                break;
            case 3:
                direction = Direction.RIGHT;
                break;
        }
    }


    public void move() {
        if (!collided) {
            switch (direction) {
                case UP:
                    if (!moveUp()) {
                        lastDirection = direction;
                        chooseDirection();
                        move();
                    }
                    break;
                case DOWN:
                    if (!moveDown()) {
                        lastDirection = direction;
                        chooseDirection();
                        move();
                    }
                    break;
                case LEFT:
                    if (!moveLeft()) {
                        lastDirection = direction;
                        chooseDirection();
                        move();
                    }
                    break;
                case RIGHT:
                    if (!moveRight()) {
                        lastDirection = direction;
                        chooseDirection();
                        move();
                    }
                    break;
            }
        }

    }

    @Override
    public boolean moveLeft() {
        if (grid[col - 1][row].isEmpty()) {

            lastPosition = position;
            position = grid[--col][position.getRow()];
            enemyPic.translate(-map.getCELL_SIZE(), 0);
            enemyPic.draw();
            return true;
        }
        return false;

    }

    @Override
    public boolean moveRight() {
        if (grid[col + 1][row].isEmpty()) {

            lastPosition = position;
            position = grid[++col][position.getRow()];
            enemyPic.translate(map.getCELL_SIZE(), 0);
            enemyPic.draw();
            return true;
        }
        return false;
    }

    @Override
    public boolean moveDown() {
        if (grid[col][row + 1].isEmpty()) {

            lastPosition = position;
            position = grid[position.getCol()][++row];
            enemyPic.translate(0, map.getCELL_SIZE());
            enemyPic.draw();
            return true;
        }
        return false;
    }


    @Override
    public boolean moveUp() {
        if (grid[col][row - 1].isEmpty()) {

            lastPosition = position;
            position = grid[position.getCol()][--row];
            enemyPic.translate(0, -map.getCELL_SIZE());
            enemyPic.draw();
            return true;
        }
        return false;
    }

    @Override
    public void setCollided(boolean collided) {

        this.collided = collided;
        hide();
        position = grid[map.getTOTAL_COLS() - 1][map.getTOTAL_ROWS() - 1];
        // > act - init = - valor
        // < act - init = + valor

    }

    public void resetPos() {
        int resetCol = position.getCol() - (map.getTOTAL_COLS() / 2);
        int resetRow = position.getRow() - (map.getTOTAL_ROWS() / 2);

        //RESET COLS
        if (position.getCol() > (map.getTOTAL_COLS() / 2)) {
            enemyPic.translate(-map.colToX(resetCol), 0);
        } else if (position.getCol() < (map.getTOTAL_COLS() / 2)) {
            enemyPic.translate(map.colToX(resetCol), 0);
        }

        //RESET ROWS
        if (position.getRow() > map.getTOTAL_COLS() / 2) {
            enemyPic.translate(0, -map.rowToY(resetRow));
        } else if (position.getRow() < map.getTOTAL_ROWS() / 2) {
            enemyPic.translate(0, map.rowToY(resetRow));
        }
    }


    @Override
    public void show() {
        enemyPic.draw();
    }

    @Override
    public void hide() {
        enemyPic.delete();

    }

    @Override
    public ConsumableType getType() {
        return ConsumableType.ENEMY;
    }

    @Override
    public boolean isConsumed() {
        //return consumed;
        return false;
    }

    @Override
    public void consume() {
    //    this.consumed = true;
    //    hide();
    //    position = grid[map.getTOTAL_COLS() - 1][map.getTOTAL_ROWS() - 1];
    }

    @Override
    public boolean samePos(Cell that) {
        return col == that.getCol() && row == that.getRow();
    }

    @Override
    public boolean hasCollided() {
        return collided;
    }

}


