package dao;

import filter.getText;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class adminDao {

    private static adminDao dao = new adminDao();
    private adminDao(){    }
    public static adminDao getInstance(){
        return dao;
    }

    public Connection connect(){
        getText gt = new getText();
        String b = gt.loadid();
        String a = gt.loadpwa();
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4406/admin?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false",b,a);
        } catch (SQLException ex) {
            Logger.getLogger("데이터 베이스 연결 중 오류 발생");
            Logger.getLogger(adminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException e) {
            Logger.getLogger("클래스 낫 파운드 오류");
        }
        return conn;
    }
    public void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if (rs != null){
            try{
                rs.close();
            } catch(SQLException ex){
                Logger.getLogger("SQLException 오류 발생");
            }
        }
        close(conn, ps);
    }
    public void close(Connection conn, PreparedStatement ps){
        if(ps != null){
            try{
                ps.close();
            } catch(SQLException ex){
                Logger.getLogger("SQLException 오류 발생");
            }
        }
        if (conn != null){
            try{
                conn.close();
            } catch(SQLException ex){
                Logger.getLogger("SQLException 오류 발생");
            }
        }
    }
    public boolean logInsert(String type, String des){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean sucSign = false;
        try{
            conn = connect();
            if(!(conn==null)) {
                pstmt = conn.prepareStatement("INSERT INTO log VALUES (?,?,default)");
                pstmt.setString(1, type);
                pstmt.setString(2, des);
                pstmt.executeUpdate();
                sucSign = true;
            }
        } catch(SQLException ex){
            Logger.getLogger("SQLException 오류 발생");
        } finally {
            close(conn, pstmt);
        }

        return sucSign;
    }
}
