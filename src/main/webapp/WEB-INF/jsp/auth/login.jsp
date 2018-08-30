<%-- 
    Document   : login
    Created on : Aug 30, 2018, 3:00:06 PM
    Author     : Leonardo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Auth (login)!</h1>
        <c:if test="${not empty errors}">
            <c:forEach items="${errors}" var="err">
            <li>${err.category} ${err.message}</li>
            </c:forEach>
        </c:if>
    <form action="<c:url value="/auth/entrar" />" method="POST">
        <div>
            <label>Usuario:</label>
            <input type="text" name="usuario.usuario"/>
        </div>
        <div>
            <label>Senha:</label>
            <input type="text" name="usuario.senha"/>
        </div>
        <div>
            <button type="submit">Gravar</button>
        </div>
    </form>
        
    </body>
</html>