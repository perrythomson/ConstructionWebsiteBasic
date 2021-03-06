
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>View All Coworkers</title>

    <link href="/frontEndFiles/css/userHomePage.css" rel="stylesheet" type="text/css" />


</head>
<body>

<h1>BFE Construction: View All Users</h1>

<table>
    <tr>
        <th> Emp-ID </th>
        <th> Role </th>
        <th> </th>
        <th> First Name </th>
        <th> Last Name </th>
        <th> </th>
        <th> Phone </th>
        <th> </th>
        <th> Address </th>
        <th> </th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
                <%--<td><a href="/admin/viewUser?userID=${user.userID}"><c:out value="${user.userID}" /></a></td>--%>
            <td align="center"><c:out value="${user.userId}" /></td>
            <td><c:out value="${roleType.roleType}" /></td>
            <th>  </th>
            <td><c:out value="${user.firstName}" /></td>
            <td><c:out value="${user.lastName}" /></td>
            <th>  </th>
            <td><c:out value="${user.phone}" /></td>
            <th>  </th>
            <td><c:out value="${user.address}" /></td>
            <th>  </th>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </tr>
    </c:forEach>
</table>

<br>
<ul>
    <li>
        <a href="/"> Home </a>
        <a href="/user/"> User Home Page </a>
        <a href="/admin/viewAllPayPeriods"> View All Pay Periods </a>
    <li style="float:right" ><a href="/logout">Log Out</a></li>
    </li>
</ul>

<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>