package ng.riby.androidtest.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ng.riby.androidtest.dao.LocationDao;
import ng.riby.androidtest.dao.LocationDatabase;
import ng.riby.androidtest.entity.LocationEntity;

public class LocationRepository {
    private LocationDao mLocationDao;
    private LiveData<List<LocationEntity>> mAllLocations;

    public LocationRepository(Application application) {
        LocationDatabase db = LocationDatabase.getDatabase(application);
        mLocationDao = db.locationDao();
        mAllLocations = mLocationDao.getAllLocations();
    }

    public LiveData<List<LocationEntity>> getAllLocations(){
        return  mAllLocations;
    }

    public void insert(final LocationEntity locationEntity) {
        LocationDatabase.databaseWriteExecutor.execute(() -> mLocationDao.insert(locationEntity));
    }
}
