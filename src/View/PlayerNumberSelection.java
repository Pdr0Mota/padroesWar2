package View;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Game;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.Color;

public class PlayerNumberSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public PlayerNumberSelection() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 115);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha o Numero de Jogadores");
		lblNewLabel.setBounds(10, 11, 191, 21);
		contentPane.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(2, 2, 5, 1));
		spinner.setBounds(211, 11, 54, 20);
		contentPane.add(spinner);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameSelectionScreen ms = new GameSelectionScreen();
				ms.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(52, 43, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confirmar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				int numberOfPlayers = (Integer) spinner.getValue();
				ColorPlayerScreen cps = new ColorPlayerScreen(numberOfPlayers);
				cps.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(151, 43, 114, 23);
		contentPane.add(btnNewButton_1);
	}
}
