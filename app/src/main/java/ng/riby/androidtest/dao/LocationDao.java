package ng.riby.androidtest.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ng.riby.androidtest.entity.LocationEntity;

@Dao
public interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LocationEntity locationEntity);

    @Query("SELECT * FROM location")
    LiveData<List<LocationEntity>> getAllLocations();
}
