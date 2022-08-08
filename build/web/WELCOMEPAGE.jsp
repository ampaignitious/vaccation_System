<%-- 
    Document   : WELCOMEPAGE
    Created on : Dec 3, 2021, 5:41:57 PM
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
                <style>
           body{
                background-image:url('https://images.unsplash.com/photo-1584118624012-df056829fbd0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80') ;
                background-repeat: no-repeat;
                background-position:bottom;
                
            }
        </style>
        
    </head>
    <body>
              <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">User Menu</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="vaccineHomePage.jsp">Vaccine Section</a>
                   
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="registeringHealthCenter.jsp">Health Center Section</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="PatientRegisteringJsp.jsp">Patient Page</a>
            
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="AllBookingsMade.jsp">View Bookings</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="registering.jsp">Registration</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="HomePageMain.jsp">Log Out</a>
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle">Group 3 System</button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul>
                                
                            </ul>
                  
                        </div>
                    </div>
                </nav>
                <!-- Page content-->
                <div class="container-fluid" >
                    <h1 class="mt-4" style="color:rgb(37, 42, 71);">Vaccine Administration Tracker System.</h1>

                </div>
            </div>
        </div>
        </div>
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
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
