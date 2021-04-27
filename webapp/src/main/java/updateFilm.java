

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateFilm
 */
@WebServlet("/updateFilm")
public class updateFilm extends HttpServlet {
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            out.println("<!DOCTYPE html>"
	                    + "<html>"
	                    + "<head>"
	                    + "<title>updateFilm</title>"
	                    + "</head>"
	                    + "<body>"
	                    + "<div class=\"container\">"
	                    + "<div class=\"row\">"
	                    + "<div class=\"col-12\">"
	                    + "<h1>Mettre à jour un film</h1>"
	                    + "<hr>"
	                    + "<form>"
	                    + "<label for=\"basic-url\" class=\"form-label\">Nom du film</label>"
	                    + "<input type=\"texte\" class=\"form-control\" name=\"FilmTitre\" - ["+request.getParameter("FilmTitre")+"]\"/>"
	                    + "<br>"
	                    + "<label for=\"basic-url\" class=\"form-label\">Année de sortie du film</label>"
	                    + "<input type=\"texte\" class=\"form-control\" name=\"FilmAnneeDeSortie\" - ["+request.getParameter("FilmAnneeDeSortie")+"]\"/>"
	                    + "<br>"
	                    + "<label for=\"basic-url\" class=\"form-label\">Numéro du film</label>"
	                    + "<input type=\"texte\" class=\"form-control\" name=\"FilmNumeroEpisode\" - ["+request.getParameter("FilmNumeroEpisode")+"]\"/>"
	                    + "<br>"
	                    + "<label for=\"basic-url\" class=\"form-label\">Coût du film</label>"
	                    + "<input type=\"texte\" class=\"form-control\" name=\"FilmCout\"  - ["+request.getParameter("FilmCout")+"]\"/>"
	                    + "<br>"
	                    + "<label for=\"basic-url\" class=\"form-label\">Recette du film</label>"
	                    + "<input type=\"texte\" class=\"form-control\" name=\"FilmRecette\"  - ["+request.getParameter("FilmRecette")+"]\"/>"
	                    + "<br>"
	                    + "<input type=\"submit\" class=\"btn btn-success\" value=\"Valider\"/>"
	                    + "</form>"
	                    + "</div>"
	                    + "</div>"
	                    + "</div>"
	                    + "</body>"
	                    + "</html>"
	                    + "");
	        }
	    }

	    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	    /**
	     * Handles the HTTP <code>GET</code> method.
	     *
	     * @param request servlet request
	     * @param response servlet response
	     * @throws ServletException if a servlet-specific error occurs
	     * @throws IOException if an I/O error occurs
	     */
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    /**
	     * Handles the HTTP <code>POST</code> method.
	     *
	     * @param request servlet request
	     * @param response servlet response
	     * @throws ServletException if a servlet-specific error occurs
	     * @throws IOException if an I/O error occurs
	     */
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    /**
	     * Returns a short description of the servlet.
	     *
	     * @return a String containing servlet description
	     */
	    @Override
	    public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>

}
