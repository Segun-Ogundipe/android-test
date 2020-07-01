package ng.riby.androidtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ng.riby.androidtest.adapter.SavedLocationsAdapter;
import ng.riby.androidtest.entity.LocationEntity;
import ng.riby.androidtest.view.LocationViewModel;

public class LocationsActivity extends AppCompatActivity {

    private LocationViewModel mLocationViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final SavedLocationsAdapter adapter = new SavedLocationsAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mLocationViewModel = new ViewModelProvider(this).get(LocationViewModel.class);
        mLocationViewModel.getAllLocations().observe(this, new Observer<List<LocationEntity>>() {
            @Override
            public void onChanged(List<LocationEntity> locations) {
                // Update the cached copy of the words in the adapter.
                adapter.setLocations(locations);
            }
        });
    }
}
