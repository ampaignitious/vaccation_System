/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.healthcenter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author icondesigners
 */
public class RegisteringHealthCenter extends HttpServlet {

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
        
        String CenterName = request.getParameter("name");
        String CenterLocation = request.getParameter("location");

        //
         request.setAttribute("name", CenterName);
         request.setAttribute("location", CenterLocation);
        
         RequestDispatcher rd = request.getRequestDispatcher("sendinghealthcenter.jsp");
         rd.include(request, response);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Driver started successfully
         try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
                //out.println("<br><h5>ThunderGray successfully connected to the database try</h5>");
                
                Statement st = con.createStatement();
                 ResultSet rs= st.executeQuery("select centername,location from healthcenter");
                 out.println("<table><tr>");
                 
                 out.println("<td><b>Name<b></td><td><b>Location<b></td></tr><tr>");
                 String link="<td><button><a href=\"healthcenterform.jsp\" style=\"textdecoration:none;\">Update Center</a></button>";
                
                 
                 while(rs.next()){
                String centername = rs.getString("centername");
                String location  =rs.getString("centername");
               if(centername!=null && location!=null){
                   out.println("<tr>");
                out.println("<td>"+centername+"</td>");
                out.println("<td>"+location+"</td>");
                out.println("<td>"+link+"</td");
                out.println("</tr>");
               }
            }
            out.println("</table>");
            out.println("<button><a href=\"WELCOMEPAGE.jsp\">Back</a></button>");
                
                }catch(SQLException e){
//                    out.println("<br>There is an error:: "+ e.getMessage());
                }
         }catch(ClassNotFoundException e){           
                out.println("<br><br>loading the driver has result to an error:: "+e.getMessage());
            }
         
       ///working with the healthcenter registration and updating 
       
         


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
