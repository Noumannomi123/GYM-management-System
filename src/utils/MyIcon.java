package utils;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.JButton;

public class MyIcon extends JButton implements Icon{
	
	private int width;
	private int height;
	private Image image;
	
	public MyIcon(Image image, int width, int height) {
		this.width = width;
		this.height = height;
		this.image = image;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.drawImage(image, x, y, getIconWidth(), getIconHeight(), c);
	}

	@Override
	public int getIconWidth() {
		return width;
	}

	@Override
	public int getIconHeight() {
		return height;
	}
	
}
