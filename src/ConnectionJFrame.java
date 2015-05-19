import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lalfechee on 19/05/2015.
 */
public class ConnectionJFrame extends JFrame implements ActionListener {

    PlaceholderTextField login = new PlaceholderTextField();
    PlaceholderPasswordField password = new PlaceholderPasswordField();
    JButton connection = new JButton("Login");
    JLabel separator = new JLabel();
    static Connect dbrequet = new Connect();

    public ConnectionJFrame(){


        setResizable(false);
        utils.centreWindow(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 0, 10));
        setTitle("SupTodo Connecting ...");
        setSize(new Dimension(500, 300));
        login.setPlaceholder("Login");
        password.setPlaceholder("Password");
        add(separator);
        add(login);
        add(password);
        add(connection);
        connection.addActionListener(this);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new Connection(login.getText(), String.valueOf(password.getPassword()), this);
    }
}
