/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.administration;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.*;

/**
 *
 * @author icondesigners
 */
public class allpatients extends SimpleTagSupport {

    private String table;
    private String displayformat;
    private String where;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
//        out.println(table);
        Connection con =null;
        
                try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Driver started successfully
         try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
                //out.println("<br><h5>ThunderGray successfully connected to the database try</h5>");
                
                Statement st = con.createStatement();
                          ResultSet rs= st.executeQuery("select name, healthcenter,vaccine, vaccinestatus, dateOfVaccination from registeringpatient");
            out.println("<br><h3>Patients Details</h3>");
            out.println("<table style=\"border:1px solid black; width:100%; border-collapse: collapse;\">            <tr>\n" +
"                <td>Name:</td>\n" +
"                <td>Health Center: </td>\n" +
"                <td>Vaccine</td>\n" +
"                <td>Vaccination Status: </td>\n" +
"                <td>DateOfVaccination: </td>\n" +
"            </tr><tr>");
            while(rs.next()){
                String first_name = rs.getString("name");
                String healthcenter = rs.getString("healthcenter");
                String vaccine = rs.getString("vaccine");
                String vaccinestatus = rs.getString("vaccinestatus");
                String dateOfVaccination = rs.getString("dateOfVaccination");
                out.println("<tr><td>"+first_name+"</td><td>"+healthcenter+"</td><td>"+vaccine+"</td><td>"+vaccinestatus+"</td><td>"+dateOfVaccination+"</td></tr>");
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
            throw new JspException("Error in allpatients tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setDisplayformat(String displayformat) {
        this.displayformat = displayformat;
    }

    public void setWhere(String where) {
        this.where = where;
    }
    
}
