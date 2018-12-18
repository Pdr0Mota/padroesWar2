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
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class MainGame extends JFrame {

	private JPanel contentPane;
	private GameController war = GameController.getInstance();
	private Tabuleiro tabs = war.getJogo().Mapa;
	/**
	 * Create the frame.
	 */
	public MainGame() {
		
		Mapa map = new Mapa();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		java.awt.Image img = new ImageIcon(this.getClass().getResource("/Brasil1988.jpg")).getImage();
		img = img.getScaledInstance(650, 650,  java.awt.Image.SCALE_SMOOTH);
		
		// Inserção dos botões para ataque
		ArrayList<Regiao> regioesAux = tabs.getRegioes();
		ArrayList<Estado> estadosAux;
		
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Turno x: Jogador cor y");
		panel_1.add(lblNewLabel_1);
		
		JPanel westPainel = new JPanel();
		contentPane.add(westPainel, BorderLayout.WEST);
		westPainel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Atacar");
		westPainel.add(btnNewButton);
		
		JButton btnMover = new JButton("Mover");
		westPainel.add(btnMover);
		
		JButton btnEncerrar = new JButton("Encerrar");
		westPainel.add(btnEncerrar);
		
		
		
		JButton btnMapa = new JButton("Mapa");
		westPainel.add(btnMapa);
		
		JLabel lblNewLabel = new JLabel("New label");
		westPainel.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.blue);
		
		JPanel panel_mapa = new JPanel();
		contentPane.add(panel_mapa, BorderLayout.CENTER);
		panel_mapa.setLayout(new BorderLayout(0, 0));
		
		JPanel painelNomeRegioes = new JPanel();
		panel_mapa.add(painelNomeRegioes, BorderLayout.NORTH);
		painelNomeRegioes.setLayout(new GridLayout(0, 5, 5, 0));
		
		JLabel labelNorte = new JLabel("Norte");
		labelNorte.setHorizontalAlignment(SwingConstants.CENTER);
		painelNomeRegioes.add(labelNorte);
		
		JLabel labelNordeste = new JLabel("Nordeste");
		labelNordeste.setHorizontalAlignment(SwingConstants.CENTER);
		painelNomeRegioes.add(labelNordeste);
		
		JLabel labelCentroOeste = new JLabel("Centro Oeste");
		labelCentroOeste.setHorizontalAlignment(SwingConstants.CENTER);
		painelNomeRegioes.add(labelCentroOeste);
		
		JLabel labelSudeste = new JLabel("Sudeste");
		labelSudeste.setHorizontalAlignment(SwingConstants.CENTER);
		painelNomeRegioes.add(labelSudeste);
		
		JLabel labelSul = new JLabel("Sul");
		labelSul.setHorizontalAlignment(SwingConstants.CENTER);
		painelNomeRegioes.add(labelSul);
		
		JPanel painelEstados = new JPanel();
		painelEstados.setBorder(null);
		panel_mapa.add(painelEstados, BorderLayout.CENTER);
		painelEstados.setLayout(new GridLayout(1, 5, 0, 0));
		
		JPanel[] btnRegioesPanel = new JPanel[regioesAux.size()];
		
		for (int i = 0; i < regioesAux.size();i++) {
			estadosAux=regioesAux.get(i).getEstados();
			btnRegioesPanel[i] = new JPanel();
			btnRegioesPanel[i].setLayout(new GridLayout(15,1));
			painelEstados.add(btnRegioesPanel[i]); 			
			for (int j = 0; j < estadosAux.size();j++) {
				JPanel jp = new JPanel();
				JButton b = new JButton(estadosAux.get(j).getNome());
				jp.add(b);
				
				JLabel corPlayer = new JLabel("        ");
				corPlayer.setOpaque(true);
				corPlayer.setBackground(Color.MAGENTA);
				jp.add(corPlayer);
				jp.add(new JLabel("Tropas: 100"));
				btnRegioesPanel[i].add(jp);
			}
		}
		
		
		btnMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(map.isVisible()==false) 
				{
//					panel_mapa.add(map);
					JFrame mp = new JFrame();
					mp.getContentPane().add(map);
					map.setVisible(true);
					mp.setSize(650, 650);
					mp.setVisible(true);
				}
				else 
				{
					map.dispose();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
//		for (int i = 0; i < regioesAux.size(); i ++) {
//			estadosAux=regioesAux.get(i).getEstados();
//			for (int j = 0; j < estadosAux.size();j++) {
//				JPanel jp = new JPanel();
//				jp.setLayout(new FlowLayout());
//				JButton btn = new JButton(estadosAux.get(j).getNome());
//				
//				jp.add(btn);
//				painelEstados.add(jp, i,j);
//			}
//			
//		}
		
		
		
	}
	
	
}
