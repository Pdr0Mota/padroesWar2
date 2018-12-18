package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Mapa extends JInternalFrame {

	/**
	 * Create the frame.
	 */
	public Mapa() {
		setClosable(true);
		setBounds(100, 100, 424, 491);
		
		JLabel lblNewLabel = new JLabel("");
		java.awt.Image img = new ImageIcon(this.getClass().getResource("/Brasil1988.jpg")).getImage();
		img = img.getScaledInstance(650, 650,  java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(img));
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);

	}

}
