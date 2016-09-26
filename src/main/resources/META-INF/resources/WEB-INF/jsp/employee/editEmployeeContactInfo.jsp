<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User Contact Information</title>

</head>
<body>
Edit User Contact Information

<br><br>
<form name="updateUserContactInfoForm" method="POST" action="/user/">
    User ID: <input type="text" name="userID" value="<c:out value="${user.userId}" />" readonly /><br>
    First Name: <input type="text" name="firstName" value="<c:out value="${user.firstName}" />" /><br>
    Last Name: <input type="text" name="lastName" value="<c:out value="${user.lastName}" />" /><br>
    Phone: <input type="text" name="phone" value="<c:out value="${user.phone}" />" /><br>
    Address: <input type="text" name="address" value="<c:out value="${user.address}" />" /><br><br><br>
    User Name:  <input type="text" name="username" autofocus required value="<c:out value="${user.userName}"/>" /><br>
    Password:   <input type="password" name="password" required value="<c:out value="${user.password}"/>" /> <br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit"><br>
</form>

<%--TODO figure out storage/display--%>
<form action="upload.php" method="post" enctype="multipart/form-data">
    Select image to upload:
    <input type="file" name="fileToUpload" id="fileToUpload">
    <input type="submit" value="Upload Image" name="submit">
</form>

</body>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</html>

<%--<form enctype="multipart/form-data" action="uploader.php" method="POST">--%>
<%--<input type="hidden" name="MAX_FILE_SIZE" value="100000" />--%>
<%--Choose a file to upload: <input name="uploadedfile" type="file" /><br />--%>
<%--<input type="submit" value="Upload File" />--%>
<%--</form>--%>