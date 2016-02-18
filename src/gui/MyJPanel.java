package gui;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {

    private Dimension d;

    public MyJPanel(String name, int width, int height) {

        setName(name);
        setSize(width, height);
        d = new Dimension(width, height);
        setPreferredSize(d);
    }

    public MyJPanel(String name, int width, int height, LayoutManager layout){
        this(name, width, height);
        setLayout(layout);
    }
}
