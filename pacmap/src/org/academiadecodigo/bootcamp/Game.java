package org.academiadecodigo.bootcamp;

public class Game {

    private Map map;
    private Player player1;
    private Enemy[] enemies;
    private Item[] items;


    public void init() {

        this.map = new Map();
        this.player1 = new Player();
        this.enemies = new Enemy[5];
        this.items = new Item[70];

    }

    public void start() {

      //  for (Enemy e : enemies) {
      //      e.move();
      //  }

    }
}
