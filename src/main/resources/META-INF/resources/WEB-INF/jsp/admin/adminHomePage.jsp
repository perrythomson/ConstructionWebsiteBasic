<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />

    <title>List All Users</title>

    <link href="/frontEndFiles/css/adminHomePage.css" rel="stylesheet" type="text/css" />

    <style type="text/css">
        <!--
        span.label {color:black;width: 25px;height:16px;text-align:center;margin-top:0;background:#ffF;font:bold 13px Arial}
        span.c1 {cursor:hand;color:black;width:30px;height:16px;text-align:center;margin-top:0;background:#ffF;font:bold 13px Arial}
        span.c2 {cursor:hand;color:red;width:30px;height:16px;text-align:center;margin-top:0;background:#ffF;font:bold 13px Arial}
        span.c3 {cursor:hand;color:#b0b0b0;width:30px;height:16px;text-align:center;margin-top:0;background:#ffF;font:bold 12px Arial}
        -->
    </style>

    <script type="text/javascript">

        <!-- Begin
        function maxDays(mm, yyyy){
            var mDay;
            if((mm == 3) || (mm == 5) || (mm == 8) || (mm == 10)){
                mDay = 30;
            }
            else{
                mDay = 31
                if(mm == 1){
                    if (yyyy/4 - parseInt(yyyy/4) != 0){
                        mDay = 28
                    }
                    else{
                        mDay = 29
                    }
                }
            }
            return mDay;
        }
        function changeBg(id){
            if (eval(id).style.backgroundColor != "yellow"){
                eval(id).style.backgroundColor = "yellow"
            }
            else{
                eval(id).style.backgroundColor = "#ffffff"
            }
        }
        function writeCalendar(){
            var now = new Date
            var dd = now.getDate()
            var mm = now.getMonth()
            var dow = now.getDay()
            var yyyy = now.getFullYear()
            var arrM = new Array("January","February","March","April","May","June","July","August","September","October","November","December")
            var arrY = new Array()
            for (ii=0;ii<=4;ii++){
                arrY[ii] = yyyy - 2 + ii
            }
            var arrD = new Array("Sun","Mon","Tue","Wed","Thu","Fri","Sat")

            var text = ""
            text = "<form name=calForm>"
            text += "<table border=1>"
            text += "<tr><td>"
            text += "<table width=100%><tr>"
            text += "<td align=left>"
            text += "<select name=selMonth onChange='changeCal()'>"
            for (ii=0;ii<=11;ii++){
                if (ii==mm){
                    text += "<option value= " + ii + " Selected>" + arrM[ii] + "</option>"
                }
                else{
                    text += "<option value= " + ii + ">" + arrM[ii] + "</option>"
                }
            }
            text += "</select>"
            text += "</td>"
            text += "<td align=right>"
            text += "<select name=selYear onChange='changeCal()'>"
            for (ii=0;ii<=4;ii++){
                if (ii==2){
                    text += "<option value= " + arrY[ii] + " Selected>" + arrY[ii] + "</option>"
                }
                else{
                    text += "<option value= " + arrY[ii] + ">" + arrY[ii] + "</option>"
                }
            }
            text += "</select>"
            text += "</td>"
            text += "</tr></table>"
            text += "</td></tr>"
            text += "<tr><td>"
            text += "<table border=1>"
            text += "<tr>"
            for (ii=0;ii<=6;ii++){
                text += "<td align=center><span class=label>" + arrD[ii] + "</span></td>"
            }
            text += "</tr>"
            aa = 0
            for (kk=0;kk<=5;kk++){
                text += "<tr>"
                for (ii=0;ii<=6;ii++){
                    text += "<td align=center><span id=sp" + aa + " onClick='changeBg(this.id)'>1</span></td>"
                    aa += 1
                }
                text += "</tr>"
            }
            text += "</table>"
            text += "</td></tr>"
            text += "</table>"
            text += "</form>"
            document.write(text)
            changeCal()
        }
        function changeCal(){
            var now = new Date
            var dd = now.getDate()
            var mm = now.getMonth()
            var dow = now.getDay()           //day of week
            var yyyy = now.getFullYear()
            var currM = parseInt(document.calForm.selMonth.value)
            var prevM
            if (currM!=0){
                prevM = currM - 1
            }
            else{
                prevM = 11
            }
            var currY = parseInt(document.calForm.selYear.value)
            var mmyyyy = new Date()
            mmyyyy.setFullYear(currY)
            mmyyyy.setMonth(currM)
            mmyyyy.setDate(1)
            var day1 = mmyyyy.getDay()
            if (day1 == 0){
                day1 = 7
            }
            var arrN = new Array(41)
            var aa
            for (ii=0;ii<day1;ii++){
                arrN[ii] = maxDays((prevM),currY) - day1 + ii + 1
            }
            aa = 1
            for (ii=day1;ii<=day1+maxDays(currM,currY)-1;ii++){
                arrN[ii] = aa
                aa += 1
            }
            aa = 1
            for (ii=day1+maxDays(currM,currY);ii<=41;ii++){
                arrN[ii] = aa
                aa += 1
            }
            for (ii=0;ii<=41;ii++){
                eval("sp"+ii).style.backgroundColor = "#FFFFFF"
            }
            var dCount = 0
            for (ii=0;ii<=41;ii++){
                if (((ii<7)&&(arrN[ii]>20))||((ii>27)&&(arrN[ii]<20))){
                    eval("sp"+ii).innerHTML = arrN[ii]
                    eval("sp"+ii).className = "c3"
                }
                else{
                    eval("sp"+ii).innerHTML = arrN[ii]
                    if ((dCount==0)||(dCount==6)){
                        eval("sp"+ii).className = "c2"
                    }
                    else{
                        eval("sp"+ii).className = "c1"
                    }
                    if ((arrN[ii]==dd)&&(mm==currM)&&(yyyy==currY)){
                        eval("sp"+ii).style.backgroundColor="#90EE90"
                    }
                }
                dCount += 1
                if (dCount>6){
                    dCount=0
                }
            }
        }
        //  End -->
    </script>

</head>
<body>

<h1>ADMIN:  HOME PAGE</h1>

<div class="parentAdminTables">
<div class="adminTables" ><table>
    <th>Employees</th>
    <tr>
        <th> Emp-ID </th>
        <th> Edit-Emp </th>
        <th> Role </th>
        <th> </th>
        <th> First Name </th>
        <th> Last Name </th>
        <th> </th>
        <th> Phone </th>
        <th> </th>
        <th> Address </th>
        <th> </th>
        <th> Salary</th>
        <th> </th>
        <th> Delete User</th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <%--<td><a href="/admin/viewUser?userID=${user.userID}"><c:out value="${user.userID}" /></a></td>--%>
            <td align="center"><c:out value="${user.userId}" /></td>
            <td align="center"><a href="/admin/editUser?userId=${user.userId}">EDIT</a></td>
            <td><c:out value="${roleType.roleType}" /></td>
                <th>  </th>
            <td><c:out value="${user.firstName}" /></td>
            <td><c:out value="${user.lastName}" /></td>
                <th>  </th>
            <td><c:out value="${user.phone}" /></td>
                <th>  </th>
            <td><c:out value="${user.address}" /></td>
                <th>  </th>
            <td align="right"><span class="dollars"><c:out value="${user.salary}" /></span></td>
                <th>  </th>
            <td align="center"><a href="/admin/deleteUser?id=${user.userId}" onclick="return confirm('Are you sure?')" >DELETE: <c:out value="${user.userId}" /></a></td>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </tr>
    </c:forEach>
</table></div>

<div class="adminTables"><table>
    <th>Applicants</th>
    <tr>
        <th> Job Seeker ID </th>
        <th> </th>
        <th> Name </th>
        <th> </th>
        <th> Phone </th>
        <th> </th>
        <th> Email </th>
        <th> </th>
        <th> Job History </th>
        <th> </th>
        <th> Delete Inquiry</th>
    </tr>

    <c:forEach items="${jobSeekers}" var="jobSeeker">
        <tr>
                <%--<td><a href="/admin/viewUser?userID=${user.userID}"><c:out value="${user.userID}" /></a></td>--%>
            <td align="center"><c:out value="${jobSeeker.jobSeekerID}" /></td>
            <th>  </th>
            <td><c:out value="${jobSeeker.name}" /></td>
            <th>  </th>
            <td><c:out value="${jobSeeker.phone}" /></td>
            <th>  </th>
            <td><c:out value="${jobSeeker.email}" /></td>
            <th>  </th>
            <td><c:out value="${jobSeeker.form}"  /></td>
            <th>  </th>
            <td align="center"><a href="/admin/deleteJobSeeker?id=${jobSeeker.jobSeekerID}" onclick="return confirm('Are you sure?')" >DELETE: <c:out value="${user.userId}" /></a></td>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </tr>
    </c:forEach>
</table></div>

<div class="adminTables"><table>
    <th>Construction Bids</th>
    <tr>
        <th> Interested Party ID </th>
        <th> </th>
        <th> Name </th>
        <th> </th>
        <th> Phone </th>
        <th> </th>
        <th> Email </th>
        <th> </th>
        <th> Job History </th>
        <th> </th>
        <th> Delete Inquiry</th>
    </tr>

    <c:forEach items="${interestedParties}" var="interestedParty">
        <tr>
                <%--<td><a href="/admin/viewUser?userID=${user.userID}"><c:out value="${user.userID}" /></a></td>--%>
            <td align="center"><c:out value="${interestedParty.interestedPartyID}" /></td>
            <th>  </th>
            <td><c:out value="${interestedParty.name}" /></td>
            <th>  </th>
            <td><c:out value="${interestedParty.phone}" /></td>
            <th>  </th>
            <td><c:out value="${interestedParty.email}" /></td>
            <th>  </th>
            <td><c:out value="${interestedParty.form}"  /></td>
            <th>  </th>
            <td align="center"><a href="/admin/deleteInterestedParty?id=${interestedParty.interestedPartyID}" onclick="return confirm('Are you sure?')" >DELETE: <c:out value="${user.userId}" /></a></td>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </tr>
    </c:forEach>
</table></div>
</div>
<br>


<script type="text/javascript">writeCalendar()</script>

<%--<p><center>--%>
    <%--<font face="arial, helvetica" size="-2">Free JavaScripts provided<br>--%>
    <%--by <a href="http://javascriptsource.com">The JavaScript Source</a></font>--%>
<%--</center></p>--%>



<br>
<ul>
    <li>
        <a class="two" href="/"> Home </a>
        <a class="two" href="/admin/addNewUser"> Add New User </a>
        <a class="two" href="/admin/viewAllUsers"> View All Users </a>
        <a class="two" href="/admin/viewAllPayPeriods"> View All Pay Periods </a>
        <li style="float:right" ><a class="two" href="/logout">Log Out</a></li>
    </li>
</ul>

<br><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</body>
</html>
