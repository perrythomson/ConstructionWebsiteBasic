<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Edit Employee Information</title>

    <link href="/frontEndFiles/css/editUser.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>Admin:  Edit Employee</h1>

<br><br>
<form name="updateEmployeeForm" method="POST" action="/admin/">
    User ID: <input type="text" name="userID" value="<c:out value="${user.userID}" />" readonly /><br>
    Role Type: <select name="roleType">
    <c:forEach var="roleType" items="${roleTypes}">
        <option value="<c:out value="${roleType}"/>"><c:out value="${roleType}"/></option></c:forEach>
    </select><br>
    First Name: <input type="text" name="firstname" value="<c:out value="${user.firstName}" />" /><br>
    Last Name: <input type="text" name="lastname" value="<c:out value="${user.lastName}" />" /><br>
    Phone: <input type="text" name="phone" value="<c:out value="${user.phone}" />" /><br>
    Address: <input type="text" name="address" value="<c:out value="${user.address}" />" /><br>
    Salary: <input type="text" name="address" value="<c:out value="${user.salary}" />" /><br><br><br>
    User Name:  <input type="text" name="username" autofocus required value="<c:out value="${user.userName}"/>" /><br>
    Password:   <input type="password" name="password" required value="<c:out value="${user.password}"/>" /> <br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit"><br>
</form>

<br><br>
<ul>
    <li>
        <a href="/">Home</a>
        <a href="/admin/addNewUser"> Add New Employee </a>
        <a href="/admin/"> View All Employees </a>
        <a href="/admin/viewAllPayPeriods"> View All Pay Periods </a>
            <li style="float:right" ><a href="/logout">Log Out</a></li>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </li>
</ul>

<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>
