package proceso;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Multi {

	/**
	 * @param args
	 */
	class Hilo implements Runnable {

		
		Socket socket;
		
		public Hilo( Socket s) {
			socket = s;
			
		}
		
		@Override
		public void run() {
			try {
				String sentenciaCliente;
				String sentenciaMayuscula;
				
				
			
			
				
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				sentenciaCliente = inFromClient.readLine();
				sentenciaMayuscula = sentenciaCliente.toUpperCase() + '\n';
				DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
				outToClient.writeBytes(sentenciaMayuscula);
				socket.close();
				System.out.println("terminando...");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
	}
	public static void main(String[] args) throws IOException {
		Executor e = Executors.newCachedThreadPool();
		Hilo h ;
		ServerSocket socketBienvenida = null;
		while (true) {
			socketBienvenida.setReuseAddress(true);
			socketBienvenida.bind(new InetSocketAddress(3333));
			System.out.println("esperando...");
			Socket s = socketBienvenida.accept();
			Multi m = new Multi();
			e.execute(m.new Hilo(s));
			
			
		}

	}

}
