package cominbrandonrjpeyton.linkedin.www.tourguideapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Brandon on 7/25/2016.
 * LocationAdapter provides the layout for each list item based on a data source, which
 * is a list of Location objects.
 */
public class LocationAdapter extends ArrayAdapter<Location> {

    /** Resource ID for the background color for this list of locations */
    private int mColorResourceId;

    // Create a new LocationAdapter object.
    public LocationAdapter(Activity context, ArrayList<Location> locations, int colorResourceId){
        super(context, 0, locations);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        // Get the Location object at this position in the list
        Location currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID location_name.
        TextView nameTextView = (TextView)listItemView.findViewById(R.id.location_name);
        // Get the Location name from the current Location and set it on the TextView.
        nameTextView.setText(currentLocation.getLocationName());

        // Find the TextView in the list_item.xml layout with the ID location_address.
        TextView addressTextView = (TextView)listItemView.findViewById(R.id.location_address);
        // Get the Location address from the current Location and set it on the TextView.
        addressTextView.setText(currentLocation.getLocationAddress());

        // Find the TextView in the list_item.xml layout with the ID location_phone.
        TextView phoneTextView = (TextView)listItemView.findViewById(R.id.location_phone);
        // Get the Location phone number from the current Location and set it on the TextView.
        phoneTextView.setText(currentLocation.getLocationPhone());

        // Find the TextView in the list_item.xml layout with the ID location_rate.
        TextView rateTextView = (TextView)listItemView.findViewById(R.id.location_rate);
        // Get the Location pricing from the current Location and set it on the TextView.
        rateTextView.setText(currentLocation.getLocationRate());

        // Find the TextView in the list_item.xml layout with the ID location_website.
        TextView websiteTextView = (TextView)listItemView.findViewById(R.id.location_website);
        // Set the text to read "Click Here" so that you don't dominate the space with the http.
        websiteTextView.setText(R.string.click_here);

        // Find the ImageView in the list_item.xml layout with the ID location_image.
        ImageView imageView = (ImageView)listItemView.findViewById(R.id.location_image);
        // Get the image ID and set it on the ImageView.
        imageView.setImageResource(currentLocation.getImageResourceId());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout so that it can be shown in the ListView.
        return listItemView;
    }

}

