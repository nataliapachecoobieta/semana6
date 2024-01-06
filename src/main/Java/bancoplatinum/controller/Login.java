package bancoplatinum.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bancoplatinum.beans.Persona;
import bancoplatinum.beans.Usuario;
import bancoplatinum.model.ModeloPersona;
import bancoplatinum.model.ModeloUsuario;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			ModeloUsuario modeloUsuario = new ModeloUsuario();
			Usuario usuario = modeloUsuario.read(username, password);
			
			if (usuario != null) {
				ModeloPersona modeloPersona = new ModeloPersona();
				Persona persona = modeloPersona.read(usuario.getRut());
				
				HttpSession session = request.getSession();
				session.setAttribute("rut", persona.getRut());
				session.setAttribute("nombre", persona.getNombre());
				session.setAttribute("apellido", persona.getApellido());
				session.setAttribute("telefono", persona.getTelefono());
				session.setAttribute("fechaIngreso", persona.getFechaIngreso());

				response.sendRedirect("http://localhost:8080/BancoPlatinum/home.jsp");
				
			} else {
				response.sendRedirect("http://localhost:8080/BancoPlatinum/error.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
