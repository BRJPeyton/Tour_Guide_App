package cominbrandonrjpeyton.linkedin.www.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Brandon on 7/25/2016.
 * CategoryAdapter provides a layout for each list item based on a data source
 * which is a list of Location objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new CategoryAdapter object.
     * @param context is the context of the app.
     * @param fragManager is the fragment manager that will keep each fragment's
     *        state in the adapter across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fragManager) {
        super(fragManager);
        mContext = context;
    }

    /**
     *
     * @param position is the page that the app is currently on.
     * @return the Fragment that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AttractionsFragment();
        } else if (position == 1){
            return new EventsFragment();
        } else if (position == 2){
            return new RestaurantsFragment();
        } else {
            return new HotelsFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.category_attractions);
        } else if(position == 1){
            return mContext.getString(R.string.category_events);
        } else if(position == 2){
            return mContext.getString(R.string.category_restaurants);
        } else{
            return mContext.getString(R.string.category_hotels);
        }
    }
}

