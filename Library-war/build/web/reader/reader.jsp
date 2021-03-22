<%-- 
    Document   : reader
    Created on : 10.05.2019, 16:43:37
    Author     : Данил
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вибір книги</title>
        <link href="default.css" rel="stylesheet">
        <link href="table.css" rel="stylesheet">
        <jsp:useBean id="readerController" class="com.library.controller.ReaderController" scope="session"></jsp:useBean>
        </head>
        <body>
            <form method="post" action="${pageContext.request.contextPath}/Reader">
            <ul id="navbar">
                <li><button name="booklist" type="submit" value="1">До вибору книг</button></li>
                <li><button name="exit" type="submit" value="1">Вихід</button></li>
            </ul>
        </form>
        <h1>Ласкаво просимо, <%=readerController.getReaderName(request.getSession().getAttribute("id_reader"))%></h1>

        <table width = "100%">
            <tr>
                <td width = "50%">
                    <h2>Перелік необроблених замовлень</h2>
                    <form action="${pageContext.request.contextPath}/Reader" method="Post"> 
                        <table width ="95%" border ="1" class="simple-little-table">
                            <tr>
                                <td>Номер</td>
                                <td>Назва книги</td>
                                <td>Дата подання</td>
                            </tr>
                            <%int i = 0;%>
                            <c:forEach items="<%=readerController.getApplicationsPending(request.getSession().getAttribute("id_reader"))%>" var = "app">
                                <tr>
                                    <td><%=++i%></td>
                                    <td>${app.getIdBook().getName()}</td>
                                    <td>${app.getIssueDate()}</td>
                                    <td><button name="remove" type="submit" value="${app.getId()}">Відминити</button></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form>
                </td>
                <td width = "50%">
                    <h2>Перелік оброблених замовлень</h2>
                    <form action="${pageContext.request.contextPath}/PDF" method="Post"> 
                        <table width ="95%" border ="1" class="simple-little-table">
                            <tr>
                                <td>Номер</td>
                                <td>Назва книги</td>
                                <td>Дата подання</td>
                                <td>Статус</td>
                            </tr>
                            <%int j = 0;%>
                            <c:forEach items="<%=readerController.getApplicationsProcessed(request.getSession().getAttribute("id_reader"))%>" var = "app">
                                <tr>
                                    <td><%=++j%></td>
                                    <td>${app.getIdBook().getName()}</td>
                                    <td>${app.getIssueDate()}</td>
                                    <td>${app.getStatus()}</td>
                                    <td><button name="read" type="submit" value="${app.getIdBook().getId()}">Читати</button></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form>
                </td>
            </tr>
        </table>

    </body>
</html>
