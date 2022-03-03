package com.mukeshkpdeveloper.scrolltopositionexample;

public class LocationMasterDatum {
    private Integer locationId;
    private String locationName;

    public LocationMasterDatum() {

    }

    public LocationMasterDatum(Integer locationId, String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
