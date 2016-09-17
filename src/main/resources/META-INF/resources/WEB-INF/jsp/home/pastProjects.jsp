<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Past Projects</title>
    <link href="/frontEndFiles/css/pastProjects.css" rel="stylesheet" type="text/css" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/frontEndFiles/css/pictures.css">
    <style>
        .mySlides {display:none;}
    </style>

</head>
<body>
<h1>BFE Construction:  Past Projects</h1>


<h2 class="w3-center">Slideshow</h2>

<div class="w3-content w3-section" style="max-width:500px">
    <img class="mySlides" src="/frontEndFiles/css/pictures/project_modern_house_2.jpg" style="width:100%">
    <img class="mySlides" src="/frontEndFiles/css/pictures/project_modern_house_1.jpg" style="width:100%">
    <img class="mySlides" src="/frontEndFiles/css/pictures/project_deck.jpg" style="width:100%">
</div>

<script>
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {myIndex = 1}
        x[myIndex-1].style.display = "block";
        setTimeout(carousel, 2000); // Change image every 2 seconds
    }
</script>


<ul>
    <li>
        <a href="/">Home Page</a>
        <a href="/home/contactUs">Contact Us</a>
        <a href="/home/employmentOpportunities">Employment Opportunities</a>
    <%--<li style="float:right" ><a class="two" href="/login">Log In</a></li>--%>
    <%--<li style="float:right" ><a href="/logout">Log Out</a></li>--%>
    </li>
</ul>
<%--<a href="/login">Login</a>--%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>