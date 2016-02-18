package gui;

import javax.swing.*;
import java.awt.*;

public class MyJButton extends JButton {


    public MyJButton(String text) {
        super(text);
        setActionCommand(text);
    }

    public MyJButton(String text, Color color){
        this(text);
        setBackground(color);
    }

    public MyJButton(Icon icon, String command) {
        super(icon);
        setActionCommand(command);
    }

}
