<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Employee</title>

</head>
<body>

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
    <tr>
        <td>Salary:</td>
        <td><c:out value="${employee.salary}" /></td>
    </tr>
</table>
<br><br>
<ul>
    <li>
        <a href="/">HOME</a>
        <a href="/addNewEmployee"> Add New Employee </a>
        <a href="/editEmployee"> Edit Employee </a>
        <a href="/viewAllEmployees"> View All Employees </a>
        <a href="/viewEmployee"> View Employee </a>
    </li>
</ul>

<br><br>

</body>
</html>