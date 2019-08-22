package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import filter.getText;
import service.TravelService;
import vo.AreaVO;
import vo.TravelVO;

public class TravelDao {
    TravelService service = TravelService.getInstance();
    private static TravelDao dao = new TravelDao();
    private TravelDao(){    }
    public static TravelDao getInstance(){
        return dao;
    }

    public Connection connect(){
        getText gt = new getText();
        String b = gt.loadid();
        String a = gt.loadpw();
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/syc?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",b,a);
        } catch (SQLException ex) {
            service.loginsert("error","SQLException in TravelDao.java");
            Logger.getLogger(TravelDao.class.getName()).log(Level.SEVERE, null, ex);

        }
         catch (ClassNotFoundException e) {
             service.loginsert("error","ClassNotFoundException in TravelDao.java");
        }
        return conn;
    }
    public void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if (rs != null){
            try{
                rs.close();
            } catch(SQLException ex){
                service.loginsert("error","SQLException in TravelDao.java");
            }
        }
        close(conn, ps);
    }
    public void close(Connection conn, PreparedStatement ps){
        if(ps != null){
            try{
                ps.close();
            } catch(SQLException ex){
                service.loginsert("error","SQLException in TravelDao.java");
            }
        }
        if (conn != null){
            try{
                conn.close();
            } catch(SQLException ex){
                service.loginsert("error","SQLException in TravelDao.java");
            }
        }
    }
    private int index(String lang){
        int index;

        switch (lang){
            case "en":
                index = 18;
                break;
            case "ja":
                index = 19;
                break;
            case "cn":
                index = 20;
                break;
            case "tw":
                index = 21;
                break;
            case "vi":
                index = 22;
                break;
            case "id":
                index = 23;
                break;
            case "th":
                index = 24;
                break;
            case "de":
                index = 25;
                break;
            case "ru":
                index = 26;
                break;
            case "es":
                index = 27;
                break;
            case "it":
                index = 28;
                break;
            case "fr":
                index = 29;
                break;
            default:
                index = 17;
                break;
        }
        return index;
    }
    public TravelVO getByConid(String id, String lang){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TravelVO travel = null;

        try{
            conn = connect();
             if(conn!=null){ pstmt = conn.prepareStatement("SELECT * FROM tour WHERE contentid = ?");
                pstmt.setString(1, id);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    travel = new TravelVO();
                    travel.setContentid(rs.getInt(3));
                    travel.setContenttypeid(rs.getInt(4));
                    travel.setAreacode(rs.getInt(5));
                    travel.setSigungucode(rs.getInt(6));
                    travel.setFirstimage(rs.getString(12));
                    travel.setFirstimage2(rs.getString(13));
                    travel.setMapx(rs.getString(14));
                    travel.setTel(rs.getString(30));
                    travel.setUpdate(rs.getString(31));
                    travel.setMapy(rs.getString(15));
                    travel.setZipcode(rs.getString(16));


                    if (lang.equals("ko")) {
                        travel.setAddr(rs.getString(7));
                        travel.setTitle(rs.getString(1));
                    } else {
                        travel.setAddr(rs.getString(8));
                        travel.setTitle(rs.getString(2));
                    }
                    travel.setDes(rs.getString(index(lang)));
                }
            }
        } catch (SQLException ex){
            service.loginsert("error","SQLException in TravelDao.java");
        } finally{
            close(conn, pstmt, rs);
        }
        return travel;
    }
    public ArrayList<TravelVO> getByConTypeid(String id, String num){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TravelVO travel = null;
        ArrayList<TravelVO> array = new ArrayList<>();
        try{
            conn = connect();
            if(conn!=null){ pstmt = conn.prepareStatement("SELECT * FROM tour WHERE contenttypeid = ? LIMIT ?,10");
                pstmt.setString(1, id);
                pstmt.setInt(2, Integer.parseInt(num)*10);
                rs = pstmt.executeQuery();
                System.out.println(pstmt.toString());
                while (rs.next()) {
                    travel = new TravelVO();
                    travel.setContentid(rs.getInt(3));
                    travel.setContenttypeid(rs.getInt(4));
                    travel.setAreacode(rs.getInt(5));
                    travel.setSigungucode(rs.getInt(6));

                    travel.setAddr(rs.getString(7));
                    travel.setTitle(rs.getString(1));
                    travel.setFirstimage(rs.getString(12));
                    travel.setFirstimage2(rs.getString(13));
                    travel.setMapx(rs.getString(14));
                    travel.setMapy(rs.getString(15));
                    travel.setZipcode(rs.getString(16));
                    travel.setTel(rs.getString(30));
                    travel.setUpdate(rs.getString(31));
                    array.add(travel);
                }
            }
        } catch (SQLException ex){
            service.loginsert("error","SQLException in TravelDao.java");
        } finally{
            close(conn, pstmt, rs);
        }
        return array;
    }
    public ArrayList<AreaVO> getByAreaCode(String id, String area, String sigun, String num, String lang){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        AreaVO travel = null;
        ArrayList<AreaVO> array = new ArrayList<>();
        try{
            conn = connect();
            if(conn!=null){pstmt = conn.prepareStatement("SELECT * FROM tour WHERE areacode = ? AND sigungucode = ? AND contenttypeid = ? LIMIT ?,10");
                pstmt.setString(1, area);
                pstmt.setString(2, sigun);
                pstmt.setString(3, id);
                pstmt.setInt(4, Integer.parseInt(num)*10);
                rs = pstmt.executeQuery();
                System.out.println(pstmt.toString());
                while (rs.next()) {
                    travel = new AreaVO();

                    travel.setAddr(rs.getString(7));
                    travel.setContentid(rs.getInt(3));
                    travel.setFirstimage(rs.getString(12));
                    travel.setFirstimage2(rs.getString(13));

                    if (lang.equals("ko")) travel.setTitle(rs.getString(1));
                    else travel.setTitle(rs.getString(2));

                    if (lang.equals("ko")) travel.setAddr(rs.getString(7));
                    else travel.setAddr(rs.getString(8));

                    array.add(travel);
                }
            }
        } catch (SQLException ex){
            service.loginsert("error","SQLException in TravelDao.java");
        } finally{
            close(conn, pstmt, rs);
        }
        return array;
    }
    public ArrayList<AreaVO> getByAreaAll(String id, String area, String num, String lang){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        AreaVO travel = null;
        ArrayList<AreaVO> array = new ArrayList<>();
        try{
            conn = connect();
            if(conn!=null){ pstmt = conn.prepareStatement("SELECT * FROM tour WHERE areacode = ? AND contenttypeid = ? LIMIT ?,10");
                pstmt.setString(1, area);
                pstmt.setString(2, id);
                pstmt.setInt(3, Integer.parseInt(num)*10);
                rs = pstmt.executeQuery();
                System.out.println(pstmt.toString());

                while (rs.next()) {
                    travel = new AreaVO();
                    travel.setContentid(rs.getInt(3));
                    travel.setSigungucode(rs.getInt(6));
                    travel.setAddr(rs.getString(7));
                    if (lang.equals("ko")) travel.setTitle(rs.getString(1));
                    else travel.setTitle(rs.getString(2));

                    travel.setFirstimage(rs.getString(12));
                    travel.setFirstimage2(rs.getString(13));

                    if (lang.equals("ko")) travel.setAddr(rs.getString(7));
                    else travel.setAddr(rs.getString(8));

                    array.add(travel);
                }
            }
        } catch (SQLException ex){
            service.loginsert("error","SQLException in TravelDao.java");
        } finally{
            close(conn, pstmt, rs);
        }
        return array;
    }
}
