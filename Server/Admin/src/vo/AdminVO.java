package vo;

public class AdminVO {
    private String passwd;
    private String mail;
    private String type;
    private String des;
    private String time;

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public String getDes() {return des;}
    public void setDes(String des) {this.des = des;}
    public String getTime() {return time;}
    public void setTime(String time) {this.time = time; }
    public String getPasswd(){
        return passwd;
    }
    public void setPasswd(String passwd){ this.passwd = passwd;  }
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
}
