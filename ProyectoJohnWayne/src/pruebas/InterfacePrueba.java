package pruebas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JButton;

import Controlador.ListaClientes;
import Modelo.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InterfacePrueba extends JFrame {

	private JPanel contentPane;
	public JComboBox comboBox;
	protected JTextField txtNombre;
	protected JTextField txtApellido;
	protected JTextField txtDni;
	protected JTextField txtEdad;
	protected JTextField txtColPelo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblEdad;
	private JLabel lblColPelo;
	private JButton btnSoyUnBoton;

	ListaClientes lc = new ListaClientes();
	private JButton btnLimpiacoo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePrueba frame = new InterfacePrueba();
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
	public InterfacePrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		contentPane.add(comboBox, gbc_comboBox);

		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 2;
		contentPane.add(lblApellido, gbc_lblApellido);

		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 2;
		contentPane.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);

		lblDni = new JLabel("DNI");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 3;
		contentPane.add(lblDni, gbc_lblDni);

		txtDni = new JTextField();
		GridBagConstraints gbc_textDni = new GridBagConstraints();
		gbc_textDni.insets = new Insets(0, 0, 5, 0);
		gbc_textDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDni.gridx = 1;
		gbc_textDni.gridy = 3;
		contentPane.add(txtDni, gbc_textDni);
		txtDni.setColumns(10);

		lblEdad = new JLabel("Edad");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 4;
		contentPane.add(lblEdad, gbc_lblEdad);

		txtEdad = new JTextField();
		GridBagConstraints gbc_txtEdad = new GridBagConstraints();
		gbc_txtEdad.insets = new Insets(0, 0, 5, 0);
		gbc_txtEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEdad.gridx = 1;
		gbc_txtEdad.gridy = 4;
		contentPane.add(txtEdad, gbc_txtEdad);
		txtEdad.setColumns(10);

		lblColPelo = new JLabel("Color Pelo");
		GridBagConstraints gbc_lblColPelo = new GridBagConstraints();
		gbc_lblColPelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblColPelo.gridx = 0;
		gbc_lblColPelo.gridy = 5;
		contentPane.add(lblColPelo, gbc_lblColPelo);

		txtColPelo = new JTextField();
		GridBagConstraints gbc_txtColPelo = new GridBagConstraints();
		gbc_txtColPelo.insets = new Insets(0, 0, 5, 0);
		gbc_txtColPelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtColPelo.gridx = 1;
		gbc_txtColPelo.gridy = 5;
		contentPane.add(txtColPelo, gbc_txtColPelo);
		txtColPelo.setColumns(10);

		btnSoyUnBoton = new JButton("Soy un boton");
		btnSoyUnBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lc.escribirNewElemento(txtNombre.getText(), txtApellido.getText(), txtDni.getText(),
							txtEdad.getText(), txtColPelo.getText());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				listar();
				limpiar();
			}
		});
		GridBagConstraints gbc_btnSoyUnBoton = new GridBagConstraints();
		gbc_btnSoyUnBoton.insets = new Insets(0, 0, 5, 5);
		gbc_btnSoyUnBoton.gridx = 0;
		gbc_btnSoyUnBoton.gridy = 6;
		contentPane.add(btnSoyUnBoton, gbc_btnSoyUnBoton);
		
	}
	public void listar(){
		for (int i = 0; i < lc.getListaCli().size(); i++) {
			System.out
					.println(lc.getListaCli().get(i).getNombre() + " " + lc.getListaCli().get(i).getApellidos() + " "
							+ lc.getListaCli().get(i).getDni() + " " + lc.getListaCli().get(i).getEdad() + " "
							+ lc.getListaCli().get(i).getColorPelo());
		}
		System.out.println();
	}
	public void limpiar(){
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtColPelo.setText("");
	}
}
