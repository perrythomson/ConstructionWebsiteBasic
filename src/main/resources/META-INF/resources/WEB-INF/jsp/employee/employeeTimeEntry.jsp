<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ID" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Employee Time Entry Page</title>
    <link href="/frontEndFiles/css/employeeTimeEntry.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction</h1>

<h2>Employee Time Entry Page</h2>

<form name="employeeTimeEntry" method="POST" action="/updateTimeSheet">
    Calendar Date: <input type="date" name="day_of_the_week" value="<c:out value="${timeSheetTracker.date}"/>"/><br>
    Employee ID: <input type="text" name="employeeID" value="<c:out value="${employee.employeeID}" />" readonly /><br>
    First Name: <input type="text" name="firstName" value="<c:out value="${employee.firstName}" />" readonly /><br>
    Last Name: <input type="text" name="lastName" value="<c:out value="${employee.lastName}" />" readonly /><br>
    Hours Worked: <input type="number" name="hoursWorked" value="<c:out value="${timeSheetTracker.hoursWorked}"/>"/>




    <input type="submit">
</form>
<br><br><br><br><br><br><br><br>
<a href="/">Home Page</a> | <a href="/employee/updateContactInfo">Update Contact Information</a> | <a href="/logout">Log Out</a>
</body>
</html>