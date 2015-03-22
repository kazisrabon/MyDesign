package com.example.bs_36.mydesign;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bs_36.mydesign.adapter.NavDrawerListAdapter;
import com.example.bs_36.mydesign.adapter.NavDrawerListAdapterRight;
import com.example.bs_36.mydesign.fragment.left.HomeFragment;
import com.example.bs_36.mydesign.fragment.left.PhotosFragment;
import com.example.bs_36.mydesign.model.NavDrawerItem;
import com.example.bs_36.mydesign.model.NavDrawerItemRight;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    Toolbar toolbar;
//    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private LinearLayoutManager mLayoutManager;
//    List<CardView> cardViews;
//    android.support.v7.widget.CardView cardView;
//Navigation Drawer
    private DrawerLayout mDrawerLayout;
//    Left drawer
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;

//right drawer
    private ListView mDrawerList2;
    private ActionBarDrawerToggle mDrawerToggle2;
    private CharSequence mDrawerTitle2;
    private CharSequence mTitle2;
    private String[] navMenuTitles2;
    private TypedArray navMenuIcons2;
    private ArrayList<NavDrawerItemRight> navDrawerItems2;
    private NavDrawerListAdapterRight adapter2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle(R.string.title);
        mTitle = mDrawerTitle = getTitle();

        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        // adding nav drawer items to array
        // Home
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        // Find People
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        // Photos
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        // Communities, Will add a counter here
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
        // Pages
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        // What's hot, We  will add a counter here
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1), true, "50+"));


        // Recycle the typed array
        navMenuIcons.recycle();

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.mipmap.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                toolbar.setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                toolbar.setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
//        Right navigation Drawer
        // nav drawer icons from resources
        navMenuIcons2 = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons_right);

        mDrawerList2 = (ListView) findViewById(R.id.list_slidermenu_right);

        navDrawerItems2 = new ArrayList<NavDrawerItemRight>();

        // adding nav drawer items to array
        // Home
        navDrawerItems2.add(new NavDrawerItemRight(navMenuIcons2.getResourceId(0, -1)));
        // Find People
        navDrawerItems2.add(new NavDrawerItemRight(navMenuIcons2.getResourceId(1, -1)));
        // Photos
        navDrawerItems2.add(new NavDrawerItemRight(navMenuIcons2.getResourceId(2, -1)));
        // Communities, Will add a counter here
        navDrawerItems2.add(new NavDrawerItemRight(navMenuIcons2.getResourceId(3, -1)));
        // Pages
        navDrawerItems2.add(new NavDrawerItemRight(navMenuIcons2.getResourceId(4, -1)));
        // What's hot, We  will add a counter here
        navDrawerItems2.add(new NavDrawerItemRight(navMenuIcons2.getResourceId(5, -1)));


        // Recycle the typed array
        navMenuIcons2.recycle();

        mDrawerList2.setOnItemClickListener(new SlideMenuClickListener2());

        // setting the nav drawer list adapter
        adapter2 = new NavDrawerListAdapterRight(getApplicationContext(),
                navDrawerItems2);
        mDrawerList2.setAdapter(adapter2);

        // enabling action bar app icon and behaving it as toggle button
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle2 = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.mipmap.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                toolbar.setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                toolbar.setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle2);

//        if (savedInstanceState == null) {
//            // on first time display view for first nav item
//            displayView2(0);
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        toolbar.setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
        mDrawerToggle2.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
        mDrawerToggle2.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(Gravity.START| Gravity.LEFT)){
            mDrawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }
    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }
    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
//            case 1:
//                fragment = new FindPeopleFragment();
//                break;
            case 2:
                fragment = new PhotosFragment();
                break;
//            case 3:
//                fragment = new CommunityFragment();
//                break;
//            case 4:
//                fragment = new PagesFragment();
//                break;
//            case 5:
//                fragment = new WhatsHotFragment();
//                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener2 implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView2(position);
        }
    }
    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView2(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
//            case 0:
//                fragment = new HomeFragment();
//                break;
//            case 1:
//                fragment = new FindPeopleFragment();
//                break;
//            case 2:
//                fragment = new PhotosFragment();
//                break;
//            case 3:
//                fragment = new CommunityFragment();
//                break;
//            case 4:
//                fragment = new PagesFragment();
//                break;
//            case 5:
//                fragment = new WhatsHotFragment();
//                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList2.setItemChecked(position, true);
            mDrawerList2.setSelection(position);
            mDrawerLayout.closeDrawer(mDrawerList2);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }


}
