import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {

    public LogInServlet() {
        System.out.println("Login instance is being created...."); //object is created
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init() being called...."); //object---> servlet is created
    }


    // service or doGet/doPost can be called .... service can call and handle all of them in Http
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("Service() method is being called.....");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Using SERVICE Method ";
        out.println("<html>\n" + "<head><title>" + title + "</title></head>\n"+
                "<h1 align = \"center\">" + title + "</h1>\n" + "</html>");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("doGet() being called....");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using GET Method ";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +  "  <li><b>First Name</b>: "
                        + request.getParameter("first_name") + "\n" +
                     "  <li><b>Last Name</b>: "
                        + request.getParameter("last_name") + "\n" +
                    "  <li><b>Fathers Name</b>: "
                        + request.getParameter("fathers_name") + "\n" +
                     "  <li><b>Mothers Name</b>: "
                        + request.getParameter("mothers_name") + "\n" +
                "</html>"
        );
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPost() being called....");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using POST Method ";
        out.println("<html>\n" + "<head><title>" + title + "</title></head>\n"+
                "<h1 align = \"center\">" + title + "</h1>\n" + "</html>");

        doGet(request, response);
    }


    @Override
    public void destroy() {
        System.out.println("destroy() being called....");
    }
}
