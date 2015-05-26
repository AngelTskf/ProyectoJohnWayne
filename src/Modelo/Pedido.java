package Modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Pedido {
	
	private ArrayList<LineaPedido> lineaPedido = new ArrayList<LineaPedido>();
	private Cliente cliente = null;
	private Date fecha = null;
	
	//Constructor
	public Pedido(ArrayList<LineaPedido> lineaPedido, Cliente cliente,
			Date fecha) {
		super();
		this.lineaPedido = lineaPedido;
		this.cliente = cliente;
		this.fecha = fecha;
	}

	//Getters and setters
	public ArrayList<LineaPedido> getLineaPedido() {
		return lineaPedido;
	}

	public void setLineaPedido(ArrayList<LineaPedido> lineaPedido) {
		this.lineaPedido = lineaPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
