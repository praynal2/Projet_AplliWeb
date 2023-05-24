package Pack;

import java.io.IOException;
import java.sql.*;

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
		facade.addUser("test", "test"); 
		response.sendRedirect("Pages/login/login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Connexion à la BDD
		String db_url = "jdbc:hsqldb:hsql://localhost/xdb";		//Quelle BD ? 
		String db_user = "sa";
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection(db_url, db_user, null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// TRaitement des opérations
		String op =  request.getParameter("op");
		
		if (op.equals("register")) {
			
		}
	}

}
