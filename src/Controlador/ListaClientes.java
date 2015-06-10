package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Modelo.AccesoFichero;
import Modelo.Cliente;

public class ListaClientes {
	private ArrayList<Cliente> listaCli = new ArrayList<>();
	private String fichero = "cliente.dat";
	private boolean crearArchivo=false;

	public ListaClientes() {
		crearArchivo();
		cargarLista();
	}
	
	public void crearArchivo() {
		/*Comprueba si existe el archivo*/
		File archivo = new File(fichero);
		if (!archivo.exists())
			try {
				archivo.createNewFile();
				escribirNewElemento(null,null ,null , (Integer) null, null);
				crearArchivo=true;
			} catch (IOException e) {
				
			}
		
	}
	
	public void cargarLista(){
		try {
			setListaCli((ArrayList<Cliente>) new AccesoFichero().leerObjeto(fichero));
		} catch (ClassNotFoundException | IOException e) {
			
		}
	}

	public void escribirNewElemento(String nombre, String apellidos, String dni, int edad, String colorPelo)
			throws IOException, FileNotFoundException {
		Cliente cliente = new Cliente(nombre, apellidos, dni, edad, colorPelo);
		// idea buscarcliente
		boolean encontrado = false;
			try {
				Cliente clientebuscado = buscarCliente(cliente.getDni());
				if(clientebuscado!=null){
					encontrado=true;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if (cliente.getNombre() != null&&encontrado==false) {
			
			listaCli.add(cliente);
			Collections.sort(getListaCli(), new Comparator<Cliente>() {
				@Override
				public int compare(Cliente o1, Cliente o2) {

					return new Integer(o1.getApellidos().compareTo(o2.getApellidos()));
				}
			});
		}
		new AccesoFichero().escribirObjeto(fichero, getListaCli());
	}

	public void modificarElemento(Cliente cliente, int posicionLista) {
		
		getListaCli().set(posicionLista, cliente);
		try {
			// Guarda la lista existente con el articulo modificado
			escribirNewElemento(null, null, null, 0, null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarCliente() {
		for (Cliente cliente : listaCli) {
			System.out.println(cliente.getNombre() + " " + cliente.getApellidos() + " " + cliente.getDni() + " "
					+ cliente.getEdad() + " " + cliente.getColorPelo());
		}
		System.out.println();
	}

	public Cliente buscarCliente(String dni) throws ClassNotFoundException, IOException {
		Cliente clienteEncontrado = null;
		for (Cliente listaCli : listaCli) {
			if (listaCli.getDni().equals(dni)) {
				clienteEncontrado = listaCli;
			}
		}
		return clienteEncontrado;
	}
	

	public ArrayList<Cliente> getListaCli() {
		return listaCli;
	}

	public void setListaCli(ArrayList<Cliente> lCliente) {
		this.listaCli = lCliente;
	}
	
}