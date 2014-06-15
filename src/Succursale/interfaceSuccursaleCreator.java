package Succursale;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class interfaceSuccursaleCreator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultListModel model;
	private JTextField textFieldIP;
	private JTextField textFieldPort;
	private JTextField textFieldSolde;
	public interfaceSuccursaleCreator() {
		initUI();
	}

	private void initUI() {


		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setToolTipText("A Panel container");
		panel.setLayout(null);

		JLabel lblListeDesSuccursales = new JLabel("Cr\u00E9ateur succursale :");
		lblListeDesSuccursales.setBounds(10, 11, 174, 19);
		lblListeDesSuccursales.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblListeDesSuccursales);

		textFieldIP = new JTextField();
		textFieldIP.setText("127.0.0.1");
		textFieldIP.setBounds(152, 45, 169, 27);
		panel.add(textFieldIP);
		textFieldIP.setColumns(10);

		textFieldPort = new JTextField();
		textFieldPort.setText("9001");
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(152, 75, 57, 27);
		panel.add(textFieldPort);

		JLabel lblServeurDeLa = new JLabel("Serveur de la banque :");
		lblServeurDeLa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblServeurDeLa.setBounds(10, 44, 142, 27);
		panel.add(lblServeurDeLa);

		JLabel lblPort = new JLabel("Port :");
		lblPort.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPort.setBounds(112, 74, 35, 27);
		panel.add(lblPort);

		JButton btnNewButton = new JButton("Cr\u00E9er Succursale");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((textFieldIP.getText().toString().trim()=="") || 
						(textFieldPort.getText().toString().trim()=="") ||
						(textFieldSolde.getText().toString().trim()=="")){
					JOptionPane.showConfirmDialog(null, "Veuillez remplir les trois champs");
					//return;
				}else{
					Thread t = new Thread(new Succursale(textFieldIP.getText(),
							Integer.valueOf(textFieldPort.getText()),
							Integer.valueOf(textFieldSolde.getText())));
					t.start();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(152, 147, 134, 35);
		panel.add(btnNewButton);

		textFieldSolde = new JTextField();
		textFieldSolde.setText("20");
		textFieldSolde.setColumns(10);
		textFieldSolde.setBounds(152, 113, 57, 27);
		panel.add(textFieldSolde);

		JLabel lblMontantInitial = new JLabel("Montant initial :");
		lblMontantInitial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMontantInitial.setBounds(48, 112, 99, 27);
		panel.add(lblMontantInitial);
		setTitle("Créer succursale.");
		setSize(401, 233);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	public static void main(String [] args)
	{
		new interfaceSuccursaleCreator();
	}
}