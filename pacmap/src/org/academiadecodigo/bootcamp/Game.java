package org.academiadecodigo.bootcamp;

public class Game {

    private Map map;
    private Player player1;
    private Enemy[] enemies;
    private Beer[] beers;
    private Dot[] dots;
    private int dotCounter = 0;

    private final int NUMBEROFBEER = 4;
    private Cell[] beerPos = new Cell[NUMBEROFBEER];

    private final int NUMBEROFENEMIES = 5;


    public void init() {

        this.map = new Map();
        this.enemies = new Enemy[NUMBEROFENEMIES];
        this.player1 = new Player(map.getGrid(), map);
        this.beers = new Beer[NUMBEROFBEER];
        this.dots = new Dot[countFreeCells()-1];

        popDots();
        popEnemies();
        popBeer();

    }

    public void start() throws InterruptedException {


        for (int i = 0; i < beerPos.length; i++) {
            beerPos[i].setEmpty();
        }
        map.getGrid()[map.getTOTAL_COLS() / 2][map.getTOTAL_ROWS() / 2].setEmpty();

        while (true) {
            Thread.sleep(200);
            player1.move();
            for (int i = 0; i < enemies.length; i++) {
                enemies[i].move();

            }

            checkCollisions();
        }
    }

    public void popBeer() {
        Cell pos;

        for (int i = 0; i < NUMBEROFBEER; i++) {
            int randomX = (int) ((Math.random() * (map.getTOTAL_COLS() - 1)));
            int randomY = (int) ((Math.random() * (map.getTOTAL_ROWS() - 1)));

            pos = map.getGrid()[randomX][randomY];

            if (pos.isEmpty()) {
                beers[i] = new Beer(map.getGrid()[randomX][randomY], map);
                pos.setFull();
                beerPos[i] = pos;

            } else {
                i--;
            }
        }

    }

    public void popDots() {
        map.getGrid()[map.getTOTAL_COLS() / 2][map.getTOTAL_ROWS() / 2].setFull();
        int dotIncrement = 0;

        for (int o = 0; o < map.getTOTAL_COLS(); o++) {
            for (int i = 0; i < map.getTOTAL_ROWS(); i++) {
                if (map.getGrid()[o][i].isEmpty()) {

                    Dot dot = new Dot(map.getGrid()[o][i], map);
                    dots[dotIncrement++] = dot;
                    dot.show();
                }
            }
        }
    }

    public int countFreeCells(){
        for (int o = 0; o < map.getTOTAL_COLS(); o++) {
            for (int i = 0; i < map.getTOTAL_ROWS(); i++) {
                if (map.getGrid()[o][i].isEmpty()) {
                    dotCounter++;
                }
            }
        }
        return dotCounter;
    }


    public void popEnemies() {
        for (int i = 0; i < NUMBEROFENEMIES; i++) {
            enemies[i] = new Enemy(map, map.getGrid());
        }
    }


    public void checkCollisions() {
        int enemiesEaten = 0;
        for (Enemy enemy : enemies) {
            if (player1.samePos(enemy.getPosition()) && !enemy.isConsumable()) {

                try {
                    Thread.sleep(1000);
                    player1.setCollided();

                    //player set initial position
                } catch (InterruptedException e) {

                    System.out.println("error while dying");
                }
                player1.loseLife();

                return;
            }
            if(player1.samePos(enemy.getPosition()) && enemy.isConsumable()){
                if(enemiesEaten == 0){
                    enemy.consume();
                    enemiesEaten++;
                    setEnemiesToNotConsumable();
                    System.out.println(enemiesEaten);
                }

                System.out.println("consumed enemy");
            }
        }

        for(Beer beer : beers){
            if(player1.samePos(beer.getPosition())){
                beer.consume();
                player1.setScore(50);
                setEnemiesToConsumable();

                enemiesEaten = 0;
                System.out.println(enemiesEaten);
            }
        }

        for(Dot dot : dots){
            if (player1.samePos(dot.getPosition())){
                dot.consume();
                player1.incrementScore();
            }
        }

    }

    public void setEnemiesToConsumable(){
        for(Enemy enemy : enemies){
            enemy.setConsumable(true);
        }
        System.out.println("enemies consumable");
    }

    public void setEnemiesToNotConsumable(){
        for(Enemy enemy : enemies){
            enemy.setConsumable(false);

        }
        System.out.println("enemies not consumable");
    }
}
