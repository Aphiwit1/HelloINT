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
        <h1><c:out value="${hello}"/></h1>
        <form action="hello">
            <input type="submit" value="Get hello message">
        </form>
    </body>
</html>
