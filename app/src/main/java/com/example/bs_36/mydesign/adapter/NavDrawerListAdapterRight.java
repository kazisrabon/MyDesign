package com.example.bs_36.mydesign.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bs_36.mydesign.R;
import com.example.bs_36.mydesign.model.NavDrawerItem;
import com.example.bs_36.mydesign.model.NavDrawerItemRight;

import java.util.ArrayList;

/**
 * Created by BS-36 on 3/20/2015.
 */
public class NavDrawerListAdapterRight extends BaseAdapter {

    private Context context;
    private ArrayList<NavDrawerItemRight> navDrawerItems;

    public NavDrawerListAdapterRight(Context context, ArrayList<NavDrawerItemRight> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item_right, null);
        }
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon_right);
        imgIcon.setImageResource(navDrawerItems.get(position).getIcon());

        return convertView;
    }

}
