<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Contact Us Page</title>
    <link href="/frontEndFiles/css/contactUs.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction:  Contact Us</h1>


<ul>
    <li>
        <a href="/">Home Page</a>
        <a href="/home/pastProjects">Past Projects</a>
        <a href="/home/employmentOpportunities">Employment Opportunities</a>
    <%--<li style="float:right" ><a class="two" href="/login">Log In</a></li>--%>
    <%--<li style="float:right" ><a href="/logout">Log Out</a></li>--%>
    </li>
</ul>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>