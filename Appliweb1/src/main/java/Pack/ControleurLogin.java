package Pack;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/ControleurLogin")
public class ControleurLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
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
//		facade.addUser("test", "test"); 
//		Client c = facade.getClient("test");
//		response.getWriter().println("<html><body>" + c.getPassword() + "</body></html>");
		response.sendRedirect("Pages/login/login.html");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
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
					request.setAttribute("user", login);
					response.sendRedirect("Pages/login/login.html");
				} 
				// Cas où l'utilisateur n'existe pas encore
				else {
					request.setAttribute("isUser", false);
					facade.addUser(login, password);
					response.sendRedirect("Pages/login/login.html");
				}			
			}
			
			// LOGIN
			else if (op.equals("Login")) {
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				boolean isUser = facade.isUser(login, password);
				// Cas où l'utilisateur existe déjà 
				// attributes : isUser = true, favorites = liste des musiques favorites
				if (isUser) {
					request.setAttribute("isUser", true); 
					request.setAttribute("user", login);

					// Ajout des informations de l'utilisateur dans la session
					// Favoris 
					List<Favorite> favs = facade.getFavs(login);
					List<Integer> favorites = new ArrayList<Integer>();
					for (Favorite f : favs) {
						favorites.add(f.getMusic().getId());
					}
<<<<<<< HEAD
					request.setAttribute("favs", favorites);
					
					
					// Achats
=======
					request.setAttribute("favorites", favorites);

					// Envoi de la liste des favoris au front
					RequestDispatcher dispatcher = request.getRequestDispatcher("../../webapp/Pages/login/login.html");
					dispatcher.forward(request, response);

>>>>>>> 233c3fd074d0d2f6b073adfb08672a2f3e2ff22c
					List<Purchase> purchs = facade.getPurchases(login);
					List<Integer> purchases = new ArrayList<Integer>();
					for (Purchase p : purchs) {
						purchases.add(p.getMusic().getId());
					}
					request.setAttribute("purs", purchases);

					// Envoi de la liste des achats au front
					RequestDispatcher dispatcher2 = request.getRequestDispatcher("../../webapp/Pages/login/login.html");
					dispatcher2.forward(request, response);

					// On passe dans la page d'accueil
					response.sendRedirect("Controleur");
				} 
				// Cas où l'utilisateur n'existe pas encore
				else {
					request.setAttribute("isUser", false);
					request.setAttribute("favorites", null);
					request.setAttribute("purchases", null);
					response.sendRedirect("ControleurLogin");
				}	
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
