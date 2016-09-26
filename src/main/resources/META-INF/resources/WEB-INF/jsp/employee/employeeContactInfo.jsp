<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>User Time Entry Page</title>
    <link href="/frontEndFiles/css/userContactInfo.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction</h1>

<h2>User Contact Information Page</h2>
<br><br>
<table>
    <tr>
        <td>ID:</td>
        <td><c:out value="${user.userId}" /></td>
    </tr>
    <tr>
        <td>First Name:</td>
        <td><c:out value="${user.firstName}" /></td>
    </tr>
    <tr>
        <td>Last Name:</td>
        <td><c:out value="${user.lastName}" /></td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><c:out value="${user.phone}" /></td>
    </tr>
    <tr>
        <td>Address:</td>
        <td><c:out value="${user.address}" /></td>
    </tr>
</table>
<br><br>

<br><br><br><br><br><br><br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

<a href="/">Home Page</a> | <a href="/home/pastProjects">Past Projects</a>
| <a href="/home/contactUs">Contact Us</a>| <a href="/home/employmentOpportunities">Employment Opportunities</a>
| <a href="/logout">Log Out</a>
</body>
</html>