package utils;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class ButtonsCompoundBorder extends JButton {
	public static JButton createButton(String label,JButton[] currentButtonContainer,int buttonYPosition) {
        JButton button = new JButton(label);
        button.setFocusPainted(false);
        button.setBackground(new Color(255, 255, 255));
        button.setBounds(5, buttonYPosition, 193, 45);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setIcon(new ImageIcon("D:\\JavaDocuments\\GymSystem\\pictures\\" + label + ".png")); // Set icon
        button.setFont(new Font("Serif", Font.PLAIN, 18));
        button.setUI(new BasicButtonUI());
        
        int arc = 40; // Adjust the arc value to control the roundness
        button.setBorder(new LineBorder(new Color(255, 255, 255), 2, true) {
        	@Override
        	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        		super.paintBorder(c, g, x, y, width, height);
        		Graphics2D g2d = (Graphics2D) g;
        		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        		// Custom border for the inside
        		RoundRectangle2D innerRound = new RoundRectangle2D.Float(x + 2, y + 2, width - 4, height - 4, arc, arc);
        		g2d.draw(innerRound);
        	}
        });
        
      // Add an ActionListener to the button
        /*button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentButtonContainer[0] != null) {
                    // Restore the border of the previously selected button
                    setButtonBorder(currentButtonContainer[0], false);
                    titleLabel.setText(label);
                    titleLabel.setHorizontalAlignment(JLabel.CENTER);
                }
                // Set the current button
                currentButtonContainer[0] = button;
                // Change the button's border
                setButtonBorder(button, true);
            }
        });*/

        return button;
    }

    public static void setButtonBorder(JButton button, boolean selected) {
        
      int arc = 40;
      BevelBorder bevelBorder = new BevelBorder(BevelBorder.RAISED, new Color(255, 0, 0), new Color(128, 0, 0));
      LineBorder customLineBorder = new LineBorder(new Color(255, 0, 0), 2, true) {
          @Override
          public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
              super.paintBorder(c, g, x, y, width, height);
              Graphics2D g2d = (Graphics2D) g;
              g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
              RoundRectangle2D innerRound = new RoundRectangle2D.Float(x + 2, y + 2, width - 4, height - 4, arc, arc);
              g2d.draw(innerRound);
          }
      };
      CompoundBorder compoundBorder = new CompoundBorder(bevelBorder, customLineBorder);

      if (selected) {
          // Change the button's background to blue and foreground to white
          button.setForeground(new Color(128, 0, 0));
          // Set the compound border on the button
          button.setBorder(compoundBorder);
      } else {
          // Restore the original appearance
          button.setForeground(new Color(0, 0, 0));
          button.setBorder(new LineBorder(new Color(255, 255, 255), 2, true) {
              @Override
              public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                  super.paintBorder(c, g, x, y, width, height);
                  Graphics2D g2d = (Graphics2D) g;
                  g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                  RoundRectangle2D innerRound = new RoundRectangle2D.Float(x + 2, y + 2, width - 4, height - 4, arc, arc);
                  g2d.draw(innerRound);
              }
          });
      }
    }
}
