<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Contact Us Page</title>
    <link href="/frontEndFiles/css/homePage.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction</h1>

<h2>Contact Us Page</h2>


<br><br><br><br><br><br><br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<a href="/">Home Page</a> | <a href="/home/pastProjects">Past Projects</a> | <a href="/home/employmentOpportunities">Employment Opportunities</a> | <a href="/login">Login</a>
</body>
</html>