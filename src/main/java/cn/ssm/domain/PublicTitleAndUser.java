package cn.ssm.domain;

import org.springframework.stereotype.Component;

@Component
public class PublicTitleAndUser {
    private Integer id;

    private String email;

    private String publicTitle;

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
        this.email = email == null ? null : email.trim();
    }

    public String getPublicTitle() {
        return publicTitle;
    }

    public void setPublicTitle(String publicTitle) {
        this.publicTitle = publicTitle == null ? null : publicTitle.trim();
    }
}