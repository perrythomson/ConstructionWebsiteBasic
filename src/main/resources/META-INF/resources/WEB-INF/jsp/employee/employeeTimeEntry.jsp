<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ID" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Employee Time Entry Page</title>
    <link href="/frontEndFiles/css/employeeTimeEntry.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction</h1>

<h2>Employee Time Entry Page</h2>

<table>
    <tr>
        <td>RoleType:</td>
        <td><c:out value="${employee.roleType}" /></td>
    </tr>
    <tr>
        <td>ID:</td>
        <td><c:out value="${employee.employeeID}" /></td>
    </tr>
    <tr>
        <td>First Name:</td>
        <td><c:out value="${employee.firstName}" /></td>
    </tr>
    <tr>
        <td>Last Name:</td>
        <td><c:out value="${employee.lastName}" /></td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><c:out value="${employee.phone}" /></td>
    </tr>
    <tr>
        <td>Address:</td>
        <td><c:out value="${employee.address}" /></td>
    </tr>
    <tr>
        <td>Email Address:</td>
        <td><c:out value="${employee.email}" /></td>
    </tr>
</table>

<br><br>

<form action="TimeSheet" method="post">
    <%--TODO get with Sean on justification if you cant figure it out--%>
    <fieldset style="width: 80%">
        <h2>Weekly Time Sheet</h2>
        <table border=1>
            <tr><th>Employee ID</th>
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
            <tr> <td><input type="text" name="employeeID" required="required" /></td>
                 <td><input type=week step=2 min=2014-W30></td>
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

<br><br><br><br><br><br>

<a href="/">Home Page</a> | <a href="/employee/editEmployeeContactInfo">Edit Contact Information</a> | <a href="/logout">Log Out</a>
</body>
</html>

<%--The most important method in Calendar is get(int calendarField), which produces an int. The calendarField are defined as static constant and includes:--%>
<%--get(Calendar.DAY_OF_WEEK): returns 1 (Calendar.SUNDAY) to 7 (Calendar.SATURDAY).--%>
<%--get(Calendar.YEAR): year--%>
<%--get(Calendar.MONTH): returns 0 (Calendar.JANUARY) to 11 (Calendar.DECEMBER).--%>

<%--<form name="employeeTimeEntry" method="POST" action="/employeeTimeEntry">--%>
<%--Employee ID: <input type="text" name="employeeID" value="<c:out value="${employee.employeeID}" />" readonly /><br>--%>
<%--First Name: <input type="text" name="firstName" value="<c:out value="${employee.firstName}" />" readonly /><br>--%>
<%--Last Name: <input type="text" name="lastName" value="<c:out value="${employee.lastName}" />" readonly /><br>--%>

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