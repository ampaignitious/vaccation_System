/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.administration;


/**
 *
 * @author icondesigners
 */
public class SystemRegistration {
    public String Administer_Name;
    public String Email;
    public String password;
    public String confirmpassword;
    
    public String registering(String name, String email, String password1,String password2 ){
        this.Administer_Name = name;
        this.Email = email;
        this.password = password1;
        this.confirmpassword = password2;
        
       
    return "insert into student set fname='"+Administer_Name+"',sname='"+email+"',"
            + " course='"+password+"', studentno='"+confirmpassword+"'";
    }

    
}
