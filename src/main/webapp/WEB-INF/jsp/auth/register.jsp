<%-- 
    Document   : register
    Created on : Aug 30, 2018, 3:00:22 PM
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
        <h1>Auth (Register)</h1>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
            <li>${err.category} ${err.message}</li>
        </c:forEach>
    </c:if>
    <form action="<c:url value="/auth/registrar" />" method="POST">
          <div>
            <label>Nome:</label>
            <input type="text" name="usuario.nome"/>
        </div>
        <div>
            <label>Usuario:</label>
            <input type="text" name="usuario.usuario"/>
        </div>
        <div>
            <label>Senha:</label>
            <input type="text" name="usuario.senha"/>
        </div>
        <div>
            <button type="submit">registrar</button>
        </div>
    </form>
</body>
</html>
