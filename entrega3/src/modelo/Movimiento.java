package modelo;

public enum Movimiento {
	
	
	
	GIRO("turn"),
	AVANCE("forward"),
	RETROCESO("backward"),
	IZQUIERDA("turnLeft"),
	DERECHA("turnRight");
	
	String nombre;
	
	Movimiento(String mov){
		nombre = mov;
	}
	
	public String getNombre(){
		return nombre;
	}

}
