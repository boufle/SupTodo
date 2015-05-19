import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lalfechee on 19/05/2015.
 */
public class mainJFrameUser extends JFrame implements ActionListener {

    JPanel ticketJbuttonPanel = new JPanel();
    JLabel ticketTitle = new JLabel();
    JLabel description = new JLabel();
    JCheckBox done = new JCheckBox();
    JTextArea commentJtextfield = new JTextArea();
    JScrollPane jScrollPane = new JScrollPane(commentJtextfield);
    JButton saveJbutton = new JButton("Save");

    public mainJFrameUser(){



        String[] test;
        test =  ConnectionJFrame.dbrequet.getAllTicket();
        for (String x : test){
            if (x != null){
                if (ConnectionJFrame.dbrequet.getCheckTicket(x) == 0){
                    JButton ticket = new JButton(x);
                    ticketJbuttonPanel.add(ticket);
                    ticket.addActionListener(this);
                }
            }
        }


        done.setText("SALUT");
        //commentJtextfield.setPlaceholder("Write a comment...");
        setLayout(new GridLayout(6, 1));
        setTitle("User Windows");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        utils.centreWindow(this);
        setSize(new Dimension(600, 600));
        add(ticketJbuttonPanel);
        add(ticketTitle);
        add(description);
        add(done);
        add(jScrollPane);
        add(saveJbutton);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();
        ticketTitle.setText("Title: "+source.getText());
        description.setText("<html>Description: <br>"+ ConnectionJFrame.dbrequet.getDescriptionTicket(source.getText())+"</html>");
        ConnectionJFrame.dbrequet.setCheckAndCom(done.isSelected(), commentJtextfield.getText());
    }
}
