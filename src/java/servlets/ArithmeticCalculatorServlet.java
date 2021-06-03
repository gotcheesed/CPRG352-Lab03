package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("message", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // capture the parameters from the POST request (Form)
        String firstNum = request.getParameter("firstNum");
        String secondNum = request.getParameter("secondNum");

        // set the attributes for the JSP
        request.setAttribute("firstNum", firstNum);
        request.setAttribute("secondNum", secondNum);
        
        try {
        // validation: if one of the parameter is null, show the page again
        if (firstNum == null || firstNum.equals("") || secondNum == null || secondNum.equals("")) {
            request.setAttribute("message", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

            return;
        }

        String add = request.getParameter("add");
        String subtract = request.getParameter("subtract");
        String multiply = request.getParameter("multiply");
        String modulo = request.getParameter("modulo");
        
        // converting String to Int
        int num1 = Integer.parseInt(firstNum);
        int num2 = Integer.parseInt(secondNum);
        double result = 0;

        // validation: if one of the parameter is not null to calculate the user input
        if (add != null) {
            result = num1 + num2;
        }
        else if (subtract != null) {
            result = num1 - num2;
        }
        else if (multiply != null) {
            result = num1 * num2;
        }
        else if (modulo != null) {
            result = num1 % num2;
        }
        
        request.setAttribute("message", result);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        
         }
        catch (NumberFormatException e) {
            // validation: if the user didn't input a number
            request.setAttribute("message", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        }
    }
    
}
