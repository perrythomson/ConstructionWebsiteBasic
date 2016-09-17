<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Add New Employee</title>

    <link href="/frontEndFiles/css/adminHomePage.css" rel="stylesheet" type="text/css" />
</head>
<body>

<h1>Add Employee</h1>

<form name="newEmployeeForm" method="POST" action="/admin/saveNewEmployee"> <!-- post information is readable get information is hidden !-->
    Role Type: <select name="roleType">
                <c:forEach var="roleType" items="${roleTypes}">
                <option value="<c:out value="${roleType}"/>"><c:out value="${roleType}"/></option></c:forEach>
                </select><br>
    First Name: <input type="text" name="firstName" /><br>
    Last Name:  <input type="text" name="lastName" /><br>
    Phone:      <input type="text" name="phone" /><br>
    Address:    <input type="text" name="address" /><br>
    Email:      <input type="email" name="email" /><br>
    Salary:     <input type="text" name="salary" /><br><br><br>
    User Name:  <input type="text" name="username" autofocus required/><br>
    Password:   <input type="password" name="password" required/><br>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit"><br>
</form>


<ul>
    <li>
        <a href="/">Home</a>
        <a href="/admin/">Admin Page</a>
        <li style="float:right" ><a href="/logout">Log Out</a></li>
    </li>
</ul>

<br><br>


</body>
</html>