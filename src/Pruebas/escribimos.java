package Pruebas;

import java.io.IOException;
import java.util.ArrayList;

import Controlador.ListaClientes;
import Modelo.AccesoFichero;
import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.LineaPedido;
import Modelo.Pedido;

public class escribimos {
public static void main(String[] args) throws ClassNotFoundException, IOException {
	AccesoFichero acceso = new AccesoFichero();
	ListaClientes listaClientes = new ListaClientes();
	listaClientes.cargarLista();
	String ruta = "cliente.dat";
	String rutaDos = "articulo.dat";
	String rutaTres = "pedido.dat";
	String[] nombre = {"Angel", "Jesus","Victor","Juan Antonio","Carlos"};
	String[] dni = {"1","2","3","4","5"};
	String[] color = {"negro","rojo","azul","rubio","verde"};
	String apellido = "DAMPrimero";
	Cliente cliente;
	ArrayList<Cliente>clientes = listaClientes.getListaCli();
	
	for (int i = 0; i < nombre.length; i++) {
		cliente = new Cliente(nombre[i],apellido, dni[i] , 20, color[i]);
		clientes.add(cliente);
	}
	
	Articulo articulo;
	ArrayList<Articulo>articulos = new ArrayList<Articulo>();
	
	
	String[] nombreArt = {"TV","PC","DVD","Tablet"};
	int[] precio = {100, 200, 300, 400};
	String descripcion = "Mas grande";
	
	for (int i = 0; i < precio.length; i++) {
		articulo = new Articulo(nombreArt[i], precio[i], descripcion);
		articulos.add(articulo);
	}
	Pedido pedido;
	ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	int[] cantidad = {1,2,1,1};
	LineaPedido lineaPedido;
	ArrayList<LineaPedido>lineasPedido  = new ArrayList<LineaPedido>();
	
	for (int i = 0; i < precio.length; i++) {
		lineaPedido = new LineaPedido(articulos.get(i), cantidad[i]);
		lineasPedido.add(lineaPedido);
	}
	pedido = new Pedido(1, clientes.get(0), lineasPedido);
	pedidos.add(pedido);
	try {
//		acceso.escribirObjeto(ruta, clientes);
//		acceso.escribirObjeto(rutaDos, articulos);
		acceso.escribirObjeto(rutaTres, pedidos);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
