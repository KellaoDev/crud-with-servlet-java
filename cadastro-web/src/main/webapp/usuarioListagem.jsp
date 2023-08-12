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
    <link rel="stylesheet" href="./Style/usuarioListagem.css">
    <title>Lista de Usuários</title>
</head>
<body>
	<header class="header">
		<h2>Lista de Usuários</h2>
	</header>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${usuarios}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? '6ead4e' : 'aaee88'}">
				<td>${usuario.id}</td>
				<td>${usuario.nome}</td>
				<td> <a href="mailto:${usuario.email}">${usuario.email}</a></td>
				<td> <a class="btn btn-success" href="usuarioAtualizar?id=${usuario.id}" role="button">editar</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table> 
	<a class="btn btn-primary" href="index.jsp" role="button" id="button">Voltar</a>
</body>
</html>