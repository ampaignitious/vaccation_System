/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.vaccine;

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
public class registeringvaccinehandler extends SimpleTagSupport {

    private String name;
    private String totalno;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    
    Connection con = null;
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
//        out.println(totalno);

               
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Driver started successfully
         try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
                //out.println("<br><h5>ThunderGray successfully connected to the database try</h5>");
                
                Statement st = con.createStatement();

                st.executeUpdate("insert into vaccineregistration(vaccine_name,numberofvaccine) values('"+name+"','"+totalno+"')");
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
            throw new JspException("Error in registeringvaccinehandler tag", ex);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalno(String totalno) {
        this.totalno = totalno;
    }
    
}
