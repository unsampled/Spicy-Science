package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 24/02/2019.
 */
public class MyKeyboard implements KeyboardHandler {

    private Keyboard kb;
    private Game game;
    private boolean showMenu;

    public MyKeyboard(Game game){

        this.game = game;
        showMenu = true;
        kb = new Keyboard(this);
        setKeys();
    }

    public boolean showMenu() {
        return showMenu;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                showMenu = false;
                break;
            default:
                System.out.println("error. key pressed is not an option");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void setKeys(){

        KeyboardEvent press_Space = new KeyboardEvent();
        press_Space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        press_Space.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(press_Space);
    }
}
