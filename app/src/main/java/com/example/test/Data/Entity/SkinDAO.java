package com.example.test.Data.Entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SkinDAO {

    @Query("SELECT * FROM Skin")
    List<Skin> getAll();

    @Query("SELECT * FROM skin WHERE uid = :uid")
    Skin findByID(int uid);

    @Insert
    void insertAll(Skin... skins);

    @Update
    void update(Skin skin);

    @Delete
    void delete(Skin skin);

    @Query("SELECT skinName FROM skin WHERE uid = :uid")
    String getSkinNameById(int uid);
}
