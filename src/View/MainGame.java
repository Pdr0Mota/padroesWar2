package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.Image;

import controller.GameController;
import model.Estado;
import model.Regiao;
import model.Tabuleiro;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainGame extends JFrame {

	private JPanel contentPane;
	private GameController war = GameController.getInstance();
	private Tabuleiro tabs = war.getJogo().Mapa;
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
		btnNewButton.setBounds(130, 140, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnMover = new JButton("Mover");
		btnMover.setBounds(130, 174, 89, 23);
		panel.add(btnMover);
		
		JButton btnEncerrar = new JButton("Encerrar");
		btnEncerrar.setBounds(130, 208, 89, 23);
		panel.add(btnEncerrar);
		
		JPanel panel_mapa = new JPanel();
		panel_mapa.setBounds(388, 0, 440, 497);
		panel.add(panel_mapa);
		
		
		ArrayList<Regiao> regioesAux = tabs.getRegioes();
		ArrayList<Estado> estadosAux;
		for(int i =0;i < regioesAux.size();i++) 
		{
			estadosAux=regioesAux.get(i).getEstados();
			for(int j=0;j< estadosAux.size();j++) 
			{
				JButton stateBtn = new JButton(estadosAux.get(j).getNome());
				
				panel_mapa.add(stateBtn);
				
			}
		}
		
		
		
		JButton btnMapa = new JButton("Mapa");
		btnMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(map.isVisible()==false) 
				{
					panel_mapa.add(map);
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
