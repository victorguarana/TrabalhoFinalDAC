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
            
        %>
        <script>
        function home() {
            window.location.href = 'http://localhost:8080/TrabalhoFinalDAC/Volume?id=<%= volume_id %>';
        }
        </script>
    </head>
    <body>
        

        
        
        <div class="card_outter">
            <div class = "card_inner">
                <a class="btn btn-primary" href="Volume?id=<%= volume_id %>"><i class="bi bi-back"> Voltar</i></a>
                <br><br>
                <h2>Preencha os campos com as informações adequadas:</h2>
                <form action="http://localhost:8080/Entrega2/api/evento/artigo" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-8">
                            <label>Título:</label>
                            <input type="text" class="form-control" name="titulo">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Idioma</label>
                            <input type="text" class="form-control" name="idioma">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-8">
                            <label>Título (em inglês):</label>
                            <input type="text" class="form-control" name="titulo_en">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Ordem do Artigo no Volume</label>
                            <input type="number" class="form-control" name="ordem_volume">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Resumo:</label>
                        <textarea class="form-control" name="resumo"></textarea>
                    </div>                    
                    <div class="form-group">
                        <label>Resumo (em inglês):</label>
                        <textarea class="form-control" name="resumo_en"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Palavra Chave</label>
                        <textarea class="form-control" name="palavras_chave"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Palavra Chave (em inglês):</label>
                        <textarea class="form-control" name="palavras_chave_en"></textarea>
                    </div>
                    <input type="hidden" name="volume" value="<%= volume_id %>">

                    <input class="btn btn-success" type="submit" value="Salvar" onclick="return home();"/>
                </form>
            </div>
        </div>
    </body>
</html>

