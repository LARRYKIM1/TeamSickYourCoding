package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import filter.langFilter;
import service.TravelService;
import vo.AreaVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class areaAllController implements Controller{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        response.setCharacterEncoding("utf-8");
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        langFilter langf = new langFilter();
        response.setContentType("application/json");
        ArrayList<AreaVO> type = null;

        String lang = request.getParameter("lang");
        String num = request.getParameter("num");
        String array = null;
        String contentTypeID = request.getParameter("ContentTypeID");
        String AreaCode = request.getParameter("AreaCode");


        if(contentTypeID==null|| num==null|| AreaCode==null|| lang==null) {
            object.addProperty("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
        }
        else if(contentTypeID.isEmpty()|| num.isEmpty()|| AreaCode.isEmpty()|| lang.isEmpty()){
            object.addProperty("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
        }
        else if(!contentTypeID.matches("[0-9]*")){
            object.addProperty("error", "특수문자는 허용되지 않습니다. 숫자로 입력해 주세요.");
        }
        else if(!num.matches("[0-9]*")){
            object.addProperty("error", "특수문자는 허용되지 않습니다. 숫자로 입력해 주세요.");
        }
        else if(!AreaCode.matches("[0-9]*")){
            object.addProperty("error", "특수문자는 허용되지 않습니다. 숫자로 입력해 주세요.");
        }
        else {
            String langs = langf.lang(lang);
            TravelService service = TravelService.getInstance();
            type = service.getByAreaAll(contentTypeID, AreaCode, num, langs);


            if(type.size()==0){
                object.addProperty("error", "해당 정보가 DB에 없습니다.");
            }
            else{
                array = gson.toJson(type);
            }
        }

        String json = gson.toJson(object);
        System.out.println(json);
        PrintWriter out = response.getWriter();


        if(array ==null)out.write(json);
        else out.write(array);
        out.flush();
        out.close();

    }
}
