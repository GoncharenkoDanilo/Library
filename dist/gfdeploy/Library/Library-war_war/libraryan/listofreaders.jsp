<%-- 
    Document   : listofreaders
    Created on : 21.05.2019, 16:04:35
    Author     : Данил
--%>

<%@page import="com.library.entitye.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="libraryanController" class="com.library.controller.LibraryanController" scope="session"></jsp:useBean>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%List<User> users = (List<User>)request.getAttribute("users");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список читачів</title>
        <link href="default.css" rel="stylesheet">
        <link href="table.css" rel="stylesheet">
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/Libraryan">
            <ul id="navbar">
                <li><button name="libraryan" type="submit" value="1">На головну</button></li>
                <li><button name="exit" type="submit" value="1">Вихід</button></li>
            </ul>
        </form>
        <h2>Список читачів</h2>
        <form action="${pageContext.request.contextPath}/Libraryan" method="Post">           
            <table border ="1" width = "50%" class="simple-little-table">
                <tr>
                    <td>ПІБ</td>
                    <td>Адреса</td>
                    <td>Телефон</td>
                    <td>Дата народження</td>
                    <td>Дата реєстрації</td>
                    <td>Кількість заборгованостей</td>

                </tr>

                <%int i = 0;%>
                <c:forEach items="<%=libraryanController.getAllReaders()%>" var = "reader">
                    <tr>
                        <td>${reader.getFullName()}</td>
                        <td>${reader.getAddress()}</td>
                        <td>${reader.getPhone()}</td>
                        <td>${reader.getBirthday()}</td>
                        <td>${reader.getStartWorkDate()}</td>
                        <td><%=libraryanController.getAllDebt(users.get(i++).getId().toString()).size()%></td>
                    </tr>
                </c:forEach>
            </table>                
        </form>
    </body>
</html>
