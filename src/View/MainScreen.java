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

public class MainScreen extends JFrame {
	
	public MainScreen() {
		super("War");
		setSize(200,100);
		setResizable(false);
		setUp();
		setVisible(true);
		
		
	}
	
	// Adicionando Main Panel
	public void setUp() {
		JPanel p = new JPanel(new BorderLayout());
		getContentPane().add(p);
		JPanel painelNorte = new JPanel();
		p.add(painelNorte, BorderLayout.NORTH);
		
		JPanel painelOeste = new JPanel();
		p.add(painelOeste, BorderLayout.WEST);
		JPanel painelLeste = new JPanel();
		p.add(painelLeste, BorderLayout.EAST);
		
		JButton b1 = new JButton("War 1");
		JButton b2 = new JButton("War 2");
		
		painelNorte.add(new JLabel("Escolha o Jogo."));		
		painelOeste.add(b1);
		painelLeste.add(b2);
		
		b1.addActionListener(new ActionListener() {			 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "War 1");
			}
			});
		
		b2.addActionListener(new ActionListener() {			 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "War 2");
			}
			});
	}
	
	
	
}
