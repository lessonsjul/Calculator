package gui;

import javax.swing.*;
import java.awt.*;

public class MyJTextField extends JTextField{

    public MyJTextField(int columns) {
        super(columns);
        Font font = new Font("Courier",Font.ITALIC,28);
        setFont(font);
//        setRequestFocusEnabled(true);
        setEditable(false);
        setForeground(Color.GRAY);
        setHorizontalAlignment(JTextField.RIGHT);
    }

    public MyJTextField(String text, int columns) {
        this(columns);
        setText(text);
    }

    public MyJTextField(int columns, Color color) {
        this(columns);
        setForeground(color);
    }
}
