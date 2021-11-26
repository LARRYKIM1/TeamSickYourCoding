import javax.print.DocFlavor;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;


public class LoggingFilter implements Filter {
    public void init(FilterConfig config){

    }
    public void doFilter(ServletRequest request, ServletResponse  response, FilterChain chain) {
        boolean isLogin = false;

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();

        try {
            if (session != null) {
                isLogin = (Boolean) session.getAttribute("id");
            }
            if (isLogin) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.sendRedirect("/admin/index.jsp");
            }
        }catch(ServletException E){
            Logger.getLogger("서블릿 오류");
        }catch(IOException X){
            Logger.getLogger("입출력 오류");
        }
    }
    public void destroy() {

    }
}
