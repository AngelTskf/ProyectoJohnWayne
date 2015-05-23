package Controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Modelo.AccesoFichero;
import Modelo.Articulo;
import Modelo.Cliente;

public class ListaClientes {
	private ArrayList<Cliente> listaCli = new ArrayList<>();
	final String fichero = "articulos.dat";
	public void cargarLista() throws ClassNotFoundException, IOException {
		setListaCli((ArrayList<Cliente>) new AccesoFichero().leerObjeto(fichero));
	}

	public void escribirNewElemento(String nombre,String apellidos,String dni,String edad,String colorPelo) throws IOException, FileNotFoundException{
		Cliente cliente = new Cliente(nombre, apellidos, dni, Integer.parseInt(edad), colorPelo);
		if (cliente != null) {
			listaCli.add(cliente);
			Collections.sort(getListaCli(), new Comparator<Cliente>() {
				@Override
				public int compare(Cliente o1, Cliente o2) {
					// Integer valor=new
					// Integer(o1.getNombre().compareTo(o2.getNombre()));
					// System.out.println("valor de la comparacion "+valor);
					// return valor;
					return new Integer(o1.getNombre().compareTo(o2.getNombre()));
				}
			});
		}
		new AccesoFichero().escribirObjeto(fichero, getListaCli());
	}

	public ArrayList<Cliente> getListaCli() {
		return listaCli;
	}

	public void setListaCli(ArrayList<Cliente> lCliente) {
		this.listaCli = lCliente;
	}
}
