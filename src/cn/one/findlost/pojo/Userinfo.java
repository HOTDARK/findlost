package cn.one.findlost.pojo;

public class Userinfo {
    private String id;

    private String userid;

    private String username;

    private String userrealname;

    private Integer sex;

    private String qq;

    private String phonenum;

    private String headimag;

    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserrealname() {
        return userrealname;
    }

    public void setUserrealname(String userrealname) {
        this.userrealname = userrealname == null ? null : userrealname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getHeadimag() {
        return headimag;
    }

    public void setHeadimag(String headimag) {
        this.headimag = headimag == null ? null : headimag.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", userrealname='" + userrealname + '\'' +
                ", sex=" + sex +
                ", qq='" + qq + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", headimag='" + headimag + '\'' +
                ", state=" + state +
                '}';
    }
}