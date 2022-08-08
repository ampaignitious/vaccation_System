<%-- 
    Document   : AllBookingsMade
    Created on : Dec 5, 2021, 3:15:10 PM
    Author     : icondesigners
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vaccine Management page</title>
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
        
        
              
                      <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">User Login Page</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="WELCOMEPAGE.jsp">Back To Home</a>
                   
                    
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle">Toggle Menu</button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        
                        </div>
                    </div>
                </nav>
                <!-- Page content-->
                <div>
                    <%@taglib uri="/WEB-INF/tlds/gettingbookingsmade" prefix="Booking"%>
                    <Booking:gettingallbookingsmadebypatients/>
                    
                </div>

              
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <%
        String name = request.getParameter("name");
        String healthcenter = request.getParameter("healthcenter");
        String vaccinechoice = request.getParameter("vaccinechoice");
        String email = request.getParameter("email");

        %>
        <%if( name!=null&& healthcenter!=null&&vaccinechoice!=null&&email!=null){%>
        <%@taglib uri="/WEB-INF/tlds/patientbookingTLD" prefix="book"%>
        <book:PatientbookingHandler name="${name}" healthcenter="${healthcenter}" vaccinechoice="${vaccinechoice}" email="${email}"/>
        <%}%>
    </body>
</html>
