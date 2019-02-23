package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 18/02/2019.
 */
public class Player implements Movable, KeyboardHandler {

    private Cell position;
    private Cell[][] grid;
    private Map map;
    private boolean collided;
    private Picture p1;
    private Keyboard kb;
    private CurrentImageType currentImage;
    private int row;
    private int col;
    private Direction direction;

    private int score;
    private int life;

    public Player(Cell[][] grid, Map map) {
        this.map = map;
        this.grid = grid;
        this.position = grid[map.getTOTAL_COLS() / 2][map.getTOTAL_ROWS() - 2];
        this.col = position.getCol();
        this.row = position.getRow();
        this.collided = false;

        this.score = 0;
        this.life = 3;
        this.direction = Direction.RIGHT;

        kb = new Keyboard(this);
        setters();

        int picX = map.colToX(position.getCol());
        int picY = map.rowToY(position.getRow());

        p1 = new Picture(picX, picY, "Player/L1-3.png");
        currentImage = CurrentImageType.F1;
        p1.draw();
    }

    public Cell getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public int getLife() {
        return life;
    }

    public void loseLife(){
        this.life--;
    }

    public Direction getDirection() {
        return direction;
    }


    public void incrementScore() {
        score++;
    }

    public void setScore(int score) {
        this.score += score;
    }

    private void setters() {
        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressDown.setKey(KeyboardEvent.KEY_DOWN);
        kb.addEventListener(pressDown);

        KeyboardEvent pressLeft = new KeyboardEvent();
        pressLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressLeft.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(pressLeft);

        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressUp.setKey(KeyboardEvent.KEY_UP);
        kb.addEventListener(pressUp);

        KeyboardEvent pressRight = new KeyboardEvent();
        pressRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressRight.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(pressRight);
    }

    @Override
    public boolean samePos(Cell that) {

        return col == that.getCol() && row == that.getRow();
    }

    @Override
    public boolean hasCollided() {
        return collided;
    }


    @Override
    public void setCollided() {
        collided = true;
        p1.delete();
        currentImage = null;
        position = grid[map.getTOTAL_COLS() / 2][map.getTOTAL_ROWS() - 2];
    }

    @Override
    public void moveLeft() {

        if (grid[col - 1][row].isEmpty()) {
            p1.delete();
            if (col > 1) {
                position = grid[--col][position.getRow()];
            }

            int x = map.colToX(col);
            int y = map.rowToY(row);

            if (currentImage == CurrentImageType.F2 || currentImage == CurrentImageType.B2 || currentImage == CurrentImageType.L1 || currentImage == CurrentImageType.R1) {
                p1 = new Picture(x, y, "Player/L2.png");
                this.currentImage = CurrentImageType.L2;

            } else if (currentImage == CurrentImageType.F3 || currentImage == CurrentImageType.B3 || currentImage == CurrentImageType.L2 || currentImage == CurrentImageType.R2) {
                p1 = new Picture(x, y, "Player/L1-3.png");
                this.currentImage = CurrentImageType.L3;

            } else if (currentImage == CurrentImageType.F4 || currentImage == CurrentImageType.B4 || currentImage == CurrentImageType.L3 || currentImage == CurrentImageType.R3) {
                p1 = new Picture(x, y, "Player/L4.png");
                this.currentImage = CurrentImageType.L4;

            } else if (currentImage == CurrentImageType.F1 || currentImage == CurrentImageType.B1 || currentImage == CurrentImageType.L4 || currentImage == CurrentImageType.R4) {
                p1 = new Picture(x, y, "Player/L1-3.png");
                this.currentImage = CurrentImageType.L1;
            }
            p1.draw();
        }
    }

