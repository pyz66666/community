package life.majiang.communtiy.community.model;

public class User {
    private Integer id;
    private String name;
    private
    private String accountId;
    private Long gmtCreate;
    private Long getModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGetModified() {
        return getModified;
    }

    public void setGetModified(Long getModified) {
        this.getModified = getModified;
    }
}
