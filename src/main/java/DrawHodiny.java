
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.imageio.ImageIO;

@WebServlet("/obrazek")
public class DrawHodiny extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ZoneId zone = ZoneId.of("Europe/Prague");
        ZonedDateTime now = ZonedDateTime.now(zone);
        int houers = now.getHour();
        int minutes = now.getMinute();

        BufferedImage img = new BufferedImage(400, 400, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.CYAN);
        g.drawOval(0, 0, 400, 400);
        int x = (int) (200+200*Math.cos((Math.toRadians(30*houers-90))));
        int y = (int) (200+200*Math.sin((Math.toRadians(30*houers-90))));
        
        int x2 = (int) (200+200*Math.cos((Math.toRadians(6*minutes-90))));
        int y2 = (int) (200+200*Math.sin((Math.toRadians(6*minutes-90))));
        g.setColor(Color.ORANGE);
        g.drawLine(200,200,(int)x,(int)y);
        g.setColor(Color.MAGENTA);
        g.drawLine(200,200,(int)x2,(int)y2);
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(img, "PNG", os);
    }
}
