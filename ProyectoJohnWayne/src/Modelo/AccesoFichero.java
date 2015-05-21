
package Modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AccesoFichero {

	public Object leerObjeto(String ruta) throws IOException, ClassNotFoundException{
		
		FileInputStream archivoR = new FileInputStream(ruta);
		BufferedInputStream bufferR = new BufferedInputStream(archivoR);
		ObjectInputStream objLectura = new ObjectInputStream(bufferR);
		
		return objLectura.readObject();
		
	}
	
	public void escribirObjeto(String ruta, Object obj) throws IOException{
		
		FileOutputStream archivoW = new FileOutputStream(ruta);
		BufferedOutputStream bufferW = new BufferedOutputStream(archivoW);
		ObjectOutputStream objEscritura = new ObjectOutputStream(bufferW);
		
		objEscritura.writeObject(obj);
		objEscritura.close();
		
	}
}
