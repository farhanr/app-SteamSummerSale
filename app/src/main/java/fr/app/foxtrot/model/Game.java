package fr.app.foxtrot.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable {
    private String name;
    private String detail;
    private String photo;
    private String discount;
    private String description;
    private String release;

    public Game(){

    }

    public Game(String name, String detail, String photo, String discount, String description, String release) {
        this.name = name;
        this.detail = detail;
        this.photo = photo;
        this.discount = discount;
        this.description = description;
        this.release = release;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDiscount() {
        return discount;
    }

    public String getDetail() {
        return detail;
    }

    public String getDescription() {
        return description;
    }

    public String getRelease() {
        return release;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.detail);
        dest.writeString(this.photo);
        dest.writeString(this.discount);
        dest.writeString(this.description);
        dest.writeString(this.release);
    }

    protected Game(Parcel in) {
        this.name = in.readString();
        this.detail = in.readString();
        this.photo = in.readString();
        this.discount = in.readString();
        this.description = in.readString();
        this.release = in.readString();
    }

    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel source) {
            return new Game(source);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}
