/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author icondesigners
 */
public class gettingallbookingsmadebypatients extends SimpleTagSupport {

    private String patientname;
    private String healthcenter;
    private String preferredvaccine;
    private String useremail;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        Connection con=null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Driver started successfully
         try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
                //out.println("<br><h5>ThunderGray successfully connected to the database try</h5>");
                
                Statement st = con.createStatement();
                          ResultSet rs= st.executeQuery("select id, name,healthcenter,vaccinechoice,email from patientbooking");
            out.println("<br><h3>Patient Booking Details</h3>");
            out.println("<table style=\"border:1px solid black; width:100%; border-collapse: collapse;\">            <tr>\n" +
"                <td><b>Patient Name<b>:</td>\n" +
"                <td><b>Health Center<b>: </td>\n" +
"                <td><b>Preferred Vaccine<b>:</td>\n" +
"                <td><b>User Email<b> : </td>\n" +

"            </tr><tr>");
            while(rs.next()){
                String id =rs.getString("id");
                String first_name = rs.getString("name");
                String healthcenter = rs.getString("healthcenter");
                String vaccine = rs.getString("vaccinechoice");
                String vaccinestatus = rs.getString("email");

                out.println("<tr><td>"+first_name+"</td><td>"+healthcenter+"</td><td>"+vaccine+"</td><td>"+vaccinestatus+"</td>"+"<td><button><a href=\"#\">Send Email</a></button></td>"+"</tr>");
            
            }
            
            out.println("</table>");
                }catch(SQLException e){
                    out.println("<br>There is an error:: "+ e.getMessage());
                }
         }catch(ClassNotFoundException e){           
                out.println("<br><br>loading the driver has result to an error:: "+e.getMessage());
            }
        
        
        
        
        
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in gettingallbookingsmadebypatients tag", ex);
        }
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public void setHealthcenter(String healthcenter) {
        this.healthcenter = healthcenter;
    }

    public void setPreferredvaccine(String preferredvaccine) {
        this.preferredvaccine = preferredvaccine;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
    
}
