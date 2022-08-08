<%-- 
    Document   : homePage
    Created on : Dec 1, 2021, 1:06:09 PM
    Author     : icondesigners
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>
    *{
      
        background-image: url("https://www.genengnews.com/wp-content/uploads/2020/04/Apr13_2020_Getty_1216735230_COVID19Medicine-scaled-e1586805070780.jpg");
        background-repeat: no-repeat;
    }
</style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
 
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      
    <div class="navbar-nav">
        <a class="navbar-item nav-link active" href="#"><b>Vaccine Administration Tracker</b></a>
        <a class="nav-item nav-link active" href="registering.jsp" style="color:white;"><b>Register</b> <span class="sr-only">(current)</span></a>
        <a class="nav-item nav-link active" href="login.jsp" style="color:white;"><b>Login</b> <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="registeringvaccine.jsp"><b>Vaccine Registration</b></a>
        <a class="nav-item nav-link" href="registeringHealthCenter.jsp"><b>Health Center Registration</b></a>
      <a class="nav-item nav-link" href="sendingformJSP.jsp"><b>Patient Page</b></a>
      <a class="nav-item nav-link" href="HomePageMain.jsp"><b>Patient Booking</b></a>
      <a class="nav-item nav-link disabled" href="WELCOMEPAGE.jsp">web</a>
    </div>

  </div>
</nav>          
     
        <div>

        <% 
          String name = request.getParameter("name");
          String email = request.getParameter("email");
          String password1 = request.getParameter("password1");
          String password2 = request.getParameter("password2");
        %>   
        <% if(name!=null&&email!=null&&password1!=null&&password2!=null){ %>
        <%@taglib uri="/WEB-INF/tlds/registeingAdmin" prefix="register"%>
        <register:RegisteringAdmins email="${email}" name="${name}" password1="${password1}" password2="${password2}"/>
        <%}%>
</div
    </body>
</html>
