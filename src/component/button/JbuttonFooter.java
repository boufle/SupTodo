package component.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by 16915_000 on 18/07/14.
 */
public class JbuttonFooter extends JButton implements MouseListener{

    private String name;
    private Image img;

    public JbuttonFooter(String str){
        super(str);
        this.name = str;
        setBorderPainted(false);
        setSelected(false);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBackground(new Color(50, 50, 50));
        this.addMouseListener(this);

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

        setBackground(new Color(50,50,50));
    }
}
