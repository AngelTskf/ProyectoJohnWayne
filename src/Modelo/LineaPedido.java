package Modelo;

public class LineaPedido {

	String nombreArt;
	int cantidad;
	
	//Constructor
	public LineaPedido(String nombreArt, int cantidad) {
		super();
		this.nombreArt = nombreArt;
		this.cantidad = cantidad;
	}
	
	//Getters and setters
	public String getNombreArt() {
		return nombreArt;
	}
	public void setNombreArt(String nombreArt) {
		this.nombreArt = nombreArt;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
