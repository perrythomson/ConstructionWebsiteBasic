<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>List All Employees</title>

    <link href="/frontEndFiles/css/viewAllEmployees.css" rel="stylesheet" type="text/css" />
</head>
<body>

<h1>ADMIN HOME PAGE</h1>

<table>
    <tr>
        <th> Employee ID </th>
        <th> Edit Employee </th>
        <th> Role Type </th>
        <th> First Name </th>
        <th> Last Name </th>
        <th> Phone </th>
        <th> Address </th>
        <th> Salary</th>
        <th> Delete Employee</th>
    </tr>

    <c:forEach items="${employees}" var="employee">
        <tr>
            <td><a href="/admin/viewEmployee?employeeID=${employee.employeeID}"><c:out value="${employee.employeeID}" /></a></td>
            <td><a href="/admin/editEmployee?employeeID=${employee.employeeID}"> EDIT /></a></td>
            <td><c:out value="${roleType.roleType}" /></td>
            <td><c:out value="${employee.firstName}" /></td>
            <td><c:out value="${employee.lastName}" /></td>
            <td><c:out value="${employee.phone}" /></td>
            <td><c:out value="${employee.address}" /></td>
            <td><c:out value="${employee.salary}" /></td>
            <td><a href="/admin/deleteEmployee?id=${employee.employeeID}" onclick="return confirm('Are you sure?')" >DELETE: <c:out value="${employee.employeeID}" /></a></td>
<%--TODO do I need to also include a delete Admin?--%>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </tr>
    </c:forEach>
</table>

<br>
<ul>
    <li>
        <a href="/"> Home </a>
        <a href="/admin/addNewEmployee"> Add New Employee </a>
        <a href="/admin/viewAllPayPeriods"> View All Pay Periods </a>
        <a href="/admin/editEmployee"> Edit Employee </a>
        <li style="float:right" ><a href="/logout">Log Out</a></li>
    </li>
</ul>

<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>
