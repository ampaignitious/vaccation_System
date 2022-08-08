<%-- 
    Document   : sendinghealthcenter
    Created on : Dec 3, 2021, 3:12:31 PM
    Author     : icondesigners
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
       <%
        String name = request.getParameter("name");
        String location = request.getParameter("location");
%>
  
 <% if(name!=null&&location!=null){%>    
 <%@ taglib uri="/WEB-INF/tlds/createhealthcenter" prefix="healthcenterregistration" %>
 <healthcenterregistration:RegisterHealthCenterHandler centername="${name}" location="${location}"/>
 <%}%>
    </body>
</html>
