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
 *Fragment that displays a list of Los Angeles based hotels.
 */
public class HotelsFragment extends Fragment {

    /** Retrieves the stored website for the business at the Location */
    private int mWebsite;

    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.hotel_best_west, R.string.address_best_west, R.string.phone_best_west,
                R.string.rate_best_west, R.string.website_best_west, R.drawable.best_western));
        locations.add(new Location(R.string.hotel_embassy_suites, R.string.address_embassy_suites, R.string.phone_embassy_suites,
                R.string.rate_embassy_suites, R.string.website_embassy_suites, R.drawable.embassy_suites));
        locations.add(new Location(R.string.hotel_bur_inn, R.string.address_bur_inn, R.string.phone_bur_inn,
                R.string.rate_bur_inn, R.string.website_bur_inn, R.drawable.holiday_inn_bur));
        locations.add(new Location(R.string.hotel_dt_inn, R.string.address_dt_inn, R.string.phone_dt_inn,
                R.string.rate_dt_inn, R.string.website_dt_inn, R.drawable.holiday_inn_dt));
        locations.add(new Location(R.string.hotel_jj_grand, R.string.address_jj_grand, R.string.phone_jj_grand,
                R.string.rate_jj_grand, R.string.website_jj_grand, R.drawable.jj_grand));
        locations.add(new Location(R.string.hotel_park, R.string.address_park, R.string.phone_park,
                R.string.rate_park, R.string.website_park, R.drawable.park_plaza));
        locations.add(new Location(R.string.hotel_vagabond, R.string.address_vagabond, R.string.phone_vagabond,
                R.string.rate_vagabond, R.string.website_vagabond, R.drawable.vagabond_inn));

        // Create a LocationAdapter, whose data source is a list of Locations
        //Adapter knows how to create list items for each item in the list.
        LocationAdapter itemAdapter = new LocationAdapter(getActivity(), locations, R.color.hotel_color);

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