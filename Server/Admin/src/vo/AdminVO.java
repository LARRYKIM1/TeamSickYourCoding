package vo;

public class AdminVO {
    private String passwd;
    private String mail;
    private String type;
    private String des;
    private String time;

    public String getPasswd() {
        String object = null;
        object = passwd;
        return object;
    }

    public void setPasswd(String passwd) {
        if (passwd != null) this.passwd = passwd;
    }

    public String getMail() {
        String object = null;
        object = mail;
        return object;
    }

    public void setMail(String mail) {
        if (mail != null) this.mail = mail;
    }

    public String getType() {
        String object = null;
        object = type;
        return object;
    }

    public void setType(String type) {
        if (type != null) this.type = type;
    }

    public String getDes() {
        String object = null;
        object = des;
        return object;
    }

    public void setDes(String des) {
        if (des != null) this.des = des;
    }

    public String getTime() {
        String object = null;
        object = time;
        return object;
    }

    public void setTime(String time) {
        if (time != null) this.time = time;
    }
}
