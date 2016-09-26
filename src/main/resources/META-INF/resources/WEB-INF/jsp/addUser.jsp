<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New User</title>
</head>
<body>
<h1>Add New User</h1>
<form name="newUserForm" method="POST" action="/admin/saveNewUser">
    <%--<form name="newUserForm" method="POST" action="/admin/saveNewUser">--%>
    username: <input type="text" name="username"><br>
    password: <input type="text" name="password"><br>
    email: <input type="text" name="email"><br>

    <%--TODO would I add role type here for initial startup?--%>
    Role Type: <select name="roleType">
        <c:forEach var="roleType" items="${roleTypes}">
            <option value="<c:out value="${roleType}"/>"><c:out value="${roleType}"/></option></c:forEach>
    </select><br>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit">
</form>
</body>
</html>
