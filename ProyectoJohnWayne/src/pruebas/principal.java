package pruebas;

import Controlador.ListaClientes;
import Modelo.Cliente;

public class principal {
public static void main(String[] args) {
	ListaClientes lc=new ListaClientes();
	Cliente cli=new Cliente("Juan Antonio", "Garcia", "1", 19, "Casta�o");
	Cliente cli2=new Cliente("Angel", "Valverde", "2", 23, "Casta�o");
	lc.escribirNewElemento(cli);
	lc.escribirNewElemento(cli2);
	lc.cargarLista();
}
}
