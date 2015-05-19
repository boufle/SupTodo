import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;

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
            JOptionPane.showMessageDialog(frame, "Login Failed", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
