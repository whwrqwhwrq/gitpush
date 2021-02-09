package wrq.beans;

import wrq.utils.IDUtil;

import java.util.Date;

/**
 * @Author:wrq
 * @Date:2020/10/27 16:25
 */
public class Site {
    private String id;
    private String name;
    private String url;
    private Long pv;
    private String coop;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = IDUtil.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPv() {
        return pv;
    }

    public void setPv(Long pv) {
        this.pv = pv;
    }

    public String getCoop() {
        return coop;
    }

    public void setCoop(String coop) {
        this.coop = coop;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", pv=" + pv +
                ", coop='" + coop + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
