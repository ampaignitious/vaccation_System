<%-- 
    Document   : sendvaccines
    Created on : Dec 3, 2021, 12:33:00 PM
    Author     : icondesigners
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                <div class="sidebar-heading border-bottom bg-light">Vaccine Management</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="WELCOMEPAGE.jsp">Back To Home</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">Vaccine Inventory Status</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">Distribute Vaccine</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="PatientRegisteringJsp.jsp">Patient Page</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
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
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item active"><a class="nav-link"><h6>Overall Vaccine Total:</h6></a></li>
                                                             <% 
          String name = request.getParameter("name");
          String totalvaccine= request.getParameter("total");
          String number =request.getParameter("number");
          String remainingVaccine = request.getParameter("remainingVaccine");
        %>  
        <%@taglib uri="/WEB-INF/tlds/registeringvaccinetld" prefix="registervaccine"%>
        <registervaccine:registeringvaccinehandler name="${name}" totalno="${number}"/>
        <%@taglib uri="/WEB-INF/tlds/gettingtotalvaccine" prefix="totalvaccines"%>
                                <li class="nav-item"><a class="nav-link" href="#!"><totalvaccines:totalvaccines /></a></li>
                                <li class="nav-item dropdown">
                              
                      
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- Page content-->
                <div class="container-fluid">
                    


                    
                </div>
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <h1>Hello World!</h1>

    </body>
</html>
