package Pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.security.auth.login.LoginContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControleurFavoris")
public class ControleurFavoris extends HttpServlet {
    
    @EJB
    private Facade_Itf facade = new Facade();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurFavoris() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("Pages/home/home.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        try {
            // Utilisateur connecté
            String user = request.getParameter("user");
            
            // Opération à effectuer
            String op = request.getParameter("op");

            if (op == "add") {
                // On ajoute un favori
                facade.addFav(user, Integer.parseInt(request.getParameter("idFav")));
            } else if (op == "remove") {
                // On supprime un favori
                facade.delFav(user, Integer.parseInt(request.getParameter("idFav")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
