package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import vo.AdminVO;
import service.AdminService;

public class LoginController implements Controller{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String pd = request.getParameter("hi");
        String mail = request.getParameter("email");
        if(pd==null || mail==null){
            request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
            response.sendRedirect("/admin/error.jsp");
            return;
        }
        if(pd.isEmpty() || mail.isEmpty()){
            request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
            response.sendRedirect("/admin/error.jsp");
            return;
        }
        if(!mail.matches("[0-9|a-z|A-Z|@|.]*")){
            request.setAttribute("error", "특수문자는 허용되지 않습니다. 올바른 이메일 주소를 입력하세요.");
            response.sendRedirect("/admin/error.jsp");
            return;
        }
        AdminVO member = new AdminVO();
        member.setPasswd(pd);
        member.setMail(mail);

        AdminService service = AdminService.getInstance();
        boolean code = service.adminLogin(member);

        if(code){
            request.setAttribute("email", mail);
            session.setAttribute("id",true);
            session.setAttribute("email",mail);
            session.setAttribute("filename","catalina.out");
            response.sendRedirect("secure/main.jsp");
        }
        else{
            request.setAttribute("error", "등록된 이메일 또는 비밀번호가 아닙니다.");
            response.sendRedirect("/admin/error.jsp");
        }
    }
}
