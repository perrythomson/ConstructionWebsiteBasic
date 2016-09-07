<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Employee Time Entry Page</title>
    <link href="/META-INF/resources/frontEndFiles/css/homePage.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction</h1>

<h2>Employee Contact Information Page</h2>
<br><br>
<table>
    <tr>
        <td>ID:</td>
        <td><c:out value="${employee.employeeID}" /></td>
    </tr>
    <tr>
        <td>First Name:</td>
        <td><c:out value="${employee.firstName}" /></td>
    </tr>
    <tr>
        <td>Last Name:</td>
        <td><c:out value="${employee.lastName}" /></td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><c:out value="${employee.phone}" /></td>
    </tr>
    <tr>
        <td>Address:</td>
        <td><c:out value="${employee.address}" /></td>
    </tr>
</table>
<br><br>

<br><br><br><br><br><br><br><br>
<a href="/">Home Page</a> | <a href="/home/pastProjects">Past Projects</a> | <a href="/home/contactUs">Contact Us</a>| <a href="/home/employmentOpportunities">Employment Opportunities</a> | <a href="/logout">Log Out</a>
</body>
</html>