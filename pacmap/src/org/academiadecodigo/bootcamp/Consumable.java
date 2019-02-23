package org.academiadecodigo.bootcamp;

public interface Consumable {

    void show();

    void hide();

    ConsumableType getType();

    boolean isConsumed();

    void consume();
}
