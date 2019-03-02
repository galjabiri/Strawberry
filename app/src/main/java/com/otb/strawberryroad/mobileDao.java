package com.otb.strawberryroad;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface mobileDao {

    @Query("SELECT * FROM Mobile_Table")
    List<Mobile> getAll();

    @Insert
    void insert(Mobile mobile);

    @Delete
    void delete(Mobile mobile);

    @Update
    void update(Mobile mobile);
}
