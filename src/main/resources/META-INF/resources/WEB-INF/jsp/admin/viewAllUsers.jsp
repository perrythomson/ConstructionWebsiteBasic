<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>List All Users</title>

    <link href="/frontEndFiles/css/viewAllUsers.css" rel="stylesheet" type="text/css" />



<body>

<h1>ADMIN:  VIEW ALL EMPLOYEES</h1>
<div class="adminTables" ><table>
    <th>Employees</th>
    <tr>
        <th> Emp-ID </th>
        <th> Edit-Emp </th>
        <th> Role </th>
        <th> </th>
        <th> First Name </th>
        <th> Last Name </th>
        <th> </th>
        <th> Phone </th>
        <th> </th>
        <th> Address </th>
        <th> </th>
        <th> Salary</th>
        <th> </th>
        <th> Delete User</th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
                <%--<td><a href="/admin/viewUser?userID=${user.userID}"><c:out value="${user.userID}" /></a></td>--%>
            <td align="center"><c:out value="${user.userId}" /></td>
            <td align="center"><a href="/admin/editUser?userId=${user.userId}">EDIT</a></td>
            <td><c:out value="${roleType.roleType}" /></td>
            <th>  </th>
            <td><c:out value="${user.firstName}" /></td>
            <td><c:out value="${user.lastName}" /></td>
            <th>  </th>
            <td><c:out value="${user.phone}" /></td>
            <th>  </th>
            <td><c:out value="${user.address}" /></td>
            <th>  </th>
            <td align="right"><span class="dollars"><c:out value="${user.salary}" /></span></td>
            <th>  </th>
            <td align="center"><a href="/admin/deleteUser?id=${user.userId}" onclick="return confirm('Are you sure?')" >DELETE: <c:out value="${user.userId}" /></a></td>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </tr>
    </c:forEach>
</table></div>


<br>
<ul>
    <li>
        <a class="two" href="/"> Home </a>
        <a class="two" href="/admin/"> Admin Home Page </a>
        <a class="two" href="/admin/addNewUser"> Add New User </a>
        <a class="two" href="/admin/viewAllPayPeriods"> View All Pay Periods </a>
    <li style="float:right" ><a class="two" href="/logout">Log Out</a></li>
    </li>
</ul>

<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>