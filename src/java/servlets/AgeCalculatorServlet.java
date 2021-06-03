package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // capture the parameters from the POST request (Form)
        String ageVariable = request.getParameter("ageParameter");

        // set the attributes for the JSP
        request.setAttribute("ageAttribute", ageVariable);
        
        try {
            // validation: if one of the parameter is null, show the first page again
            if (ageVariable == null || ageVariable.equals("")) {
                // create a helpful message to send to the user
                request.setAttribute("message", "You must give your current age.");
                
                // forward the req and response objects to the JSP
                // display the form again
                getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            }
            // continue to the result by adding 1 to the inputted age
            else {
                int ageInt = Integer.parseInt(ageVariable);
                ageInt += 1; 
                request.setAttribute("message", "Your age next birthday will be " + ageInt);
                getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            }
        }
        catch (NumberFormatException n) {
            // validation: if the user didn't input a number
            request.setAttribute("message", "You must enter a number.");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        }
    }

}
