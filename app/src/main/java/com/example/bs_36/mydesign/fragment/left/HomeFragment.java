package com.example.bs_36.mydesign.fragment.left;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bs_36.mydesign.CardView;
import com.example.bs_36.mydesign.R;
import com.example.bs_36.mydesign.SongAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BS-36 on 3/20/2015.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
    }
//    LinearLayout linearLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    List<CardView> cardViews;
    android.support.v7.widget.CardView cardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.my_recycler_view);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        cardView = (android.support.v7.widget.CardView)mRecyclerView.findViewById(R.id.card_view);
        cardViews = new ArrayList<CardView>();
        cardViews.add(new CardView("Song 1"));
        cardViews.add(new CardView("Song 2"));
        cardViews.add(new CardView("Song 3"));
        // specify an adapter (see also next example)
        mAdapter = new SongAdapter(cardViews);
        mRecyclerView.setAdapter(mAdapter);
    }
}
