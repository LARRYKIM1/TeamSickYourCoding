package Controller;

import java.io.*;
import com.google.gson.*;
import com.google.gson.JsonObject;
import javax.servlet.*;
import javax.servlet.http.*;
import service.TravelService;
import vo.TravelVO;
import filter.langFilter;

public class travelController implements Controller{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        String contentID = request.getParameter("ContentID");
        String lang = request.getParameter("lang");
        TravelVO vo = null;
        Gson gson = new Gson();
        JsonObject object = new JsonObject();

        if(contentID==null || lang==null){
            object.addProperty("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
        }
        else if(contentID.isEmpty() || lang.isEmpty()){
            object.addProperty("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
        }
        else if(!contentID.matches("[0-9]*")){
            object.addProperty("error", "특수문자는 허용되지 않습니다. 숫자로 입력해 주세요.");
        }
        else if(!lang.matches("[a-z]*")){
            object.addProperty("error", "lang 파라미터를 영어 소문자로 입력해주세요.");
        }
        else {
            langFilter lfile = new langFilter();
            lang = lfile.lang(lang);

            TravelService service = TravelService.getInstance();
            vo = service.getByConid(contentID, lang);

            if (!(vo==null)) {
                System.out.println(contentID+"를 조회했습니다.");

                object.addProperty("contentid", vo.getContentid());
                object.addProperty("contenttypeid", vo.getContenttypeid());
                object.addProperty("areacode", vo.getAreacode());
                object.addProperty("sigungucode", vo.getSigungucode());
                object.addProperty("addr", vo.getAddr());
                object.addProperty("title", vo.getTitle());
                object.addProperty("firstimage", vo.getFirstimage());
                object.addProperty("firstimage2", vo.getFirstimage2());
                object.addProperty("mapx", vo.getMapx());
                object.addProperty("mapy", vo.getMapy());
                object.addProperty("zipcode", vo.getZipcode());
                object.addProperty("overview", vo.getDes());
                object.addProperty("tel", vo.getTel());
                object.addProperty("update", vo.getUpdate());
            } else {
                object.addProperty("error", "DB에 해당 contentid가 없습니다.");
            }
        }
        String json = gson.toJson(object);
        System.out.println(json);
        PrintWriter out = response.getWriter();
        json = json.replaceAll("<","").replaceAll("<","");
        out.write(json);
        out.flush();
        out.close();

    }
}