<%-- 
    Document   : manager
    Created on : 23.05.2019, 13:58:31
    Author     : Данил
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="managerController" class="com.library.controller.ManagerController" scope="session"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Список книг</title>
            <link href="default.css" rel="stylesheet">
            <link href="table.css" rel="stylesheet">
        </head>
        <body>
            <form method="post" action="${pageContext.request.contextPath}/Manager">
            <ul id="navbar">
                <li><button name="booklist" type="submit" value="1">На головну</button></li>
                <li><button name="addNewBook" type="submit" value="1">Додати нову книгу</button></li>
                <li><button name="exit" type="submit" value="1">Вихід</button></li>
            </ul>
        </form>
        <h2>Перелік книг</h2>
        <table width ="100%">
            <tr>
                <td>

                    <form action="${pageContext.request.contextPath}/Manager" method="Post">           
                        <table  border ="1" class="simple-little-table">
                            <tr>
                                <td>Назва</td>
                                <td>Автор</td>
                                <td>Жанр</td>
                                <td>Рік</td>
                                <td>Видавництво</td>
                                <td>Зображення</td>
                            </tr>

                            <c:forEach items="<%=request.getAttribute("allBooks")%>" var = "books">
                                <tr>
                                    <td>${books.getName()}</td>
                                    <td>${books.getAuthor().getSurname()}</td>
                                    <td>${books.getGenre().getName()}</td>
                                    <td>${books.getYear()}</td>
                                    <td>${books.getPublish()}</td>
                                    <td><img width="70" src="${pageContext.request.contextPath}/ImageServlet?id=${books.getId()}" /></td>
                                    <td><button name="delete" type="submit" value="${books.getId()}">Видалити</button><br><br>
                                        <button name="alter" type="submit" value="${books.getId()}">Змінити</button></td>
                                </tr>
                            </c:forEach>
                        </table>        
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/Manager" method="Post">     
                        <br>
                        <input type="text" name ="searchRequest"> <select name = "type">
                            <option value="name">Назва</option>
                            <option value="authorName">Автор</option>
                        </select><br><br>
                        <input type="submit" name ="search" value="Пошук"><br>
                    </form>


                </td>
                <td width = 20%>
                    <form action="${pageContext.request.contextPath}/Manager" method="Post">     
                        <ul>
                            <li><button name = "booklist" value="${genre.getId()}">Всі жанри</button></li>
                                <c:forEach items="<%=managerController.getAllGenres()%>" var = "genre">
                                <li><button name = "genres" value="${genre.getId()}">${genre.getName()}</button></li>
                                </c:forEach>
                        </ul>
                    </form>
                </td>
                </form>
            </tr>
        </table>
    </body>
</html>