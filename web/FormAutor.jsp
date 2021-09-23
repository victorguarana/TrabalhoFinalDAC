<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Formulário de Autores</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="assets/css/comum.css">
        <% 
            if (request.getParameter("artigo") == null || request.getParameter("volume") == null){
                response.sendRedirect("Home");
            }
            String artigo_id = (String) request.getParameter("artigo");
            String volume_id = (String) request.getParameter("volume");
            
        %>
        <script>
        function home() {
            window.location.href = 'http://localhost:8080/TrabalhoFinalDAC/Artigo?id=<%= artigo_id %>&volume=<%= volume_id %>';
        }
        </script>
    </head>
    <body>
        <div class="card_outter">
            <div class = "card_inner">
                <a class="btn btn-primary" href="Artigo?id=<%= artigo_id %>&volume=<%= volume_id %>"><i class="bi bi-back"> Voltar</i></a>
                <br><br>
                <h2>Preencha os campos com as informações adequadas:</h2>
                <form action="http://localhost:8080/Entrega2/api/evento/autor" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label>Primeiro nome:</label>
                            <input type="text" class="form-control" name="nome_primeiro">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Nome do meio:</label>
                            <input type="text" class="form-control" name="nome_meio">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Último nome:</label>
                            <input type="text" class="form-control" name="nome_ultimo">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label>E-mail</label>
                            <input type="text" class="form-control" name="email">
                        </div>
                        <div class="form-group col-md-4">
                            <label>OrcID</label>
                            <input type="text" class="form-control" name="orcid">
                        </div>
                        <div class="form-group col-md-2">
                            <label>País</label>
                            <input type="text" class="form-control" name="pais">
                        </div>
                        <div class="form-group col-md-2">
                            <label>Ordem do Autor</label>
                            <input type="number" class="form-control" name="ordem_artigo">
                        </div>
                    </div>
                    
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Afiliação:</label>
                            <input type="text" class="form-control" name="afiliacao">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Afiliação (em inglês):</label>
                            <input type="text" class="form-control" name="afiliacao_en">
                        </div>
                    </div>

                    <input type="hidden" name="artigo" value="<%= artigo_id %>">

                    <input class="btn btn-success" type="submit" value="Salvar" onclick="return home();"/>
                </form>
            </div>
        </div>
    </body>
</html>

