package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Dot extends Item implements Consumable {

    private Picture picture;
    private int x;
    private int y;
    private Cell position;
    private int row;
    private int col;



    private Map map;

    private boolean consumed;


    public Dot(Cell position, Map map) {
        super(position, map);
        row = position.getRow();
        col = position.getCol();
        this.x = map.colToX(position.getCol());
        this.y = map.rowToY(position.getRow());
        this.position = position;
        this.map = map;
        picture = new Picture(x,y,"/Users/codecadet/dev/testdm/drunk-man/pacmap/resources/Items/yellow-dot.png");
    }

    @Override
    public void show() {
        picture.draw();
    }

    @Override
    public void hide() {
        picture.delete();
    }

    @Override
    public ConsumableType getType() {
        return ConsumableType.DOT;
    }

    @Override
    public boolean isConsumed() {
        return consumed;
    }

    @Override
    public void consume() {
        this.consumed = true;
        hide();
        position = map.getGrid()[map.getTOTAL_COLS()-1][map.getTOTAL_ROWS()-1];
    }


    public Cell getPosition() {
        return position;
    }
}
