package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Modelo.Menu;

public class MenuDaoMysql implements MenuDao {

	@Override
	public void guardar(Menu m) {
		Statement st = null;
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/comidas","root","hola");
				st = (Statement) c.createStatement();
				int res = st.executeUpdate("INSERT INTO menus(nombre,descripción,precio)" +
						                                      "values('"+m.nombre+"','"+m.desc+"',"+m.precio+")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
