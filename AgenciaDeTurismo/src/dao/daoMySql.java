package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class daoMySql implements interfaceDao {

	@Override
	public void guardar(Reserva r) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia","root","hola");
			java.sql.Statement s = c.createStatement();
			int result = s.executeUpdate("INSERT INTO reserva(origen, destino,adultos,ninos,pais, categoria)" +
					                                  "values('"+r.origen+"','"+r.destino+"',"+r.adultos+","+r.ninos+",'"+r.pais+"','"+r.categoria+"')");
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
