package component.button;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JbuttonToDo extends JButton implements MouseListener, FocusListener {

    private String name;
    private Image img;
    boolean test = true;

    public JbuttonToDo(String str){
        super(str);
        this.name = str;
        setBorderPainted(false);
        setSelected(false);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        //setBorder(new LineBorder(Color.black,2));
        setBackground(new Color(50, 50, 50));
        this.addMouseListener(this);
        this.addFocusListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        setBackground(new Color(128,128,128));
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (test)
        setBackground(new Color(50, 50, 50));

    }

    @Override
    public void focusGained(FocusEvent e) {
        setBackground(new Color(128,128,128));
        test = false;
    }

    @Override
    public void focusLost(FocusEvent e) {

        setBackground(new Color(50, 50, 50));
        test = true;
    }
}
