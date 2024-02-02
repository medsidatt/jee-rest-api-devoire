package mr.iscae;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Login Page</h1>");
		out.println("<form method=\"post\" action=\"/jee-rest-application/login\">");
		out.println("<label>Nom d'utilisateur</label>");
		out.println("<input type=\"text\" name=\"username\" />");
		out.println("<br>");
		out.println("<label>Not de pass</label>");
		out.println("<input type=\"password\" name=\"password\"/>");
		out.println("<br>");
		out.println("<input type=\"submit\"/>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
        	 
        	 HttpSession session = request.getSession();
        	 session.setAttribute("username", "admin");
             session.setAttribute("userRole", "admin");
        	
        	response.sendRedirect(request.getContextPath() + "/secure/admin/directeurs");
        } else {
        	response.sendRedirect(request.getContextPath() + "/login");
        }

    }

	
    
    private boolean authenticate(String username, String password) {
        return "admin".equals(username) && "admin".equals(password);
    }

}
