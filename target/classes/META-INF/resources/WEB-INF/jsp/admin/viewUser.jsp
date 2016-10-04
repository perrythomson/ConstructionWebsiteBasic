<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View User</title>

</head>
<body>

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
    <tr>
        <td>Salary:</td>
        <td><c:out value="${user.salary}" /></td>
    </tr>
</table>
<br><br>
<ul>
    <li>
        <a href="/">HOME</a>
        <a href="/addNewUser"> Add New User </a>
        <a href="/editUser"> Edit User </a>
        <a href="/viewAllUsers"> View All Users </a>
        <a href="/viewUser"> View User </a>
    </li>
</ul>

<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>