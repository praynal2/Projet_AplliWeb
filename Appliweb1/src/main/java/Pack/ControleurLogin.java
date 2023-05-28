package Pack;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class ControleurLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//@EJB
	Facade_Itf facade = new Facade(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("Pages/login/login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		// facade.addUser("test", "test"); 
		// doGet(request, response);
		
		// Traitement des opérations
		try {

			String op = request.getParameter("op");

			// REGISTER 
			if (op.equals("Register")) {
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				boolean isUser = facade.isUser(login, password);

				// Cas où l'utilisateur existe déjà 
				if (isUser) {
					request.setAttribute("isUser", true); 
				} 
				// Cas où l'utilisateur n'existe pas encore
				else {
					request.setAttribute("isUser", false);
					facade.addUser(login, password);
				}

				response.sendRedirect("Pages/login/login.html");
			}
			// LOGIN
			else if (op.equals("Login")) {
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				boolean isUser = facade.isUser(login, password);

				// Cas où l'utilisateur existe déjà 
				// attributes : isUser = true, favourites = liste des musiques favorites
				if (isUser) {
					request.setAttribute("isUser", true); 
					List<Favorite> favs = facade.getFavs(login);
					request.setAttribute("favorites", favs);
				} 
				// Cas où l'utilisateur n'existe pas encore
				else {
					request.setAttribute("isUser", false);		// Utilisateur inexistant
					request.setAttribute("favourites", null);	// Liste de favoris vide
				}

				response.sendRedirect("Pages/login/login.html");
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
