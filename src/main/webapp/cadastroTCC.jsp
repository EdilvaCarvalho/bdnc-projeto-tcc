<%-- 
    Document   : cadastroTCC
    Created on : 09/10/2017, 09:05:44
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca Digital de Trabalhos de Conclusão de Curso</title>
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        <script src="js/jquery.maskedinput.min.js" type="text/javascript"></script>
        <script src="js/funcoes.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </head>
    <body>
        <div><jsp:include page="paginaDoUsuario.jsp"/></div>
        <br>
        <div class="container text-center">
            <h2>Dados do TCC</h2>
            <br>
        </div>
        <div class="container">
            <div class="row">
                <form method="post" id="cadastroCliente" action="Controller?command=CadastrarTCC" enctype = "multipart/form-data">
                    <div class="form-group col-md-6">
                        <label for="titulo">Título: </label>
                        <input type="text" class="form-control" name="titulo" id="titulo" autofocus required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="autor">Autor: </label>
                        <input type="text" class="form-control" name="autor" id="autor" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="orientador">Orientador: </label>
                        <input type="text" class="form-control" name="orientador" id="orientador" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="area">Área:</label>
                        <select class="form-control" name="area" id="area">
                            <c:forEach var="area" items="${areas}">
                                <option value="${area}">${area.descricao}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="ano">Ano: </label>
                        <input type="number" class="form-control" name="ano" id="ano" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="palavraChave">Palavra Chave: </label>
                        <input type="text" class="form-control" name="palavraChave" id="palavraChave" required>
                    </div>
                    <div id="palavrasChave"></div>
                    <div class="form-group col-md-12">
                        <a href="#" id="add" class="btn btn-success btn-lg btn-xs">+ Adicionar mais Palavras Chave</a><br>
                    </div>
                    <div class="form-group col-md-12">
                        <label for="resumo">Resumo: </label>
                        <textarea class="form-control" name="resumo" id="resumo" required></textarea>
                    </div>
                    <div class="form-group col-md-12">
                        <label for="pdf">PDF do TCC: </label>
                        <input type="file" class="form-control" name="pdf" id="pdf" required>
                    </div>
                    <div class="form-group col-md-3">
                        <input id="btnCadastrar" type="submit" value="Cadastrar" class="btn btn-block btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
