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
            list.put("/travel.do", new travelController());
            list.put("/areaall.do",new areaAllController());
            list.put("/map.do",new mapController());
            list.put("/ten.do", new gettenController());
            list.put("/area.do", new areaController());
        }

        request.setCharacterEncoding("UTF-8");
        String url = request.getRequestURI();
        String contextPath = request.getContextPath();
        String path = url.substring(contextPath.length());
        Controller subController = list.get(path);
        subController.execute(request, response);
    }
}
