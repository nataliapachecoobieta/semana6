import static org.junit.Assert.*;

import org.junit.Test;

import bancoplatinum.beans.Persona;
import bancoplatinum.beans.Usuario;
import bancoplatinum.model.ModeloPersona;
import bancoplatinum.model.ModeloUsuario;

public class TestLogin {

	@Test
	public void test1() {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		Usuario usuario = modeloUsuario.read("1", "1");
		assertNotEquals(usuario, null);
	}
	
	@Test
	public void test2() {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		Usuario usuario = modeloUsuario.read("1", "2");
		assertEquals(usuario, null);
	}
	
	@Test
	public void test3() {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		Usuario usuario = modeloUsuario.read(null, null);
		assertEquals(usuario, null);
	}
}
