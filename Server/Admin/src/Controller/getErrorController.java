package Controller;

import service.AdminService;
import vo.AdminVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class getErrorController implements Controller{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AdminService service = AdminService.getInstance();
        ArrayList<AdminVO> list = service.errorList();

        session.setAttribute("elist",list);

        response.sendRedirect("errorlog.jsp");
    }
}
