package utils;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
public class MenuMaker {
	public static void makeMenu(String buttonLabels[], JPanel panel, JLabel titleLabel,
			JPanel panelW[], JButton newButtons[]) {
	    int buttonYPosition = 0;
	    JButton[] currentButton = new JButton[1];
	    
	    for (int i = 0; i < buttonLabels.length; i++) {
	        final String label = buttonLabels[i];
	        final JButton newButton = ButtonsCompoundBorder.createButton(buttonLabels[i], currentButton, buttonYPosition);
	        newButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (currentButton[0] != null) {
	                	ButtonAction.performAction(currentButton[0],false,titleLabel,label,buttonLabels,panelW);
	                	ButtonsCompoundBorder.setButtonBorder(newButton, true);
	                	for(JButton button: newButtons) {
	                		if(button != newButton)
	                			ButtonsCompoundBorder.setButtonBorder(button, false);
	                	}
	                }
	            }
	        });
	        
	        newButtons[i] = newButton;
	        panel.add(newButtons[i]);
	        buttonYPosition += 46;
	        	
	    }
	    currentButton[0] = newButtons[0];
	    ButtonsCompoundBorder.setButtonBorder(newButtons[0], true);
	}

}
