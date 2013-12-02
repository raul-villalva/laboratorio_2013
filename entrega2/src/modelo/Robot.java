package modelo;

public class Robot {
	
	private String nombre;
	private Ritmo ritmo;
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
	
	@anotaciones.Ritmo
	public Ritmo getRitmo() {
		return ritmo;
	}
	/**
	 * @param ritmo the ritmo to set
	 */
	public void setRitmo(Ritmo ritmo) {
		this.ritmo = ritmo;
	}
	

}
