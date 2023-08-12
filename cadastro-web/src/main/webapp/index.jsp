<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="./Style/index.css">
    <title>Login</title>
</head>

<body>
    <header>
        <h2 class="header">Tela Login</h2>
    </header>
    <main class="main">
        <form action="login">
            <label for="nameLogin">Nome:</label>
            <input type="search" name="nomeLogin" id="nomeLogin" required="required">
            <label for="emailLogin">Email:</label>
            <input type="email" name="emailLogin" id="emailLogin">
            <label for="senhaLogin">Senha:</label>
            <input type="password" name="senhaLogin" id="senhaLogin" required="required">
            <input type="submit" value="Entrar" id="button">
            <a href="usuarioCadastro.jsp">Clique aqui para se cadastrar!</a>
        </form>
    </main>
</body>
</html>