package Controlador;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Modelo.Cliente;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PanelModificarCliente extends JPanel {
	protected JTextField txtApellido;
	protected JTextField txtDni;
	protected JTextField txtEdad;
	protected JTextField txtColorPelo;
	protected JTextField txtMensaje;
	ListaClientes listacli;// = new ListaClientes();
	protected JTextField txtNombre;
	protected JButton btnModificar;
	protected Cliente cliente;

	/**
	 * Create the panel.
	 */
	public PanelModificarCliente(ListaClientes lc) {
		listacli = lc;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblAadirCliente = new JLabel("Consultar Cliente");
		GridBagConstraints gbc_lblAadirCliente = new GridBagConstraints();
		gbc_lblAadirCliente.gridwidth = 7;
		gbc_lblAadirCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblAadirCliente.gridx = 0;
		gbc_lblAadirCliente.gridy = 1;
		add(lblAadirCliente, gbc_lblAadirCliente);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.gridwidth = 8;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 121, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblDni = new JLabel("Buscar por DNI:");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 2;
		gbc_lblDni.gridy = 1;
		panel.add(lblDni, gbc_lblDni);

		txtDni = new JTextField();
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.insets = new Insets(0, 0, 5, 5);
		gbc_txtDni.gridx = 3;
		gbc_txtDni.gridy = 1;
		panel.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtDni.getText().equals("")) {
					listacli.cargarLista();

					try {
						cliente = listacli.buscarCliente(txtDni.getText());
						if (cliente != null) {
							txtMensaje.setText("Mostrando datos del cliente con dni " + txtDni.getText());
							txtApellido.setText(cliente.getApellidos());
							txtColorPelo.setText(cliente.getColorPelo());
							txtNombre.setText(cliente.getNombre());
							txtEdad.setText(String.valueOf(cliente.getEdad()));
							txtColorPelo.setEditable(true);
							btnModificar.setEnabled(true);
						} else
							txtMensaje.setText("Cliente no encontrado");

					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente = listacli.buscarCliente(txtDni.getText());
					int posicionLista = listacli.getListaCli().indexOf(cliente);
					if (cliente != null) {
						listacli.cargarLista();
						cliente.setColorPelo(txtColorPelo.getText());
						listacli.modificarElemento(cliente, posicionLista);
						btnModificar.setEnabled(false);
						txtColorPelo.setEditable(false);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModificar.setEnabled(false);

		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.anchor = GridBagConstraints.EAST;
		gbc_btnConsultar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultar.gridx = 4;
		gbc_btnConsultar.gridy = 1;
		panel.add(btnConsultar, gbc_btnConsultar);

		JLabel lblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 3;
		panel.add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.WEST;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 3;
		panel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido: ");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 2;
		gbc_lblApellido.gridy = 4;
		panel.add(lblApellido, gbc_lblApellido);

		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.anchor = GridBagConstraints.WEST;
		gbc_txtApellido.gridx = 3;
		gbc_txtApellido.gridy = 4;
		panel.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);

		JLabel lblEdad = new JLabel("Edad: ");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.EAST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 2;
		gbc_lblEdad.gridy = 5;
		panel.add(lblEdad, gbc_lblEdad);

		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		GridBagConstraints gbc_txtEdad = new GridBagConstraints();
		gbc_txtEdad.anchor = GridBagConstraints.WEST;
		gbc_txtEdad.insets = new Insets(0, 0, 5, 5);
		gbc_txtEdad.gridx = 3;
		gbc_txtEdad.gridy = 5;
		panel.add(txtEdad, gbc_txtEdad);
		txtEdad.setColumns(10);

		JLabel lblColorPelo = new JLabel("Color pelo: ");
		GridBagConstraints gbc_lblColorPelo = new GridBagConstraints();
		gbc_lblColorPelo.anchor = GridBagConstraints.EAST;
		gbc_lblColorPelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorPelo.gridx = 2;
		gbc_lblColorPelo.gridy = 6;
		panel.add(lblColorPelo, gbc_lblColorPelo);

		txtColorPelo = new JTextField();
		txtColorPelo.setEditable(false);
		GridBagConstraints gbc_txtColorPelo = new GridBagConstraints();
		gbc_txtColorPelo.insets = new Insets(0, 0, 5, 5);
		gbc_txtColorPelo.anchor = GridBagConstraints.WEST;
		gbc_txtColorPelo.gridx = 3;
		gbc_txtColorPelo.gridy = 6;
		panel.add(txtColorPelo, gbc_txtColorPelo);
		txtColorPelo.setColumns(10);

		
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 4;
		gbc_btnModificar.gridy = 6;
		panel.add(btnModificar, gbc_btnModificar);

		JLabel lblMensaje = new JLabel("Mensaje: ");
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.anchor = GridBagConstraints.EAST;
		gbc_lblMensaje.insets = new Insets(0, 0, 0, 5);
		gbc_lblMensaje.gridx = 1;
		gbc_lblMensaje.gridy = 8;
		panel.add(lblMensaje, gbc_lblMensaje);

		txtMensaje = new JTextField();
		txtMensaje.setEditable(false);
		GridBagConstraints gbc_txtMensaje = new GridBagConstraints();
		gbc_txtMensaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMensaje.gridwidth = 4;
		gbc_txtMensaje.gridx = 2;
		gbc_txtMensaje.gridy = 8;
		panel.add(txtMensaje, gbc_txtMensaje);
		txtMensaje.setColumns(10);

	}

}
