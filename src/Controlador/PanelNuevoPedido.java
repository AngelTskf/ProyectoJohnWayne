package Controlador;

import javax.print.attribute.standard.DateTimeAtCreation;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import java.awt.Insets;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.LineaPedido;
import Modelo.Pedido;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelNuevoPedido extends JPanel {
	protected JPanel panelNorte;
	protected JLabel lblCliente;
	protected JComboBox comboBoxCliente;
	protected JPanel panelCentral;
	protected JScrollPane scrollPane;
	protected JTable table;
	protected JPanel panelSur;
	protected JButton btnAnadirLinea;
	protected JButton btnGuardarPedido;
	
	JComboBox comboDos = new JComboBox();
	ListaClientes listaClientes;
	ListaArticulos listaArticulos;
	LineaPedido lineaPedido;
	LineaPedido miLineaPedido;
	ArrayList<LineaPedido> lineasPedido;
	Cliente cliente;
	private JButton btnEliminarLinea;
	private JButton btnNewButton;
	
	/**
	 * Create the panel.
	 */
	public PanelNuevoPedido(ListaArticulos la, ListaClientes lc, GestorPedido gp ) {
		listaArticulos = la;//new ListaArticulos();
		listaClientes = lc;//new ListaClientes();
		GestorPedido gestorPedido = gp;// new GestorPedido();
		//el primer pedido
		try {
			gestorPedido.crearPedido(gestorPedido.calcularNumPedido(),  new ArrayList<LineaPedido>());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//para el primero
		
		setLayout(new BorderLayout(0, 0));
		panelNorte = new JPanel();
		add(panelNorte, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorte = new GridBagLayout();
		gbl_panelNorte.columnWidths = new int[] { 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelNorte.rowHeights = new int[] { 0, 0 };
		gbl_panelNorte.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panelNorte.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelNorte.setLayout(gbl_panelNorte);

		lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 0, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		panelNorte.add(lblCliente, gbc_lblCliente);

		comboBoxCliente = new JComboBox();
		rellenaComboCliente(comboBoxCliente);
		
		GridBagConstraints gbc_comboBoxCliente = new GridBagConstraints();
		gbc_comboBoxCliente.gridwidth = 5;
		gbc_comboBoxCliente.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCliente.gridx = 1;
		gbc_comboBoxCliente.gridy = 0;
		panelNorte.add(comboBoxCliente, gbc_comboBoxCliente);

		panelCentral = new JPanel();
		add(panelCentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWidths = new int[] { 0, 0 };
		gbl_panelCentral.rowHeights = new int[] { 28, 0, 0 };
		gbl_panelCentral.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelCentral.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panelCentral.setLayout(gbl_panelCentral);

		scrollPane = new JScrollPane();
		panelCentral.add(scrollPane);
		JComboBox combo = new JComboBox();
		// Pongamos nombres a las columnas
		String[] nombresColumnas = { "Concepto", "Cantidad", "Precio", "SubTotal" };
		Object[][] datos = { {} };
		table = new JTable();
		
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setCellEditor(new DefaultCellEditor(combo));
		table.setModel(new DefaultTableModel(datos, nombresColumnas));
		scrollPane.setViewportView(table);

		// Como meter un combox en una celda
		
		rellenaComboArticulo(comboDos);
		// extraer la columna de la tabla
		TableColumn tc = table.getColumnModel().getColumn(0);
		// Crear un editor de celdas del tipo combobox
		TableCellEditor tce = new DefaultCellEditor(comboDos);
		// Asociar la columna al nuevo editor de combobox
		tc.setCellEditor(tce);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panelCentral.add(scrollPane, gbc_scrollPane);
		
		panelSur = new JPanel();
		add(panelSur, BorderLayout.SOUTH);
		GridBagLayout gbl_panelSur = new GridBagLayout();
		gbl_panelSur.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelSur.rowHeights = new int[]{0, 0};
		gbl_panelSur.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelSur.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelSur.setLayout(gbl_panelSur);
		
		
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		btnAnadirLinea = new JButton("A\u00F1adir L\u00EDnea");
		btnAnadirLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				int fila = table.getSelectedRow();
				gestorPedido.crearLineaPedido((Articulo)comboDos.getSelectedItem(),  Integer.parseInt((String) table.getModel().getValueAt(fila, 1)));
				modelo.addRow(new Object[] {"","","",""});
				
			}
		});
		GridBagConstraints gbc_btnAnadirLinea = new GridBagConstraints();
		gbc_btnAnadirLinea.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnadirLinea.gridwidth = 2;
		gbc_btnAnadirLinea.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnadirLinea.gridx = 1;
		gbc_btnAnadirLinea.gridy = 0;
		panelSur.add(btnAnadirLinea, gbc_btnAnadirLinea);
		btnGuardarPedido = new JButton("Guardar Pedido");
		btnGuardarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cliente = (Cliente) comboBoxCliente.getSelectedItem();
				gestorPedido.insertarCliente(cliente);
				Pedido instancia = new Pedido();
				try {
					//try {
						//gestorPedido.crearPedido(gestorPedido.calcularNumPedido(), cliente.getDni(), instancia.getLineaPedido());
						
	
					int fila = table.getSelectedRow();
						gestorPedido.crearLineaPedido((Articulo)comboDos.getSelectedItem(),  Integer.parseInt((String) table.getModel().getValueAt(fila, 1)));
				
						
						
						
						
						//gestorPedido.confirmarLinea(miLineaPedido);
						
						Pedido pedido = gestorPedido.pedido;
						//pedido.setNumPedido(???);
						//pedido.setNumPedido(1);
						gestorPedido.escribirNuevoElemento(pedido);
						
						//Para el siguiente
						gestorPedido.crearPedido(gestorPedido.calcularNumPedido(),  new ArrayList<LineaPedido>());
//					} catch (ClassNotFoundException | IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		btnEliminarLinea = new JButton("Eliminar linea");
		btnEliminarLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modelo.getRowCount() > 1) {
					modelo.removeRow(modelo.getRowCount()-1);
				}
			}
		});
		GridBagConstraints gbc_btnEliminarLinea = new GridBagConstraints();
		gbc_btnEliminarLinea.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminarLinea.gridx = 5;
		gbc_btnEliminarLinea.gridy = 0;
		panelSur.add(btnEliminarLinea, gbc_btnEliminarLinea);
		
		btnNewButton = new JButton("Completar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Articulo articulo = (Articulo) comboDos.getSelectedItem();
				int cantidad = 0;
				try {
					cantidad = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 1));
					modelo.setValueAt(articulo.getPvp(), table.getSelectedRow(), 2);
					
					lineaPedido = new LineaPedido(articulo, cantidad);
					gestorPedido.confirmarLinea(lineaPedido);
					
					modelo.setValueAt(lineaPedido.calculoSubtotal(), table.getSelectedRow(), 3);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				miLineaPedido = new LineaPedido(articulo, cantidad);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 0;
		panelSur.add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_btnGuardarPedido = new GridBagConstraints();
		gbc_btnGuardarPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarPedido.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardarPedido.gridx = 10;
		gbc_btnGuardarPedido.gridy = 0;
		panelSur.add(btnGuardarPedido, gbc_btnGuardarPedido);
	}

	private void rellenaComboCliente(JComboBox<Cliente>comboBoxCliente) {
		comboBoxCliente.removeAll();
		listaClientes.cargarLista();
		for (Cliente cliente : listaClientes.getListaCli()) {
			comboBoxCliente.addItem(cliente);
		}
	}
	
	private void rellenaComboArticulo(JComboBox<Articulo>comboDos){
		comboDos.removeAll();
		listaArticulos.cargarArticulos();
		for (Articulo articulo : listaArticulos.getListaArt()) {
			comboDos.addItem(articulo);
		}
	}

	public JPanel getPanelNorte() {
		return panelNorte;
	}

	public void setPanelNorte(JPanel panelNorte) {
		this.panelNorte = panelNorte;
	}

	public JLabel getLblCliente() {
		return lblCliente;
	}

	public void setLblCliente(JLabel lblCliente) {
		this.lblCliente = lblCliente;
	}

	public JComboBox getComboBoxCliente() {
		return comboBoxCliente;
	}

	public void setComboBoxCliente(JComboBox comboBoxCliente) {
		this.comboBoxCliente = comboBoxCliente;
	}

	public JPanel getPanelCentral() {
		return panelCentral;
	}

	public void setPanelCentral(JPanel panelCentral) {
		this.panelCentral = panelCentral;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getbtnAnadirLinea() {
		return btnAnadirLinea;
	}

	public void setbtnAnadirLinea(JButton btnAnadirLinea) {
		this.btnAnadirLinea = btnAnadirLinea;
	}

	public ListaClientes getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ListaClientes listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ListaArticulos getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(ListaArticulos listaArticulos) {
		this.listaArticulos = listaArticulos;
	}

}
