package com.example.test.Data.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private Integer uid;

    @ColumnInfo(name = "highscore")
    private Integer highscore;

    @ColumnInfo(name = "coin")
    private Integer coin;


    public User(Integer uid, Integer highscore, Integer coin) {
        this.uid = uid;
        this.highscore = highscore;
        this.coin = coin;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getHighscore() {
        return highscore;
    }

    public void setHighscore(Integer highscore) {
        this.highscore = highscore;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

}
