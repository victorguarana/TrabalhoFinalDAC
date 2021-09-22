/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import model.Volume;

/**
 *
 * @author viter
 */
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

    WebTarget wt;
    String corpo, saida;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JAXBException {
        response.setContentType("text/html;charset=UTF-8");
        
        Client client = ClientBuilder.newClient();
        URI uri;
        String volume = request.getParameter("volume");
        String artigo = request.getParameter("artigo");
        String autor = request.getParameter("autor");

        String path = null;
        String back  = "Home";

        //Deleta Volume 
        if (volume != null && artigo == null){
            path = "volume/" + volume;
        }

        //Deleta Artigo
        if (volume != null && artigo != null){
            path = "volume/" + volume + "/artigo/" + artigo;
            back = "Volume?id=" + volume;
        }
        
        //Deleta Autor
        if (artigo != null && autor != null){
            path = "artigo/" + artigo + "/autor/" + autor;
            back = "Artigo?id=" + artigo;
        }

        //Caso tenha erro com o caminho
        if (path == null)
            response.sendRedirect(back);
        
        try {
            String url_delete = "http://localhost:8080/Entrega2/api/evento/" + path;
            uri = new URI(url_delete);
            this.wt = client.target(uri);
            wt.request().accept("application/xml");
            Invocation call = wt.request().buildDelete();
            Response resposta = call.invoke();
            int status = resposta.getStatus();
            volume = "0";
        } catch (URISyntaxException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(back);


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
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            //Logger.getLogger(ConsultaIdServlet.class.getName()).log(Level.SEVERE, null, ex);
        }


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
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            //Logger.getLogger(ConsultaIdServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
