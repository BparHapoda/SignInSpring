<%--
  Created by IntelliJ IDEA.
  User: julia
  Date: 09.04.2023
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signUp page</title>
</head>

<style>
    .screen{
        display: flex;
        align-items: center;
        flex-direction: column;
        justify-content: center;
    }
    button{width: 300px;
        height: 50px;}
</style>
<body>
<div class="screen">
    <h2>Регистрация:</h2>
    <form action="signUp" method="post">
        <div class="screen">
            <Label>Имя </Label>
            <input type="text" name="name" value="">
            <br>
            <Label>Фамилия </Label>
            <input type="text" name="surname" value="">
            <br>
            <Label>email </Label>
            <input type="email" name="email" value="">
            <br>
            <Label>Логин </Label>
            <input type="text" name="login" value="">
            <br>
            <Label>Пароль </Label>
            <input type="password" name="password" value="">
            <br>


            <input type="submit" value="Зарегистрироваться">
        </div>
    </form>
    <br>
</div>
</body>
</html>
