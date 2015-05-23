package pruebas;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controlador.ListaClientes;
import Modelo.Cliente;

public class principal {
public static void main(String[] args) {
	ListaClientes lc=new ListaClientes();
	try {
		lc.escribirNewElemento("Juan Antonio", "Garcia", "1", "19", "Castaño");
		lc.escribirNewElemento("Angel", "Valverde", "2", "23", "Castaño");
//		lc.cargarLista();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
