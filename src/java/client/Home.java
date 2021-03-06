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
import model.Volume;


@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

    WebTarget wt;
    String corpo, saida;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Volume> volumes = null;
        
        try (PrintWriter out = response.getWriter()) {

            Client client = ClientBuilder.newClient();
            URI uri;
            try {
                uri = new URI("http://localhost:8080/Entrega2/api/evento/volume");
                this.wt = client.target(uri);
                wt.request().accept("application/xml");
                Invocation call = wt.request().buildGet();
                Response resposta = call.invoke();
                volumes = resposta.readEntity(new GenericType<List<Volume>>(){});
            } catch (URISyntaxException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>Volumes</title>"
                    + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">"
                    + "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>"
                    + "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\">"
                    + "<link rel=\"stylesheet\" href=\"assets/css/comum.css\">"
                    + "</head>");
            
            out.println("<body>");
            
            out.println("<div class=\"card_outter\">");
            out.println("<div class=\"card_inner\">");
            
            out.println("<h1>Todos os Volumes Dispon??veis:</h1>");
            out.println("<table class=\"table\">"
                    + "<thead>"
                    + "<tr>"
                    + "<th scope=\"col\">Sigla</th>"
                    + "<th scope=\"col\">Edi????o</th>"
                    + "<th scope=\"col\">Data</th>"
                    + "<th scope=\"col\">A????es</th>"

                    + "</tr>"
                    + "</thead>");
            
            out.println("<tbody>");

            Iterator<Volume> volume_interator = volumes.iterator();
                        while (volume_interator.hasNext()) {
                Volume aux = volume_interator.next();
                String link_volume = "Volume?id=" + aux.getId();
                String link_excluir = "Delete?volume="+aux.getId();

                out.println("<tr>"
                                + "<th scope=\"row\"><a href=\"" + link_volume + "\">" + aux.getSigla()+ "</a></th>"
                                + "<th>" + aux.getEdicao()+ "??</th>"
                                + "<th>" + aux.getDataInicio()+ "</th>"
                                + "<th> "
                                    + "<a class=\"btn btn-danger\" href=\"" + link_excluir + "\">"
                                        + "<i class=\"bi bi-trash\"> Excluir</i>"
                                    + "</a>"
                                + " </th>"

                            + "</tr>" );
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("<a href=\"FormVolume.jsp\"  class=\"btn btn-warning\"><i class=\"bi bi-plus-square\"> Adicionar Volume</i></a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception ex){
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
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
