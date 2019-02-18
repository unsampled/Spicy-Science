package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TransferQueue;

public class PlayerTest extends Picture implements KeyboardHandler {

    private Picture p1;
    private Keyboard kb;
    private String currentImage;
    private final int TRANS = 15;


    public PlayerTest() {
        super(10, 0, "man/frente 1-3.png");
        kb = new Keyboard(this);
        setters();
        p1 = new Picture(10, 0, "man/frente 1-3.png");
        currentImage = "f1";
        p1.draw();
    }

    private void setters() {
        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressDown.setKey(KeyboardEvent.KEY_DOWN);
        kb.addEventListener(pressDown);
    }

    private void moveDown(String currentImage) {
        int y = p1.getY();
        switch (currentImage) {
            case "f1":
                p1.delete();
                y = y + TRANS;
                p1 = new Picture(10, y, "man/frente 2.png");
                this.currentImage = "f2";
                p1.draw();
                break;
            case "f2":
                p1.delete();
                y = y + TRANS;
                p1 = new Picture(10, y, "man/frente 1-3.png");
                this.currentImage = "f3";
                p1.draw();
                break;
            case "f3":
                p1.delete();
                y = y + TRANS;
                p1 = new Picture(10, y, "man/frente 4.png");
                this.currentImage = "f4";
                p1.draw();
                break;
            case "f4":
                p1.delete();
                y = y + TRANS;
                p1 = new Picture(10, y, "man/frente 1-3.png");
                this.currentImage = "f1";
                p1.draw();
                break;
            default:
                System.out.println("someting wrong on movement");
        }

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                moveDown(currentImage);
            default:
                System.out.println("não te outras hipoteses");
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
