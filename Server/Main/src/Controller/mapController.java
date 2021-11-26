package Controller;

import service.TravelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import filter.getText;
public class mapController implements Controller{
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        String pageno = request.getParameter("pageno");
        String mapx = request.getParameter("mapx");
        String mapy = request.getParameter("mapy");
        getText gt = new getText();
        String api = gt.loadapi();
        PrintWriter out = null;
        String urls = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/locationBasedList?" +
                "serviceKey=" +api+
                "&numOfRows=10&pageSize=10&pageNo="+pageno+"&startPage=1&MobileOS=ETC&MobileApp=AppTest" +
                "&listYN=Y&arrange=A&mapX="+mapx+"&mapY="+mapy+"&radius=1000&_type=json";
        TravelService service = TravelService.getInstance();
        String resultSet = "";
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            out = response.getWriter();
            URL url = new URL(urls);
            URLConnection conn = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                resultSet = resultSet.concat(line);
            }
            resultSet = resultSet.replaceAll("<", "").replaceAll(">", "");
            out.write(resultSet);
            service.loginsert("event","/map.do?pageno="+pageno+"?mapx="+mapx+"?mapy="+mapy);
        }
        catch(MalformedURLException ex){
            service.loginsert("error","MalformedURLException in mapController.java");
        }
        catch (IOException ex){
            service.loginsert("error","IOException in mapController.java");
        }
        finally {
            try {
                if(out!=null && bufferedReader !=null) {
                    out.flush();
                    out.close();
                    bufferedReader.close();
                }
            }
            catch(NullPointerException x){
                service.loginsert("error","NullPointerException in mapController.java");
            }
            catch(IOException x){
                service.loginsert("error","IOException in mapController.java");
            }
        }

    }
}
