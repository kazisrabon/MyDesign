package com.example.bs_36.mydesign.fragment.left;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridView;

import com.example.bs_36.mydesign.R;
import com.example.bs_36.mydesign.adapter.GridViewImageAdapter;
import com.example.bs_36.mydesign.helper.AppConstant;
import com.example.bs_36.mydesign.helper.Utils;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by BS-36 on 3/20/2015.
 */
public class PhotosFragment extends Fragment {
    private Utils utils;
    private ArrayList<String> imagePaths = new ArrayList<String>();
    private ArrayList<File> fileList = new ArrayList<File>();
    private File root;
    private GridViewImageAdapter adapter;
    private GridView gridView;
    private int columnWidth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);
        root = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath());

        return rootView;
    }
//    public ArrayList<File> getfile(File dir) {
//        File listFile[] = dir.listFiles();
//        if (listFile != null && listFile.length > 0) {
//            for (int i = 0; i < listFile.length; i++) {
//
//                if (listFile[i].isDirectory()) {
//                    fileList.add(listFile[i]);
//                    getfile(listFile[i]);
//
//                } else {
//                    if (listFile[i].getName().endsWith(".png")
//                            || listFile[i].getName().endsWith(".jpg")
//                            || listFile[i].getName().endsWith(".jpeg")
//                            || listFile[i].getName().endsWith(".gif"))
//
//                    {
//                        fileList.add(listFile[i]);
//                    }
//                }
//
//            }
//        }
//        return fileList;
//    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gridView = (GridView) getActivity().findViewById(R.id.grid_view);
        utils = new Utils(getActivity());
        // Initilizing Grid View
        InitilizeGridLayout();

        // loading all image paths from SD card
//        imagePaths = utils.getFilePaths();
        fileList = utils.getfile(root);

        // Gridview adapter
        adapter = new GridViewImageAdapter(getActivity(), fileList,
                columnWidth);

        // setting grid view adapter
        gridView.setAdapter(adapter);
    }

    private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                AppConstant.GRID_PADDING, r.getDisplayMetrics());

        columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) * padding)) / AppConstant.NUM_OF_COLUMNS);

        gridView.setNumColumns(AppConstant.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding,
                (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }
}
