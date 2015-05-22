import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lalfechee on 19/05/2015.
 */
public class mainJFrameUser extends JFrame implements ActionListener {

    private final mainJFrameUser main;
    JPanel ticketJbuttonPanel = new JPanel();
    JLabel ticketTitle = new JLabel();
    JLabel description = new JLabel();
    JCheckBox done = new JCheckBox();
    JPanel pancomment = new JPanel();
    JButton source;
    JTextArea commentJtextfield = new JTextArea();
    JScrollPane panecomment = new JScrollPane(pancomment);
    JScrollPane jScrollPane = new JScrollPane(commentJtextfield);
    JButton saveJbutton = new JButton("Save");
    int conteur = 0;
    boolean checkshow = false;

    public mainJFrameUser(){

        main = this;
        setLayout(new GridLayout(7, 1));
        setTitle("User Windows");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        utils.centreWindow(this);
        setSize(new Dimension(600, 600));
    init();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        pancomment.removeAll();

        checkshow = true;
        String[] test;
//        test =  ConnectionJFrame.dbrequet.getComment(ConnectionJFrame.dbrequet.getIdToDoByName(source.getText()));
        source = (JButton) e.getSource();
        ticketTitle.setText("Title: " + source.getText());
        description.setText("<html>Description: <br>" + ConnectionJFrame.dbrequet.getDescriptionTicket(source.getText()) + "</html>");

        for (String x : ConnectionJFrame.dbrequet.getComment(ConnectionJFrame.dbrequet.getIdToDoByName(source.getText()))){
            if (x != null){
                conteur++;
            }
            pancomment.setLayout(new GridLayout(conteur,1));
        }

        for (String x : ConnectionJFrame.dbrequet.getComment(ConnectionJFrame.dbrequet.getIdToDoByName(source.getText()))){
            if (x != null){
            JLabel comment = new JLabel("<html>Comment from: " + "<br>"+x+"</html>");
            pancomment.add(comment);
            }

        }



    }

    public void init(){


        String[] test;
        commentJtextfield.setText("");
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
        saveJbutton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkshow) {

                    if (done.isSelected()) {
                        if (!commentJtextfield.getText().isEmpty()) {
                            ConnectionJFrame.dbrequet.setCheck(done.isSelected(), source.getText());

                            main.getContentPane().removeAll();
                            ticketJbuttonPanel.removeAll();
                            main.repaint();
                            main.init();
                            main.revalidate();
                            commentJtextfield.setText("");
                            done.setSelected(false);

                        } else {
                            JOptionPane.showMessageDialog(mainJFrameUser.this, "Please enter a comment", "Missing Comment", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    ConnectionJFrame.dbrequet.setComment(source.getText(), commentJtextfield.getText(), 1);
                    JOptionPane.showMessageDialog(mainJFrameUser.this, "Your comment have been added", "Done", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(mainJFrameUser.this, "Pick a ticket", "Miss ticket", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        add(ticketJbuttonPanel);
        add(ticketTitle);
        add(description);
        add(panecomment);
        add(done);
        add(jScrollPane);
        add(saveJbutton);
        setVisible(true);
    }
}
