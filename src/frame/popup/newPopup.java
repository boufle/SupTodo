package frame.popup;

import component.button.JbuttonFooter;
import component.button.exiteJButton;
import utils.Connection;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by lalfechee on 22/05/2015.
 */
public class newPopup extends JDialog implements KeyListener{

    protected JPanel top = new JPanel();
    protected JPanel body = new JPanel();
    protected JPanel bot = new JPanel();
    protected JLabel spacer = new JLabel();
    protected JLabel title = new JLabel();
    protected JLabel errorMessage = new JLabel();
    protected JLabel typeError = new JLabel();
    protected JbuttonFooter jbuttonFooter = new JbuttonFooter("Valider");

    AbstractAction d = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            newPopup.this.dispose();
        }
    };

    AbstractAction s= new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {

            newPopup.this.dispose();

        }
    };
    ActionListener dsd = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            newPopup.this.dispose();
        }
    };


    public newPopup(String titre, String contenu){



        title.setText(titre);
        setModal(true);
        setSize(new Dimension(300, 200));
        setUndecorated(true);
        setLocationRelativeTo(this);

        top.setBackground(new Color(50, 50, 50));
        top.setBorder(new LineBorder(Color.black, 2));

        body.setBackground(new Color(77, 77, 77));

        spacer.setPreferredSize(new Dimension(5, 30));
        top.add(spacer);
        title.setPreferredSize(new Dimension(270, 30));
        title.setForeground(Color.RED);
        top.add(title);

        bot.add(jbuttonFooter);
        jbuttonFooter.addActionListener(s);

        bot.setBackground(new Color(50, 50, 50));

        errorMessage.setText(contenu);
        errorMessage.setForeground(Color.RED);
        errorMessage.setFont(new Font("Sans serif",Font.ITALIC, 18));
        body.add(errorMessage, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                requestFocus();
            }
        });
        addKeyListener(this);
        add(top, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        add(bot, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER ){
            newPopup.this.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
