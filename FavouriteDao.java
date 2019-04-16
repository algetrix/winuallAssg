package com.example.Assignment;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface FavouriteDao {

    @Query("SELECT * FROM `defaultdata`")
   List<Entity> getdefaultdata();

    @Insert
    void insert(Entity Entity);

    @Delete
    void delete(Entity Entity);

    @Query("DELETE FROM defaultdata WHERE id=:id")
    void deleteFavById(int id);


}
