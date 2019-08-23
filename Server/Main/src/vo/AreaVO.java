package vo;

public class AreaVO {
    private int sigungucode;
    private int contentid;
    private String addr;
    private String title;
    private String firstimage;
    private String firstimage2;

    public int getSigungucode() {
        int object = 0;
        object = sigungucode;
        return object;
    }

    public void setSigungucode(int sigungucode) {
        if (sigungucode != 0) this.sigungucode = sigungucode;
    }

    public int getContentid() {
        int object = 0;
        object = contentid;
        return object;
    }

    public void setContentid(int contentid) {
        if (contentid != 0) this.contentid = contentid;
    }

    public String getAddr() {
        String object = null;
        object = addr;
        return object;
    }

    public void setAddr(String addr) {
        if (addr != null) this.addr = addr;
    }

    public String getTitle() {
        String object = null;
        object = title;
        return object;
    }

    public void setTitle(String title) {
        if (title != null) this.title = title;
    }

    public String getFirstimage() {
        String object = null;
        object = firstimage;
        return object;
    }

    public void setFirstimage(String firstimage) {
        if (firstimage != null) this.firstimage = firstimage;
    }

    public String getFirstimage2() {
        String object = null;
        object = firstimage2;
        return object;
    }

    public void setFirstimage2(String firstimage2) {
        if (firstimage2 != null) this.firstimage2 = firstimage2;
    }
}
