package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 24/02/2019.
 */
public class Menu {

    private Picture background;
    private Rectangle box;
    private Text text1;
    private Text startText;
    private MyKeyboard kb;

    public Menu(MyKeyboard kb) {

        background = new Picture(10, 10, "Menus/lab.jpg");

        int boxW = 150;
        int boxH = 50;
        int boxX = (background.getMaxX() / 2) - (boxW / 2);
        int boxY = (background.getMaxY() / 6) * 4;

        box = new Rectangle(boxX, boxY, boxW, boxH);
        box.setColor(Color.BLACK);

        int textX = background.getMaxX() / 2;
        int text1Y = boxY + boxH / 5;
        text1 = new Text(textX, text1Y, "Press SPACE to");
        int xTransl = -(text1.getWidth() / 2);
        text1.translate(xTransl, 0);

        startText = new Text(textX, text1Y, "START");
        int transX = -(startText.getWidth() / 2);
        int transY = (boxY + boxH / 5 * 3) - text1Y;
        startText.translate(transX, transY);
        this.kb = kb;



    }

    public void draw() {
        background.draw();
        box.fill();
        text1.setColor(Color.WHITE);
        text1.draw();
        startText.setColor(Color.WHITE);
        startText.draw();
    }

    public void delete() {
        box.delete();
        text1.delete();
        startText.delete();

    }

    public void exitMenu(){
        delete();
        background.delete();
    }

}
