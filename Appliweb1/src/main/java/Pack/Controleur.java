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

@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
	@EJB
    Facade_Itf facade = new Facade();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Enregistrement des musiques dans la BD 
        //facade.initBD(); Eventuellement ??

		response.sendRedirect("Pages/home/home.html");
        // On récupère les favoris du client 
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

            
            // On modifie les favoris du client lorqu'il quitte la page
            if (op == "setClient") { 
                // On récupère les favoris
                List<Integer> musics = (List<Integer>) request.getAttribute("newfavs");
                facade.setFavs(user, musics);
                // On récupère les achats
                List<Integer> purchases = (List<Integer>) request.getAttribute("newpurchases");
                facade.setPurchases(user, purchases);
            } 

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
