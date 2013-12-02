import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import anotaciones.RemoteBot;

import modelo.PistaDeBaile;


public class mock {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
			PistaDeBaile pista = new PistaDeBaile();
			
			
			
			
			Class<PistaDeBaile> clasePista = (Class<PistaDeBaile>) pista.getClass();
			RemoteBot rem = (RemoteBot) clasePista.getAnnotation(RemoteBot.class);
			String config = rem.conf();
			
		    File archivo = new File (config);
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			
			String direccion = br.readLine();
			String puerto  =  br.readLine();
		
		    URL url = new URL(direccion+":"+puerto); 
			String query= "mando algo";
		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();           
		    connection.setDoOutput(true); 
		    connection.setInstanceFollowRedirects(false); 
		    connection.setRequestMethod("POST"); 
		    connection.setRequestProperty("Content-Type", "text/plain"); 
		    connection.setRequestProperty("charset", "utf-8");
		    connection.connect();
		    java.io.DataOutputStream output = new java.io.DataOutputStream(connection.getOutputStream());
		    output.writeBytes(query);
		    System.out.println("log: response code: " + connection.getResponseCode());
		    System.out.println("log: response message: " + connection.getResponseMessage());
		    java.io.DataInputStream input = new java.io.DataInputStream(connection.getInputStream());

	}

}
