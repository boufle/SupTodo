import frame.MainJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lalfechee on 19/05/2015.
 */
public class ConnectionJFrame extends MainJFrame implements ActionListener {


    PlaceholderTextField login = new PlaceholderTextField();
    PlaceholderPasswordField password = new PlaceholderPasswordField();
    static Connect dbrequet = new Connect();
    GridBagConstraints c = new GridBagConstraints();


    public ConnectionJFrame(){


        setResizable(false);
        utils.centreWindow(this);
        login.setPlaceholder("Login");
        password.setPlaceholder("Password");

        login.setPreferredSize(new Dimension(200, 30));
        password.setPreferredSize(new Dimension(200,30));

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

        jbuttonFooter.addActionListener(this);
        pack();
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(jbuttonFooter))
            new Connection(login.getText(), String.valueOf(password.getPassword()), this);
    }
}
