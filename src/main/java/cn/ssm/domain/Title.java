package cn.ssm.domain;

public class Title {
    private String titleName;

    private Integer id;

    public Title(String titleName) {
        this.titleName = titleName;
    }

    public Title() {
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Title{" +
                "titleName='" + titleName + '\'' +
                ", id=" + id +
                '}';
    }
}