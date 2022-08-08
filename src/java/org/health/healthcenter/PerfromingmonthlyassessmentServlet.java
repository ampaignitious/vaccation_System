/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.healthcenter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author icondesigners
 */
public class PerfromingmonthlyassessmentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection con =null;
        String centername = request.getParameter("name_center");
        if(centername!=null){
        
        
        }

                try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Driver started successfully
         try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
                //out.println("<br><h5>ThunderGray successfully connected to the database try</h5>");
                
                Statement st = con.createStatement();
              
//                ResultSet rd= st.executeQuery("select distinct centername from healthcenter");


                String totalvaccine = "select sum(numberofvaccine) from vaccineregistration";
                ResultSet hd = st.executeQuery(totalvaccine);
                hd.next();
                int totalvaccine2 = hd.getInt(1);
                
////

            String query5 = "select sum(numberofvaccine) from vaccineregistration where vaccine_name=\"Astrazeneca\"";
            String query6 = "select sum(numberofvaccine) from vaccineregistration where vaccine_name=\"Pfizer-BioNTech\"";
            String query7 = "select sum(numberofvaccine) from vaccineregistration where vaccine_name=\"Moderna\"";
            
            String query8 = "select sum( numberofvaccine) from vaccineregistration where vaccine_name=\"Johnson & Johnson\"";
                
        ////////////////////////////////
            
                ResultSet rx = st.executeQuery(query8);
                rx.next();
                int Johnson = rx.getInt(1);   
                
                
       //////////////////////
                 ResultSet rx1 = st.executeQuery(query7);
                 rx1.next();
                 int Moderna =rx1.getInt(1);
                 
                 
        ///////////////////////
                ResultSet rex2 = st.executeQuery(query6);
                 rex2.next();
                 int Pfizer_BioNTech = rex2.getInt(1);
                 
        ////////////////////////////
                ResultSet rex3 = st.executeQuery(query5);
                 rex3.next();
                 int Astrazeneca = rex3.getInt(1);
                 out.println("<p style=\"color:rgb(99, 82, 117); font-size:35px;\">"+centername +" vaccine supply</p>");
                 out.println("<ul style=\"display: flex;list-style:none;\">");
                 out.println("<li style=\"margin:5px;\">Total Vaccines in the System "+totalvaccine2+"</li>");
                 out.println("<li style=\"margin:5px;\">Johnson & Johnson :"+Johnson+"</li>");
                 out.println("<li style=\"margin:5px;\"> Moderna :"+Moderna+"</li>");
                 
                 out.println("<li style=\"margin:5px;\">Pfizer_BioNTech :"+Pfizer_BioNTech+"</li>");
                 out.println("<li style=\"margin:5px;\">Astrazeneca :"+Astrazeneca+"</li>");
                 out.println("</ul>");
        ///////////////////////////////

                String vaccine_name = request.getParameter("vaccinename");
                 String vaccine_amount = request.getParameter("vaccine_amount");
                 String center_name =request.getParameter("center_name");
                 if(vaccine_name!=null && vaccine_amount!=null&&center_name!=null){
                     
                     st.executeUpdate("insert into distribuctiontable set Center_name='"+center_name+"',vaccine_name='"+vaccine_name+"',vaccineamount='"+vaccine_amount+"'");
                     
                     out.println("Received successfully vaccine: "+vaccine_name+" amount: "+vaccine_amount+" dozes");
                     int x = Integer.parseInt(vaccine_amount);
                     int remaining_vaccines = totalvaccine2 -x;
                     out.println("Total Vaccines remaining :"+remaining_vaccines );
                     int remainingVaccine = remaining_vaccines;
                     request.setAttribute("remainingVaccine", remainingVaccine);
                     RequestDispatcher rdv = request.getRequestDispatcher("sendvaccine.jsp");
                 }


               
                String query = "select count(healthcenter) from registeringpatient where healthcenter='\""+centername+"\"'";
                String query2 = "select count(healthcenter) from registeringpatient where vaccinestatus='\"complete doze\"' AND healthcenter='\""+centername+"\"'";
                String query3 ="select count(vaccinestatus) from registeringpatient where vaccinestatus='\"incomplete doze\"' AND healthcenter='\""+centername+"\"'";
                ResultSet rs = st.executeQuery(query);
                rs.next();
                int mulagopatients = rs.getInt(1);
                ///////
                ResultSet rsd = st.executeQuery(query3);
                rsd.next();
                int activepatients = rsd.getInt(1);
                
                out.println("<h4 style=\"color:rgb(99, 82, 117);\">Overall total patients: "+mulagopatients+"</h4>");
                out.println("<h4 style=\"color:rgb(99, 82, 117);\">Active Patients: " + activepatients);
                out.println("<h4 style=\"color:rgb(99, 82, 117);\">Distributing Vaccine To The health center:</h4>");
                out.println("<form action=\"PerfromingmonthlyassessmentServlet\" method=\"post\">\n" +
"<table>\n" +
"    <tr>\n" +
"        <td>Vaccine Type:</td>\n" +
"             <td><select name=\"vaccinename\">\n" +
"                                    <option></option>        \n" +
"                            <option value=\"Johnson & Johnson\">Johnson & Johnson</option>\n" +
"                            <option value=\"Moderna\">Moderna</option>\n" +
"                            <option value=\"Pfizer-BioNTech\">Pfizer-BioNTech</option>\n" +
"                            <option value=\"Astrazeneca\">Astrazeneca</option>\n" +
"                        </select></td>\n" +
"        \n" +
"     </tr>\n" +
"     <tr> \n" +
"     <td>Vaccine Received: </td>  \n" +
"     <td><input type=\"text\" name=\"vaccine_amount\"></td>\n" +
"\n" +"<tr>"+

"     <td>Center name: </td>  \n" +
"     <td><input type=\"text\" name=\"center_name\"></td>\n" +
"\n" +"</tr>"+
"    </tr>\n" +
"    <tr>\n" +
"        <td><input type=\"submit\" value=\"Distribute\"></td>\n" +
"    </tr>\n" +
"</table>\n" +
"</form>");
                
                 
                 out.println("<a href=\"performingmonthlyassessment.jsp\"><br><button>Back</button></a>");

            
                
                }catch(SQLException e){
                    out.println("<br>There is an error:: "+ e.getMessage());
                }
         }catch(ClassNotFoundException e){           
                out.println("<br><br>loading the driver has result to an error:: "+e.getMessage());
            }

        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
