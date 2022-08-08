<%-- 
    Document   : vaccineHomePage
    Created on : Dec 3, 2021, 9:56:46 PM
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
                      <style>
           body{
                background-image:url('https://images.unsplash.com/photo-1584118624012-df056829fbd0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80') ;
                background-repeat: no-repeat;
                background-position:bottom;
                
            }
        </style>
    </head>
    <body>

         <body>
              <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">Vaccine Management</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="WELCOMEPAGE.jsp">Back To Home</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="vaccineinventoryPage.jsp">Vaccine Inventory Status</a>
                   
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
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item active"><a class="nav-link"><h6>Overall Vaccines Received:</h6></a></li>
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
                    <h4 class="mt-4">Register vaccines received:</h4>
                        <form action="vaccineinventoryservlet" method="get">
            <table>
                <tr>
                    <td>Vaccine Name:</td>
                                        <td><select name="name">
                            <option value="Johnson & Johnson">Johnson & Johnson</option>
                            <option value="Moderna">Moderna</option>
                            <option value="Pfizer-BioNTech">Pfizer-BioNTech</option>
                            <option value="Astrazeneca">Astrazeneca</option>
                        </select></td>

                </tr>
                <tr>
                    <td>Total Vaccine:</td>
                    <td><input type="text" name="name2" required=""></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Register" ></td>
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
