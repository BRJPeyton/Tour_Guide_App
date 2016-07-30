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
 *Fragment that displays a list of Special Events unique to Los Angeles.
 */
public class EventsFragment extends Fragment {

    /** Retrieves the stored website for the business at the Location */
    private int mWebsite;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.event_bowl, R.string.address_bowl, R.string.phone_bowl,
                R.string.rate_bowl, R.string.website_bowl, R.drawable.hollywood_bowl));
        locations.add(new Location(R.string.event_clippers, R.string.address_clippers, R.string.phone_clippers,
                R.string.rate_clippers, R.string.website_clippers, R.drawable.clippers));
        locations.add(new Location(R.string.event_dodgers, R.string.address_dodgers, R.string.phone_dodgers,
                R.string.rate_dodgers, R.string.website_dodgers, R.drawable.dodgers));
        locations.add(new Location(R.string.event_kings, R.string.address_kings, R.string.phone_kings,
                R.string.rate_kings, R.string.website_kings, R.drawable.kings));
        locations.add(new Location(R.string.event_lakers, R.string.address_lakers, R.string.phone_kings,
                R.string.rate_kings, R.string.website_lakers, R.drawable.lakers));
        locations.add(new Location(R.string.event_usc, R.string.address_usc, R.string.phone_usc,
                R.string.rate_usc, R.string.website_usc, R.drawable.trojans));
        locations.add(new Location(R.string.event_wwe, R.string.address_wwe, R.string.phone_wwe,
                R.string.rate_wwe, R.string.website_wwe, R.drawable.wwe));

        // Create a LocationAdapter, whose data source is a list of Locations
        //Adapter knows how to create list items for each item in the list.
        LocationAdapter itemAdapter = new LocationAdapter(getActivity(), locations, R.color.event_color);

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