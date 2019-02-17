package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.pacGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    Rectangle player = new Rectangle(18,0,18,18);

    public static void main(String[] args) {
        Main p = new Main();
        pacGrid field = new pacGrid(50,50);
        field.init();
        p.tester();

        Wall walltest = new Wall();

    }

    public void tester(){

       // Rectangle field = new Rectangle(0,0,300,300);


        //player
        player.setColor(Color.BLUE);
        player.fill();

        //wall


    }


}
