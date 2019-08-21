package Controller;

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

public class mapController implements Controller{
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        String pageno = request.getParameter("pageno");
        String mapx = request.getParameter("mapx");
        String mapy = request.getParameter("mapy");
        PrintWriter out = null;
        String urls = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/locationBasedList?" +
                "serviceKey=RaV1p1mncJrI16%2FeEpAT4KOYzG4MiOjznmMztcqmpqOpOLyarHG7cGIJLi4fomlJ78hapy10Zm7fthL%2BWw5BLA%3D%3D" +
                "&numOfRows=10&pageSize=10&pageNo="+pageno+"&startPage=1&MobileOS=ETC&MobileApp=AppTest" +
                "&listYN=Y&arrange=A&mapX="+mapx+"&mapY="+mapy+"&radius=1000&_type=json";

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
        }
        catch(MalformedURLException ex){
            System.out.println("오류");
        }
        catch (IOException ex){
            System.out.println("오류");
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
                System.out.println("오류");
            }
            catch(IOException x){
                System.out.println("오류");
            }
        }

    }
}
