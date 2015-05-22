/**
 * Created by lalfechee on 19/05/2015.
 */
/**
 * Created by lalfechee on 19/05/2015.
 */


import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class PlaceholderPasswordField extends JPasswordField implements FocusListener{

    public static void main(final String[] args) {
        final PlaceholderTextField tf = new PlaceholderTextField("");
        tf.setColumns(20);

        tf.setPlaceholder("All your base are belong to us!");
        final Font f = tf.getFont();
        tf.setFont(new Font(f.getName(), f.getStyle(), 30));
        JOptionPane.showMessageDialog(null, tf);
    }

    private String placeholder;

    public PlaceholderPasswordField() {

        setBackground(new Color(128, 128, 128));
        setBorder(new LineBorder(new Color(180, 180, 180), 2, true));
        setSelectionColor(Color.RED);
        setCaretColor(Color.WHITE);
        setForeground(Color.WHITE);
        addFocusListener(this);
    }

    public PlaceholderPasswordField(
            final Document pDoc,
            final String pText,
            final int pColumns)
    {
        super(pDoc, pText, pColumns);
    }

    public PlaceholderPasswordField(final int pColumns) {
        super(pColumns);
    }

    public PlaceholderPasswordField(final String pText) {
        super(pText);
    }

    public PlaceholderPasswordField(final String pText, final int pColumns) {
        super(pText, pColumns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getDisabledTextColor());
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
                .getMaxAscent() + getInsets().top);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }
    @Override
    public void focusGained(FocusEvent e) {
        setBorder(new LineBorder(new Color(69, 111, 175), 2, true));
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBorder(new LineBorder(new Color(180, 180, 180), 2, true));
    }
}