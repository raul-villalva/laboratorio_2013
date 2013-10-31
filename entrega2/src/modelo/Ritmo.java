package modelo;

import java.util.ArrayList;

public class Ritmo {
	
	private String nombre;
	private ArrayList<Paso> pasos = new ArrayList<Paso>();

	/**
	 * @return the pasos
	 */
	public ArrayList<Paso> getPasos() {
		return pasos;
	}

	/**
	 * @param pasos the pasos to set
	 */
	public void setPasos(ArrayList<Paso> pasos) {
		this.pasos = pasos;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
