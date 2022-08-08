<%-- 
    Document   : performingmonthlyassessment
    Created on : Dec 5, 2021, 2:37:51 AM
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
                <div class="sidebar-heading border-bottom bg-light">Health Center Page</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="healthcenterform.jsp">Registration</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="RegisteringHealthCenter">View registered Health Center</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href=" performingmonthlyassessment.jsp">Perform Monthly Assessment</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href=" WELCOMEPAGE.jsp">Back To Home</a>
              
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
                <div class="container-fluid">
                    <h3 class="mt-4">Enter The Name Of The Health Center</h3>
                    
                    <form action="PerfromingmonthlyassessmentServlet" method="post">
                        <table>
                            <tr>
                                <td><input type="text" name="name_center" required=""></td>
                                <td><input type="submit" value="Search"></td>
                            </tr>
                        </table>
                    </form>
                    
                    
                </div>
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>

</html>

