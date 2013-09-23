import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class probarCirculo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String salida = "";
		try{
		// Definimos un flujo de caracteres de entrada: leerEntrada
		BufferedReader leerEntrada = new BufferedReader(new InputStreamReader(System.in));
		// Leemos la entrada, finaliza al pulsar la tecla Entrar
		salida = leerEntrada.readLine();
		} catch( IOException e) {
		System.err.println("Error: " + e.getMessage());
		}
		
		
		
		
		
		InnerStatic.Circulo.radio = Integer.parseInt(salida);
		System.out.println(InnerStatic.Circulo.getArea());

	}

}
