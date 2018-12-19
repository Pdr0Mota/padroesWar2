package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.GameController;

public class GameSelectionScreen extends JFrame {
	
	private GameController war = GameController.getInstance();
	
	public GameSelectionScreen() {
		super("War");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(236,144);
		setUp();
		setVisible(true);
		
		
	}
	
	// Adicionando Main Panel
	public void setUp() {
		JPanel p = new JPanel(new BorderLayout());
		getContentPane().add(p);
		JPanel painelNorte = new JPanel();
		p.add(painelNorte, BorderLayout.NORTH);
		
		painelNorte.add(new JLabel("Escolha o Jogo."));
		
		JPanel panel = new JPanel();
		p.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton b1 = new JButton("War 1");
		b1.setBounds(62, 11, 97, 23);
		panel.add(b1);
		JButton b2 = new JButton("War 2");
		b2.setBounds(62, 40, 97, 23);
		panel.add(b2);
		
		b2.addActionListener(new ActionListener() {			 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				war.newGame("mapWar2.txt");
				PlayerNumberSelection w2 = new PlayerNumberSelection();
				w2.setVisible(true);
				dispose();			
			}
			});
		
		b1.addActionListener(new ActionListener() {			 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				war.newGame("mapWar1.txt");
				PlayerNumberSelection w1 = new PlayerNumberSelection();
				w1.setVisible(true);
				dispose();
			}
			});
	}
		
}
