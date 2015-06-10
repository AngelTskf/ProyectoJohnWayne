package Controlador;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Modelo.AccesoFichero;
import Modelo.Articulo;

public class ListaArticulos {
	private ArrayList<Articulo> listaArt=new ArrayList<Articulo>();
	private String fichero = "articulo.dat";
	private boolean crearArchivo=false;

	public ListaArticulos(){
		crearArchivo();
		cargarArticulos();
	}
	
	public void crearNuevoElemento(String nombre, String precio, String descripcion) {
		Articulo instancia = new Articulo(nombre, Float.parseFloat(precio), descripcion);
		guardarNuevoArticulo(instancia);

	}
	
	public void listarArticulos() {
		cargarArticulos();
		for (Articulo articulo : getListaArt()) {
			System.out.println("articulo " + articulo.toString());
		}
	}

	public boolean buscarElemento(String text) {
		for (Articulo articulo : listaArt) {
			if (articulo.toString().equals(text))
				return false;
		}
		return true;
	}
	public void consolaArticulos(){
		for (Articulo articulo : listaArt) {
			System.out.println(articulo.getNombre());
		}
	}

	
	
	public boolean isNumero(String precio) {
		try {
			Float.valueOf(precio);
		} catch (NumberFormatException e1) {
			return false;
		}
		return true;
	}
	public float getPvp(String numero) {
		float precio=convertirNumero(numero);
		return (float) (precio+precio*.10);
	}
	public float convertirNumero(String numero){
		return (float)Float.valueOf(numero);
	}

	// almacena un nuevo articulo
		public void guardarNuevoArticulo(Articulo articulo) {

//			Si el usuario pasa null como parametro guardaré la lista con los mismos
//			articulos que ya tiene
			if (articulo != null  ) {
				getListaArt().add(articulo);
				if (!isCrearArchivo()) {
				//Ordena la lista
				Collections.sort(getListaArt(), new Comparator<Articulo>() {
					@Override
					public int compare(Articulo o1, Articulo o2) {
						return new Integer(o1.getNombre().compareTo(o2.getNombre()));
					}
				});
				}
			}
			try {
				new AccesoFichero().escribirObjeto( fichero,  getListaArt());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			crearArchivo=false;
		}

	public void crearArchivo() {
		/*Comprueba si existe el archivo*/
		File archivo = new File(fichero);
		if (!archivo.exists())
			try {
				archivo.createNewFile();
				guardarNuevoArticulo(null);
				crearArchivo=true;
			} catch (IOException e) {
				
			}
		
	}
		// Leer los articulos del fichero
		public void cargarArticulos() {
			
			if (!crearArchivo) {
				try {
					setListaArt((ArrayList<Articulo>) new AccesoFichero().leerObjeto(fichero));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public ArrayList<Articulo> getListaArt() {
			return listaArt;
		}

		public void setListaArt(ArrayList<Articulo> listaArt) {
			this.listaArt = listaArt;
		}
		

		public boolean isCrearArchivo() {
			return crearArchivo;
		}

		public void setCrearArchivo(boolean crearArchivo) {
			this.crearArchivo = crearArchivo;
		}


}
