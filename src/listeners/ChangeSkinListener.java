package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangeSkinListener implements ActionListener{

    private LookAndFeel laf;
    private JFrame frame;

    public ChangeSkinListener(JFrame frame, LookAndFeel laf) {
        this.laf = laf;
        this.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ChangeSkinListener.class.getName()).log(Level.SEVERE, null, ex);
        }

        SwingUtilities.updateComponentTreeUI(frame);
    }

}
