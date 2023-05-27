package Pack;

import java.io.IOException;
import java.util.List;

@WebServlet("/ControleurFavoris")
public class ControleurFavoris extends HttpServlet {
    
    @EJB
    private Facade_Itf facade = new Facade();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Integer> favs = request.getParameter();
        }
    }
}
