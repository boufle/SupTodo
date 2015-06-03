package frame;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import component.button.JbuttonToDo;



/**
 * Created by lalfechee on 19/05/2015.
 */
public class mainJFrameUser extends MainJFrame implements ActionListener {

    private final mainJFrameUser main;
    //JPanel ticketJbuttonPanel = new JPanel();
    JLabel ticketTitle = new JLabel();
    JLabel description = new JLabel();
    JCheckBox done = new JCheckBox();
    JPanel pancomment = new JPanel();
    JButton source;
    JTextArea commentJtextfield = new JTextArea();
    JScrollPane panecomment = new JScrollPane(pancomment);
    JScrollPane jScrollPane = new JScrollPane(commentJtextfield);
    JPanel descrptionpan = new JPanel();
    JButton saveJbutton = new JButton("Save");
    int conteur = 0;
    boolean checkshow = false;
    GridBagConstraints c = new GridBagConstraints();

    public mainJFrameUser(){

        main = this;
        jbuttonMenu.setVisible(true);
        jbuttonMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.dispose();
                new ConnectionJFrame();
            }
        });
        body.setLayout(new GridBagLayout());
        setTitle("User Windows");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(600, 600));
        descrptionpan.setLayout(new GridLayout(2, 1));
        descrptionpan.setPreferredSize(new Dimension(500, 150));
        descrptionpan.setBackground(new Color(77, 77, 77));
        descrptionpan.setBorder(new LineBorder(Color.black));

        ticketTitle.setPreferredSize(new Dimension(500, 50));
        ticketTitle.setForeground(Color.WHITE);
        description.setPreferredSize(new Dimension(500, 50));
        description.setForeground(Color.WHITE);

        jScrollPane.setPreferredSize(new Dimension(500, 100));
        spacer.setPreferredSize(new Dimension(385, 24));
        panecomment.setPreferredSize(new Dimension(500, 200));
        pancomment.setLayout(new GridBagLayout());
        panecomment.setAlignmentY(LEFT_ALIGNMENT);
        pancomment.setAlignmentY(LEFT_ALIGNMENT);
        pancomment.setBackground(new Color(77, 77, 77));
        panecomment.setBorder(new LineBorder(Color.black));

        done.setBackground(new Color(77, 77, 77));
        done.setForeground(Color.WHITE);
        done.setFocusPainted(false);
        done.setFocusable(false);

        commentJtextfield.setBackground(new Color(77, 77, 77));
        commentJtextfield.setForeground(Color.WHITE);
        jScrollPane.setBorder(new LineBorder(Color.black));
        jScrollPane.setFocusable(false);


        init();
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int compteur = 0;
        pancomment.removeAll();
        checkshow = true;
        String[] test;
//        test =  frame.ConnectionJFrame.dbrequet.getComment(frame.ConnectionJFrame.dbrequet.getIdToDoByName(source.getText()));
        source = (JButton) e.getSource();
        ticketTitle.setText("Title: " + source.getText());
        description.setText("<html>Description: <br>" + ConnectionJFrame.dbrequet.getDescriptionTicket(source.getText()) + "</html>");


        for (String x : ConnectionJFrame.dbrequet.getComment(ConnectionJFrame.dbrequet.getIdToDoByName(source.getText()))){
            if (x != null){
                JLabel comment = new JLabel("<html>Comment from: " + "<br>"+x+"</html>");
                comment.setForeground(Color.WHITE);
                c.gridx = 0;
                c.gridy = compteur;
                c.anchor = GridBagConstraints.NORTHWEST;
                c.weighty = 1;
                c.insets = new Insets(10,0,0,0);
                pancomment.add(comment,c);
                compteur++;
                panecomment.repaint();
            }

        }



    }

    public void init(){


        String[] test;
        int compteur = 0;
        commentJtextfield.setText("");
        test =  ConnectionJFrame.dbrequet.getAllTicket();
        for (String x : test){
            if (x != null){
                if (ConnectionJFrame.dbrequet.getCheckTicket(x) == 0){
                    JbuttonToDo ticket = new JbuttonToDo(x);
                    c.gridx = compteur;
                    c.gridy = 0;
                    c.anchor = GridBagConstraints.FIRST_LINE_START;
                    c.weighty = 1;
                    c.insets = new Insets(0,0,0,0);
                    body.add(ticket, c);
                    ticket.addActionListener(this);
                    compteur++;
                }
            }
        }


        done.setText("SALUT");
        //commentJtextfield.setPlaceholder("Write a comment...");
        jbuttonFooter.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkshow) {

                    if (done.isSelected()) {
                        if (!commentJtextfield.getText().isEmpty()) {
                            ConnectionJFrame.dbrequet.setCheck(done.isSelected(), source.getText());

                            main.getContentPane().removeAll();
                            //ticketJbuttonPanel.removeAll();
                            main.repaint();
                            main.init();
                            main.revalidate();
                            done.setSelected(false);

                        } else {
                            JOptionPane.showMessageDialog(mainJFrameUser.this, "Please enter a comment", "Missing Comment", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    ConnectionJFrame.dbrequet.setComment(source.getText(), commentJtextfield.getText(), 1);
                    commentJtextfield.setText("");
                    JOptionPane.showMessageDialog(mainJFrameUser.this, "Your comment have been added", "Done", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(mainJFrameUser.this, "Pick a ticket", "Miss ticket", JOptionPane.ERROR_MESSAGE);

                }

            }
        });


        //add(ticketJbuttonPanel);
        descrptionpan.add(ticketTitle);
        descrptionpan.add(description);

        /*c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = compteur;
        c.insets = new Insets(0,0,0,0);
        body.add(ticketTitle, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = compteur;
        body.add(description, c);*/

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = compteur;
        c.insets = new Insets(0,0,0,0);
        body.add(descrptionpan, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = compteur;
        c.insets = new Insets(5,0,0,0);
        body.add(panecomment, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = compteur;
        body.add(done, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = compteur;
        body.add(jScrollPane, c);

        /*c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = compteur;
        body.add(saveJbutton,c);*/
        setVisible(true);
    }
}
