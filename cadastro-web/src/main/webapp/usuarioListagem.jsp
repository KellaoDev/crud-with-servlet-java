<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="assets/"
	data-template="vertical-menu-template-free">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>Tables - Basic Tables | Sneat - Bootstrap 5 HTML Admin
	Template - Pro</title>

<meta name="description" content="" />

<!-- Favicon -->
<link rel="icon" type="image/x-icon"
	href="assets/img/favicon/favicon.ico" />

<!-- Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet" />

<!-- Icons. Uncomment required icon fonts -->
<link rel="stylesheet" href="assets/vendor/fonts/boxicons.css" />

<!-- Core CSS -->
<link rel="stylesheet" href="assets/vendor/css/core.css"
	class="template-customizer-core-css" />
<link rel="stylesheet" href="assets/vendor/css/theme-default.css"
	class="template-customizer-theme-css" />
<link rel="stylesheet" href="assets/css/demo.css" />

<!-- Vendors CSS -->
<link rel="stylesheet"
	href="assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

<!-- Page CSS -->

<!-- Helpers -->
<script src="assets/vendor/js/helpers.js"></script>

<!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
<!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
<script src="assets/js/config.js"></script>
</head>
<body>

	<header>
		<h2 class="text-center mt-4">Lista de Usuários</h2>
	</header>

	<div class="content-xxl flex-grow-1 container-p-y">
		<div class="card">
			<h5 class="card-header">Tabela Cadastro</h5>
			<div class="table-responsive text-nowrap">
				<table class="table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Email</th>
							<th>&nbsp;</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody class="table-border-bottom-0">
						<c:forEach var="usuario" items="${usuarios}">
							<tr>
								<td>${usuario.id}</td>
								<td>${usuario.nome}</td>
								<td><a href="mailto:${usuario.email}">${usuario.email}</a></td>
								<td><a class="btn btn-success"
									href="atualizarUsuario?id=${usuario.id}" role="button">editar</a></td>
								<td><a class="btn btn-danger"
									href="excluirUsuario?id=${usuario.id}" role="button">excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br>
		<a class="btn btn-primary" href="usuarioCadastro.jsp" role="button">Voltar</a>
		</div>
	</div>
</body>
</html>