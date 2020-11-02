import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@WebServlet("/tovarna")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String pozadavek = request.getParameter("jidla");
        TovarnaNaJidlo tovarna = new TovarnaNaJidlo();
        Jidlo j = null;
        String cena = " ";
        String postup = " ";
        if (pozadavek != null || pozadavek.equals("")) {
            j = tovarna.vyrobJidlo(pozadavek);
            cena += j.dejCenu();
            postup += j.vyrobTo();
        }

        out.println("<html lang=\"cs\">\n"
                + "<head>\n"
                + "    <meta charset=\"utf-8\">\n"
                + "    <title>Továrna na Jídlo</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <form method=\"GET\">\n"
                + "        <label for=\"jidlo\">Vyber si jídlo:</label>\n"
                + "        <select selected=\"\" id=\"jidlo\" name=\"jidla\" onchange=\"this.form.submit()\">\n"
                + "            <option value=\"\"> -- select an option -- </option>\n"
                + "            <option value=\"dort\">Dort pro pejska</option>\n"
                + "            <option value=\"caj\">Čaj pro královnu</option>\n"
                + "            <option value=\"svickova\">Svicková pro mudrce</option>\n"
                + "        </select>\n"
                + "    </form>\n"
                + "\n"
                + "    <dl>\n"
                + "        <dt>Cena" + cena + "</dt>\n"
                + "        <dt>Postup" + postup + "</dt>\n"
                + "    </dl>\n"
                + "</body>\n"
                + "</html>");
    }
}
