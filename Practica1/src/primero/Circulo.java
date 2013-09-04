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
		System.out.println("soy un circulo y mi area es "+this.area());
		
	}

	@Override
	public int area() {
		// TODO Auto-generated method stub
		return (int) ((int)Math.PI * Math.pow(radio, 2.0));
	}

	@Override
	public int compareTo(FiguraGeometrica o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
