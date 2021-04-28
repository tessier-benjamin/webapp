

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import starWars.DAOFilm;

/**
 * Servlet implementation class suppFilm
 */
@WebServlet("/suppFilm")
public class suppFilm extends HttpServlet {
	 private int filmIdSelectionne = 0;
	    private String suppressionStatut = "";

	    /**
	     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	     * methods.
	     *
	     * @param request servlet request
	     * @param response servlet response
	     * @throws ServletException if a servlet-specific error occurs
	     * @throws IOException if an I/O error occurs
	     */
	    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	    	 System.out.println("[Suppression d'un film]");
	        if(!request.getParameter("supprimer").isEmpty() && "supprimer".equals(request.getParameter("supprimer"))){
	            try{
	            	 System.out.println(request.getParameter("filmIdSelectionne"));
	                this.filmIdSelectionne = Integer.parseInt(request.getParameter("filmIdSelectionne"));
	                System.out.println("id : "+this.filmIdSelectionne);
	                DAOFilm daoFilm = new DAOFilm();
	                daoFilm.deleteFilm("film",filmIdSelectionne);
	            } catch (Exception e) {}
	        }
	        
	        response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            out.println("<!DOCTYPE html>"
	                    + "<html>"
	                    + "<head>"
	                    + "<title>Servlet FilmSaisi</title>"
	                    + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap.min.css\" rel=\"stylesheet\">"
	                    + "<link href=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/css/bootstrap-grid.min.css\" rel=\"stylesheet\">"
	                    + "</head>"
	                    + "<body>"
	                    + "<div class=\"container\">"
	                    + "<div class=\"row\">"
	                    + "<div class=\"col-12\">"
	                    + "<h1>Saisir un film <small style=\"font-size:16px;\"><a href=\"/2020-java-modelisation-web/\">[accueil]</a></small></h1>"
	                    + "<hr>"
	                    + "[id] = "+this.filmIdSelectionne
	                    + "<br>"
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
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
