<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Employee</title>

</head>
<body>

Add Employee
<br><br>
<form name="newEmployeeForm" method="POST" action="/saveNewEmployee"> <!-- post information is readable get information is hidden !-->
    First Name: <input type="text" name="firstname" /><br>
    Last Name: <input type="text" name="lastname" /><br>
    Phone: <input type="text" name="phone" /><br>
    Address: <input type="text" name="address" /><br>
    Salary: <input type="text" name="salary" /><br>
    <input type="submit">
</form>

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