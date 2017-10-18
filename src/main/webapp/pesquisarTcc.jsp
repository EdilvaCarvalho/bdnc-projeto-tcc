<%-- 
    Document   : paginaDeResposta
    Created on : 26/04/2017, 13:00:34
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
        <div>
            <br><br><br>
            <div class="container text-center">
                <h3>Busque um tcc</h3>
                <div class="container">
                    <div class="row">
                        <form method="post" id="cadastroCliente"  enctype = "multipart/form-data" action="Controller?command=BuscarTccAno" >
                            <div class="form-group col-md-6">
                                <label for="titulo">Título: </label>
                                <input type="text" class="form-control" name="pesquisa" id="titulo" autofocus required>
                            </div>
                            <div class="form-group col-md-3">
                                <input id="btnCadastrar" type="submit" value="buscar" class="btn btn-block btn-primary">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
