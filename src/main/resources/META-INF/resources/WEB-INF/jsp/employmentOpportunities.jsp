<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Home Page</title>
    <link href="/META-INF/resources/frontEndFiles/css/employmentOpportunities.css" rel="stylesheet" type="text/css" />

</head>
<body>
<h1>BFE Construction</h1>

<p> BFE Construction is an excellent place to 'build' up your career.  We are steadily growing and we are
looking for qualified laborers, framers, and much more.  Please fill out the form below and we will get back to you shortly.
</p>

<form name = "employmentSignUpForm" method="POST" action="/register">

    Email:      <input type="text" name="email"   value="${email}">"    /><br/><br/>
    Name:       <input type="text" name="name"    value="${name}">"     /><br/><br/>
    Phone:      <input type="text" name="phone"   value='${phone}'>"   /><br/><br/>
    Job Experience:     <input type="text" name="jobExperience"   value='${jobExperience}'>"   /><br/><br/>
<%--TODO figure out if text box to be saved in db--%>
    <form>
        <div class="form-group">
            <label for="comment">Job Experience:</label>
            <textarea class="form-control" rows="5" id="comment"></textarea>
        </div>
    </form>
    <input type="submit" value="Submit your information!">
</form>

<br><br><br><br><br><br><br><br>
<a href="/login/">login</a> | <a href="/">Past Projects</a> | <a href="/">Contact Us</a>
</body>
</html>