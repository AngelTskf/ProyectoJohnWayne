package Controlador;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import javax.swing.border.LineBorder;

import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.LineaPedido;
import Modelo.Pedido;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PanelConsultaPedido extends JPanel {
	protected JTextField txtNombre;
	protected JTextField txtApellidos;
	protected JTextField txtDni;
	protected JTextField txtBuscar;
	protected JButton btnBuscar;
	protected JTable tabla;
	protected JTextField txtTotalPed;
	
	

	/**
	 * Create the panel.
	 */

	public PanelConsultaPedido(GestorPedido gp) {
		GestorPedido gestorPedido =  gp;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 250, 488, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 32, 116, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label_2 = new JLabel("  ");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 0;
		add(label_2, gbc_label_2);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblBuscarPedido = new JLabel("Consultar Pedido");
		lblBuscarPedido.setFont(new Font("Arial Black", Font.PLAIN, 17));
		GridBagConstraints gbc_lblBuscarPedido = new GridBagConstraints();
		gbc_lblBuscarPedido.gridwidth = 2;
		gbc_lblBuscarPedido.anchor = GridBagConstraints.WEST;
		gbc_lblBuscarPedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscarPedido.gridx = 1;
		gbc_lblBuscarPedido.gridy = 2;
		add(lblBuscarPedido, gbc_lblBuscarPedido);
		
		JPanel panelNumeroPedido = new JPanel();
		panelNumeroPedido.setBorder(new LineBorder(Color.GRAY, 1, true));
		GridBagConstraints gbc_panelNumeroPedido = new GridBagConstraints();
		gbc_panelNumeroPedido.insets = new Insets(0, 0, 5, 5);
		gbc_panelNumeroPedido.fill = GridBagConstraints.BOTH;
		gbc_panelNumeroPedido.gridx = 1;
		gbc_panelNumeroPedido.gridy = 3;
		add(panelNumeroPedido, gbc_panelNumeroPedido);
		GridBagLayout gbl_panelNumeroPedido = new GridBagLayout();
		gbl_panelNumeroPedido.columnWidths = new int[]{20, 0, 122, 97, 0, 0};
		gbl_panelNumeroPedido.rowHeights = new int[]{10, 0, 10, 0};
		gbl_panelNumeroPedido.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelNumeroPedido.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelNumeroPedido.setLayout(gbl_panelNumeroPedido);
		
		JLabel lblNPedido = new JLabel("Pedido n\u00BA: ");
		GridBagConstraints gbc_lblNPedido = new GridBagConstraints();
		gbc_lblNPedido.anchor = GridBagConstraints.EAST;
		gbc_lblNPedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblNPedido.gridx = 1;
		gbc_lblNPedido.gridy = 1;
		panelNumeroPedido.add(lblNPedido, gbc_lblNPedido);
		
		txtBuscar = new JTextField();
		GridBagConstraints gbc_txtBuscar = new GridBagConstraints();
		gbc_txtBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_txtBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBuscar.gridx = 2;
		gbc_txtBuscar.gridy = 1;
		panelNumeroPedido.add(txtBuscar, gbc_txtBuscar);
		txtBuscar.setColumns(10);
		
		btnBuscar = new JButton("Consultar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtBuscar.getText().isEmpty())
				{
					
					Pedido pedido = null;
					try {
						pedido = gestorPedido.buscarPedido(Integer.parseInt(txtBuscar.getText()));
					} catch (NullPointerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(pedido != null){
						
						Cliente cliente = pedido.getCliente();
						txtDni.setText(cliente.getDni());
						txtNombre.setText(cliente.getNombre());
						txtApellidos.setText(cliente.getApellidos());
						
						
						DefaultTableModel model = (DefaultTableModel) tabla.getModel();
						
						
						ArrayList<LineaPedido> lineasPedido = pedido.getLineaPedido();				
						for (LineaPedido lineaPedido : lineasPedido) {
							model.setRowCount(lineasPedido.size());
							Articulo articulo = lineaPedido.getArticulo();
							model.addRow(new Object[]{articulo.getNombre(), lineaPedido.getCantidad(),String.format("%.02f",articulo.getPvp()),lineaPedido.calculoSubtotal(),
							String.format("%.02f",lineaPedido.calculoSubtotal())});
						}
						
						//numero decimales de precio
						txtTotalPed.setText(String.format("%.02f", pedido.calculoTotalPedido()));
					}
					else
					{
						JOptionPane.showMessageDialog(null,"No existe el pedido");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Introduce el numero del pedido que buscas");
				}
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 2;
		panelNumeroPedido.add(btnBuscar, gbc_btnBuscar);
		
		JPanel panelDatosCliente = new JPanel();
		panelDatosCliente.setBorder(new LineBorder(Color.GRAY, 1, true));
		GridBagConstraints gbc_panelDatosCliente = new GridBagConstraints();
		gbc_panelDatosCliente.insets = new Insets(0, 0, 5, 5);
		gbc_panelDatosCliente.fill = GridBagConstraints.BOTH;
		gbc_panelDatosCliente.gridx = 2;
		gbc_panelDatosCliente.gridy = 3;
		add(panelDatosCliente, gbc_panelDatosCliente);
		GridBagLayout gbl_panelDatosCliente = new GridBagLayout();
		gbl_panelDatosCliente.columnWidths = new int[]{20, 56, 0, 154, 45, 108, 0, 59, 20, 0};
		gbl_panelDatosCliente.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelDatosCliente.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelDatosCliente.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDatosCliente.setLayout(gbl_panelDatosCliente);
		
		JLabel lblDatosCliente = new JLabel("Datos del Cliente");
		lblDatosCliente.setFont(new Font("Arial Black", Font.PLAIN, 15));
		GridBagConstraints gbc_lblDatosCliente = new GridBagConstraints();
		gbc_lblDatosCliente.gridwidth = 9;
		gbc_lblDatosCliente.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatosCliente.gridx = 0;
		gbc_lblDatosCliente.gridy = 0;
		panelDatosCliente.add(lblDatosCliente, gbc_lblDatosCliente);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 1;
		panelDatosCliente.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 1;
		panelDatosCliente.add(txtNombre, gbc_txtNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 2;
		gbc_lblApellidos.gridy = 2;
		panelDatosCliente.add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.gridx = 3;
		gbc_txtApellidos.gridy = 2;
		panelDatosCliente.add(txtApellidos, gbc_txtApellidos);
		
		JLabel lblDni = new JLabel("DNI: ");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 0, 5);
		gbc_lblDni.gridx = 2;
		gbc_lblDni.gridy = 3;
		panelDatosCliente.add(lblDni, gbc_lblDni);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.insets = new Insets(0, 0, 0, 5);
		gbc_txtDni.gridx = 3;
		gbc_txtDni.gridy = 3;
		panelDatosCliente.add(txtDni, gbc_txtDni);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		tabla = new JTable();
		String[] nombresColumnas = { "Concepto", "Cantidad", "Precio", "SubTotal" };
		Object[][] datos = { {} };
		tabla.setFont(new Font("Tahoma", Font.BOLD, 11));
//		tabla.setCellEditor(new DefaultCellEditor(combo));
		tabla.setModel(new DefaultTableModel(datos, nombresColumnas));
		scrollPane.setViewportView(tabla);
		
		JPanel panelTotal = new JPanel();
		GridBagConstraints gbc_panelTotal = new GridBagConstraints();
		gbc_panelTotal.anchor = GridBagConstraints.EAST;
		gbc_panelTotal.insets = new Insets(0, 0, 5, 5);
		gbc_panelTotal.fill = GridBagConstraints.VERTICAL;
		gbc_panelTotal.gridx = 2;
		gbc_panelTotal.gridy = 5;
		add(panelTotal, gbc_panelTotal);
		GridBagLayout gbl_panelTotal = new GridBagLayout();
		gbl_panelTotal.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 46, 0, 0, 0, 0, 50, 0, 0, 0, 0};
		gbl_panelTotal.rowHeights = new int[]{0, 0};
		gbl_panelTotal.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTotal.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTotal.setLayout(gbl_panelTotal);
		
		JLabel lblTotal = new JLabel("Total Coste Pedido:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 21));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.gridwidth = 5;
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 4;
		gbc_lblTotal.gridy = 0;
		panelTotal.add(lblTotal, gbc_lblTotal);
		
		txtTotalPed = new JTextField();
		GridBagConstraints gbc_txtTotalPed = new GridBagConstraints();
		gbc_txtTotalPed.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotalPed.gridwidth = 8;
		gbc_txtTotalPed.gridx = 9;
		gbc_txtTotalPed.gridy = 0;
		panelTotal.add(txtTotalPed, gbc_txtTotalPed);
		txtTotalPed.setEditable(false);
		txtTotalPed.setColumns(10);

	}

}
