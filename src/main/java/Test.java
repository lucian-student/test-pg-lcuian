
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String pozadavek = request.getParameter("jidla");
        List<String[]> records = new ArrayList<String[]>();
        String url = "https://onemocneni-aktualne.mzcr.cz/api/v2/covid-19/testy.csv";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            String line;
            int pocet = 0;
            while ((line = br.readLine()) != null) {
                if (pocet != 0) {
                    String[] values = line.split(",");
                    records.add(values);
                } else {
                    pocet++;
                }
            }
            request.setAttribute("records", records);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
