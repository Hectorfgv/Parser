package parserlibro;

import java.util.ArrayList;

public class Autor {
	
	private String nombre;
	private String apellido;
	public Autor(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return " Autor: [nombre=" + nombre + ", apellido=" + apellido + "]";
	}	
}