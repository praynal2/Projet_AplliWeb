package Pack;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControleurFavoris")
public class ControleurFavoris extends HttpServlet {
    
    @EJB
    private Facade_Itf facade = new Facade();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
