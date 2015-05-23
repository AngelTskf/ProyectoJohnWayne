package Modelo;

public class Articulo {

	private String nombre;
	private float precio;
	static float iva;
	private String descripcion;
	
	//Constructor
	public Articulo(String nombre, float precio, String descripcion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public float calcularPvp(){
		return (precio * (iva/100));
	}

	//Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public static float getIva() {
		return iva;
	}

	public static void setIva(float iva) {
		Articulo.iva = iva;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
