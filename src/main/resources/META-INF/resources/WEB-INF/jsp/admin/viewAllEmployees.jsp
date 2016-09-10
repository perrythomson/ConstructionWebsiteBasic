<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List All Employees</title>

</head>
<body>

ADMIN HOME PAGE

<table>
    <tr>
        <th> Employee ID |</th>
        <th> First Name |</th>
        <th> Last Name |</th>
        <th> Phone |</th>
        <th> Address |</th>
        <th> Salary</th>


    </tr>
    <c:forEach items="${employees}" var="employees">
        <tr>
            <td><a href="/viewEmployee?employeeID=${employee.employeeID}"><c:out value="${employee.employeeID}" /></a></td>
            <td><c:out value="${employee.firstName}" /> | </td>
            <td><c:out value="${employee.lastName}" /> | </td>
            <td><c:out value="${employee.phone}" /> | </td>
            <td><c:out value="${employee.address}" /> | </td>
            <td><c:out value="${employee.salary}" /> | </td>
        </tr>
    </c:forEach>
</table>

<br><br>
<ul>
    <li>
        <a href="/">HOME</a>
        <a href="/admin/addNewEmployee"> Add New Employee  |</a>
        <a href="/admin/viewAllPayPeriods"> View All Pay Periods  |</a>
        <%--<a href="/admin/view"> Add New Employee  |</a>--%>
        <%--<a href="/admin/editEmployee"> Edit Employee  |</a>--%>
        <%--<a href="/admin/viewAllEmployees"> View All Employees  |</a>--%>
        <%--<a href="/admin/viewEmployee"> View Employee  |</a>--%>
        <a href="/logout">Log Out</a>
    </li>
</ul>

<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>
