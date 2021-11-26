package Controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class FrontController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig sc) throws ServletException{

    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HashMap<String, Controller> list = new HashMap<String, Controller>();
        if(list.isEmpty()){
            list.put("/log.do", new logController());
            list.put("/login.do", new LoginController());
            list.put("/secure/date.do", new datelogController());
            list.put("/secure/event.do", new getEventController());
            list.put("/secure/error.do", new getErrorController());
        }

        request.setCharacterEncoding("UTF-8");
        String url = request.getRequestURI();
        String contextPath = request.getContextPath();
        String path = url.substring(contextPath.length());
        Controller subController = list.get(path);
        subController.execute(request, response);
    }
}
