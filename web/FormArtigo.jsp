<%@page import="model.Artigo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Formulário de Artigos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="assets/css/comum.css">
        <% 
            if (request.getParameter("volume") == null){
                response.sendRedirect("Home");
            }
            String volume_id = (String) request.getParameter("volume");
            
            Artigo artigo = new Artigo();
            artigo.empty();
            if (request.getParameter("id") != null && session.getAttribute("artigo") != null){
                artigo = (Artigo) session.getAttribute("artigo");
            }
        %>

    </head>
    <body>
        

        
        
        <div class="card_outter">
            <div class = "card_inner">
                <% if (request.getParameter("id") != null) { %>
                <a class="btn btn-primary" href="Artigo?id=<%= artigo.getId()%>&volume=<%= volume_id %>"><i class="bi bi-back"> Voltar</i></a>
                <% } else { %>
                <a class="btn btn-primary" href="Volume?id=<%= volume_id %>"><i class="bi bi-back"> Voltar</i></a>
                <% } %>
                <br><br>
                <h2>Preencha os campos com as informações adequadas:</h2>
                <form action="http://localhost:8080/Entrega2/api/evento/artigo" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-8">
                            <label>Título:</label>
                            <input type="text" value="<%= artigo.getTitulo() %>" class="form-control" name="titulo">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Idioma</label>
                            <input type="text" value="<%= artigo.getIdioma() %>" class="form-control" name="idioma">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-8">
                            <label>Título (em inglês):</label>
                            <input type="text" value="<%= artigo.getTituloEn() %>" class="form-control" name="titulo_en">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Ordem do Artigo no Volume</label>
                            <input type="number" id="ordem_volume" class="form-control" name="ordem_volume">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Resumo:</label>
                        <textarea class="form-control" name="resumo"><%= artigo.getResumo() %></textarea>
                    </div>                    
                    <div class="form-group">
                        <label>Resumo (em inglês):</label>
                        <textarea class="form-control" name="resumo_en"><%= artigo.getResumoEn() %></textarea>
                    </div>
                    <div class="form-group">
                        <label>Palavra Chave</label>
                        <textarea class="form-control" name="palavras_chave"><%= artigo.getPalavrasChave() %></textarea>
                    </div>
                    <div class="form-group">
                        <label>Palavra Chave (em inglês):</label>
                        <textarea class="form-control" name="palavras_chave_en"><%= artigo.getPalavrasChaveEn() %></textarea>
                    </div>
                    <input type="hidden" name="id" value="<%= artigo.getId() %>">
                    <input type="hidden" name="volume" value="<%= volume_id %>">

                    <input class="btn btn-success" type="submit" value="Salvar" onclick="return home();"/>
                </form>
            </div>
        </div>
        <script>
            document.getElementById("ordem_volume").value = <%= artigo.getOrdemVolume()%>
        </script>
        <script>
        function home() {
            <% if (request.getParameter("id") != null) { %>
            path = "Artigo?id=<%= artigo.getId() %>&volume=<%= volume_id %>";
            <% } else { %>
            path = "Volume?id=<%= volume_id %>";
            <% } %>
            window.location.href = path;
            
            window.location.href = 'http://localhost:8080/TrabalhoFinalDAC/Volume?id=<%= volume_id %>';
        }
        </script>
    </body>
</html>

