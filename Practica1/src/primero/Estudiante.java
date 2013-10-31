package primero;

public class Estudiante implements Comparable{
	public String apellido, 
	nombre , legajo;
	
	
	public String toString(){
		return apellido+"   "+nombre+"  "+legajo;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Estudiante est = (Estudiante)o;
		return legajo.compareTo(est.legajo);
	}

}
