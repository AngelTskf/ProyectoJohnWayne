package Controlador;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JTextArea;

import java.awt.Canvas;

import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelIntroducirArticulo extends JPanel {
	protected JPanel panelNorte;
	protected JLabel lblIntroducir;
	protected JTextField txtArticulo;
	protected JLabel lblPrecio;
	protected JTextField txtPrecio;
	protected JPanel panelCentral;
	protected JLabel lblIPvp;
	protected JTextField txtPvp;
	protected JLabel lblDescripcion;
	protected JTextArea txtAreaDescripcion;
	protected JButton btnComprobarArticulo;
	protected JButton btnIntroducirArticulo;
	protected JPanel panelSur;
	protected JLabel lblMensaje;
	protected JTextField txtMensaje;
	
	protected ListaArticulos listArt;//=new ListaArticulos();

	/**
	 * Create the panel.
	 */
	public PanelIntroducirArticulo(ListaArticulos la) {
		listArt = la;
		setLayout(new BorderLayout(0, 0));
		
		panelNorte = new JPanel();
		panelNorte.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panelNorte, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorte = new GridBagLayout();
		gbl_panelNorte.columnWidths = new int[]{83, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelNorte.rowHeights = new int[]{0, 0, 0};
		gbl_panelNorte.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelNorte.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelNorte.setLayout(gbl_panelNorte);
		
		lblIntroducir = new JLabel("Art\u00EDculo a Introducir");
		lblIntroducir.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblIntroducir = new GridBagConstraints();
		gbc_lblIntroducir.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntroducir.gridx = 0;
		gbc_lblIntroducir.gridy = 0;
		panelNorte.add(lblIntroducir, gbc_lblIntroducir);
		
		txtArticulo = new JTextField();
		GridBagConstraints gbc_txtArticulo = new GridBagConstraints();
		gbc_txtArticulo.gridwidth = 4;
		gbc_txtArticulo.insets = new Insets(0, 0, 5, 5);
		gbc_txtArticulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtArticulo.gridx = 1;
		gbc_txtArticulo.gridy = 0;
		panelNorte.add(txtArticulo, gbc_txtArticulo);
		txtArticulo.setColumns(10);
		
		lblPrecio = new JLabel("Indicar un Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 1;
		panelNorte.add(lblPrecio, gbc_lblPrecio);
		
		txtPrecio = new JTextField();
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.gridwidth = 2;
		gbc_txtPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridx = 1;
		gbc_txtPrecio.gridy = 1;
		panelNorte.add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);
		
		panelCentral = new JPanel();
		panelCentral.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panelCentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWidths = new int[]{0, 0, 22, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCentral.rowHeights = new int[]{7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCentral.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCentral.setLayout(gbl_panelCentral);
		
		lblIPvp = new JLabel("PVP");
		lblIPvp.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblIPvp = new GridBagConstraints();
		gbc_lblIPvp.gridwidth = 4;
		gbc_lblIPvp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIPvp.gridx = 0;
		gbc_lblIPvp.gridy = 1;
		panelCentral.add(lblIPvp, gbc_lblIPvp);
		
		txtPvp = new JTextField();
		GridBagConstraints gbc_txtPvp = new GridBagConstraints();
		gbc_txtPvp.gridwidth = 10;
		gbc_txtPvp.insets = new Insets(0, 0, 5, 5);
		gbc_txtPvp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPvp.gridx = 4;
		gbc_txtPvp.gridy = 1;
		panelCentral.add(txtPvp, gbc_txtPvp);
		txtPvp.setEditable(false);
		txtPvp.setColumns(10);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.gridwidth = 4;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 2;
		gbc_lblDescripcion.gridy = 2;
		panelCentral.add(lblDescripcion, gbc_lblDescripcion);
		
		txtAreaDescripcion = new JTextArea();
		GridBagConstraints gbc_txtAreaDescripcion = new GridBagConstraints();
		gbc_txtAreaDescripcion.gridheight = 5;
		gbc_txtAreaDescripcion.gridwidth = 12;
		gbc_txtAreaDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtAreaDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtAreaDescripcion.gridx = 2;
		gbc_txtAreaDescripcion.gridy = 3;
		panelCentral.add(txtAreaDescripcion, gbc_txtAreaDescripcion);
		
		btnComprobarArticulo = new JButton("Comprobar Art\u00EDculo");
		/*----------------------------------------------------------------------------------------------------------------BOTON COMPROBAR*/
		btnComprobarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean hazlo = true;
				boolean hazloDos = true;
				if (!listArt.isCrearArchivo()) {
					hazlo=listArt.buscarElemento(txtArticulo.getText());
					hazloDos=listArt.isNumero(txtPrecio.getText());
				}
				
				if (!hazlo) {
					txtMensaje.setText("Articulo no valido");
				}
				if (hazlo && !hazloDos) {
					txtMensaje.setText("Precio no valido");
				}
				if (hazlo && hazloDos) {
					btnIntroducirArticulo.setEnabled(true);
					txtMensaje.setText("Cliente valido");	
					txtArticulo.setEnabled(false);
					txtPrecio.setEnabled(false);
					txtAreaDescripcion.setEnabled(false);
					txtPvp.setText(Float.toString(listArt.getPvp(txtPrecio.getText())));
				}
				
				
			}
		});
		btnComprobarArticulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnComprobarArticulo = new GridBagConstraints();
		gbc_btnComprobarArticulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnComprobarArticulo.gridwidth = 4;
		gbc_btnComprobarArticulo.insets = new Insets(0, 0, 5, 5);
		gbc_btnComprobarArticulo.gridx = 2;
		gbc_btnComprobarArticulo.gridy = 9;
		panelCentral.add(btnComprobarArticulo, gbc_btnComprobarArticulo);
		
		btnIntroducirArticulo = new JButton("Introducir Art\u00EDculo");
		btnIntroducirArticulo.setEnabled(false);
		/*--------------------------------------------------------------------------------------------------------------------------------BOTON INTRODUCIR*/
		btnIntroducirArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listArt.crearNuevoElemento(txtArticulo.getText(), txtPrecio.getText(), txtAreaDescripcion.getText());
				txtArticulo.setEnabled(true);
				txtPrecio.setEnabled(true);
				txtAreaDescripcion.setEnabled(true);
				btnIntroducirArticulo.setEnabled(false);
				btnComprobarArticulo.setEnabled(true);
				
				
			}
		});
		if (listArt.isCrearArchivo()) {
			btnComprobarArticulo.setEnabled(false);
			btnIntroducirArticulo.setEnabled(true);
		}
		btnIntroducirArticulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnIntroducirArticulo = new GridBagConstraints();
		gbc_btnIntroducirArticulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIntroducirArticulo.gridwidth = 5;
		gbc_btnIntroducirArticulo.insets = new Insets(0, 0, 5, 5);
		gbc_btnIntroducirArticulo.gridx = 9;
		gbc_btnIntroducirArticulo.gridy = 9;
		panelCentral.add(btnIntroducirArticulo, gbc_btnIntroducirArticulo);
		
		panelSur = new JPanel();
		panelSur.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panelSur, BorderLayout.SOUTH);
		GridBagLayout gbl_panelSur = new GridBagLayout();
		gbl_panelSur.columnWidths = new int[]{30, 0, 181, 0, 0, 0, 0, 0};
		gbl_panelSur.rowHeights = new int[]{0, 0};
		gbl_panelSur.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSur.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelSur.setLayout(gbl_panelSur);
		
		lblMensaje = new JLabel("Mensaje");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.insets = new Insets(0, 0, 0, 5);
		gbc_lblMensaje.gridx = 0;
		gbc_lblMensaje.gridy = 0;
		panelSur.add(lblMensaje, gbc_lblMensaje);
		
		txtMensaje = new JTextField();
		GridBagConstraints gbc_txtMensaje = new GridBagConstraints();
		gbc_txtMensaje.gridwidth = 3;
		gbc_txtMensaje.insets = new Insets(0, 0, 0, 5);
		gbc_txtMensaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMensaje.gridx = 2;
		gbc_txtMensaje.gridy = 0;
		panelSur.add(txtMensaje, gbc_txtMensaje);
		txtMensaje.setColumns(10);

	}

}
