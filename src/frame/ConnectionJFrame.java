package frame;

import component.textfield.PlaceholderPasswordField;
import component.textfield.PlaceholderTextField;
import utils.Connect;
import utils.Connection;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by lalfechee on 19/05/2015.
 */
public class ConnectionJFrame extends MainJFrame implements ActionListener, KeyListener {


    PlaceholderTextField login = new PlaceholderTextField();
    PlaceholderPasswordField password = new PlaceholderPasswordField();
    public static Connect dbrequet = new Connect();
    GridBagConstraints c = new GridBagConstraints();


    public ConnectionJFrame(){


        setResizable(false);
        login.setPlaceholder("Login");
        password.setPlaceholder("Password");

        login.setPreferredSize(new Dimension(200, 30));
        password.setPreferredSize(new Dimension(200, 30));


        body.setLayout(new GridBagLayout());
        c.insets = new Insets(20, 2, 2, 2);
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTH;
        body.add(login,c);

        c.insets = new Insets(5, 2, 20, 2);
        c.gridx = 0;
        c.gridy =1;
        c.anchor = GridBagConstraints.SOUTH;
        body.add(password,c);


        addKeyListener(this);
        login.addKeyListener(this);
        password.addKeyListener(this);
        jbuttonFooter.addActionListener(this);
        pack();
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(jbuttonFooter))
            new Connection(login.getText(), String.valueOf(password.getPassword()), this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER ){
            new Connection(login.getText(), String.valueOf(password.getPassword()), this);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
