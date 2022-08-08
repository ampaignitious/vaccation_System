<%-- 
    Document   : PatientRegisteringJsp
    Created on : Dec 2, 2021, 11:57:03 AM
    Author     : icondesigners
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration of patients</title>
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
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="WELCOMEPAGE.jsp">Back TO Home</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="selectingregisteredpatients.jsp">All Registered Patients</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="WELCOMEPAGE.jsp">Back To Home</a>
                  
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

                        </div>
                    </div>
                </nav>
                <!-- Page content-->
                <div class="container-fluid">
 
                    <h4>Patient Registration Page </h4>
                <form action="patientregistrationServlets" method="get" >
            <table>
                <tr>
                    <td> Name:</td>
                    <td><input type="text" name="name" placeholder="name"></td>
                </tr>
                <tr>
                    <td>Health Center</td>
                    <td><select name="healthcenter">
                            <option></option>
                            <option value="Mulago">Mulago</option>
                            <option value="Case Hospital">Case Hospitlal</option>
                            <option value="Butabika">Butabika</option>
                            <option value="Nsambya" >Nsambya</option>
                            <option value="Benedict">Benedict</option>

                        </select></td>
                </tr>
                <tr>
                    <td>NIN:</td>
                    <td><input type="text" name="nin"></td>
                </tr>
                <tr>
                    <td>Date of vaccination:</td>
                    <td><input type="date" name="dateOfVaccination"></td>
                </tr>
                <tr>
                    <td>Vaccine:</td>
                    
                            <td><select name="vaccine">
                                    <option></option>        
                            <option value="Johnson & Johnson">Johnson & Johnson</option>
                            <option value="Moderna">Moderna</option>
                            <option value="Pfizer-BioNTech">Pfizer-BioNTech</option>
                            <option value="Astrazeneca">Astrazeneca</option>
                        </select></td>

                </tr>
                <tr>
                    <td>Batch No:</td>
                    <td><input type="text" name="batch"></td>
                </tr>
                <tr>
                    <td>Vaccine status</td>
                                        <td><select name="vaccinestatus">
                                                <option></option>
                            <option value="complete doze">complete doze</option>
                            <option value="incomplete doze">incomplete doze</option>

                        </select></td>
   
                </tr>
                <tr>
                    <td><input type="submit" value="Register"></td>
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

                <%
                String nin = request.getParameter("nin");
                String name = request.getParameter("name");
                String dateOfvaccination = request.getParameter("dateOfVaccination");
                String vaccine = request.getParameter("vaccine");
                String batch = request.getParameter("batch");
                String vaccinestatus =request.getParameter("vaccinestatus");
                String healthcenter=request.getParameter("healthcenter");
                String table ="patients";
                

                %>
                <%@taglib uri="/WEB-INF/tlds/registerPatient" prefix="PatientRegistration" %>
                <%if(nin!=null&&dateOfvaccination!=null&&name!=null&&vaccinestatus!=null&&vaccine!=null&&batch!=null&&healthcenter!=null){%>
                <PatientRegistration:patientregistrationHandler  batch="${batch}" dateOfVaccination="${dateOfVaccination}" name="${name}" nin="${nin}" vaccine="${vaccine}" vaccinestatus='"${vaccinestatus}"' healthcenter='"${healthcenter}"'/>
                <%}%>
    </body>
</html>
