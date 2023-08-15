<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <link rel="stylesheet" href="./Style/usuarioAtualizar.css">
    <title>Atualizar Usuário</title>
</head>
<body>
 <header class="header">
        <h2>Atualizar Cadastro</h2>
    </header>
 <main class="main">
        <form method="post" action="atualizarUsuario">
        	<input type="hidden" name="id" value="${usuario.id}">
            <label for="nameAtualizar">Nome:</label>
            <input type="text" name="nameAtualizar" id="nameAtualizar" value="${usuario.nome}">
            <label for="emailAtualizar">Email:</label>
            <input type="email" name="emailAtualizar" id="emailAtualizar" value="${usuario.email}">
            <label for="senhaAtualizar">Digite a nova senha:</label>
            <input type="password" name="senhaAtualizar01" id="senhaAtualizar01" required="required">
            <label for="senhaAtualizar">Repita a senha:</label>
            <input type="password" name="senhaAtualizar02" id="senhaAtualizar02" required="required">
            <button class="btn btn-primary" type="submit" id="button">Salvar</button>
        </form>
        <c:if test="${not empty mensagem}">
        	<hr>
        	<div class="alert alert-danger" role="alert">
        		<span>${mensagem}</span>
        	</div>
        </c:if>
</main>
</body>
</html>