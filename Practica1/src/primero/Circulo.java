package primero;

public class Circulo extends FiguraGeometrica {
	
	private int radio;

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	@Override
	public void dibujar() {
		System.out.println("soy un circulo y mi radio es"+this.radio);
		
	}
}
