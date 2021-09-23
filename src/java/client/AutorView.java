package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import model.Autor;
import model.Autor;


@WebServlet(name = "AutorView", urlPatterns = {"/Autor"})
public class AutorView extends HttpServlet {

    WebTarget wt;
    String corpo, saida;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Autor> autores = null;
        int autor_id = Integer.parseInt(request.getParameter("id"));

        int artigo_id = Integer.parseInt(request.getParameter("artigo"));
        int volume_id = Integer.parseInt(request.getParameter("volume"));

        Autor autor = null;
        int status;
        
                
        try (PrintWriter out = response.getWriter()) {

            Client client = ClientBuilder.newClient();
            URI uri;
            try {
                String url_api = "http://localhost:8080/Entrega2/api/evento/autor/" + autor_id;
                uri = new URI(url_api);
                this.wt = client.target(uri);
                wt.request().accept("application/xml");
                Invocation call = wt.request().buildGet();
                Response resposta = call.invoke();
                status = resposta.getStatus();
                autor = resposta.readEntity(Autor.class);
            } catch (URISyntaxException ex) {
                Logger.getLogger("").log(Level.SEVERE, null, ex);
            }

            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>Autor: " + autor.getNomeUltimo()+"</title>"
                    + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">"
                    + "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>"
                    + "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\">"
                    + "<link rel=\"stylesheet\" href=\"assets/css/comum.css\">"
                    + "</head>");
            
            out.println("<body>");
            
            out.println("<div class=\"card_outter\">");
            out.println("<div class=\"card_inner\">");
            
            out.println("<a class=\"btn btn-primary\" href=\"Home\"><i class=\"bi bi-house\"> Página inicial</i></a>");
            out.println("<a class=\"btn btn-primary\" href=\"Artigo?id=" + artigo_id + "&volume=" + volume_id + "\"><i class=\"bi bi-back\"> Voltar</i></a>");
            out.println("<br><br>");

            out.println("<h1>Informações do Autor selecionado:</h1>");
            out.println("<dl class=\"row\">" +
                    "  <dt class=\"col-sm-3\">Primeiro nome</dt>" +
                    "  <dd class=\"col-sm-9\">" + autor.getNomePrimeiro()+ "</dd>" +
                    "  <dt class=\"col-sm-3\">Nome do meio</dt>" +
                    "  <dd class=\"col-sm-9\">" + autor.getNomeMeio() + "</dd>" +
                    "  <dt class=\"col-sm-3\">Último nome</dt>" +
                    "  <dd class=\"col-sm-9\">" + autor.getNomeUltimo() + "</dd>" +
                    "  <dt class=\"col-sm-3\">ORCID</dt>" +
                    "  <dd class=\"col-sm-9\">" + autor.getOrcid() + "</dd>" +
                    "  <dt class=\"col-sm-3\">E-mail</dt>" +
                    "  <dd class=\"col-sm-9\">" + autor.getEmail() + "</dd>" +
                    "  <dt class=\"col-sm-3\">País</dt>" +
                    "  <dd class=\"col-sm-9\">" + autor.getPais()+ "</dd>" +
                    "  <dt class=\"col-sm-3\">Afiliação</dt>" +
                    "  <dd class=\"col-sm-9\">" + autor.getAfiliacao()+ "</dd>" +
                    "  <dt class=\"col-sm-3\">Afiliação (Em inglês)</dt>" +
                    "  <dd class=\"col-sm-9\">" + autor.getAfiliacaoEn()+ "</dd>"
                    + "</dl>");
            out.println("<a class=\"btn btn-warning\"><i class=\"bi bi-pencil-square\"> Editar Autor</i></a>");
               
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception ex){
            Logger.getLogger(AutorView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
