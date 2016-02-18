package listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyButtonsListener extends KeyAdapter {
    @Override
    public void keyPressed (KeyEvent e) {
        String res = e.getKeyChar() == '/' ? "Pressed divide": "I don't undestand";

        System.out.println(res);
    }
}
