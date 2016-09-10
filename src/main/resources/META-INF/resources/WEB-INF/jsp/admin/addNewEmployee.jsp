<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Employee</title>

</head>
<body>

Add Employee
<br><br>
<form name="newEmployeeForm" method="POST" action="saveNewEmployee"> <!-- post information is readable get information is hidden !-->
    Role Type: <select name="roleType">
                <c:forEach var="roleType" items="${roleTypes}">
                <option value="<c:out value="${roleType}"/>"><c:out value="${roleType}"/></option></c:forEach>
                </select><br>
    First Name: <input type="text" name="firstname" /><br>
    Last Name: <input type="text" name="lastname" /><br>
    Phone: <input type="text" name="phone" /><br>
    Address: <input type="text" name="address" /><br>
    Email: <input type="email" name="email" /><br>
    Salary: <input type="text" name="salary" /><br>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit">

</form>

<br><br>
<ul>
    <li>
        <a href="/">HOME</a>
        <a href="/admin/">Admin Page</a>
        <%--<a href="/admin/addNewEmployee"> Add New Employee </a>--%>
        <%--<a href="/admin/editEmployee"> Edit Employee </a>--%>
        <%--<a href="/admin/viewEmployee"> View Employee </a>--%>
        <a href="/logout">Log Out</a>
    </li>
</ul>

<br><br>


</body>
</html>