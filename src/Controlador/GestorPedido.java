package Controlador;

import java.util.ArrayList;

import Modelo.LineaPedido;
import Modelo.Pedido;

public class GestorPedido {

	ArrayList<Pedido> miPedido = new ArrayList<Pedido>();
	
	
	
	public GestorPedido(ArrayList<Pedido> miPedido) {
		super();
		this.miPedido = miPedido;
	}

	public static void cargarLista(){
		
		
		
	}
	
	public static void escribirNewElemento(){
		
		
		
	}
	public static void crearPedido(){
		LineaPedido lineaPedido = new LineaPedido(nombreArt, cantidad);
		Pedido pedido = new Pedido(lineaPedido, cliente, fecha);
	}
	public static void insertarCliente(){
		
	}
}
