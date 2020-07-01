package ng.riby.androidtest.view;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ng.riby.androidtest.entity.LocationEntity;
import ng.riby.androidtest.repository.LocationRepository;

public class LocationViewModel extends AndroidViewModel {

    private LocationRepository mRepository;
    private LiveData<List<LocationEntity>> mAllLocations;

    public  LocationViewModel(Application application) {
        super(application);
        mRepository = new LocationRepository(application);
        mAllLocations = mRepository.getAllLocations();
    }

    public LiveData<List<LocationEntity>> getAllLocations() {
        return mAllLocations;
    }

    public void  insert(LocationEntity locationEntity) {
        mRepository.insert(locationEntity);
    }
}