    @Override
    public void moveRight() {
        if (grid[col + 1][row].isEmpty()) {
            p1.delete();
            if (col < map.getTOTAL_COLS() - 2) {
                position = grid[++col][position.getRow()];
            }

            int x = map.colToX(col);
            int y = map.rowToY(row);

            if (currentImage == CurrentImageType.F2 || currentImage == CurrentImageType.B2 || currentImage == CurrentImageType.R1 || currentImage == CurrentImageType.L1) {
                p1 = new Picture(x, y, "Player/R2.png");
                this.currentImage = CurrentImageType.R2;

            } else if (currentImage == CurrentImageType.F3 || currentImage == CurrentImageType.B3 || currentImage == CurrentImageType.R2 || currentImage == CurrentImageType.L2) {
                p1 = new Picture(x, y, "Player/R1-3.png");
                this.currentImage = CurrentImageType.R3;

            } else if (currentImage == CurrentImageType.F4 || currentImage == CurrentImageType.B4 || currentImage == CurrentImageType.R3 || currentImage == CurrentImageType.L3) {
                p1 = new Picture(x, y, "Player/R4.png");
                this.currentImage = CurrentImageType.R4;

            } else if (currentImage == CurrentImageType.F1 || currentImage == CurrentImageType.B1 || currentImage == CurrentImageType.R4 || currentImage == CurrentImageType.L4) {
                p1 = new Picture(x, y, "Player/R1-3.png");
                this.currentImage = CurrentImageType.R1;
            }
            p1.draw();
        }
    }

    @Override
    public void moveDown() {
        if (grid[col][row + 1].isEmpty()) {
            p1.delete();
            if (row < map.getTOTAL_ROWS() - 2) {
                position = grid[position.getCol()][++row];
            }

            int x = map.colToX(col);
            int y = map.rowToY(row);

            if (currentImage == CurrentImageType.R2 || currentImage == CurrentImageType.L2 || currentImage == CurrentImageType.F1 || currentImage == CurrentImageType.B1) {
                p1 = new Picture(x, y, "Player/F2.png");
                this.currentImage = CurrentImageType.F2;

            } else if (currentImage == CurrentImageType.R3 || currentImage == CurrentImageType.L3 || currentImage == CurrentImageType.F2 || currentImage == CurrentImageType.B2) {
                p1 = new Picture(x, y, "Player/F1-3.png");
                this.currentImage = CurrentImageType.F3;

            } else if (currentImage == CurrentImageType.R4 || currentImage == CurrentImageType.L4 || currentImage == CurrentImageType.F3 || currentImage == CurrentImageType.B3) {
                p1 = new Picture(x, y, "Player/F4.png");
                this.currentImage = CurrentImageType.F4;

            } else if (currentImage == CurrentImageType.R1 || currentImage == CurrentImageType.L1 || currentImage == CurrentImageType.F4 || currentImage == CurrentImageType.B4) {
                p1 = new Picture(x, y, "Player/F1-3.png");
                this.currentImage = CurrentImageType.F1;
            }
            p1.draw();
        }
    }



    @Override
    public void moveUp() {
        if (grid[col][row - 1].isEmpty()) {
            p1.delete();
            if (row > 1) {
                position = grid[position.getCol()][--row];
            }

            int x = map.colToX(col);
            int y = map.rowToY(row);

            if (currentImage == CurrentImageType.R2 || currentImage == CurrentImageType.L2 || currentImage == CurrentImageType.B1 || currentImage == CurrentImageType.F1) {
                p1 = new Picture(x, y, "Player/B2.png");
                this.currentImage = CurrentImageType.B2;

            } else if (currentImage == CurrentImageType.R3 || currentImage == CurrentImageType.L3 || currentImage == CurrentImageType.B2 || currentImage == CurrentImageType.F2) {
                p1 = new Picture(x, y, "Player/B1-3.png");
                this.currentImage = CurrentImageType.B3;

            } else if (currentImage == CurrentImageType.R4 || currentImage == CurrentImageType.L4 || currentImage == CurrentImageType.B3 || currentImage == CurrentImageType.F3) {
                p1 = new Picture(x, y, "Player/B4.png");
                this.currentImage = CurrentImageType.B4;

            } else if (currentImage == CurrentImageType.R1 || currentImage == CurrentImageType.L1 || currentImage == CurrentImageType.B4 || currentImage == CurrentImageType.F4) {
                p1 = new Picture(x, y, "Player/B1-3.png");
                this.currentImage = CurrentImageType.B1;
            }
            p1.draw();
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                direction = Direction.DOWN;
                break;
            case KeyboardEvent.KEY_UP:
                direction = Direction.UP;
                break;
            case KeyboardEvent.KEY_LEFT:
                direction = Direction.LEFT;
                break;
            case KeyboardEvent.KEY_RIGHT:
                direction = Direction.RIGHT;
                break;
            default:
                System.out.println("error. key pressed is not an option");
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void move() {
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
            default:
                System.out.println("error while moving player");
        }

    }
}