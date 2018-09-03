<%-- 
    Document   : form
    Created on : Aug 30, 2018, 1:16:20 PM
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
        <h1>Carro (Cadastro)</h1>
        <c:if test="${not empty errors}">
            <c:forEach items="${errors}" var="err">
            <li>${err.category} ${err.message}</li>
            </c:forEach>
        </c:if>
            <form action="${linkTo[CarroController].save}" method="POST">
        <div>
            <label>Marca:</label>
            <input type="text" name="carro.marca"/>
        </div>
        <div>
            <label>Modelo:</label>
            <input type="text" name="carro.modelo"/>
        </div>
        <div>
            <button type="submit">Gravar</button>
        </div>
    </form>
</body>
</html>
