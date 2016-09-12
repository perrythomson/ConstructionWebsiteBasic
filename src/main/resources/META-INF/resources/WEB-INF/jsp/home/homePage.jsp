<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Home Page</title>
    <link href="/frontEndFiles/css/homePage.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction</h1>
<h2>Built For Eternity</h2>


<%--<a href="http://www.accuweather.com/en/us/new-york-ny/10007/weather-forecast/349727" class="aw-widget-legal"></a><div--%>
        <%--id="awcc1473710440238" class="aw-widget-current"  data-locationkey="" data-unit="f" data-language="en-us"--%>
        <%--data-useip="true" data-uid="awcc1473710440238"></div><script type="text/javascript" src="http://oap.accuweather.com/launch.js"></script>--%>

<ul>
    <li>
        <a href="/home/pastProjects">Past Projects</a>
        <a href="/home/contactUs">Contact Us</a>
        <a href="/home/employmentOpportunities">Employment Opportunities</a>
    <li style="float:right" ><a href="/login">Log In</a></li>
    <%--<li style="float:right" ><a href="/logout">Log Out</a></li>--%>
    </li>
</ul>
<%--<a href="/login">Login</a>--%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>