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
 *Fragment that displays a list of Attractions and Theme Parks unique to Los Angeles.
 */
public class AttractionsFragment extends Fragment {

    /** Retrieves the stored website for the business at the Location */
    private int mWebsite;

    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.attraction_disney, R.string.address_disney, R.string.phone_disney,
                R.string.rate_disney, R.string.website_disney, R.drawable.disney));
        locations.add(new Location(R.string.attraction_sign, R.string.address_sign, R.string.phone_sign,
                R.string.rate_sign, R.string.website_sign, R.drawable.hollywood_sign));
        locations.add(new Location(R.string.attraction_walk, R.string.address_walk, R.string.phone_walk,
                R.string.rate_walk, R.string.website_walk, R.drawable.walk_of_fame));
        locations.add(new Location(R.string.attraction_wax, R.string.address_wax, R.string.phone_wax,
                R.string.rate_wax, R.string.website_wax, R.drawable.hollywood_wax));
        locations.add(new Location(R.string.attraction_tarpit, R.string.address_tarpit, R.string.phone_tarpit,
                R.string.rate_tarpit, R.string.website_tarpit, R.drawable.tar_pits));
        locations.add(new Location(R.string.attraction_art, R.string.address_art, R.string.phone_art,
                R.string.rate_art, R.string.website_art, R.drawable.museum_of_art));
        locations.add(new Location(R.string.attraction_zoo, R.string.address_zoo, R.string.phone_zoo,
                R.string.rate_zoo, R.string.website_zoo, R.drawable.la_zoo));
        locations.add(new Location(R.string.attraction_history, R.string.address_history, R.string.phone_history,
                R.string.rate_history, R.string.website_history, R.drawable.history_museum));
        locations.add(new Location(R.string.attraction_pier, R.string.address_pier, R.string.phone_pier,
                R.string.rate_pier, R.string.website_pier, R.drawable.sm_pier));
        locations.add(new Location(R.string.attraction_universal, R.string.address_universal, R.string.phone_universal,
                R.string.rate_universal, R.string.website_universal, R.drawable.universal_studios));

        // Create a LocationAdapter, whose data source is a list of Locations
        //Adapter knows how to create list items for each item in the list.
        LocationAdapter itemAdapter = new LocationAdapter(getActivity(), locations, R.color.attraction_color);

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
