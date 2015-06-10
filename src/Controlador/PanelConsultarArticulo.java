package Controlador;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.Canvas;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.EtchedBorder;

import Modelo.Articulo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelConsultarArticulo extends JPanel {
	protected JPanel panelNorte;
	protected JLabel lblNombre;
	protected JComboBox comboBox;
	protected JLabel lblPrecio;
	protected JTextField txtPrecio;
	protected JLabel lblPvp;
	protected JTextField txtPvp;
	protected JPanel panelCentral;
	protected JLabel lblDescripcion;
	protected JTextArea txtDesc;
	
	protected ListaArticulos listArt;//=new ListaArticulos();
	
	protected Articulo articuloActual;

	/**
	 * Create the panel.
	 */
	public PanelConsultarArticulo(ListaArticulos la) {
		listArt = la;
		setLayout(new BorderLayout(0, 0));
		
		panelNorte = new JPanel();
		panelNorte.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(panelNorte, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorte = new GridBagLayout();
		gbl_panelNorte.columnWidths = new int[]{126, 82, 0, 0, 0, 0, 0, 0};
		gbl_panelNorte.rowHeights = new int[]{0, 39, -4, 0};
		gbl_panelNorte.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelNorte.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelNorte.setLayout(gbl_panelNorte);
		
		lblNombre = new JLabel("Nombre Art\u00EDculo");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panelNorte.add(lblNombre, gbc_lblNombre);
		
		comboBox = new JComboBox();
		/*-----------------------------------------------------------------------------------------------------------------------------COMBOBOX*/
		listArt.cargarArticulos();
		rellenaCombo();
		getComboBox().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				rellenaFormularioArticuloConsulta(e.getItem());
			}

		});
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panelNorte.add(comboBox, gbc_comboBox);
		
		lblPrecio = new JLabel("Precio Art\u00EDculo");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.gridheight = 2;
		gbc_lblPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 1;
		panelNorte.add(lblPrecio, gbc_lblPrecio);
		
		txtPrecio = new JTextField();
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.gridheight = 2;
		gbc_txtPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridx = 1;
		gbc_txtPrecio.gridy = 1;
		panelNorte.add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);
		
		lblPvp = new JLabel("PVP");
		lblPvp.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblPvp = new GridBagConstraints();
		gbc_lblPvp.gridwidth = 2;
		gbc_lblPvp.gridheight = 2;
		gbc_lblPvp.insets = new Insets(0, 0, 0, 5);
		gbc_lblPvp.gridx = 2;
		gbc_lblPvp.gridy = 1;
		panelNorte.add(lblPvp, gbc_lblPvp);
		
		txtPvp = new JTextField();
		GridBagConstraints gbc_txtPvp = new GridBagConstraints();
		gbc_txtPvp.gridwidth = 2;
		gbc_txtPvp.gridheight = 2;
		gbc_txtPvp.insets = new Insets(0, 0, 0, 5);
		gbc_txtPvp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPvp.gridx = 4;
		gbc_txtPvp.gridy = 1;
		panelNorte.add(txtPvp, gbc_txtPvp);
		txtPvp.setColumns(10);
		
		panelCentral = new JPanel();
		panelCentral.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		add(panelCentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCentral.rowHeights = new int[]{0, 39, 0, 0, 0, 0, 0};
		gbl_panelCentral.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCentral.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCentral.setLayout(gbl_panelCentral);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.gridwidth = 2;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 0;
		panelCentral.add(lblDescripcion, gbc_lblDescripcion);
		
		txtDesc = new JTextArea();
		GridBagConstraints gbc_txtDesc = new GridBagConstraints();
		gbc_txtDesc.gridheight = 4;
		gbc_txtDesc.gridwidth = 12;
		gbc_txtDesc.insets = new Insets(0, 0, 5, 5);
		gbc_txtDesc.fill = GridBagConstraints.BOTH;
		gbc_txtDesc.gridx = 1;
		gbc_txtDesc.gridy = 1;
		panelCentral.add(txtDesc, gbc_txtDesc);

	}
	private void rellenaCombo() {
		this.getComboBox().removeAll();
		for (Articulo articulo : listArt.getListaArt()) {
			this.getComboBox().addItem(articulo);
		}
//		articuloActual = rellenaFormularioArticuloConsulta(this.getComboBox().getSelectedItem());

	}
	private Articulo rellenaFormularioArticuloConsulta(Object item) {
		listArt.cargarArticulos();
		Articulo instancia = (Articulo) item;
		this.setTxtPrecio(String.valueOf(instancia.getPrecio()));
		this.setTxtPVP(String.valueOf(instancia.getPvp()));
		this.setTxtDesc(instancia.getDescripcion());
		return instancia;
	}
	public JTextField getTxtPrecio() {
		return txtPrecio;
	}
	public void setTxtPrecio(String txtPrecio) {
		this.txtPrecio.setText(txtPrecio);
	}
	public JTextField getPvp() {
		return txtPvp;
	}
	public void setTxtPVP(String txtPVP) {
		this.txtPvp.setText(txtPVP);
	}
	public JTextArea getTxtDescripcion() {
		return txtDesc;
	}
	public void setTxtDesc(String txtDesc) {
		this.txtDesc.setText(txtDesc);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

}
