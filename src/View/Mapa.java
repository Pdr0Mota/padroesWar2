package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Mapa extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mapa frame = new Mapa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mapa() {
		setClosable(true);
		setBounds(100, 100, 424, 491);
		
		JLabel lblNewLabel = new JLabel("");
		java.awt.Image img = new ImageIcon(this.getClass().getResource("/Brasil1988.jpg")).getImage();
		img = img.getScaledInstance(400, 400,  java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(img));
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);

	}

}
