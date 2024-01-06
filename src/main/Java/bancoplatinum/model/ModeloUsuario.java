package bancoplatinum.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bancoplatinum.beans.Usuario;

public class ModeloUsuario {
	
	public Usuario read(String username, String password) {
		Database database = new Database();
		Connection connection = database.getConnection();
		
		Usuario resultado;
		
		try {
			Statement statement = connection.createStatement();
			
			String query = String.format("select rut, username, password from usuario where username='%s' and password='%s'", username, password);

			ResultSet rs = statement.executeQuery(query);
			
			boolean found = rs.next();
			
			if (found) {
				resultado = new Usuario();
				resultado.setRut(rs.getString("rut"));
				resultado.setUsername(username);
				resultado.setPassword(password);
			} else {
				resultado = null;
			}
			
		} catch (Exception e) {
			resultado = null;
		}
		
		return resultado;
	}
}
