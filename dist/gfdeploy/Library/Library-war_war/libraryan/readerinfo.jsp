<%-- 
    Document   : readerinfo
    Created on : 18.05.2019, 13:00:36
    Author     : Данил
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.library.entitye.BookRental"%>
<%@page import="java.util.List"%>
<%@page import="com.library.entitye.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="libraryanController" class="com.library.controller.LibraryanController" scope="session"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Info</title>
            <link href="default.css" rel="stylesheet">
            <link href="table.css" rel="stylesheet">
        </head>
        <body>
        <%User user_info = libraryanController.getReaderInfo(request.getParameter("id_info"));%>
        <%List<BookRental> debts = libraryanController.getAllDebt(request.getParameter("id_info"));%>
        <h2>Інформація про кліента <%=user_info.getFullName()%></h2><br>
        Прізвище та ім'я: <%=user_info.getFullName()%><br>
        Дата реєстрації: <%=user_info.getStartWorkDate()%><br>
        Телефон: <%=user_info.getPhone()%><br>
        Адреса: <%=user_info.getAddress()%><br>
        Кількість заборгованостей: <%=debts.size()%><br>
        <c:if test="${debts.size()!=0}">
            <table border ="1" width = "50%" class="simple-little-table">
                <tr>
                    <td>Номер</td>
                    <td>Назва книги</td>
                    <td>Дата подання</td>
                </tr>
                <%int i = 0;%>
                <c:forEach items="<%=debts%>" var = "debt">
                    <td><%=++i%></td>
                    <td>${debt.getIdBook().getName()}</td>
                    <td>${debt.getIssueDate()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
