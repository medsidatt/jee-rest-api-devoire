package mr.iscae;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginData loginData = new LoginData();

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

        boolean isAdmin = isAdmin(username, password);
        boolean isDirecteur = isDirecteur(username, password);

        HttpSession session = request.getSession();
        if (isAdmin || isDirecteur) {
            String role = isDirecteur ? "directeur" : "admin";
            session.setAttribute("username", username);
            session.setAttribute("role", role);

            System.out.println("/secure/" + role + "/produits");
            response.sendRedirect(request.getContextPath() + "/secure/" + role + "/produits");
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    private boolean isAdmin(String username, String password) {
        User user = getByUserNameAndPsw(username, password);
        return user.getRole().equals("admin");
    }

    private boolean isDirecteur(String username, String password) {
        User user = getByUserNameAndPsw(username, password);
        return user.getRole().equals("directeur");
    }

    private User getByUserNameAndPsw(String userName, String password) {
        return loginData.getUserByUserNameAndPassword(userName, password);
    }
}
