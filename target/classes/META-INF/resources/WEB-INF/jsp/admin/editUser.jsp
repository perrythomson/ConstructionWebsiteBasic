<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Edit User Information</title>

    <link href="/frontEndFiles/css/editUser.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>Admin:  Edit User</h1>

<br><br>
<form name="updateUserForm" method="POST" action="/admin/saveEditedUser">
    User ID: <input type="text" name="userId" value="<c:out value="${user.userId}" />" readonly /><br>
    Role Type: <select name="roleType">
    <c:forEach var="roleType" items="${roleTypes}">
        <c:forEach var="userRole" items="${user.roles}">
            <option <c:if test="${roleType eq userRole}"><c:out value="selected" /></c:if>
                value="<c:out value="${roleType}"/>"><c:out value="${roleType}"/>
            </option>
        </c:forEach>
    </c:forEach>
    </select><br>

    First Name: <input type="text" name="firstName" value="<c:out value="${user.firstName}" />" /><br>
    Last Name: <input type="text" name="lastName" value="<c:out value="${user.lastName}" />" /><br>
    Phone: <input type="text" name="phone" value="<c:out value="${user.phone}" />" /><br>
    Address: <input type="text" name="address" value="<c:out value="${user.address}" />" /><br>
    Email: <input type="text" name="email" value="<c:out value="${user.email}" />" /><br>
    Salary: <input type="text" name="salary" value="<c:out value="${user.salary}" />" /><br><br><br>
    User Name:  <input type="text" name="userName" autofocus required value="<c:out value="${user.userName}"/>" /><br>
    Password:   <input type="password" name="password" required value="<c:out value="${user.password}"/>" /> <br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit"><br>
</form>

<br><br>
<ul>
    <li>
        <a  class="two" href="/">Home</a>
        <a  class="two" href="/admin/addNewUser"> Add New User </a>
        <a  class="two" href="/admin/"> View All Users </a>
        <a  class="two" href="/admin/viewAllPayPeriods"> View All Pay Periods </a>
            <li style="float:right" ><a  class="two" href="/logout">Log Out</a></li>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </li>
</ul>

<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>
