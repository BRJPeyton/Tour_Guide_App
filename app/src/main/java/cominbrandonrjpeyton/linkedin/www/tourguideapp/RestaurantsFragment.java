package cominbrandonrjpeyton.linkedin.www.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 *Fragment that displays a list of Restaurants unique to Los Angeles.
 */
public class RestaurantsFragment extends Fragment {

    /** Retrieves the stored website for the business at the Location */
    private int mWebsite;

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.restaurant_hugos, R.string.address_hugos, R.string.phone_hugos,
                R.string.rate_hugos, R.string.website_hugos, R.drawable.hugos));
        locations.add(new Location(R.string.restaurant_in_n_out, R.string.address_in_n_out, R.string.phone_in_n_out,
                R.string.rate_in_n_out, R.string.website_in_n_out, R.drawable.in_n_out));
        locations.add(new Location(R.string.restaurant_joans, R.string.address_joans, R.string.phone_joans,
                R.string.rate_joans, R.string.website_joans, R.drawable.joans));
        locations.add(new Location(R.string.restaurant_tommys, R.string.address_tommys, R.string.phone_tommys,
                R.string.rate_tommys, R.string.website_tommys, R.drawable.tommys));
        locations.add(new Location(R.string.restaurant_pinks, R.string.address_pinks, R.string.phone_pinks,
                R.string.rate_pinks, R.string.website_pinks, R.drawable.pinks));
        locations.add(new Location(R.string.restaurant_rfd, R.string.address_rfd, R.string.phone_rfd,
                R.string.rate_rfd, R.string.website_rfd, R.drawable.real_food));
        locations.add(new Location(R.string.restaurant_roscoes, R.string.address_roscoes, R.string.phone_roscoes,
                R.string.rate_roscoes, R.string.website_roscoes, R.drawable.roscoes));
        locations.add(new Location(R.string.restaurant_titos, R.string.address_titos, R.string.phone_titos,
                R.string.rate_titos, R.string.website_titos, R.drawable.titos));

        // Create a LocationAdapter, whose data source is a list of Locations
        //Adapter knows how to create list items for each item in the list.
        LocationAdapter itemAdapter = new LocationAdapter(getActivity(), locations, R.color.restaurant_color);

        //Find the ListView object in the view hierarchy of the Activity.
        //There should be a ListView with the view ID called list, which is declared in the
        //location_list.xml.
        ListView listView = (ListView)rootView.findViewById(R.id.list);

        //Set the ListView to use the LocationAdapter so that the ListView will display list
        //items for each Location in the list.
        listView.setAdapter(itemAdapter);

        //Set the click listener to open a browse and the website when clicked on.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //Get the position of the item clicked.
                Location location = locations.get(position);

                //Get the web address for the item clicked.
                mWebsite = location.getLocationWebsite();

                //covert the website int into a String.
                String website = getString(mWebsite);

                //Open a browser.
                Intent in = new Intent(Intent.ACTION_VIEW);

                //Set data for the web address.
                in.setData(Uri.parse(website));

                //Load website.
                startActivity(in);
            }
        });

        return rootView;
    }

}
