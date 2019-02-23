package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Item{


    private Picture pic;
    private int x;
    private int y;

    private Cell cell;
    private Map map;


    public Item(Cell cell, Map map){
        this.x = map.colToX(cell.getCol());
        this.y = map.rowToY(cell.getRow());
        this.cell = cell;
        this.map = map;
        this.pic = new Picture(x,y,"/Users/codecadet/dev/testdm/drunk-man/pacmap/resources/Items/yellow-dot.png");
    }
}
