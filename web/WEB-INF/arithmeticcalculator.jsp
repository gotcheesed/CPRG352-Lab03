<%-- 
    Document   : arithmeticcalculator
    Created on : 2-Jun-2021, 10:39:57 PM
    Author     : jewob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="arithmetic">
            <label>First: </label>
            <input type="text" name="firstNum" value="${firstNum}"></input>
            <br>
            <label>Second: </label>
            <input type="text" name="secondNum" value="${secondNum}"></input>
            <br>
            <input type="submit" name="add" value="+"></input>
            <input type="submit" name="subtract" value="-"></input>
            <input type="submit" name="multiply" value="*"></input>
            <input type="submit" name="modulo" value="%"></input>
        </form>
            
            <p>Result: ${message}</p>
            <a href="age">Age Calculator</a>
    </body>
</html>
