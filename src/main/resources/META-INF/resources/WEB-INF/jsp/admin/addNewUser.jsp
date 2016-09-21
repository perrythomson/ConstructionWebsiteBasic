<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Add New Employee</title>

    <link href="/frontEndFiles/css/adminHomePage.css" rel="stylesheet" type="text/css" />
</head>
<body>

<h1>ADMIN:  Add Employee</h1>

<form name="newEmployeeForm" method="POST" action="/admin/saveNewUser"> <!-- post information is readable get information is hidden !-->
<%--<form name="newEmployeeForm" method="POST" action="/admin/saveNewEmployee"> <!-- post information is readable get information is hidden !-->--%>
        Role Type: <select name="roleType">
            <c:forEach var="roleType" items="${roleTypes}">
            <option value="<c:out value="${roleType}"/>"><c:out value="${roleType}"/></option></c:forEach>
                </select><br>
        First Name: <input type="text" name="firstName" /><br>
        Last Name:  <input type="text" name="lastName" /><br>
        Phone:      <input type="text" name="phone" /><br>
        Address:    <input type="text" name="address" /><br>
        Email:      <input type="text" name="email" /><br>
        Salary:     <input type="text" name="salary" /><br><br><br>
        User Name:  <input type="text" name="username" /><br>
        Password:   <input type="text" name="password" /><br>

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



<%--<form:form id="userForm" commandName="user" modelAttribute="user" method="POST" action="/admin/saveNewEmployee" >&ndash;%&gt;--%>
    <%--<form:label path="name" >First Name: </form:label><br>--%>
    <%--<form:label path="name" >Last Name: </form:label><br>--%>

    <%--<form:label path="address" >Address: </form:label><br>--%>
    <%--<form:label path="city" >City: </form:label><br>--%>

    <%--<form:label path="zip" >Zip: </form:label><br>--%>
    <%--<form:label path="states">State:</form:label>--%>
    <%--&lt;%&ndash;<form:select path="states" id="states"><form:options items="${STATES}" />&ndash;%&gt;--%>
    <%--&lt;%&ndash;</form:select>&ndash;%&gt;--%>
    <%--<form:label path="email" >Email: </form:label><br>--%>
    <%--<form:label path="phone" >Phone: </form:label><br>--%>

    <%--<form:label path="userName" >UserName: </form:label><br>--%>
    <%--<form:label path="password" >Password: </form:label>br>--%>
    <%--<form:label path="matchingPassword" >Confirm Password: </form:label>br>