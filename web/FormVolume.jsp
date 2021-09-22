<%@page import="model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Guara Store (Vendedor) - Form Cliente</title>
        
        
          <!-- Bootstrap core CSS -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="assets/css/shop-homepage.css" rel="stylesheet">
    </head>
    <body>
        <% 
            String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", 
                "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
            
            if (request.getAttribute("cliente") == null || request.getAttribute("criar") == null){
                response.sendRedirect("Cliente?acao=exibir");
            }
            Cliente cliente = (Cliente) request.getAttribute("cliente");
            
            Boolean criar = (Boolean) request.getAttribute("criar");
            if (!criar)session.setAttribute("clienteid", cliente.getId());
        %>
          <!-- Navigation -->
  <%@include file="/Comum/navi.jsp" %>
        <div class="container mt-2">

            <div class="col-8 mt-5">
                <% if (criar) { %>
                <h4>Cadastrar Cliente</h4>
                <% } else { %> 
                <h4>Editar Cliente</h4>
                <% } %>
                <form method="POST" action="Cliente?acao=salvar" >

                      
                    <div class="form-group">
                        <label for="nome">Nome</label>
                        <input id="nome" value="<%=cliente.getNome()%>" type="text" class="form-control" name="nome" pattern=".{1,50}" placeholder="Nome do cliente" required>
                    </div>
                      
                    <div class="form-group">
                        <label for="cpf">CPF</label>
                        <input id="cpf" value="<%=cliente.getCpf()%>" type="text" class="form-control cpf" name="cpf" pattern=".{14,14}" placeholder="CPF do Cliente" required>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-7">
                            <label for="endereco">Endereço</label>
                            <input id="endereco" value="<%=cliente.getEndereco()%>" type="text" class="form-control" name="endereco" pattern=".{1,50}" placeholder="Endereço do cliente" required>
                        </div>                      
                        <div class="form-group col-md-5">
                            <label for="bairro">Bairro</label>
                            <input id="bairro" value="<%=cliente.getBairro()%>" type="text" class="form-control" name="bairro" pattern=".{1,50}" placeholder="Bairro do cliente" required>
                        </div>                      
                    </div>
                      
                    <div class="form-row">
                        <div class="form-group col-md-5">
                          <label for="cidade">Cidade</label>
                          <input id="cidade" value="<%=cliente.getCidade()%>" type="text" class="form-control" pattern=".{1,50}" name="cidade" placeholder="Cidade do cliente" required>
                        </div>
                        <div class="form-group col-md-3">
                          <label for="estado">Estado</label>
                          <select id="estado" name="estado" class="form-control">
                              <% for(String estado : estados){  %>
                              <% if (!criar && estado.equals(cliente.getUf())) { %>
                              <option selected><%= estado %></option>
                              <% } else { %>
                              <option><%= estado %></option>
                              <% } } %>
                          </select>
                        </div>
                        <div class="form-group col-md-4">
                          <label for="cep">CEP</label>
                          <input id="cep" value="<%=cliente.getCep()%>" type="text" class="form-control cep" pattern=".{9,9}" name="cep" placeholder="CEP do cliente" required>
                        </div>
                    </div>
                    
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="telefone">Telefone</label>
                            <input id="telefone" value="<%=cliente.getTelefone()%>" type="text" class="form-control telefone" pattern=".{13,14}" name="telefone" placeholder="Telefone do cliente (Com DDD)" required>
                        </div>

                        <div class="form-group col-md-6">
                            <label for="email">Email</label>
                            <input id="email" value="<%=cliente.getEmail()%>" type="email" class="form-control" name="email" pattern=".{1,50}" placeholder="Email do Cliente" required>
                        </div>                      
                    </div>
                    
                            <input id="id" value="<%=cliente.getId()%>" type="hidden" name="id">

                    <button type="submit" class="btn btn-primary">Confirmar</button>
                    <a href="Cliente?acao=exibir" class="btn btn-outline-danger">Cancelar</a>
                </form>
            </div>
        </div>

    <!-- Footer -->
    <div class ="mt-5">
    <%@include file="/Comum/footer.html" %>
    </div>
  
        <%@include file="/Comum/Scripts_basicos.html" %>
        
        <%if (request.getAttribute("mensagemformcliente") != null){%>
        <script>
           alert("<%=request.getAttribute("mensagemformcliente").toString()%>");
        </script>
        <%request.removeAttribute("mensagemformcliente");
        }%>
    </body>
</html>

