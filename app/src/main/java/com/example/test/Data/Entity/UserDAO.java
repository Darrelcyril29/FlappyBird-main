package com.example.test.Data.Entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid = :uid")
    User findByID(int uid);

    @Insert
    void insertAll(User... users);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("UPDATE User SET highscore = :newHighscore, coin = coin + :newCoins WHERE uid = :userId")
    void updateHighscoreAndCoins(int userId, int newHighscore, int newCoins);

    @Query("UPDATE User SET coin = :newCoins WHERE uid = :userId")
    void updateCoins(int userId, int newCoins);

    @Query("SELECT coin FROM user WHERE uid = :userId")
    double getCoin(long userId);


}


