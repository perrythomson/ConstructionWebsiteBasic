<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>Thank You  Page</title>

    <%--This sets the time for this page and redirects to home--%>
    <script>
        setTimeout(function () {
            window.location='/';
        }, 3000);
    </script>

</head>
<body>

<h1> Application Submitted!</h1>

<p> Thank you for your submission.  We will contact you here shortly!</p>

</body>
</html>