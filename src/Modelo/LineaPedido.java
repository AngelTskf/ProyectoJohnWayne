package Modelo;

import java.io.Serializable;

public class LineaPedido implements Serializable{
	private Articulo articulo;
	private int cantidad;

	// Constructor
	public LineaPedido(Articulo articulo, int cantidad) {
		
		if (articulo != null && cantidad != 0) {
			this.articulo = articulo;
			this.cantidad = cantidad;
		} else {
			this.articulo = null;
			this.cantidad = 0;
		}
	}

	// Getters and Setters
	public Articulo getArticulo() {
		return articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float calculoSubtotal(){
		if (articulo != null && cantidad != 0) {
			return (articulo.getPvp() * cantidad);
		}
		return 0;
	}
}
