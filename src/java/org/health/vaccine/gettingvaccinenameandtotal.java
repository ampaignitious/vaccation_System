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
public class gettingvaccinenameandtotal extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    Connection con =null;
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        
                try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Driver started successfully
         try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
                //out.println("<br><h5>ThunderGray successfully connected to the database try</h5>");
                
                Statement st = con.createStatement();
                
            ResultSet rs= st.executeQuery("select distinct(vaccine_name) from vaccineregistration");
            
            while(rs.next()){

                String first_name = rs.getString("vaccine_name");
                out.println("Vaccine name: " +first_name + "<br> <br>");
                

            }  
            
            String query3 = "select sum(numberofvaccine) from vaccineregistration where vaccine_name=\"Astrazeneca\"";
            String query2 = "select sum(numberofvaccine) from vaccineregistration where vaccine_name=\"Pfizer-BioNTech\"";
            String query1 = "select sum(numberofvaccine) from vaccineregistration where vaccine_name=\"Moderna\"";

            String query = "select sum( numberofvaccine) from vaccineregistration where vaccine_name=\"Johnson & Johnson\"";
                
        ////////////////////////////////
            
                ResultSet rx = st.executeQuery(query);
                rx.next();
                int Johnson = rx.getInt(1);   
                out.println("<b>Total number of available Johnson & Johnson<b/> ="+Johnson);
                
       //////////////////////
                 ResultSet rx1 = st.executeQuery(query1);
                 rx1.next();
                 int Moderna =rx1.getInt(1);
                 out.println("<br>Total number of available Moderna= "+Moderna+"<br>");
                 
        ///////////////////////
                ResultSet rex2 = st.executeQuery(query2);
                 rex2.next();
                 int Pfizer_BioNTech = rex2.getInt(1);
                 out.println("Total number of available Pfizer_BioNTech= "+Pfizer_BioNTech+"<br>");
        ////////////////////////////
                ResultSet rex3 = st.executeQuery(query3);
                 rex3.next();
                 int Astrazeneca = rex3.getInt(1);
                 out.println("Total number of available Astrazeneca= "+Astrazeneca+"<br>");
        ///////////////////////////////
     
                 
        
        
               
                 
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
            throw new JspException("Error in gettingvaccinenameandtotal tag", ex);
        }
    }
    
}
