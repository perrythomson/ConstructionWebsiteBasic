<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Past Projects</title>
    <link href="/frontEndFiles/css/pastProjects.css" rel="stylesheet" type="text/css" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/frontEndFiles/css/pastProjects.css">
    <style>
        .mySlides {display:none;}
    </style>

</head>
<body>
<div>
<h1>BFE Construction:  Past Projects</h1>
</div>


<div class="slide_parent">
    <h2 class="w3-center"> ~ Architectural Construction ~ </h2>
    <div class="w3-content w3-section" >
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_modern_house_1.jpg">
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_modern_house_2.jpg">
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_modern_house_3.jpg">
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_modern_house_4.jpg">
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_modern_house_5.jpg">
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_modern_house_6.jpg">
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_modern_house_7.jpg">
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_modern_house_8.jpg">
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_modern_house_9.jpg">
        <%--<img class="mySlides slide" src="/frontEndFiles/pictures/project_modern_house_11.jpg">--%>
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_stairs_1.jpg" >
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_stairs_2.jpg" >
        <img class="mySlides slide" src="/frontEndFiles/pictures/project_stairs_3.jpg" >
    </div>
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
        x[myIndex-1].style.className = "slide";
        setTimeout(carousel, 2000); // Change image every 2 seconds
    }
</script>


<ul>
    <li>
        <a class="two" href="/">Home Page</a>
        <a class="two" href="/home/contactUs">Contact Us</a>
        <a class="two" href="/home/employmentOpportunities">Employment Opportunities</a>
    <%--<li style="float:right" ><a class="two" href="/login">Log In</a></li>--%>
    <%--<li style="float:right" ><a href="/logout">Log Out</a></li>--%>
    </li>
</ul>
<%--<a href="/login">Login</a>--%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>