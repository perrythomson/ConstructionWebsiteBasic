<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ID" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>User Time Entry Page</title>
    <link href="/frontEndFiles/css/userHomePage.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction: User Home Page</h1>
<table>
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
    </tr>

    <%--<c:forEach items="${users}" var="user">--%>
        <tr>
            <td align="center"><c:out value="${user.userId}" /></td>
            <td align="center"><a href="/admin/editUser?userId=${user.userId}">EDIT</a></td>
            <c:forEach items="${user.roles}" var="role">
                <td><c:out value="${role}" /></td>
            </c:forEach>
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
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </tr>
    <%--</c:forEach>--%>
</table>

<br><br>

<%--<form action="TimeSheet" method="post" action="/user/userTimeSheet">--%>
<form name = "TimeSheet" method="post" action="/user/userTimeSheet">

    <fieldset style="width: 80%">
        <h2>Weekly Time Sheet</h2>
        <table border=1>
            <tr>
                <th>Time Sheet ID</th>
                <th>User ID</th>
                <th>Date</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Lunch Time Start</th>
                <th>Lunch Time End</th>
                <th>Work Done</th>
                <th>Total Hours</th>
            </tr>
            <%--check to see if this for loop will define the entries to only 7 within the week --%>
            <%for(int j = 0; j < 7; j++){ %>
            <tr>
                 <td><input type="text" name="timeSheetID" required="required" value="<c:out value="${timeSheetTracker.timeSheetID}" />" readonly /></td>
                 <td><input type="text" name="userId" required="required" value="<c:out value="${user.userId}" />" readonly /></td>
                 <td><input type=date step=7 min=2016-01-01 > </td>
                 <%--<td><input type=week step=2 min=2014-W30></td>--%>
                 <%--<td><input type="date" id="date" name="date"/></td>--%>
                 <td><input type="time" class="startTime" name="startTime"/></td>
                 <td><input type="time" class="endTime"name="endTime" /></td>
                 <td><input type="time" class="lunchTimeStart" name="lunchTimeStart"/></td>
                 <td><input type="time" class="lunchTimeEnd" name="lunchTimeEnd"/></td>
                 <td><input type="textArea" name="task" required="required" /></td>
                 <td><input class="totalTime" readonly="readonly" /></td>
            </tr>
                <%}%>
        </table>
        <br>
    </fieldset>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Submit">
</form>

<ul>
    <li>
        <a href="/"> Home </a>
        <a href="/admin/viewAllPayPeriods"> View All Pay Periods </a>
        <a href="/user/viewAllCoworkers"> View All Coworkers </a>
    <li style="float:right" ><a href="/logout">Log Out</a></li>
    </li>
</ul>

<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>

<%--The most important method in Calendar is get(int calendarField), which produces an int. The calendarField are defined as static constant and includes:--%>
<%--get(Calendar.DAY_OF_WEEK): returns 1 (Calendar.SUNDAY) to 7 (Calendar.SATURDAY).--%>
<%--get(Calendar.YEAR): year--%>
<%--get(Calendar.MONTH): returns 0 (Calendar.JANUARY) to 11 (Calendar.DECEMBER).--%>

<%--<form name="userTimeEntry" method="POST" action="/userTimeEntry">--%>
<%--User ID: <input type="text" name="userID" value="<c:out value="${user.userID}" />" readonly /><br>--%>
<%--First Name: <input type="text" name="firstName" value="<c:out value="${user.firstName}" />" readonly /><br>--%>
<%--Last Name: <input type="text" name="lastName" value="<c:out value="${user.lastName}" />" readonly /><br>--%>

<%--&lt;%&ndash;<table>&ndash;%&gt;--%>
<%--&lt;%&ndash;<tbody>&ndash;%&gt;--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td> Calendar Day: </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td> <input type="date" name="day_of_the_month" value="<c:out value="${timeSheetTracker.date}"/>"/><br></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td> Day of the Week: </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td> <input type="date" name="day_of_the_week" value="<c:out value="${timeSheetTracker.date}"/>"/><br></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td> Hours Worked: </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td> <input type="number" name="hoursWorked" value="<c:out value="${timeSheetTracker.hoursWorked}"/>"/><br></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tbody>&ndash;%&gt;--%>
<%--&lt;%&ndash;<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />&ndash;%&gt;--%>

<%--&lt;%&ndash;</table>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;Calendar Date: <input type="date" name="day_of_the_week" value="<c:out value="${timeSheetTracker.date}"/>"/><br>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;Hours Worked: <input type="number" name="hoursWorked" value="<c:out value="${timeSheetTracker.hoursWorked}"/>"/>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;<input type="submit">&ndash;%&gt;--%>
<%--</form>--%>

            <%--<tr>--%>
            <%--<td>RoleType:</td>--%>
            <%--<td><c:out value="${user.roleType}" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>ID:</td>--%>
            <%--<td><c:out value="${user.userID}" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>First Name:</td>--%>
            <%--<td><c:out value="${user.firstName}" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>Last Name:</td>--%>
            <%--<td><c:out value="${user.lastName}" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>Phone:</td>--%>
            <%--<td><c:out value="${user.phone}" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>Address:</td>--%>
            <%--<td><c:out value="${user.address}" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>Email Address:</td>--%>
            <%--<td><c:out value="${user.email}" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>User Name:</td>--%>
            <%--<td><c:out value="${user.userName}" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>Password:</td>--%>
            <%--<td><c:out value="${user.password}" /></td>--%>
            <%--</tr>--%>