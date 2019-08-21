package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import service.TravelService;
import vo.AreaVO;
import filter.langFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class areaController implements Controller{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        ArrayList<AreaVO> type = null;
        String contentTypeID = request.getParameter("ContentTypeID");
        String AreaCode = request.getParameter("AreaCode");
        String SigunguCode = request.getParameter("SigunguCode");
        String lang = request.getParameter("lang");
        String num = request.getParameter("num");
        String array = null;
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        langFilter langf = new langFilter();

        if(contentTypeID==null|| num==null|| AreaCode==null|| SigunguCode==null|| lang==null){
            object.addProperty("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
        }
        else if(contentTypeID.isEmpty()|| num.isEmpty()|| AreaCode.isEmpty()|| SigunguCode.isEmpty()|| lang.isEmpty()){
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
        else if(!SigunguCode.matches("[0-9]*")){
            object.addProperty("error", "특수문자는 허용되지 않습니다. 숫자로 입력해 주세요.");
        }
        else {
            String langs = langf.lang(lang);
            TravelService service = TravelService.getInstance();
            type = service.getByAreaCode(contentTypeID, AreaCode, SigunguCode, num, langs);


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

        json = json.replaceAll("<","").replaceAll(">","");
        if(array ==null)out.write(json);
        else {
            array = array.replaceAll("<","").replaceAll(">","");
            out.write(array);
        }
        out.flush();
        out.close();

    }
}
