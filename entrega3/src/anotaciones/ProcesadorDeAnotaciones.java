package anotaciones;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JLabel;

import modelo.Paso;
import modelo.PistaDeBaile;
import modelo.Ritmo;
import modelo.Robot;

public class ProcesadorDeAnotaciones {
	
	@SuppressWarnings({ "unchecked", "resource", "unused" })
	public void SendRequets(String query,PistaDeBaile pistaDeBaile, JLabel consola){	
		Class<PistaDeBaile> clasePista = (Class<PistaDeBaile>) pistaDeBaile.getClass();
		RemoteBot rem = (RemoteBot) clasePista.getAnnotation(RemoteBot.class);
		String config = rem.conf();
		try {
		    File archivo = new File (config);
			FileReader fr;
			fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			String direccion = br.readLine();
			int pos = direccion.indexOf(":")+1;
			direccion = direccion.substring(pos);
			String puerto  =  br.readLine();
			pos = puerto.indexOf(":")+1;
			puerto = puerto.substring(pos);
		    URL url = new URL(direccion+":"+puerto); 
		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();           
		    connection.setDoOutput(true); 
		    connection.setInstanceFollowRedirects(false); 
		    connection.setRequestMethod("POST"); 
		    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    connection.connect();
		    java.io.DataOutputStream output = new java.io.DataOutputStream(connection.getOutputStream());
		    output.writeBytes("commands="+query);
		    consola.setText("Estado: Se obtuvo una conexion exitosa");
		    consola.setForeground(Color.GREEN);
		    
		    java.io.DataInputStream input = new java.io.DataInputStream(connection.getInputStream());
		    
		    
		} catch (FileNotFoundException e) {
			consola.setText("Estado: hubo un error con el archivo");
			consola.setForeground(Color.RED);
		} catch (IOException e) {
			consola.setText("Estado: Hay un error con el servidor");
			consola.setForeground(Color.RED);
		}		
	}
	
	@SuppressWarnings("unchecked")
	public String armJson(PistaDeBaile pistaDeBaile){		
		ArrayList<modelo.Robot> robots = null;		
		Class<PistaDeBaile> clasePista = (Class<PistaDeBaile>) pistaDeBaile.getClass();
		for(Method m : clasePista.getMethods()){		
			if(m.isAnnotationPresent(Robots.class)){
				 try {
					robots = (ArrayList<Robot>) m.invoke(pistaDeBaile,new Object[0]);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}		
		}
		String query=  "[{\"target\": \"board\",\"board\": {\"device\": \"/dev/ttyUSB0\"},\"command\": \"__init__\"	}";	
		if(robots != null){
			for(modelo.Robot r : robots){
				int id = r.getId();
				String json = ",{"+
						"\"target\": \"robot\","+
						"\"board\": {\"device\": \"/dev/ttyUSB0\"},"+
						"\"command\": \"__init__\","+
						"\"id\":"+id+
					"}	";
				
				
				for(Method m : r.getClass().getMethods()){
					Ritmo ritmo;
					if(m.isAnnotationPresent(anotaciones.Ritmo.class)){
						try {
							 ritmo = (Ritmo) m.invoke(r, new Object[0]);
						
							 for(Paso p : ritmo.getPasos()){
								json +=",{"+
									   "\"target\": \"robot\","+
										"\"board\": {\"device\": \"/dev/ttyUSB0\"},"+
										"\"id\": "+id+","+
										"\"command\": \""+p.getMovimiento().getNombre()+"\","+
										"\"args\": ["+p.getVelocidad()+","+p.getTiempo()+"]"+
									"}";		 
							 }						
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}					
					
						break;					
					}				
				}
				query += json; 		
			} 
			 query += "]";		
		}		
		
		return query;
	}

}
