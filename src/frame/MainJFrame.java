package frame;

import component.button.JbuttonFooter;
import component.button.JbuttonMenu;
import component.button.exiteJButton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by lalfechee on 22/05/2015.
 */
public class MainJFrame extends JFrame {

    int posX, posY;
    protected JPanel top = new JPanel();
    protected JPanel body = new JPanel();
    protected JPanel footer = new JPanel();
    protected JLabel spacer = new JLabel();
    protected exiteJButton exiteJButton = new exiteJButton("");
    protected JbuttonMenu jbuttonMenu = new JbuttonMenu("");
    protected JbuttonFooter jbuttonFooter = new JbuttonFooter("Valider");
    GridBagConstraints c = new GridBagConstraints();

    public MainJFrame(){

        setUndecorated(true);
        setResizable(false);
        setSize(new Dimension(500, 300));
        setLocationRelativeTo(this);

        jbuttonMenu.setVisible(false);
        top.setLayout(new GridBagLayout());
        top.setPreferredSize(new Dimension(300, 30));
        top.setBorder(new LineBorder(Color.black, 2));
        top.setBackground(new Color(50, 50, 50));

        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        jbuttonMenu.setPreferredSize(new Dimension(56, 24));
        top.add(jbuttonMenu, c);

        c.gridx = 1;
        c.gridy = 0;
        spacer.setPreferredSize(new Dimension(240, 24));
        top.add(spacer, c);

        c.anchor = GridBagConstraints.EAST;
        c.gridx = 2;
        c.gridy = 0;
        exiteJButton.setPreferredSize(new Dimension(56, 24));
        top.add(exiteJButton, c);

        top.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                posX = e.getX();
                posY = e.getY();
            }
        });

        top.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                int depX = e.getX() - posX;
                int depY = e.getY() - posY;
                setLocation(getX() + depX, getY() + depY);
            }
        });


        body.setBorder(new LineBorder(Color.black, 2));
        body.setBackground(new Color(77, 77, 77));


        footer.setBorder(new LineBorder(Color.black));
        footer.setBackground(new Color(50, 50, 50));
        footer.setPreferredSize(new Dimension(300,35));

        footer.add(jbuttonFooter);
        add(top, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
        exiteJButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


}
