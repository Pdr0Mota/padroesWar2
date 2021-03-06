package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.GameController;
import controller.Jogo;
import javax.swing.JList;
import javax.swing.JComboBox;

public class ColorPlayerScreen extends JFrame {

	private GameController war = GameController.getInstance();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String[] cores = {"Verde", "Azul", "Vermelho", "Preto", "Amarelo"};
	
	
	public String[] getCoresFromComboBox(JComboBox[] n) {
		String [] coresEscolhidas = new String[n.length];
		for (int i = 0; i < n.length;i++) {			
			coresEscolhidas[i] = new String( (String)n[i].getSelectedItem());
			System.out.println(coresEscolhidas[i]);			
		}
		
		return coresEscolhidas;
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public ColorPlayerScreen(int n) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 2, 1, 1));
		
		// Panel de labels
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(5, 1, 0, 0));
		
		// Panel de Text
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(5, 1, 0, 0));
		
		JComboBox[] comboBoxCores = new JComboBox[n];
		
		for (int i = 0; i < n; i++) {
			JLabel lblNewLabel_5 = new JLabel("Cor do jogador " + (i+1));
			panel_3.add(lblNewLabel_5);
			
			comboBoxCores[i] = new JComboBox(cores);
			panel_4.add(comboBoxCores[i]);
									
		}		
	
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Escolha as Cores dos Jogadores");
		panel_1.add(lblNewLabel);	
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayerNumberSelection pns = new PlayerNumberSelection();
				pns.setVisible(true);
				dispose();
			}
		});
		panel_2.add(btnVoltar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				war.setJogadores(getCoresFromComboBox(comboBoxCores));
				//war.getJogo().initBaralho();
				war.getJogo().distribuirEstados();
				MainGame mg = new MainGame();
				mg.setVisible(true);
				dispose();
			}
		});
		panel_2.add(btnConfirmar);
		}
	
	
}
