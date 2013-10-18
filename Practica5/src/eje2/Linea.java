package eje2;

import java.util.ArrayList;

public class Linea {
	
	ArrayList<Punto> puntos = new ArrayList<Punto>();
	
	public void agregarPunto(Punto p){
		puntos.add(p);
	}
	public int cantPuntos(){
		return puntos.size();
	}
	
    public ArrayList<Punto> getPuntos(){
    	return puntos;
    }
	

}
