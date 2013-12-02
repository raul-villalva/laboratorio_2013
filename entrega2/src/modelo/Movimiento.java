package modelo;

public enum Movimiento {
	
	
	
	GIRO("giro"),
	AVANCE("avance"),
	RETROCESO("retroceso"),
	IZQUIERDA("izquierda"),
	DERECHA("derecha");
	
	String nombre;
	
	Movimiento(String mov){
		nombre = mov;
	}
	
	public String getNombre(){
		return nombre;
	}

}
