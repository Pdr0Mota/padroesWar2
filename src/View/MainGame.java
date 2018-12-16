package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.Image;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MainGame() {
		
		Mapa map = new Mapa();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		java.awt.Image img = new ImageIcon(this.getClass().getResource("/Brasil1988.jpg")).getImage();
		img = img.getScaledInstance(400, 400,  java.awt.Image.SCALE_SMOOTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Atacar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(264, 11, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnMover = new JButton("Mover");
		btnMover.setBounds(264, 45, 89, 23);
		panel.add(btnMover);
		
		JButton btnEncerrar = new JButton("Encerrar");
		btnEncerrar.setBounds(264, 79, 89, 23);
		panel.add(btnEncerrar);
		
		JPanel panel_mapa = new JPanel();
		panel_mapa.setBounds(388, 0, 440, 497);
		panel.add(panel_mapa);
		panel_mapa.add(map);
		
		JButton btnMapa = new JButton("Mapa");
		btnMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(map.isVisible()==false) 
				{
					map.setVisible(true);
				}
				else 
				{
					map.dispose();
				}
			}
		});
		btnMapa.setBounds(130, 386, 89, 23);
		panel.add(btnMapa);
		
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Turno x: Jogador cor y");
		panel_1.add(lblNewLabel_1);
		
		
	}
}
