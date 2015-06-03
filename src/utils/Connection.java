package utils;

import frame.ConnectionJFrame;
import frame.mainJFrameAdmin;
import frame.mainJFrameUser;
import frame.popup.newPopup;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lalfechee on 19/05/2015.
 */
public class Connection {

    public Connection(String login,  String password, JFrame frame){


        if(ConnectionJFrame.dbrequet.testConnectionUser(login, password)){
            if (ConnectionJFrame.dbrequet.typeofuser(login) == 0){
                new mainJFrameUser();
                frame.dispose();
            }
            else if (ConnectionJFrame.dbrequet.typeofuser(login) == 1){
                new mainJFrameAdmin();
                frame.dispose();
            }
            else {
                JOptionPane.showMessageDialog(frame, "Role Failed", "Role Error", JOptionPane.ERROR_MESSAGE);
            }


        }
        else {
            Toolkit.getDefaultToolkit().beep();
            new newPopup("Login Failed","You missmatch something");

        }
    }
}
