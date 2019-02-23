package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy implements Movable, Consumable {

    private Picture enemyPic;
    private Map map;
    private Cell[][] grid;
    private Cell position;
    private Direction direction;
    private int x;
    private int y;
    private int row;
    private int col;
    private boolean consumable = false;
    private boolean consumed;


    public Enemy(Map map, Cell[][] grid) {

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
        if (!consumed) {
            switch (direction) {
                case UP:
                    moveUp();
                    break;
                case DOWN:
                    moveDown();
                    break;
                case LEFT:
                    moveLeft();
                    break;
                case RIGHT:
                    moveRight();
                    break;
            }
        }

    }

    @Override
    public void moveLeft() {
        if (grid[col - 1][row].isEmpty()) {

            position = grid[--col][position.getRow()];
            enemyPic.translate(-map.getCELL_SIZE(), 0);
            enemyPic.draw();
        } else {
            chooseDirection();
        }

    }

    @Override
    public void moveRight() {
        if (grid[col + 1][row].isEmpty()) {

            position = grid[++col][position.getRow()];
            enemyPic.translate(map.getCELL_SIZE(), 0);
            enemyPic.draw();

        } else {
            chooseDirection();
        }
    }

    @Override
    public void moveDown() {
        if (grid[col][row + 1].isEmpty()) {

            position = grid[position.getCol()][++row];
            enemyPic.translate(0, map.getCELL_SIZE());
            enemyPic.draw();
        } else {
            chooseDirection();
        }
    }

    @Override
    public void setCollided() {

    }


    @Override
    public void moveUp() {
        if (grid[col][row - 1].isEmpty()) {
            position = grid[position.getCol()][--row];
            enemyPic.translate(0, -map.getCELL_SIZE());
            enemyPic.draw();
        } else {
            chooseDirection();
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
        return consumed;
    }

    @Override
    public void consume() {
        this.consumed = true;
        hide();
        position = grid[map.getTOTAL_COLS() - 1][map.getTOTAL_ROWS() - 1];
    }

    @Override
    public boolean samePos(Cell that) {
        return col == that.getCol() && row == that.getRow();
    }

    @Override
    public boolean hasCollided() {
        return false;
    }

}


