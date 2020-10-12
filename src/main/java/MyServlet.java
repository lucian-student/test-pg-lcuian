
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@WebServlet("/timezone")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form name=\"timezonForm\" method=\"post\" action=\"\">\n"
                + "    Username: <input type=\"text\" name=\"timezone\"/> <br/>\n"
                + "    <input type=\"submit\" value=\"Timezone\" />\n"
                + "</form>"
                + "");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // read form fields
        String timezone = request.getParameter("timezone");

        System.out.println("username: " + timezone);
        try {
            ZoneId zone = ZoneId.of(timezone);
            ZonedDateTime now = ZonedDateTime.now(zone);
            PrintWriter writer = response.getWriter();
            String htmlRespone = "<html>";
            htmlRespone += "<h2>" + timezone + ": " + now + "<br/>";
            htmlRespone += "</html>";
            writer.println(htmlRespone);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath());
        }

    }
}
