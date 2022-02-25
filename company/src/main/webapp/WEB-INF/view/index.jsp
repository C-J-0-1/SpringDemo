<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Form Demo</title>
    </head>
    <body>
        <h1 align = "center">Form Demo</h1>

        <form:form>
            <form:input path = "First Name:"/>
            <form:input path = "Last Name:"/>
        </form:form>
    </body>
</html>