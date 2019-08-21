package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import service.TravelService;
import vo.TravelVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class gettenController implements Controller{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        ArrayList<TravelVO> type = null;
        String contentTypeID = request.getParameter("ContentTypeID");
        String num = request.getParameter("num");
        String array = null;
        Gson gson = new Gson();
        JsonObject object = new JsonObject();

        if(contentTypeID==null|| num==null){
            object.addProperty("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
        }
        else if(contentTypeID.isEmpty()|| num.isEmpty()){
            object.addProperty("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
        }
        else if(!contentTypeID.matches("[0-9]*")){
            object.addProperty("error", "특수문자는 허용되지 않습니다. 숫자로 입력해 주세요.");
        }
        else if(!num.matches("[0-9]*")){
            object.addProperty("error", "특수문자는 허용되지 않습니다. 숫자로 입력해 주세요.");
        }
        else {
            TravelService service = TravelService.getInstance();
            type = service.getByConTypeid(contentTypeID, num);


            if(type.size()==0){
                object.addProperty("error", "파라미터를 확인해주세요.");
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
