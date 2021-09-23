<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Formulário de Volume</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="assets/css/comum.css">

        <script>
        function home() {
            window.location.href = 'http://localhost:8080/TrabalhoFinalDAC/Home';
        }
        </script>
    </head>
    <body>
        <div class="card_outter">
            <div class = "card_inner">
                <a class="btn btn-primary" href="Home"><i class="bi bi-house"> Página inicial</i></a>
                <br><br>
                <h2>Preencha os campos com as informações adequadas:</h2>
                <form action="http://localhost:8080/Entrega2/api/evento/volume" method="post">
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label>Sigla:</label>
                        <input type="text" class="form-control" name="sigla">
                    </div>
                    <div class="form-group col-md-3">
                        <label>Edição:</label>
                        <input type="number" class="form-control" name="edicao">
                    </div>
                    <div class="form-group col-md-3">
                        <label>Data de inicio:</label>
                        <input type="date" class="form-control" name="data_inicio">
                    </div>
                    <div class="form-group col-md-3">
                        <label>Cidade:</label>
                        <input type="text" class="form-control" name="cidade">
                    </div>
                </div>
                <div class="form-group">
                    <label>Descrição:</label>
                    <textarea class="form-control" name="descricao"></textarea>
                </div>                    
                <div class="form-group">
                    <label>Descrição (em inglês):</label>
                    <textarea class="form-control" name="descricao_en"></textarea>
                </div>                    
                    <input class="btn btn-success" type="submit" value="Salvar" onclick="return home();"/>
                </form>
            </div>
        </div>
    </body>
</html>

