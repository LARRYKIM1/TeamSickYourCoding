package service;
import  dao.adminDao;
import vo.AdminVO;

import java.util.ArrayList;

public class AdminService {
    private static AdminService service = new AdminService();
    public adminDao dao = adminDao.getInstance();

    private AdminService(){ }
    public static AdminService getInstance(){
        return service;
    }
    public boolean adminLogin(AdminVO admin){ return dao.adminLogin(admin); }
    public ArrayList<AdminVO> eventList(){return dao.eventList();}
    public ArrayList<AdminVO> errorList(){return dao.errorList();}
}
