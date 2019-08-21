package vo;

public class AreaVO {
    private int sigungucode;
    private int contentid;

    public int getSigungucode() {
        return sigungucode;
    }

    public void setSigungucode(int sigungucode) {
        this.sigungucode = sigungucode;
    }

    private String addr;
    private String title;
    private String firstimage;
    private String firstimage2;

    public int getContentid() { return contentid; }

    public String getAddr() { return addr; }
    public String getTitle() { return title; }

    public String getFirstimage() { return firstimage; }
    public String getFirstimage2() { return firstimage2; }

    public void setContentid(int contentid) { this.contentid = contentid; }

    public void setAddr(String addr) { this.addr = addr; }
    public void setTitle(String title) { this.title = title; }

    public void setFirstimage(String firstimage) { this.firstimage = firstimage; }
    public void setFirstimage2(String firstimage2) { this.firstimage2 = firstimage2; }

}
