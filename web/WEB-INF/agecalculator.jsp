<%-- 
    Document   : agecalculator
    Created on : 31-May-2021, 11:00:08 AM
    Author     : jewob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="POST" action="age">
              <label for="age">Enter your age:</label>
              <input id="age" name="ageParameter" type="number" value="${ageAttribute}">
              <br>
              <input type="submit" value="Age next birthday">
        </form>
              
              <p>${message}</p>
              <p><a href="arithmetic">Arithmetic Calculator</a></p>
    </body>
</html>
