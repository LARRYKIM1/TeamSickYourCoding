package dao;

import java.sql.*;
import crypt.SHA256;
import java.util.logging.Level;
import java.util.logging.Logger;
import filter.getText;
import vo.AdminVO;
import java.util.ArrayList;

public class adminDao {

    private static adminDao dao = new adminDao();
    private adminDao(){    }
    public static adminDao getInstance(){
        return dao;
    }

    public Connection connect(){
        getText gt = new getText();
        String b = gt.loadid();
        String a = gt.loadpw();
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4406/admin?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false",b,a);
        } catch (SQLException ex) {
            Logger.getLogger("데이터 베이스 연결 오류");
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException e) {
            Logger.getLogger("클래스 낫 파운드");

        }
        return conn;
    }
    public void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if (rs != null){
            try{
                rs.close();
            } catch(SQLException ex){
                Logger.getLogger("SQL 오류");
            }
        }
        close(conn, ps);
    }
    public void close(Connection conn, PreparedStatement ps){
        if(ps != null){
            try{
                ps.close();
            } catch(SQLException ex){
                Logger.getLogger("SQL 오류");
            }
        }
        if (conn != null){
            try{
                conn.close();
            } catch(SQLException ex){
                Logger.getLogger("SQL 오류");
            }
        }
    }
    public boolean adminLogin (AdminVO member){
        SHA256 hash = new SHA256();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isLogin = false;

        try{
            conn = connect();
            if(!(conn==null)) {
                pstmt = conn.prepareStatement("SELECT * FROM us1er WHERE email = ?");
                pstmt.setString(1, member.getMail());
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    if (hash.SHA256Encryption(member.getPasswd()).equals(rs.getString(2))) {
                        isLogin = true;
                    }
                }
            }
        } catch (SQLException ex){
            Logger.getLogger("SQL 오류");
        } finally{
            close(conn, pstmt, rs);
        }
        return isLogin;
    }

    public ArrayList<AdminVO> eventList() {

        ArrayList<AdminVO> list = new ArrayList<AdminVO>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        AdminVO member = null;

        try {
            conn = connect();
            if(!(conn==null)) {
                pstmt = conn.prepareStatement("select * from log where type = 'event' order by  time desc LIMIT 0,20");
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    member = new AdminVO();
                    member.setType(rs.getString(1));
                    member.setDes(rs.getString(2));
                    member.setTime(rs.getString(3));
                    list.add(member);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger("SQL 오류");
        } finally {
            close(conn, pstmt, rs);
        }

        return list;
    }
    public ArrayList<AdminVO> errorList() {

        ArrayList<AdminVO> list = new ArrayList<AdminVO>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        AdminVO member = null;

        try {
            conn = connect();
            if(!(conn==null)) {
                pstmt = conn.prepareStatement("select * from log where type = 'error' order by  time desc LIMIT 0,20");

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    member = new AdminVO();
                    member.setType(rs.getString(1));
                    member.setDes(rs.getString(2));
                    member.setTime(rs.getString(3));
                    list.add(member);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger("SQL 오류");
        } finally {
            close(conn, pstmt, rs);
        }

        return list;
    }
}
