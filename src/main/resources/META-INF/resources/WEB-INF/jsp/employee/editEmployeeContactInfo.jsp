<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee Contact Information</title>

</head>
<body>
Edit Employee Contact Information

<br><br>
<form name="updateEmployeeContactInfoForm" method="POST" action="/employee/updateEmployee">
    Employee ID: <input type="text" name="employeeID" value="<c:out value="${employee.employeeID}" />" readonly /><br>
    First Name: <input type="text" name="firstName" value="<c:out value="${employee.firstName}" />" /><br>
    Last Name: <input type="text" name="lastName" value="<c:out value="${employee.lastName}" />" /><br>
    Phone: <input type="text" name="phone" value="<c:out value="${employee.phone}" />" /><br>
    Address: <input type="text" name="address" value="<c:out value="${employee.address}" />" /><br>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <input type="submit">
</form>

</body>


</body>
</html>