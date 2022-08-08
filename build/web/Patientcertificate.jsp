<%-- 
    Document   : Patientcertificate
    Created on : Dec 4, 2021, 3:03:44 PM
    Author     : icondesigners
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vaccine Certificate</title>
        <style>
            button{
                opacity: 1;
            }
            button:hover{
                opacity: 0;
            }
            </style>
    </head>
    <body>
        <%
         String name =request.getParameter("name");
         String nin =request.getParameter("nin");
         String dateOfVaccination =request.getParameter("dateOfVaccination");
         String vaccine = request.getParameter("vaccine");
         String batch = request.getParameter("batch");
         String vaccinestatus =request.getParameter("vaccinestatus");
         String healthcenter =request.getParameter("healthcenter");
    
        %>
      <%if(vaccinestatus=="complete doze"){%>
        <div style="width:800px; height:600px; padding:20px; text-align:center; border: 10px solid #787878">
<div style="width:750px; height:550px; padding:20px; text-align:center; border: 5px solid #787878"><br/><br/><br/><br/>
       <span style="font-size:50px; font-weight:bold">Certificate of Vaccination</span>
       <br><br>
       <span style="font-size:25px"><i>This is to certify that</i></span>
       <br><br>
       <span style="font-size:30px"><b><%=name %></b></span><br/><br/>
       <span style="font-size:25px"><i>has completed vaccination</i></span> <br/><br/>

       <span style="font-size:20px">with the doze of <b><%= vaccine %></b></span> <br/><br/>
       <span style="font-size:25px">dated</span><br>
       <b><%= dateOfVaccination%></b>
       <br/>
       <br/>
       <br/>
</div>
</div>
       <%}else{%>
       
        <div style="width:800px; height:600px; padding:20px; text-align:center; border: 10px solid #787878">
<div style="width:750px; height:550px; padding:20px; text-align:center; border: 5px solid #787878"><br/><br/><br/><br/>
       <span style="font-size:50px; font-weight:bold">Certificate of Vaccination</span>
       <br><br>
       <span style="font-size:25px"><i>This is to certify that</i></span>
       <br><br>
       <span style="font-size:30px"><b><%=name %></b></span><br/><br/>
       <span style="font-size:25px"><i>has completed the first doze</i></span> <br/><br/>

       <span style="font-size:20px">with  <b><%= vaccine %></b></span> <br/><br/>
       <span style="font-size:25px">dated</span><br>
       <b><%= dateOfVaccination%></b>
       <span>Next date of vaccination after<b>30days<b></span>
       <br/>
       <br/>
       <br/>
</div>
</div>

       
       <%}%>
       <br/><p>
           <button><a href="#" onclick="javascript:window.print();">Print this Certificate</a></button>
       </p>
    </body>
</html>
