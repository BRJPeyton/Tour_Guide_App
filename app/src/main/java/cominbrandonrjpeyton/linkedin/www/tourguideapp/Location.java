package cominbrandonrjpeyton.linkedin.www.tourguideapp;

/**
 * Created by Brandon on 7/25/2016.
 */
public class Location {

    /** String resource ID for the location name*/
    private int mLocationNameId;

    /** String resource ID for the location address*/
    private int mLocationAddressId;

    /** String resource ID for the location phone number*/
    private int mLocationPhoneId;

    /** String resource ID for the location price rates*/
    private int mLocationRateId;

    /** String resource ID for the location web address*/
    private int mLocationWebsiteId;

    /**Image resource ID for a picture of the location*/
    private int mImageResourceId;

    /**
     * Create a new Location object.
     */
    public Location(int locationName, int locationAddress, int locationPhone, int locationRate, int locationWebsite, int imageResource) {
        mLocationNameId = locationName;
        mLocationAddressId = locationAddress;
        mLocationPhoneId = locationPhone;
        mLocationRateId = locationRate;
        mLocationWebsiteId = locationWebsite;
        mImageResourceId = imageResource;
    }

    /*
    Return the resource ID for the name of the location.
     */
    public int getLocationName(){
        return mLocationNameId;
    }

    /*
    Return the resource ID for the address of the location.
     */
    public int getLocationAddress(){
        return mLocationAddressId;
    }

    /*
    Return the resource ID for the phone number of the location.
     */
    public int getLocationPhone(){
        return mLocationPhoneId;
    }

    /*
    Return the resource ID for the pricing of the location.
     */
    public int getLocationRate(){
        return mLocationRateId;
    }

    /*
    Return the resource ID for the web address of the location.
     */
    public int getLocationWebsite(){
        return mLocationWebsiteId;
    }

    /*
    Return the image resource ID for the location.
     */
    public int getImageResourceId(){
        return mImageResourceId;
    }
}
