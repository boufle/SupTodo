import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lalfechee on 19/05/2015.
 */
public class mainJFrameAdmin extends JFrame implements ActionListener {

    JLabel todo = new JLabel("                      Write new ToDo");
    PlaceholderTextField ticketname = new PlaceholderTextField();
    PlaceholderTextField todotext = new PlaceholderTextField();
    JButton add = new JButton("Add todo");

    public mainJFrameAdmin(){

        setLayout(new GridLayout(4,1));
        todotext.setPlaceholder("Enter new ToDo...");
        ticketname.setPlaceholder("Enter a ticket name...");
        setTitle("Admin Windows");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        utils.centreWindow(this);
        setSize(new Dimension(600, 600));
        add(todo);
        add(ticketname);
        add(todotext);
        add(add);
        add.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConnectionJFrame.dbrequet.setToDo(todotext.getText(), ticketname.getText());
    }
}