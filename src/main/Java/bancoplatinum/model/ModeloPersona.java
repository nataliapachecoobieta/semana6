package bancoplatinum.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bancoplatinum.beans.Persona;
import bancoplatinum.beans.Usuario;

public class ModeloPersona {
	
	public Persona read(String rut) {
		Database database = new Database();
		Connection connection = database.getConnection();
		
		Persona resultado;
		
		try {
			Statement statement = connection.createStatement();
			
			String query = String.format("select rut, nombre, apellido, telefono, fechaIngreso from persona where rut='%s'", rut);
			ResultSet rs = statement.executeQuery(query);

			boolean found = rs.next();
			
			if (found) {
				resultado = new Persona();
				resultado.setRut(rs.getString("rut"));
				resultado.setNombre(rs.getString("nombre"));
				resultado.setApellido(rs.getString("apellido"));
				resultado.setTelefono(rs.getString("telefono"));
				resultado.setFechaIngreso(rs.getString("fechaIngreso"));

			} else {
				resultado = null;
			}
			
		} catch (Exception e) {
			resultado = null;
		}
		
		return resultado;
	}
}
