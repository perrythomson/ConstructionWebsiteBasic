<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Home Page</title>
    <link href="/frontEndFiles/css/homePage.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div><h1>BFE Construction</h1></div>
<div><h2>Built For Eternity</h2></div>

<p class="weather" >
    <a href="http://www.accuweather.com/en/us/salt-lake-city-ut/84101/weather-forecast/331216" class="aw-widget-legal">
    <!--
    By accessing and/or using this code snippet, you agree to AccuWeather’s terms and conditions (in English) which can be found at http://www.accuweather.com/en/free-weather-widgets/terms and AccuWeather’s Privacy Statement (in English) which can be found at http://www.accuweather.com/en/privacy.
    -->
    </a>
    <div id="awcc1473794899938" class="aw-widget-current"  data-locationkey="331216"
             data-unit="f" data-language="en-us" data-useip="false" data-uid="awcc1473794899938">
        </div><script type="text/javascript" src="http://oap.accuweather.com/launch.js"></script>
</p>

<div>
    <ul>
        <li>
            <a class="two" href="/home/pastProjects">Past Projects</a>
            <a class="two" href="/home/contactUs">Contact Us</a>
            <a class="two" href="/home/employmentOpportunities">Employment Opportunities</a>
        <li style="float:right" ><a class="two" href="/login">Log In</a></li>
        <%--<li style="float:right" ><a href="/logout">Log Out</a></li>--%>
        </li>
    </ul>
</div>
<%--<a href="/login">Login</a>--%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>