<%-- 
    Document   : editarUsuario
    Created on : 04/10/2017, 14:41:45
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoUsuario.jsp"/></div>
        <br><br><br>
        <div class="container text-center">
            <h2>Dados do Usuário</h2>
            <br>
        </div>
        <div class="container">
            <div class="row">
                <form method="post" id="cadastroCliente" action="Controller?command=AtualizarUsuario&id=${usuario.id}">
                    <div class="form-group col-md-6">
                        <label for="nome">Nome: </label>
                        <input type="text" class="form-control" name="nome" id="nome" value="${usuario.nome}" autofocus required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="email">Email: </label>
                        <input type="email" class="form-control" name="email" id="email" value="${usuario.email}" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="senha">Senha: </label>
                        <input type="password" class="form-control" name="senha" id="senha" value="${usuario.senha}" required>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="senha"> </label>
                        <input id="btnCadastrar" type="submit" value="Atualizar" class="btn btn-block btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
