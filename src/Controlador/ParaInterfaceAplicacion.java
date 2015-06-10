package Controlador;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ParaInterfaceAplicacion extends JFrame {

	PanelIntroducirArticulo introArt;
	PanelConsultarArticulo consArt;
	PanelNuevoPedido newPed;
	PanelAnadirCliente anadirCli;
	PanelConsultarCliente consCli;
	PanelModificarCliente modCli;
	PanelConsultaPedido consPed;
	protected JPanel contentPane;
	protected JPanel panel;
	CardLayout card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaInterfaceAplicacion frame = new ParaInterfaceAplicacion();
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
	public ParaInterfaceAplicacion() {
		ListaArticulos listaArt = new ListaArticulos();
		ListaClientes listaCli = new ListaClientes();
		GestorPedido gestorPedido =  new GestorPedido();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		card = new CardLayout();
		contentPane.setLayout(card);

		introArt = new PanelIntroducirArticulo(listaArt);
		contentPane.add(introArt, "introArt");

		consArt = new PanelConsultarArticulo(listaArt);
		contentPane.add(consArt, "consArt");

		newPed = new PanelNuevoPedido(listaArt,listaCli,gestorPedido);
		contentPane.add(newPed, "newPed");

		consPed = new PanelConsultaPedido(gestorPedido);
		contentPane.add(consPed, "consPed");

		anadirCli = new PanelAnadirCliente(listaCli);
		contentPane.add(anadirCli, "anadirCli");

		consCli = new PanelConsultarCliente(listaCli);
		contentPane.add(consCli, "consCli");
		
		modCli = new PanelModificarCliente(listaCli);
		contentPane.add(modCli,"modCli");

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		JMenuItem mntmDarDeAlta = new JMenuItem("Dar de Alta");
		mntmDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaCli.cargarLista();
				card.show(contentPane, "anadirCli");
			}
		});
		mnCliente.add(mntmDarDeAlta);

		JMenuItem mntmConsultarCliente = new JMenuItem("Consultar Cliente");
		mntmConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaCli.cargarLista();
				card.show(contentPane, "consCli");
			}
		});
		mnCliente.add(mntmConsultarCliente);

		JMenuItem mntmModificarCliente = new JMenuItem("Modificar Cliente");
		mntmModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "modCli");
			}
		});
		mnCliente.add(mntmModificarCliente);

		JMenu mnArticulo = new JMenu("Articulo");
		menuBar.add(mnArticulo);

		JMenuItem mntmNuevoArticulo = new JMenuItem("Nuevo Articulo");
		mntmNuevoArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaArt.cargarArticulos();
				card.show(contentPane, "introArt");
			}
		});
		mnArticulo.add(mntmNuevoArticulo);

		JMenuItem mntmConsultarArticulo = new JMenuItem("Consultar Articulo");
		mntmConsultarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaArt.cargarArticulos();
				card.show(contentPane, "consArt");
			}
		});
		mnArticulo.add(mntmConsultarArticulo);

		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);

		JMenuItem mntmNuevoPedido = new JMenuItem("Nuevo Pedido");
		mntmNuevoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				listaArt.cargarArticulos();
//				listaCli.cargarLista();
				card.show(contentPane, "newPed");
			}
		});
		mnPedido.add(mntmNuevoPedido);

		JMenuItem mntmConsultarPedido = new JMenuItem("Consultar Pedido");
		mntmConsultarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "consPed");
			}
		});
		mnPedido.add(mntmConsultarPedido);
		introArt = new PanelIntroducirArticulo(listaArt);

	}

}
