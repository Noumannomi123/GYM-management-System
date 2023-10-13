
package utils;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonAction {
	public static void performAction(JButton currentButton,boolean flag,JLabel titleLabel,String label,String buttonLabels[],JPanel panelW[]) {
		// Restore the border of the previously selected button
        ButtonsCompoundBorder.setButtonBorder(currentButton, flag);
        titleLabel.setText(label);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        for(int j = 0; j < buttonLabels.length; j++)
        	panelW[j].setVisible(false);
        final int idxLabel = Arrays.asList(buttonLabels).indexOf(label);
        panelW[idxLabel].setVisible(true);/////////////////
	}
}
