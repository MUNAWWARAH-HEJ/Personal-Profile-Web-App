package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ProfileServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect GET requests to the form
        response.sendRedirect("index.html");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html;charset=UTF-8");
        
        // Retrieve form data
        String name = request.getParameter("name");
        String studentId = request.getParameter("studentId");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String introduction = request.getParameter("introduction");
        
        // Validate required fields
        if (name == null || name.trim().isEmpty() || 
            studentId == null || studentId.trim().isEmpty() ||
            program == null || program.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            introduction == null || introduction.trim().isEmpty()) {
            
            request.setAttribute("error", "Please fill in all required fields.");
            request.getRequestDispatcher("index.html").forward(request, response);
            return;
        }
        
        // Set attributes for JSP
        request.setAttribute("name", name);
        request.setAttribute("studentId", studentId);
        request.setAttribute("program", program);
        request.setAttribute("email", email);
        request.setAttribute("hobbies", hobbies);
        request.setAttribute("introduction", introduction);
        
        // Forward to JSP page
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}