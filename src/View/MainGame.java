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
import javax.swing.JOptionPane;
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
	private JLabel cabecalho, labelDesc;
	private Estado Origem;
	private Estado Destino;
	public int btnPressed=0;
	private boolean moved =false;
	private boolean attacked=false;
	
	public void updateLabelTurno() {
		cabecalho.setText("Turno " + war.getJogo().getRodada() +": Jogador cor " + war.getJogo().getJogadorAtualCor());
	}
	
	public void updateLabelDesc(int n, String cor) {
		labelDesc.setText("Rodada - Jogador " + cor + ": " +  n + " tropas.");
	}
	
	
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
		
		cabecalho = new JLabel();
		cabecalho.setHorizontalAlignment(SwingConstants.CENTER);
		updateLabelTurno();
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		panel_1.add(cabecalho);
		
		labelDesc = new JLabel("Rodada Inicial - Jogador " + war.getJogo().getJogadorAtualCor() + ": " +  war.getJogo().getJogadorTurno().getExercitos_Disponiveis() + " tropas.");
		labelDesc.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(labelDesc);
		
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
				Estado aux = estadosAux.get(j);
				JPanel jp = new JPanel();
				JButton b = new JButton(estadosAux.get(j).getNome());
				jp.add(b);
				JLabel corPlayer = new JLabel("        ");
				corPlayer.setOpaque(true);
				setLabelBackground(corPlayer, estadosAux.get(j).getDominante().getCor());
				jp.add(corPlayer);
				JLabel tropasLabel = new JLabel("1");
				jp.add(tropasLabel);
				btnRegioesPanel[i].add(jp);
				b.addActionListener(new ActionListener() {
//					Estado aux;
					public void actionPerformed(ActionEvent arg0) {
						System.out.println(b.getText() + " - " + corPlayer.getText() + " - " + tropasLabel.getText());						
						if (war.getJogo().getAcaoTurno() == 4) {
							//rodada inicial
							if (war.getJogo().inserirTropa(aux) == true) {
								updateLabelDesc(war.getJogo().getJogadorTurno().getExercitos_Disponiveis(), war.getJogo().getJogadorAtualCor());
//								int aux = tropasLabel.getText() + 1;
								tropasLabel.setText(String.valueOf((Integer.parseInt(tropasLabel.getText()) + 1)));
								if (war.getJogo().getJogadorTurno().getExercitos_Disponiveis() == 0) {
									war.getJogo().proximoJogador();
									updateLabelTurno();
									updateLabelDesc(war.getJogo().getJogadorTurno().getExercitos_Disponiveis(), war.getJogo().getJogadorAtualCor());
								}
							} else {
								JOptionPane.showMessageDialog(null, "Este estado não te percente DEMONHO");
							}
						}
						else if (war.getJogo().getAcaoTurno() == 1) {
							// Inserir tropas
							if (war.getJogo().inserirTropa(aux) == true) {
								updateLabelDesc(war.getJogo().getJogadorTurno().getExercitos_Disponiveis(), war.getJogo().getJogadorAtualCor());
//								int aux = tropasLabel.getText() + 1;
								tropasLabel.setText(String.valueOf((Integer.parseInt(tropasLabel.getText()) + 1)));
								if (war.getJogo().getJogadorTurno().getExercitos_Disponiveis() == 0) {
									
								}
							} else {
								JOptionPane.showMessageDialog(null, "Este estado não te percente DEMONHO");
							}
							
						} else if(war.getJogo().getAcaoTurno() == 2) {
							//atacar
							
						} else if(war.getJogo().getAcaoTurno() == 3) {
							// mover
							
							
						} else if (war.getJogo().getAcaoTurno() == 0) {
							JOptionPane.showMessageDialog(null, "Escolha uma ação antes");
						}
						
						
						
						
//						if(MainGame.this.btnPressed==0) 
//						{
//							aux = new Estado(b.getText());
//							MainGame.this.setOrigem(aux);
//							MainGame.this.btnPressed = 1;
//							System.out.println("Origem: "+ Origem.getNome());
//						}
//						else if(MainGame.this.btnPressed==1) 
//						{
//							aux = new Estado(b.getText());
//							MainGame.this.setDestino(aux);
//							MainGame.this.btnPressed =0;
//							System.out.println("Destino: " + Destino.getNome());
//						}
						
					}
				});
				
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
		
		
		btnMover.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
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
	
	public void setLabelBackground(JLabel l, String cor) {
		if (cor.equalsIgnoreCase("Verde")) {
			l.setBackground(Color.GREEN);
		} else if (cor.equalsIgnoreCase("Azul")) {
			l.setBackground(Color.BLUE);
		} else if (cor.equalsIgnoreCase("Preto")) {
			l.setBackground(Color.BLACK);
		} else if (cor.equalsIgnoreCase("Vermelho")) {
			l.setBackground(Color.RED);
		} else {
			l.setBackground(Color.YELLOW);
		}	
	}


	public Estado getOrigem() {
		return Origem;
	}


	public void setOrigem(Estado origem) {
		Origem = origem;
	}


	public Estado getDestino() {
		return Destino;
	}


	public void setDestino(Estado destino) {
		Destino = destino;
	}


	public boolean isMoved() {
		return moved;
	}


	public void setMoved(boolean moveu) {
		this.moved = moveu;
	}


	public boolean isAttacked() {
		return attacked;
	}


	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}
	
	
}
