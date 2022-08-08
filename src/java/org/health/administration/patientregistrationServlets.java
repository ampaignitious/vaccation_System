/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.administration;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author icondesigners
 */
public class patientregistrationServlets extends HttpServlet {

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
        Connection con=null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nin = request.getParameter("nin");
        String name = request.getParameter("name");
        String dateOfVaccination = request.getParameter("dateOfVaccination");
        String vaccine = request.getParameter("vaccine");
        String batch = request.getParameter("batch");
        String vaccinestatus = request.getParameter("vaccinestatus");
        String healthcenter = request.getParameter("healthcenter");
        
        //database getting healthcenter patients///
                
         request.setAttribute("name", name);
         request.setAttribute("nin", nin);
         request.setAttribute("dateOfVaccination", dateOfVaccination);
         request.setAttribute("vaccine", vaccine);
         request.setAttribute("batch", batch);
         request.setAttribute("vaccinestatus", vaccinestatus);
         request.setAttribute("healthcenter", healthcenter);
         RequestDispatcher rdx = request.getRequestDispatcher("PatientRegisteringJsp.jsp");
         rdx.include(request, response);
         RequestDispatcher rdt =request.getRequestDispatcher("Patientcertificate.jsp");
         rdt.forward(request, response); 
        
        
                //database connection//
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Driver started successfully
         try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
                //out.println("<br><h5>ThunderGray successfully connected to the database try</h5>");
                
                Statement st = con.createStatement();
                
                String mengo = "select count(healthcenter) from registeringpatient where healthcenter='\"mulago\"'";
                String total_patients ="select count(healthcenter) from registrationpatient)";
                String query = "select count(healthcenter) from registeringpatient where healthcenter='\"mulago\"'";
                
                ResultSet rs = st.executeQuery(query);
                rs.next();
                int mulagopatients = rs.getInt(1);
                out.println(mulagopatients);
                HttpSession healthcenter1 = request.getSession();
                healthcenter1.setAttribute("number@mulago", mulagopatients);
                
                
         request.setAttribute("mulagopatients", mulagopatients);
         RequestDispatcher rd = request.getRequestDispatcher("Healthcenterpageassessment.jsp");
         rd.include(request, response);
 
                
//            request.setAttribute("mulagopatients", mulagopatients);

         }catch(SQLException e){
                    out.println("<br>There is an error:: "+ e.getMessage());
                }
         }catch(ClassNotFoundException e){           
                out.println("<br><br>loading the driver has result to an error:: "+e.getMessage());
            }
                                      
        
        
        
        
        /////end of getting patient details;/////


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
