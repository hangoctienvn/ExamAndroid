package com.example.hangoctien.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    long insertUser(User user);

    @Query("Select * from user where id = :id")
    User findUser(int id);

}
