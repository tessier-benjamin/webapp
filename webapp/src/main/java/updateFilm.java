

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import starWars.DAOFilm;
import starWars.film;

/**
 * Servlet implementation class updateFilm
 */
@WebServlet("/updateFilm")
public class updateFilm extends HttpServlet {
	  private int filmIdSelectionne;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  if(!request.getParameter("modifier").isEmpty() && "modifier".equals(request.getParameter("modifier"))){
	            try{
	            	System.out.println(request.getParameter("filmIdSelectionne"));
					this.filmIdSelectionne  = Integer.parseInt(request.getParameter("filmIdSelectionne"));
					System.out.println("id : "+this.filmIdSelectionne);
	                //getServletContext().getRequestDispatcher("/2020-java-modelisation-web/FilmResultRequete").forward(request,response);
	        
	                String requetSQL = "SELECT * FROM films WHERE id="+filmIdSelectionne+"";
	                DAOFilm daoFilm = new DAOFilm();
	                ArrayList daoFilmList = new ArrayList();
	                daoFilmList.addAll(daoFilm.listReadingArrayList(requetSQL));
	                
	                film film = (film) daoFilmList.get(0);
	                int filmId = film.getId();
	                String filmTitre = film.getTitre();
	                String filmAnneeDeSortie = film.getAnneeSortie();
	                int filmNumeroEpisode = film.getNumeroEpisode();
	                int filmCout = film.getCout();
	                int filmRecette = film.getRecette();

	                response.setContentType("text/html;charset=UTF-8");
	                try (PrintWriter out = response.getWriter()) {
	                    out.println("<!DOCTYPE html>"
	                            + "<html>"
	                            + "<head>"
	                            + "<title>updateFilm</title>"
	                            + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap.min.css\" rel=\"stylesheet\">"
	                            + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap-grid.min.css\" rel=\"stylesheet\">"
	                            + "</head>"
	                            + "<body>"
	                            + "<div class=\"container\">"
	                            + "<div class=\"row\">"
	                            + "<div class=\"col-12\">"
	                            + "<h1>Mettre à jour un film <small style=\"font-size:16px;\"><a href=\"/2020-java-modelisation-web/\">[accueil]</a></small></h1>"
	                            + "<hr>"
	                            + "<form method=\"post\" action=\"FilmSaisiResultat\">"
	                            + "<input type=\"text\" name=\"FilmId\" value=\""+filmId+"\" hidden />"
	                            + "<label for=\"basic-url\" class=\"form-label\">Nom du film</label>"
	                            + "<input type=\"texte\" class=\"form-control\" name=\"FilmTitre\" placeholder=\"(String)\" value=\""+filmTitre+"\"/>"
	                            + "<br>"
	                            + "<label for=\"basic-url\" class=\"form-label\">Année de sortie du film</label>"
	                            + "<input type=\"texte\" class=\"form-control\" name=\"FilmAnneeDeSortie\" placeholder=\"(String)\" value=\""+filmAnneeDeSortie+"\"/>"
	                            + "<br>"
	                            + "<label for=\"basic-url\" class=\"form-label\">Numéro du film</label>"
	                            + "<input type=\"texte\" class=\"form-control\" name=\"FilmNumeroEpisode\" placeholder=\"(int)\" value=\""+filmNumeroEpisode+"\"/>"
	                            + "<br>"
	                            + "<label for=\"basic-url\" class=\"form-label\">Coût du film</label>"
	                            + "<input type=\"texte\" class=\"form-control\" name=\"FilmCout\" placeholder=\"(double)\" value=\""+filmCout+"\"/>"
	                            + "<br>"
	                            + "<label for=\"basic-url\" class=\"form-label\">Recette du film</label>"
	                            + "<input type=\"texte\" class=\"form-control\" name=\"FilmRecette\" placeholder=\"(double)\" value=\""+filmRecette+"\"/>"
	                            + "<br>"
	                            + "<input type=\"submit\" class=\"btn btn-success\" name=\"update\" value=\"Update\"/>"
	                            + "</form>"
	                            + "</div>"
	                            + "</div>"
	                            + "</div>"
	                            + "</body>"
	                            + "</html>"
	                            + "");
	                }
	            } catch (Exception e) {}
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
