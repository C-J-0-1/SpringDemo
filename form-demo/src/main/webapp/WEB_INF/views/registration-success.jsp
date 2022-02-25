<%@ page language = "java" contentType = "text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Registration Success</title>
</head>
<body>
    <div align="center">
    <h1>Registration Success</h1>
    <br>
    Full Name: ${student.name}<br>
    Email: ${student.email}<br>
    Password: ${student.password}<br>
    BirthDate: ${student.birthDate}<br>
    Branch: ${student.branch}<br>
    Gender: ${student.gender}<br>
    Hobbies: <c:forEach var="hobby" items="${student.hobbies}">
                ${hobby}, </c:forEach>
    </div>
</body>
</html>