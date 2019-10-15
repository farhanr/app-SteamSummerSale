package fr.app.foxtrot.model;

public class Game {
    private String name;
    private String detail;
    private String photo;
    private String discount;

    public Game(){

    }

    public Game(String name, String detail, String photo, String discount) {
        this.name = name;
        this.detail = detail;
        this.photo = photo;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
