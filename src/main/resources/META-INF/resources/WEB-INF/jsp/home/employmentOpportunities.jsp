<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Home Page</title>
    <link href="/frontEndFiles/css/employmentOpportunities.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction: Employement Opportunities</h1>

<p> BFE Construction is an excellent place to 'build' up your career.  We are steadily growing and we are
looking for qualified laborers, framers, and much more.  Please fill out the form below and we will get back to you shortly.
</p>

<form name = "employmentSignUpForm" method="POST" action="/home/jobSeeker">
    <h2> ~ Employment Opportunities ~ </h2> <br/>
    Email:      <input type="text" name="email"   value="${email}">    <br/><br/>
    Name:       <input type="text" name="name"    value="${name}">     <br/><br/>
    Phone:      <input type="text" name="phone"   value='${phone}'>    <br/><br/>

    <div class="form-group">
        <label for="comment">Job Experience:</label><br><br>
        <textarea name="form" class="form-control" rows="5" id="comment"></textarea>
    </div>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Submit your information!">
</form>

<ul>
    <li>
        <a class="two" href="/">Home Page</a>
        <a class="two" href="/home/contactUs">Contact Us</a>
        <a class="two" href="/home/pastProjects">Past Projects</a>
    <%--<li style="float:right" ><a class="two" href="/login">Log In</a></li>--%>
    <%--<li style="float:right" ><a href="/logout">Log Out</a></li>--%>
    </li>
</ul>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>