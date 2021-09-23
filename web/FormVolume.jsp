<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Volume"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Formulário de Volume</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="assets/css/comum.css">


    </head>
    <body>
        <% 
            Volume volume = new Volume();
            volume.empty();
            if (request.getParameter("id") != null && session.getAttribute("volume") != null){
                volume = (Volume) session.getAttribute("volume");
            }
        
        %>

        <div class="card_outter">
            <div class = "card_inner">
                <% if (request.getParameter("id") != null) { %>
                <a class="btn btn-primary" href="Volume?id=<%= volume.getId() %>"><i class="bi bi-back"> Voltar</i></a>
                <% } else { %>
                <a class="btn btn-primary" href="Home"><i class="bi bi-back"> Voltar</i></a>
                <% } %>
            
                <br><br>
                <h2>Preencha os campos com as informações adequadas:</h2>
                <form action="http://localhost:8080/Entrega2/api/evento/volume" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label>Sigla:</label>
                            <input type="text" value="<%= volume.getSigla() %>" class="form-control" name="sigla">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Edição:</label>
                            <input type="number" id="edicao" class="form-control" name="edicao">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Data de inicio:</label>
                            <input type="date" id="data_inicio" class="form-control" name="data_inicio">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Cidade:</label>
                            <input type="text" value="<%= volume.getCidade() %>" class="form-control" name="cidade">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Descrição:</label>
                        <textarea class="form-control" name="descricao"><%= volume.getDescricao() %></textarea>
                    </div>                    
                    <div class="form-group">
                        <label>Descrição (em inglês):</label>
                        <textarea class="form-control" name="descricao_en"><%= volume.getDescricaoEn()%></textarea>
                    </div>
                    
                    <input type="hidden" name="id" value="<%= volume.getId() %>">
                    
                    <input class="btn btn-success" type="submit" value="Salvar" onsubmit="return home();"/>
                </form>
            </div>
        </div>
        <script>
            document.getElementById("edicao").value = <%= volume.getEdicao() %>
            document.getElementById("data_inicio").value = "<%= volume.getDataInicio()%>"
        </script>
        <script>
        function home() {
            <% if (request.getParameter("id") != null) { %>
            path = "Volume?id=<%= volume.getId() %>";
            <% } else { %>
            path = "Home";
            <% } %>
            window.location.href = 'http://localhost:8080/TrabalhoFinalDAC/Home';
        }
        </script>
        
    </body>
</html>

