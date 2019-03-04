package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall {

    private Picture pic;
    private int x;
    private int y;

    private Cell cell;
    private Map map;


    public Wall(Cell cell, Map map) {
        this.cell = cell;
        this.map = map;
        this.x = map.colToX(cell.getCol());
        this.y = map.rowToY(cell.getRow());
        wallPic(cell);

    }


    private void wallPic(Cell cell) {


        if (topLeftConner()) {
            drawWall( "TLCorner.png");

        } else if (topRigthConner()) {
            drawWall("TRCorner.png");

        } else if (bottomLeftConner()) {
            drawWall("BLCorner.png");

        } else if (bottomRightConner()) {
            drawWall("BRCorner.png");

        } else if (crossing()) {
            drawWall("crossingWall.png");

        }else if(soloWall()) {
            drawWall("dotWall.png");

        }else if(topTail()) {
            drawWall("topTailWall.png");

        }else if (bottomTail()) {
            drawWall("bottomTailWall.png");

        }else if (rightTail()) {
            drawWall("rightTailWall.png");


        }else  if(leftTail()) {
            drawWall("leftTailWall.png");

        }else if (bottomCrossing()) {
            drawWall("bottonCrossWall.png");

        }else if (topCrossing()) {
            drawWall("topCrossWall.png");

        }else if (leftCrossing()) {
            drawWall("leftCrossWall.png");

        }else if (rightCrossing()){
            drawWall("rightCrossWall.png");

        } else if (verticalWall()) {
            drawWall( "verticalWall.png");

        } else {
            drawWall( "horizontalWall.png");

        }
    }


    private void drawWall(String file){
        pic = new Picture(x, y,"Walls/" + file);
        pic.draw();
    }

    private boolean outsideWalls() {
        if (cell.getCol() == 0 || cell.getRow() == 0 || cell.getRow() == map.getTOTAL_ROWS() - 1 || cell.getCol() == map.getTOTAL_COLS() - 1) {
            return true;
        }
        return false;
    }

    private boolean topLeftConner() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (col == 0 && row == 0) {
            return true;
        }

        if (outsideWalls()) {
            return false;
        }

        if (map.getGrid()[col][row - 1].isEmpty() &&
                map.getGrid()[col - 1][row].isEmpty() &&
                !map.getGrid()[col + 1][row].isEmpty() &&
                !map.getGrid()[col][row + 1].isEmpty()) {
            return true;
        }

        return false;
    }

    private boolean topRigthConner() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (row == 0 && col == (map.getTOTAL_COLS() - 1)) {
            return true;
        }

        if (outsideWalls()) {
            return false;
        }

        if (map.getGrid()[col][row - 1].isEmpty() &&
                map.getGrid()[col + 1][row].isEmpty() &&
                !map.getGrid()[col - 1][row].isEmpty() &&
                !map.getGrid()[col][row + 1].isEmpty()) {
            return true;
        }

        return false;
    }
    private boolean bottomLeftConner() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (col == 0 && row == (map.getTOTAL_ROWS() - 1)) {
            return true;
        }

        if (outsideWalls()) {
            return false;
        }

        if (map.getGrid()[col][row + 1].isEmpty() &&
                map.getGrid()[col - 1][row].isEmpty() &&
                !map.getGrid()[col + 1][row].isEmpty() &&
                !map.getGrid()[col][row - 1].isEmpty()) {
            return true;
        }
        return false;
    }


    private boolean bottomRightConner() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (col == (map.getTOTAL_COLS() - 1) && row == (map.getTOTAL_ROWS() - 1)) {
            return true;
        }

        if (outsideWalls()) {
            return false;
        }

        if (map.getGrid()[col][row + 1].isEmpty() &&
                map.getGrid()[col + 1][row].isEmpty() &&
                !map.getGrid()[col - 1][row].isEmpty() &&
                !map.getGrid()[col][row - 1].isEmpty()) {
            return true;
        }
        return false;
    }


    private boolean bottomTail() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            return false;
        }

        if (map.getGrid()[col][row + 1].isEmpty() &&
                map.getGrid()[col + 1][row].isEmpty() &&
                map.getGrid()[col - 1][row].isEmpty() &&
                !map.getGrid()[col][row - 1].isEmpty()) {
            return true;
        }

        return false;
    }


    private boolean topTail() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            return false;
        }

        if (map.getGrid()[col][row - 1].isEmpty() &&
                map.getGrid()[col + 1][row].isEmpty() &&
                map.getGrid()[col - 1][row].isEmpty() &&
                !map.getGrid()[col][row + 1].isEmpty()) {
            return true;
        }

        return false;
    }


    private boolean rightTail() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            return false;
        }

        if (map.getGrid()[col][row + 1].isEmpty() &&
                map.getGrid()[col][row - 1].isEmpty() &&
                map.getGrid()[col + 1][row].isEmpty() &&
                !map.getGrid()[col - 1][row].isEmpty()) {
            return true;
        }
        return false;
    }


    private boolean leftTail() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            return false;
        }

        if (map.getGrid()[col][row + 1].isEmpty() &&
                map.getGrid()[col][row - 1].isEmpty() &&
                map.getGrid()[col - 1][row].isEmpty() &&
                !map.getGrid()[col + 1][row].isEmpty()) {
            return true;
        }
        return false;
    }



    private boolean soloWall() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            return false;
        }

        if (map.getGrid()[col][row + 1].isEmpty() &&
                map.getGrid()[col][row - 1].isEmpty() &&
                map.getGrid()[col + 1][row].isEmpty() &&
                map.getGrid()[col - 1][row].isEmpty()) {
            return true;
        }

        return false;
    }


    private boolean crossing() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            return false;
        }

        if (!map.getGrid()[col][row + 1].isEmpty() &&
                !map.getGrid()[col][row - 1].isEmpty() &&
                !map.getGrid()[col + 1][row].isEmpty() &&
                !map.getGrid()[col - 1][row].isEmpty()) {
            return true;
        }

        return false;
    }


    private boolean bottomCrossing() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            if (row != map.getTOTAL_ROWS() -1) {
                return false;
            }
        }

        if (!map.getGrid()[col + 1][row].isEmpty() &&
                !map.getGrid()[col - 1][row].isEmpty() &&
                !map.getGrid()[col][row - 1].isEmpty()) {
            return true;
        }

        return false;
    }


    private boolean topCrossing() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            if (row != 0) {
                return false;
            }
        }

        if (!map.getGrid()[col + 1][row].isEmpty() &&
                !map.getGrid()[col - 1][row].isEmpty() &&
                !map.getGrid()[col][row + 1].isEmpty()) {
            return true;
        }

        return false;
    }


    private boolean leftCrossing() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            if (col != 0) {
                return false;
            }
        }

        if (!map.getGrid()[col][row + 1].isEmpty() &&
                !map.getGrid()[col][row - 1].isEmpty() &&
                !map.getGrid()[col + 1][row].isEmpty()) {
            return true;
        }

        return false;
    }

    private boolean rightCrossing() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            if (col != map.getTOTAL_COLS() - 1) {
                return false;
            }
        }

        if (!map.getGrid()[col][row + 1].isEmpty() &&
                !map.getGrid()[col][row - 1].isEmpty() &&
                !map.getGrid()[col - 1][row].isEmpty()) {
            return true;
        }

        return false;
    }


    private boolean verticalWall() {
        int row = cell.getRow();
        int col = cell.getCol();

        if (outsideWalls()) {
            if (row == 0 || row == (map.getTOTAL_ROWS() - 1)) {
                return false;
            }
            return true;
        }
        if (!map.getGrid()[col][row + 1].isEmpty() && !map.getGrid()[col][row - 1].isEmpty()) {
            return true;
        }
        return false;
    }
}
