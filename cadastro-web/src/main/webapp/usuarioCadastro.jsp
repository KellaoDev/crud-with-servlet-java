<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="./Style/TelaCadastro.css">
    <title>Cadastro de Usuário</title>
</head>
<body>
	<%
	String nome = request.getParameter("nome");
	if(nome == null)
		nome = "";
	
	String email = request.getParameter("email");
	if(email == null)
		email = "";
	%>


    <header class="header">
        <h2>Cadastro de Usuário</h2>
    </header>
    <main class="main">
        <form method="post" action="cadastrarUsuario">
            <label for="nameCrud">Nome:</label>
            <input type="text" name="nameCrud" id="nameCrud" value="${nome}">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" value="${email}">
            <label for="senha">Senha:</label>
            <input type="password" name="senha1" id="senha1">
            <label for="senha">Repita a senha:</label>
            <input type="password" name="senha2" id="senha2">
            <label for="data">Data de Nascimento:</label>
            <input type="date" name="dataCadastro" id="dataCadastro" />
            <div class="flex">
                <a class="btn btn-primary" href="index.html" role="button" id="button">Voltar</a>
                <input class="btn btn-primary" type="submit" value="Salvar" id="button">
                <a class="btn btn-primary" href="cadastrarUsuario" role="button" id="button">Listar Usuários</a>
            </div>
        </form>
        <c:if test="${not empty param.nameCrud}">
        	<hr>
        	<div class="alert alert-danger" roles="alert">
        		<span>${param.nameCrud}, as senhas informadas não são iguais</span>
        	</div>
        </c:if>
    </main>
</body>
</html>