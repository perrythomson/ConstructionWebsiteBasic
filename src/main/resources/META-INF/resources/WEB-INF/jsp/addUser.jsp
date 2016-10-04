<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />
    <title>Add New User</title>
    <link href="/frontEndFiles/css/editUser.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>Add New User</h1>
<form name="newUserForm" method="POST" action="/admin/saveNewUser">
    <%--<form name="newUserForm" method="POST" action="/admin/saveNewUser">--%>
    username: <input type="text" name="username"><br>
    password: <input type="text" name="password"><br>
    email: <input type="email" name="email"><br>

    first name: <input type="text" name="firstName"><br>
    last name: <input type="text" name="lastName"><br>
    phone: <input type="text" name="phone"><br>
    address: <input type="text" name="address"><br>

    salary: <input type="number" name="salary"><br>

    Role Type: <select name="roleType">
        <c:forEach var="roleType" items="${roleTypes}">
            <option value="<c:out value="${roleType}"/>"><c:out value="${roleType}"/></option></c:forEach>
    </select><br>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit">
</form>
<br>
<br>








<br>
<ul>
    <li>
        <a class="two" href="/"> Home Page </a>
        <a class="two" href="/admin/"> Admin Home Page </a>
        <a class="two" href="/admin/viewAllUsers"> View All Users </a>
        <a class="two" href="/admin/viewAllPayPeriods"> View All Pay Periods </a>
    <li style="float:right" ><a class="two" href="/logout">Log Out</a></li>
    </li>
</ul>



<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />


</body>
</html>
