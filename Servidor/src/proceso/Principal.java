package proceso;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Principal implements Runnable {
	
    int i;
	
	private Principal(int j){
		i = j;
		
	}
	
	
	
	public void run() {
	
		try {
			String sentenciaCliente;
			String sentenciaMayuscula;
			
			ServerSocket socketBienvenida;
			socketBienvenida = new ServerSocket();
		
			socketBienvenida.setReuseAddress(true);
			socketBienvenida.bind(new InetSocketAddress(i));
			System.out.println("esperando...");
			Socket socketConectado = socketBienvenida.accept();
			
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socketConectado.getInputStream()));
			sentenciaCliente = inFromClient.readLine();
			sentenciaMayuscula = sentenciaCliente.toUpperCase() + '\n';
			DataOutputStream outToClient = new DataOutputStream(socketConectado.getOutputStream());
			outToClient.writeBytes(sentenciaMayuscula);
			socketConectado.close();
			System.out.println("terminando...");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	           	
	}


	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
	    int j=3333;
		while(true) {
			j++;
			Principal p = new Principal(j);
            Thread t = new  Thread(p);
			t.start();

		}




	}

}
