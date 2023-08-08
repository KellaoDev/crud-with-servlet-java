<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="./Style/atualizarUsuario.css">
    <title>Atualizar Usuário</title>
</head>
<body>
 <header class="header">
        <h2>Atualizar Cadastro</h2>
    </header>
 <main class="main">
        <form method="post" action="cadastrarUsuario">
            <label for="nameAtualizar">Nome:</label>
            <input type="text" name="nameAtualizar" id="nameAtualizar">
            <label for="emailAtualizar">Email:</label>
            <input type="email" name="emailAtualizar" id="emailAtualizar">
            <label for="senhaAtualizar">Senha:</label>
            <input type="password" name="senhaAtualizar" id="senhaAtualizar">
            <input class="btn btn-success" type="submit" value="Salvar" id="button">
        </form>
</main>
</body>
</html>