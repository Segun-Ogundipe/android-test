package ng.riby.androidtest.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "location")
public class LocationEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "origin_latitude")
    private double oLatitude;

    @ColumnInfo(name = "origin_longitude")
    private double oLongitude;

    @ColumnInfo(name = "destination_latitude")
    private double destLatitude;

    @ColumnInfo(name = "destination_longitude")
    private double destLongitude;

    public LocationEntity(){

    }

    public int getId() {
        return id;
    }

    public double getOLatitude() {
        return oLatitude;
    }

    public double getOLongitude() {
        return oLongitude;
    }

    public double getDestLatitude() {
        return destLatitude;
    }

    public double getDestLongitude() {
        return destLongitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOLatitude(double oLatitude) {
        this.oLatitude = oLatitude;
    }

    public void setOLongitude(double oLongitude) {
        this.oLongitude = oLongitude;
    }

    public void setDestLatitude(double destLatitude) {
        this.destLatitude = destLatitude;
    }

    public void setDestLongitude(double destLongitude) {
        this.destLongitude = destLongitude;
    }
}
