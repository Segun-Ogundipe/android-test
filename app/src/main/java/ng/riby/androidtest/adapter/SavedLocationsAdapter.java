package ng.riby.androidtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ng.riby.androidtest.R;
import ng.riby.androidtest.entity.LocationEntity;

public class SavedLocationsAdapter extends RecyclerView.Adapter<SavedLocationsAdapter.LocationViewHolder> {

    private final LayoutInflater mInflater;
    private List<LocationEntity> mLocations; // Cached copy of locations

    public SavedLocationsAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LocationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        if (mLocations != null) {
            LocationEntity current = mLocations.get(position);
            holder.idTv.setText(String.valueOf(current.getId()));
            holder.oLatTv.setText(String.valueOf(current.getOLatitude()));
            holder.oLonTv.setText(String.valueOf(current.getOLongitude()));
            holder.dLatTv.setText(String.valueOf(current.getDestLatitude()));
            holder.dLonTv.setText(String.valueOf(current.getDestLongitude()));

        }
    }

    @Override
    public int getItemCount() {
        if (mLocations != null)
            return mLocations.size();
        else return 0;
    }

    public void setLocations(List<LocationEntity> locations){
        mLocations = locations;
        notifyDataSetChanged();
    }

    static class LocationViewHolder extends RecyclerView.ViewHolder {
        private final TextView idTv;
        private final TextView oLatTv;
        private final TextView oLonTv;
        private final TextView dLatTv;
        private final TextView dLonTv;

        private LocationViewHolder(View itemView) {
            super(itemView);
            idTv = itemView.findViewById(R.id.locId);
            oLatTv = itemView.findViewById(R.id.oLatTv);
            oLonTv = itemView.findViewById(R.id.oLonTv);
            dLatTv = itemView.findViewById(R.id.destLatTv);
            dLonTv = itemView.findViewById(R.id.destLonTv);
        }
    }
}
