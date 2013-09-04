package primero;

public class Rectangulo extends FiguraGeometrica {

	private int alto;
	private int ancho;
	
	
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	@Override
	public void dibujar() {
		System.out.println("soy un cuadrado y tengo "+(this.ancho*this.alto));
		
	}
	@Override
	public int area() {
		// TODO Auto-generated method stub
		return alto * ancho;
	}
	@Override
	public int compareTo(FiguraGeometrica o) {
		
		return this.area() > o.area()?1:(this.area() < o.area()?-1:0);
	}


}
