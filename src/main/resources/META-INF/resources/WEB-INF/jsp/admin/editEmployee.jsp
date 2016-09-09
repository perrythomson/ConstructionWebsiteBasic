<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee Information</title>

</head>
<body>
Edit Employee

Edit Owner
<br><br>
<form name="updateEmployeeForm" method="POST" action="/admin/updateEmployee">
    Employee ID: <input type="text" name="employeeID" value="<c:out value="${employee.employeeID}" />" readonly /><br>
    First Name: <input type="text" name="firstname" value="<c:out value="${employee.firstName}" />" /><br>
    Last Name: <input type="text" name="lastname" value="<c:out value="${employee.lastName}" />" /><br>
    Phone: <input type="text" name="phone" value="<c:out value="${employee.phone}" />" /><br>
    Address: <input type="text" name="address" value="<c:out value="${employee.address}" />" /><br>
    Salary: <input type="text" name="address" value="<c:out value="${employee.salary}" />" /><br>
    <input type="submit">
</form>

</body>
<br><br>
<ul>
    <li>
        <a href="/">HOME</a>
        <a href="/admin/addNewEmployee"> Add New Employee </a>
        <%--<a href="/editEmployee"> Edit Employee </a>--%>
        <a href="/admin/viewAllEmployees"> View All Employees </a>
        <a href="/admin/viewEmployee"> View Employee </a>
    </li>
</ul>

<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>
