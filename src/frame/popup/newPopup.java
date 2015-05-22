package frame.popup;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lalfechee on 22/05/2015.
 */
public class newPopup extends JDialog {

    JPanel top = new JPanel();
    JPanel body = new JPanel();
    JPanel bot = new JPanel();
    JLabel errorMessage = new JLabel();
    JLabel typeError = new JLabel();

    public newPopup(){


        setModal(true);
        setSize(new Dimension(600, 300));
        setUndecorated(true);
        setLocationRelativeTo(this);


        add(top, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        add(bot, BorderLayout.SOUTH);
        setVisible(true);
    }
}
