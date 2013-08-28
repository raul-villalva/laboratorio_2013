package primero;

public class PainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Paint p = new Paint();
		p.init();
		
		for(FiguraGeometrica fg : p.getPaleta()){
			fg.dibujar();
			
		}

	}

}
