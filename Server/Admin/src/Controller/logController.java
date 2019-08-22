package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class logController implements Controller {

    public void execute(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        String logPath = "/usr/local/tomcat9/logs/";
        String fileName =  request.getParameter("log_filename");

        if(!(fileName==null))fileName = logPath + fileName.trim().replaceAll("\\.\\.", "");
        else fileName = "catalina.out";
            long preEndPoint = request.getParameter("preEndPoint") == null ? 0 : Long.parseLong(request.getParameter("preEndPoint") + "");
            StringBuilder log = new StringBuilder();
            System.out.println(fileName);
            long startPoint = 0;
            long endPoint = 0;
            RandomAccessFile file = null;
            String str = "";
            PrintWriter out = null;
            try {
                out = response.getWriter();
                file = new RandomAccessFile(fileName, "r");
                endPoint = file.length();
                startPoint = preEndPoint > 0 ?
                        preEndPoint : endPoint < 2000 ?
                        0 : endPoint - 2000;
                file.seek(startPoint);

                while ((str = file.readLine()) != null) {
                    log.append(str);
                    log.append("\\\\r\\\\n");
                    endPoint = file.getFilePointer();
                    file.seek(endPoint);
                }
            } catch (FileNotFoundException fnfe) {
                log.append("File does not exist.");
            } catch (IOException e) {
                log.append("Sorry. An error has occurred.");
            } finally {
                try {
                    file.close();
                } catch (NullPointerException e) {
                    log.append("File does not exist.");
                }catch(IOException ex){
                    log.append("Sorry. An error has occurred.");
                }
            }
            String a = log.toString();
            a = a.replaceAll("\\[","\\(").replaceAll("\\]","\\)").replaceAll(",","");
            try{
                response.getWriter().print("{\"endPoint\":\"" + endPoint + "\", \"logs\":\"" + a + "\"}");
            }
            catch(IOException E){
                log.append("File does not exist.");
            }
        }
}
