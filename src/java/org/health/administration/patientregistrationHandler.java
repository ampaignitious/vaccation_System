/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.administration;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.*;

/**
 *
 * @author icondesigners
 */
public class patientregistrationHandler extends SimpleTagSupport {

    private String nin;
    private String name;
    private String dateOfVaccination;
    private String vaccine;
    private String batch;
    private String healthcenter;
    private String vaccinestatus;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    
    Connection con = null;
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        out.println(name);
        out.println(dateOfVaccination);
        int x=0;
        
        //database connection//
                        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Driver started successfully
         try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
                //out.println("<br><h5>ThunderGray successfully connected to the database try</h5>");
                
                Statement st = con.createStatement();
            String healthcenter1 = "mulago";
      
//                st.executeUpdate("insert into registeringpatient set nin='"+nin+"',name='"+name+"', dateOfVaccination='"+dateOfVaccination+"',vaccinestatus='"+vaccinestatus+"', vaccine='"+vaccine+"', batch='"+batch+"', healthcenter='"+healthcenter+"'");
                st.executeUpdate("insert into registeringpatient(nin,name,dateOfVaccination,vaccine,batch,healthcenter,vaccinestatus) values('"+nin+"','"+name+"','"+dateOfVaccination+"','"+vaccine+"','"+batch+"','"+healthcenter+"','"+vaccinestatus+"')");
            
                String query = "select count(healthcenter) from registeringpatient where healthcenter='\"mulago\"'";
                
                ResultSet rs = st.executeQuery(query);
                rs.next();
                int mulagopatients = rs.getInt(1);
                out.println(mulagopatients);
            
               
         }catch(SQLException e){
                    out.println("<br>There is an error:: "+ e.getMessage());
                }
         }catch(ClassNotFoundException e){           
                out.println("<br><br>loading the driver has result to an error:: "+e.getMessage());
            }
        
                        // end of database connection
                       
                        
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
            throw new JspException("Error in patientregistrationHandler tag", ex);
        }
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfVaccination(String dateOfVaccination) {
        this.dateOfVaccination = dateOfVaccination;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setTable(String healthcenter) {
        this.healthcenter = healthcenter;
    }
    public void setVaccinestatus(String vaccinestatus){
        this.vaccinestatus = vaccinestatus;
    }
    public void setHealthcenter(String healthcenter){
        this.healthcenter = healthcenter;
    }
    
    
}
