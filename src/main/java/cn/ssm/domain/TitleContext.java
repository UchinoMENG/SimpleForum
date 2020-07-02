package cn.ssm.domain;

public class TitleContext {
    private Integer id;
    private String email;
    private String user_text;

    public TitleContext() {
    }

    public TitleContext(Integer id, String email, String user_text) {
        this.id = id;
        this.email = email;
        this.user_text = user_text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_text() {
        return user_text;
    }

    public void setUser_text(String user_text) {
        this.user_text = user_text;
    }

    @Override
    public String toString() {
        return "TitleContext{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", user_text='" + user_text + '\'' +
                '}';
    }
}
