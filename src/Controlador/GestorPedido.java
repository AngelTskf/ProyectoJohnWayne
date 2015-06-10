package Controlador;

import java.awt.dnd.DnDConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Vector;

import Modelo.AccesoFichero;
import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.LineaPedido;
import Modelo.Pedido;

public class GestorPedido {
	ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();
	Pedido pedido;
	LineaPedido linea;
	ListaClientes listaClientes;
	ListaArticulos listaArticulos;
	AccesoFichero accesoFichero = new AccesoFichero();
	String fichero = "pedido.dat";
	private boolean crearArchivo=false;

	public GestorPedido() {
		pedido = new Pedido();
		listaClientes = new ListaClientes();
		listaArticulos = new ListaArticulos();
		crearArchivo();
		cargarLista();
	}
	public void crearArchivo() {
		/*Comprueba si existe el archivo*/
		File archivo = new File(fichero);
		if (!archivo.exists())
			try {
				archivo.createNewFile();
				crearArchivo=true;
			} catch (IOException e) {
				
			}
		
	}

	public void crearPedido(int numPedido, ArrayList<LineaPedido> lineaPedido)
			throws ClassNotFoundException, IOException {
		pedido = new Pedido();
		pedido.setNumPedido(numPedido);
		pedido.setLineaPedido(lineaPedido);
		
	}
	
	public Pedido buscarPedido(int numero) {
		
			//cargarLista();
			Pedido pedidoBuscado = null;
			for (Pedido pedidoAux : getListaPedido()) {
				if (pedidoAux.getNumPedido() == numero) {
					//pedidoBuscado = pedidoAux;
					pedidoBuscado = pedidoAux;
				}
			}
			return pedidoBuscado;
		
	}

	public void cargarLista() {
		try {
			setListaPedido((ArrayList<Pedido>) accesoFichero.leerObjeto("pedido.dat"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void escribirNuevoElemento(Pedido pedido){
		//Si se encuentra un pedido con el mismo numero de pedido no se escribirá
		Pedido pedidoBuscado = buscarPedido(pedido.getNumPedido());

		boolean encontrado = false;
		if(pedidoBuscado!=null){
			encontrado=true;
		}
	
	if (pedido.getNumPedido() != 0 && encontrado==false) {
		
		listaPedido.add(pedido);
		
	}
	try {
		new AccesoFichero().escribirObjeto(fichero, getListaPedido());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public int calcularNumPedido(){
		
		//hazlo otra vez anda
		Pedido pedidoAux;
		int todosPedidos = listaPedido.size();
		int numeroPedido = 0;
		if (todosPedidos == 0) {
			numeroPedido = 1;
		} else {
			System.out.println(numeroPedido = todosPedidos + 1);
			numeroPedido = todosPedidos + 1;
		}
		
		 return numeroPedido;
	}

	public void insertarCliente(Cliente c){
		pedido.setCliente(c);
	}
	public Cliente insertarCliente(String dni) throws ClassNotFoundException, IOException {
		Cliente cliente = listaClientes.buscarCliente(dni);
		return cliente;
	}

	public void crearLineaPedido(Articulo articulo, int cantidad) {
		linea = new LineaPedido(articulo, cantidad);
		pedido.getLineaPedido().add(linea);
	}

	public void confirmarLinea(LineaPedido linea) {
		//ArrayList<LineaPedido> lineasPedido = new ArrayList<LineaPedido>();
		//pedido.getLineaPedido().add(linea);
		//lineasPedido.add(linea);
		//pedido.setLineaPedido(lineasPedido);
	}
	public ArrayList<Pedido> getListaPedido() {
		return listaPedido;
	}
	public void setListaPedido(ArrayList<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}
}
