package service;

import dao.TravelDao;
import vo.AreaVO;
import vo.TravelVO;

import java.util.ArrayList;

public class TravelService {
    private static TravelService service = new TravelService();
    public TravelDao dao = TravelDao.getInstance();

    private TravelService(){ }
    public static TravelService getInstance(){
        return service;
    }
    public TravelVO getByConid(String id, String lang){
        return dao.getByConid(id, lang);
    }
    public ArrayList<TravelVO> getByConTypeid(String id, String num){ return  dao.getByConTypeid(id,num); }
    public ArrayList<AreaVO> getByAreaCode(String id, String area, String sigun, String num, String lang){ return  dao.getByAreaCode(id,area,sigun,num,lang); }
    public ArrayList<AreaVO> getByAreaAll(String id, String area, String num, String lang){ return  dao.getByAreaAll(id,area,num,lang); }
}
