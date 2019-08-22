package Controller;
import service.loglist;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class datelogController implements Controller{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String file = request.getParameter("file");

        if(file==null){
            request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
            response.sendRedirect("/admin/error.jsp");
            return;
        }
        loglist ll = new loglist();
        List<String> list = ll.list();

        if(list.contains(file)) session.setAttribute("filename", file);
        else session.setAttribute("filename","catalina.out");

        response.sendRedirect("log.jsp");

    }
}
