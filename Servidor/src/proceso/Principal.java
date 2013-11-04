package proceso;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Principal {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		String sentenciaCliente;
		String sentenciaMayuscula;
		
		ServerSocket socketBienvenida = new ServerSocket();
		socketBienvenida.setReuseAddress(true);
		socketBienvenida.bind(new InetSocketAddress(3333));
		while(true) {
			System.out.println("esperando...");
			Socket socketConectado = socketBienvenida.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socketConectado.getInputStream()));
			sentenciaCliente = inFromClient.readLine();
			sentenciaMayuscula = sentenciaCliente.toUpperCase() + '\n';
			DataOutputStream outToClient =
			new DataOutputStream(socketConectado.getOutputStream());
			outToClient.writeBytes(sentenciaMayuscula);
			socketConectado.close();
			System.out.println("terminando...");

		}




	}

}
