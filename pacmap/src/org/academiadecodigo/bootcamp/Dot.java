package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Dot extends Item implements Consumable {

    private Ellipse ellipse;
    private boolean consumed;
    final int SIZE;

    public Dot(Position position) {
        super(position);
         SIZE = Map.pacGrid.getCellSize()/2;

        int elliX = Map.pacGrid.columnToX(position.getCol());
        int elliY = Map.pacGrid.rowToY(position.getRow());

        ellipse = new Ellipse(elliX + Map.pacGrid.getPadding(), elliY - Map.pacGrid.getPadding()/2, SIZE, SIZE);

        show();
    }

    @Override
    public void show() {
        ellipse.setColor(Color.YELLOW);
        ellipse.fill();
    }

    @Override
    public void hide() {
        ellipse.delete();
    }

    public ConsumableType getType() {
        return ConsumableType.BASIC;
    }

    @Override
    public boolean isConsumed() {
        return consumed;
    }
}
