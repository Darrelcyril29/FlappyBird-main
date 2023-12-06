package com.example.test.Data.Entity;

import androidx.annotation.ColorLong;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Skin {

    @PrimaryKey(autoGenerate = true)
    private Integer uid;

    @ColumnInfo(name = "Skin")
    private Boolean skin;

    @ColumnInfo(name = "SkinName")
    private String skinname;

    @ColumnInfo(name = "Price")
    private Integer price;

    public Skin(Integer uid, Boolean skin, String skinname, Integer price) {
        this.uid = uid;
        this.skin = skin;
        this.skinname = skinname;
        this.price = price;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Boolean getSkin() {
        return skin;
    }

    public void setSkin(Boolean skin) {
        this.skin = skin;
    }

    public String getSkinname() {
        return skinname;
    }

    public void setSkinname(String skinname) {
        this.skinname = skinname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // toString, equals, and hashCode methods can also be added here
}

