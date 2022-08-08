<%-- 
    Document   : registeringvaccine
    Created on : Dec 3, 2021, 12:28:01 PM
    Author     : icondesigners
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
                        <form action="vaccineinventoryservlet" method="get">
            <table>
                <tr>
                    <td>Vaccine Name:</td>
                    <td><input type="text" name="name" required=""></td>
                </tr>
                <tr>
                    <td>Total Vaccine:</td>
                    <td><input type="text" name="name2" required=""></td>
                </tr>

                <tr>
                    <td><input type="submit" value="submit" ></td>
                </tr>
            </table>
            
            
        </form>
    </body>
</html>
