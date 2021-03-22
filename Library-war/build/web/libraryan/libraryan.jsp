<%-- 
    Document   : libraryan
    Created on : 17.05.2019, 17:01:05
    Author     : Данил
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libraryan</title>
        <jsp:useBean id="libraryanController" class="com.library.controller.LibraryanController" scope="session"></jsp:useBean>
            <link href="default.css" rel="stylesheet">
            <link href="table.css" rel="stylesheet">
        </head>
        <body>



        <form method="post" action="${pageContext.request.contextPath}/Libraryan">
            <ul id="navbar">
                <li><button name="readerlist" type="submit" value="1">Список читачів</button></li>
                <li><button name="exit" type="submit" value="1">Вихід</button></li>
            </ul>
        </form>
        <h2>Перелік замовлень</h2>
        <form action="${pageContext.request.contextPath}/Libraryan" method="Post">           
            <table border ="1" width = "50%" class="simple-little-table">
                <tr>
                    <td>Замовник</td>
                    <td>Назва книги</td>
                    <td>Дата замовлення</td>
                </tr>

                <c:forEach items="<%=libraryanController.getAllOrders()%>" var = "orders">
                    <tr>
                        <td><a href="libraryan/readerinfo.jsp?id_info=${orders.getIdReader().getId()}" >${orders.getIdReader().getFullName()}</a></td>
                        <td>${orders.getIdBook().getName()}</td>
                        <td>${orders.getIssueDate()}</td>
                        <td><button name="ok" type="submit" value="${orders.getId()}">Підтвердити</button>
                            <button name="cancel" type="submit" value="${orders.getId()}">Відмовити</button></td>
                    </tr>
                </c:forEach>
            </table>                
        </form>
    </body>
</html>
