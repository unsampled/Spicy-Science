package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Game {

    private Map map;
    private Player player1;
    private Enemy[] enemies;
    private Beer[] beers;
    private Dot[] dots;

    //used to populate dots array
    private int dotCounter;
    private int eatenDots = 0;
    private int playerLives = 3;


    private MyKeyboard menuKB = new MyKeyboard(this);
    private Menu menu = new Menu(menuKB);

    private final int NUMBEROFBEER = 4;
    private Cell[] beerPos = new Cell[NUMBEROFBEER];

    private final int NUMBEROFENEMIES = 5;

    public void menu(){
        //menu.draw();

        while (menuKB.showMenu()) {
            try {
                Thread.sleep(600);
                menu.draw();
                Thread.sleep(600);
                menu.delete();

            } catch (InterruptedException e) {
                e.getMessage();
                System.out.println("error during collision");
            }
        }

        menu.exitMenu();
        init();
    }


    public void init() {

        this.map = new Map();
        this.enemies = new Enemy[NUMBEROFENEMIES];
        this.player1 = new Player(map.getGrid(), map);
        this.beers = new Beer[NUMBEROFBEER];
        this.dots = new Dot[countFreeCells() - 1];

        popDots();
        popEnemies();
        popBeer();

        try {
            start();
        } catch (InterruptedException e) {
            e.getMessage();
            System.out.println("error while starting game");
        }

    }

    private void start() throws InterruptedException {


        for (int i = 0; i < beerPos.length; i++) {
            beerPos[i].setEmpty();
        }
        map.getGrid()[map.getTOTAL_COLS() / 2][map.getTOTAL_ROWS() / 2].setEmpty();
        playSound("gameMusic");
        while (playerLives > 0) {

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
        dotCounter = 0;

        for (int o = 0; o < map.getTOTAL_COLS(); o++) {
            for (int i = 0; i < map.getTOTAL_ROWS(); i++) {
                if (map.getGrid()[o][i].isEmpty()) {
                    Dot dot = new Dot(map.getGrid()[o][i], map);
                    dots[dotCounter++] = dot;
                    dot.show();
                }
            }
        }
    }

    public int countFreeCells() {
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

                player1.setCollided(true);

                try {

                    player1 = new Player(map.getGrid(), map);
                    playerLives--;
                    map.decreaseLife(1);
                    playSound("loseLife");
                    enemy.setCollided(true);
                    Thread.sleep(800);

                } catch (InterruptedException e) {
                    e.getMessage();
                    System.out.println("error while dying");
                }
                for (int i = 0; i < enemies.length; i++) {
                    enemies[i].hide();
                    enemies[i] = new Enemy(map, map.getGrid());
                    enemies[i].getPosition().setEmpty();
                    enemies[i].setCollided(false);
                }
                checkPlayerLives(playerLives);
            }

            else if (player1.samePos(enemy.getPosition()) && enemy.isConsumable()) {
                if (enemiesEaten == 0) {
                    playSound("eatEnemy");
                    enemy.setCollided(true);
                    enemiesEaten++;
                    player1.setPowerActive(false);
                    setEnemiesToNotConsumable();

                }

            }
        }

        for (Beer beer : beers) {
            if (player1.samePos(beer.getPosition())) {
                beer.consume();
                player1.beerScore();
                playSound("beer");
                setEnemiesToConsumable();
                player1.setPowerActive(true);
                enemiesEaten = 0;

            }
        }

        for (Dot dot : dots) {
            if (player1.samePos(dot.getPosition())) {
                dot.consume();
                playSound("dot");
                eatenDots = eatenDots + 1;
                dotsCheck(dotCounter, eatenDots);
                player1.dotScore();
            }
        }

    }

    public void playSound(String fileName){
        try
        {
            FileInputStream fis = new FileInputStream("/Users/codecadet/Downloads/drunk-man/pacmap/resources/SoundEffects/" + fileName + ".wav");
            InputStream bufferedIn = new BufferedInputStream(fis);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            if(fileName.equals("gameMusic")){
                clip.loop(69);
            }

        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    public void setEnemiesToConsumable() {
        for (Enemy enemy : enemies) {
            enemy.setConsumable(true);
        }
    }

    public void setEnemiesToNotConsumable() {
        for (Enemy enemy : enemies) {
            enemy.setConsumable(false);

        }
    }

    public void checkPlayerLives(int playerLives) {
        if (playerLives == 0) {
            player1.setCollided(true);
            for (int i = 0; i < enemies.length; i++) {
                enemies[i].setCollided(true);
            }
            playSound("gameover");

            Picture gameover = new Picture(map.getPADDING(), map.getPADDING(), "Menus/GameOver.png");
            gameover.draw();
            menuKB.setGameOver();

        }
    }

    public void dotsCheck(int dotCounter, int eatenDots) {
        if (dotCounter == eatenDots) {

            player1.setCollided(true);

            for (int i = 0; i < enemies.length; i++) {
                enemies[i].setCollided(true);
            }

            playSound("win");

            try {
                Thread.sleep(500);
                for (int i = 0; i < enemies.length; i++) {
                    enemies[i].setCollided(true);
                }
                player1.setCollided(true);
                Picture youwin = new Picture(map.getPADDING(), map.getPADDING(), "Menus/youwin.png");
                youwin.draw();
                menuKB.setGameOver();
            } catch (InterruptedException e) {
                e.getMessage();
                System.out.println("error while winning");
            }

        }
    }
}
