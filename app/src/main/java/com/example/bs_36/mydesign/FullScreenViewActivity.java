package com.example.bs_36.mydesign;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.bs_36.mydesign.adapter.FullScreenImageAdapter;
import com.example.bs_36.mydesign.helper.Utils;

import java.io.File;

/**
 * Created by BS-36 on 3/20/2015.
 */
public class FullScreenViewActivity extends ActionBarActivity{

    private Utils utils;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;
    Toolbar toolbar;
    private File root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_view);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setNavigationIcon(R.mipmap.ic_action_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        root = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath());
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        viewPager = (ViewPager) findViewById(R.id.pager);

        utils = new Utils(getApplicationContext());

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);

        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
                utils.getfile(root));

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);
    }
}