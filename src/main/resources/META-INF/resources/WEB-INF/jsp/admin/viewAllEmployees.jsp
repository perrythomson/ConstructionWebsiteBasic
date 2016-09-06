<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List All Employees</title>

</head>
<body>

<table>
    <tr>
        <th>Employee ID</th>
        <th>First</th>
        <th>Last</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Salary</th>

    </tr>
    <c:forEach items="${employees}" var="employees">
        <tr>
            <%--TODO make sure that this href is correct for employeeID instead of employeeid--%>
            <td><a href="/viewEmployee?employeeID=${employee.employeeID}"><c:out value="${employee.employeeID}" /></a></td>
            <td><c:out value="${employee.firstName}" /></td>
            <td><c:out value="${employee.lastName}" /></td>
            <td><c:out value="${employee.phone}" /></td>
            <td><c:out value="${employee.address}" /></td>
            <td><c:out value="${employee.salary}" /></td>
        </tr>
    </c:forEach>
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
