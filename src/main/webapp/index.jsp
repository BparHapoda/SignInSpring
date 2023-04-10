<%@ page contentType="text/html;charset=utf-8" %>
<html>
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
<h2>В][од в приложение:</h2>
    <form action="signIn" method="post">
        <div class="screen">
        <Label>Логин </Label>
        <input type="text" name="login" value="">
        <br>
        <Label>Пароль </Label>
        <input type="password" name="password" value="">
        <br>
        <input type="submit" value="Войти">
        </div>
    </form>
    <br>
    <a href="signUp.jsp">Регистрация</a>
</div>
</body>
</html>
