<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h1>Add User</h1>
<form name="newUserForm" method="POST" action="/saveNewUser">
    username: <input type="text" name="username"><br>
    password: <input type="text" name="password"><br>
    email: <input type="text" name="email"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit">
</form>
</body>
</html>
