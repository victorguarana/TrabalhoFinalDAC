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
import model.Artigo;
import model.Autor;


@WebServlet(name = "ArtigoView", urlPatterns = {"/Artigo"})
public class ArtigoView extends HttpServlet {

    WebTarget wt;
    String corpo, saida;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Autor> autores = null;
        int artigo_id = Integer.parseInt(request.getParameter("id"));
        int volume_id = Integer.parseInt(request.getParameter("volume"));

        
        Artigo artigo = null;
        int status;
        
                
        try (PrintWriter out = response.getWriter()) {

            Client client = ClientBuilder.newClient();
            URI uri;
            try {
                String url_api = "http://localhost:8080/Entrega2/api/evento/artigo/" + artigo_id;
                uri = new URI(url_api);
                this.wt = client.target(uri);
                wt.request().accept("application/xml");
                Invocation call = wt.request().buildGet();
                Response resposta = call.invoke();
                status = resposta.getStatus();
                artigo = resposta.readEntity(Artigo.class);
            } catch (URISyntaxException ex) {
                Logger.getLogger("").log(Level.SEVERE, null, ex);
            }

            
            try {
                String url_api = "http://localhost:8080/Entrega2/api/evento/artigo/" + artigo_id + "/autores";
                uri = new URI(url_api);
                this.wt = client.target(uri);
                wt.request().accept("application/xml");
                Invocation call = wt.request().buildGet();
                Response resposta = call.invoke();
                status = resposta.getStatus();
                autores = resposta.readEntity(new GenericType<List<Autor>>(){});
            } catch (URISyntaxException ex) {
                Logger.getLogger(ArtigoView.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>Artigo: " + artigo.getTitulo()+"</title>"
                    + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">"
                    + "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>"
                    + "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\">"
                    + "</head>");
            
            out.println("<body style=\"background: rgb(0 123 255 / 25%);\" >");
            
            out.println("<div style=\""
                        + "    padding-left: 15%;"
                        + "    padding-right: 15%;"
                        + "    padding-bottom: 1%;"
                        + "    padding-top: 1%;\">");
            out.println("<div style= \"box-shadow: 0px 0px 10px grey;"
                    + "padding: 10px 10px 10px 10px;"
                    + "background: white\">");
            
            out.println("<a class=\"btn btn-primary\" href=\"Home\"><i class=\"bi bi-house\"> Página inicial</i></a>");
            out.println("<a class=\"btn btn-primary\" href=\"Volume?id=" + volume_id + "\"><i class=\"bi bi-back\"> Voltar</i></a>");
            out.println("<br><br>");

            out.println("<h1>Informações do Artigo selecionado:</h1>");
            out.println("<dl class=\"row\">" +
                    "  <dt class=\"col-sm-3\">Titulo</dt>" +
                    "  <dd class=\"col-sm-9\">" + artigo.getTitulo()+ "</dd>" +
                    "  <dt class=\"col-sm-3\">Titulo (em inglês)</dt>" +
                    "  <dd class=\"col-sm-9\">" + artigo.getTituloEn()+ "</dd>" +
                    "  <dt class=\"col-sm-3\">Idioma</dt>" +
                    "  <dd class=\"col-sm-9\">" + artigo.getIdioma()+ "</dd>" +
                    "  <dt class=\"col-sm-3\">Resumo</dt>" +
                    "  <dd class=\"col-sm-9\">" + artigo.getResumo()+ "</dd>" +
                    "  <dt class=\"col-sm-3\">Resumo (em inglês)</dt>" +
                    "  <dd class=\"col-sm-9\">" + artigo.getResumoEn()+ "</dd>" +
                    "  <dt class=\"col-sm-3\">Palavra Chave</dt>" +
                    "  <dd class=\"col-sm-9\">" + artigo.getPalavrasChave()+ "</dd>" +
                    "  <dt class=\"col-sm-3\">Palavra Chave (Em inglês)</dt>" +
                    "  <dd class=\"col-sm-9\">" + artigo.getPalavrasChaveEn()+ "</dd>"
                    + "</dl>");
            out.println("<a class=\"btn btn-warning\"><i class=\"bi bi-pencil-square\"> Editar Artigo</i></a>");
               
            out.println("<br><br><br><br>");

            out.println("<h2>Todos os Autores do Artigo selecionado:</h2>");
            out.println("<table class=\"table\">"
                    + "<thead>"
                    + "<tr>"
                    + "<th scope=\"col\">Titulo</th>"
                    + "<th scope=\"col\">Ações</th>"
                    + "</tr>"
                    + "</thead>");
                            
            out.println("<tbody>");

            //String base = "http://localhost:8080/ClienteAgenda/ConsultaIdServlet";
            Iterator<Autor> autor_interator = autores.iterator();
                        while (autor_interator.hasNext()) {
                Autor aux = autor_interator.next();
                String link_autor = "Autor?id=" + aux.getId();
                String link_excluir = "Home?id="+aux.getId();

                //String link = base+"?id="+aux.getId();
                //out.println("<li><a href=\"" + link + "\">" + aux.getSobrenome() + ", " + aux.getNome() + "</a></li>");
                out.println("<tr>"
                                + "<th scope=\"row\"><a href=\"" + link_autor + "\">" + aux.getNomePrimeiro()+ " " + aux.getNomeMeio() + " " + aux.getNomeUltimo() + "</a></th>"
                                /*+ "<th> "
                                        + "<a class=\"btn btn-info\"><i class=\"bi bi-pencil-square\"> Editar</i></a>"
                                + " </th>"*/
                                + "<th> "
                                        + "<form method=\"post\" action=" + link_excluir + ">"
                                            + "<button class=\"btn btn-danger\" onclick=\"return confirm('Confirmar exclusão do autor: " + aux.getNomeUltimo()+ "?')\">"
                                                + "<i class=\"bi bi-trash\"> Excluir</i>"
                                        + "</button></form>"
                                + " </th>"

                            + "</tr>" );
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("<a class=\"btn btn-warning\"><i class=\"bi bi-plus-square\"> Adicionar Autor</i></a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception ex){
            Logger.getLogger(ArtigoView.class.getName()).log(Level.SEVERE, null, ex);
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
