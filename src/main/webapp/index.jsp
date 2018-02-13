<%-- 
    Document   : hello
    Created on : Feb 3, 2018, 3:04:27 PM
    Author     : jiraw
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <img src="Photo.png" />
        <form action="hello">
            <input type="submit" value="Get hello message">
            <h1>
                <c:forEach items="${hello}" var="h">
                    ${h}
                </c:forEach>
            </h1>
        </form>
    </center>
</body>
</html>
