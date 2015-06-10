package Modelo;

import java.io.Serializable;

public class Articulo implements Serializable {
	private String nombre;
	private float precio;
	private String descripcion;
	
	
	
	public Articulo(String nombre, float precio, String descripcion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	
	}
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	public float getPvp() {
		return (float) (precio+precio*.10);
	}

}
