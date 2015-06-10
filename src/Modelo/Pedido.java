package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.Vector;

public class Pedido implements Serializable{
	private int numPedido;
	private Cliente cliente;
	private ArrayList<LineaPedido> lineaPedido = new ArrayList<LineaPedido>();

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	// Constructor
	public Pedido(int numPedido, Cliente cliente, ArrayList<LineaPedido> lineaPedido) {
		super();
		this.numPedido = numPedido;
		this.cliente = cliente;
		this.lineaPedido = lineaPedido;
	}

	@Override
	public String toString() {
		
		return super.toString();
	}
	
	// Getters and Setters
	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<LineaPedido> getLineaPedido() {
		return lineaPedido;
	}

	public void setLineaPedido(ArrayList<LineaPedido> lineaPedido) {
		this.lineaPedido = lineaPedido;
	}
	
	public float calculoTotalPedido() {
		float total = 0;
		for (int i = 0; i < lineaPedido.size(); i++) {
			total = total + lineaPedido.get(i).calculoSubtotal();
		}
		return total;
	}
}
