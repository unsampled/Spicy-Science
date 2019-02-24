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

    private int picX;
    private int picY;

    private Direction direction;
    private Direction lastDirection;
    private boolean powerActive = false;

    private String beerPowerFileName = "beerPower.png";
    private Picture beerPowerPicture;


    public Player(Cell[][] grid, Map map) {
        this.map = map;
        this.grid = grid;
        this.position = grid[map.getTOTAL_COLS() / 2][map.getTOTAL_ROWS() - 2];


        this.col = position.getCol();
        this.row = position.getRow();
        this.collided = false;

        this.direction = Direction.RIGHT;

        kb = new Keyboard(this);
        setters();


        //+2 por causa do sprite do player (21 em vez de 25)
        this.picX = map.colToX(position.getCol()) + 2;
        this.picY = map.rowToY(position.getRow());

        p1 = new Picture(picX, picY, "Player/L1-3.png");
        currentImage = CurrentImageType.F1;
        p1.draw();
    }

    public Cell getPosition() {
        return position;
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public void dotScore() {
        map.increaseScore(+1);
    }

    public void beerScore() {
        map.increaseScore(+50);
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
    public void setCollided(boolean collided) {
        this.collided = collided;
        try {
            Thread.sleep(300);
            p1.delete();
            Thread.sleep(300);
            p1.draw();
            Thread.sleep(300);
            p1.delete();
            Thread.sleep(300);

        } catch (InterruptedException e) {
            e.getMessage();
            System.out.println("error during collision");
        } finally {
            position = grid[map.getTOTAL_COLS() - 1][map.getTOTAL_ROWS() - 1];
            this.picX = map.colToX(position.getCol()) + 2;
            this.picY = map.rowToY(position.getRow());

            p1 = new Picture(picX, picY, "Player/L1-3.png");
        }


    }


    @Override
    public boolean moveLeft() {

        if (grid[col - 1][row].isEmpty()) {
            p1.delete();
            if (col > 1) {
                position = grid[--col][position.getRow()];
            }

            //+2 por causa do sprite do player (21 em vez de 25)
            int x = map.colToX(col) + 2;
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
            return true;
        }

        return false;
    }

    @Override
    public boolean moveRight() {
        if (grid[col + 1][row].isEmpty()) {
            p1.delete();
            if (col < map.getTOTAL_COLS() - 2) {
                position = grid[++col][position.getRow()];
            }

            //+2 por causa do sprite do player (21 em vez de 25)
            int x = map.colToX(col) + 2;
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
            return true;
        }
        return false;
    }

    @Override
    public boolean moveDown() {
        if (grid[col][row + 1].isEmpty()) {
            p1.delete();
            if (row < map.getTOTAL_ROWS() - 2) {
                position = grid[position.getCol()][++row];
            }

            //+2 por causa do sprite do player (21 em vez de 25)
            int x = map.colToX(col) + 2;
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
            return true;
        }
        return false;
    }


    @Override
    public boolean moveUp() {
        if (grid[col][row - 1].isEmpty()) {
            p1.delete();
            if (row > 1) {
                position = grid[position.getCol()][--row];
            }

            //+2 por causa do sprite do player (21 em vez de 25)
            int x = map.colToX(col) + 2;
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
            return true;
        }
        return false;
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

    private void drawBeerPower() {
        int x = map.colToX(col);
        int y = map.rowToY(row);

        String path = "/Player/";

        beerPowerPicture = new Picture(x, y, path + beerPowerFileName);
        beerPowerPicture.draw();

    }

    private void beerPowerActive() {

        if (beerPowerPicture == null) {
            drawBeerPower();
        } else if (beerPowerFileName.equals("beerPower.png")) {
            beerPowerPicture.delete();
            beerPowerFileName = "beerPower2.png";
            drawBeerPower();
        } else {
            beerPowerPicture.delete();
            beerPowerFileName = "beerPower.png";
            drawBeerPower();
        }
    }

    public void setPowerActive(boolean powerActive) {
        this.powerActive = powerActive;
        if (!powerActive) {
            beerPowerPicture.delete();
        }
    }

    public void move() {
        if (!collided) {

            switch (direction) {
                case UP:
                    if (!moveUp()) {
                        direction = lastDirection;
                    } else {
                        lastDirection = direction;
                    }
                    break;
                case DOWN:
                    if (!moveDown()) {
                        direction = lastDirection;
                    } else {
                        lastDirection = direction;
                    }
                    break;
                case LEFT:
                    if (!moveLeft() && lastDirection != direction) {
                        direction = lastDirection;
                    } else {
                        lastDirection = direction;
                    }
                    break;
                case RIGHT:
                    if (!moveRight()) {
                        direction = lastDirection;
                    } else {
                        lastDirection = direction;
                    }
                    break;
                default:
                    System.out.println("error while moving player");
                    break;
            }
            if (powerActive) {
                beerPowerActive();
            }
        }

    }
}