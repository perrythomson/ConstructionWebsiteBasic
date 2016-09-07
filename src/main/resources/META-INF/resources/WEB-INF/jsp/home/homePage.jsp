<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Home Page</title>
    <link href="/META-INF/resources/frontEndFiles/css/homePage.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction</h1>

Test to see if this works
<%--TODO--%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<br><br><br><br><br><br><br><br>
<a href="/login">login</a> | <a href="/home/pastProjects/">Past Projects</a> | <a href="/home/contactUs/">Contact Us</a>| <a href="/home/employmentOpportunities/">Employment Opportunities</a>
</body>
</html>