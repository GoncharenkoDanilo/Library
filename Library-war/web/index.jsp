<%-- 
    Document   : index
    Created on : 09.05.2019, 14:13:13
    Author     : Данил
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="default.css" rel="stylesheet">
    </head>
    <body>

        <form action="${pageContext.request.contextPath}/Session" method="Post"> 
            <div class="loginpass">
                <h1>Бібліотека</h1>
                <table>
                    <tr>
                        <td>Логін:</td>
                        <td> <input type="text" name="login"></td>
                    </tr>
                    <tr>
                    <tr>
                        <td>Пароль: </td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td>
                            <input class="submit" type="submit"
                                   name="submit" value="Увійти"> 
                            <input class="submit" type="submit"
                                   name="registration" value="Реєстрація"></td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>
