<%-- 
    Document   : alterbook
    Created on : 23.05.2019, 16:11:54
    Author     : Данил
--%>

<%@page import="com.library.entitye.Genre"%>
<%@page import="com.library.entitye.Author"%>
<%@page import="java.util.List"%>
<%@page import="com.library.entitye.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
    List<Genre> genres = (List<Genre>) request.getAttribute("genres");
    List<Author> authors = (List<Author>) request.getAttribute("authors");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Змінити інформацію про книгу</title>
        <link href="default.css" rel="stylesheet">
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/Manager" method="Post" enctype="multipart/form-data"> 
            <table>
                <tr>
                    <td>Назва:</td><td> <input name ="name" type="text"</td>
                </tr>
                <tr>
                    <td>  Автор: </td>
                    <td>  <select name = "author">
                            <c:forEach items="<%=authors%>" var="author">
                                <option  value="${author.getId()}">${author.getSurname()}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>   Жанр:</td>
                    <td>   <select name = "genre">

                            <c:forEach items="<%=genres%>" var="genre">
                                <option  value="${genre.getId()}">${genre.getName()}</option>

                            </c:forEach>
                        </select></td>
                </tr>
                <tr><td>Рік: </td><td><input name ="year" type="text"></td></tr>
                <tr><td>Видавництво: </td><td><input name ="publish" type="text"></td></tr>
                <tr>
                    <td>Зображення: </td>

                    <td>
                        <img width="70" />
                        <input type="file" name="image" accept="image/jpg">
                    </td>
                </tr>
            </table>
            <input type="submit" name="doAddNewBook" value="Додати">
        </form>


    </body>
</html>
