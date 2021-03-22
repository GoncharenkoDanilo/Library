<%-- 
    Document   : registration
    Created on : 19.05.2019, 10:25:18
    Author     : Данил
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регістрація</title>
        <link href="default.css" rel="stylesheet">
        <link href="table.css" rel="stylesheet">
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/Registration" method="Post">   
            <div class="loginpass">
                <table>
                    <h2>Реєстрація нового користувача</h2><br>

                    <tr>
                        <td>Прізвище та ім'я: </td> <td><input type="text" name = "fullname"></td>
                    </tr>
                    <tr>
                        <td>Адреса: </td> <td><input type="text" name = "address"></td>
                    </tr>
                    <tr>
                        <td>Телефон: </td> <td><input type="text" name = "phone"></td>
                    </tr>
                    <tr>
                        <td>День народження: </td> <td><input type="date" name = "birthday"></td>
                    </tr>
                    <tr>
                        <td>Логін: </td> <td><input type="text" name = "login"></td>
                    </tr>
                    <tr>
                        <td>Пароль: </td> <td><input type="password" name = "password"></td>
                    </tr>
                    <tr>
                        <td></td> <td><input type="submit" name = "submit" value="Зареєструватися"></td>
                    </tr>
                </table>

                
            </div>
        </form>
    </body>
</html>
