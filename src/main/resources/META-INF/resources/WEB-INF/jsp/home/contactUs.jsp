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

<div>
    <image class="head_shot" src="/frontEndFiles/pictures/Brad_Head_Shot.jpg" ></image>
</div>
<div>
    <p>  Hi, I'm Brad Evans and I'm the owner and operator of Built For Eternity construction.
    We pride ourselves on providing the highest quality product for the lowest cost. If you are interested in our services and would like an estimate
on your project, please fill out the form below and I will personally get back with you.</p>
</div>

<div><form name = "contactUs" method="POST" action="/home/interestedParty">
    <h2> ~ Contact Us ~ </h2> <br/>
    Email:      <input type="text" name="email"   value="${email}">    <br/><br/>
    Name:       <input type="text" name="name"    value="${name}">     <br/><br/>
    Phone:      <input type="text" name="phone"   value="${phone}">    <br/><br/>
    Location:   <input type="text" name="location" value="${location}"> <br/><br/>

    <div class="form-group">
        <label for="comment">Explain your project: </label><br><br>
        <textarea name="form" class="form-control" rows="5" id="comment"></textarea>
    </div>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Submit!">
</form></div>

<ul>
    <li>
        <a class="two" href="/">Home Page</a>
        <a class="two" href="/home/pastProjects">Past Projects</a>
        <a class="two" href="/home/employmentOpportunities">Employment Opportunities</a>
    <%--<li style="float:right" ><a class="two" href="/login">Log In</a></li>--%>
    <%--<li style="float:right" ><a href="/logout">Log Out</a></li>--%>
    </li>
</ul>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>