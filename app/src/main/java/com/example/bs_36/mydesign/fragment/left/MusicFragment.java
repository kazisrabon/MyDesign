package com.example.bs_36.mydesign.fragment.left;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bs_36.mydesign.CardView;
import com.example.bs_36.mydesign.R;
import com.example.bs_36.mydesign.SongAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BS-36 on 3/20/2015.
 */
public class MusicFragment extends Fragment {

    public MusicFragment() {
    }
//    LinearLayout linearLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    List<CardView> cardViews;
    ImageButton fabImageButton;
    android.support.v7.widget.CardView cardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_music, container, false);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        fabImageButton = (ImageButton) rootView.findViewById(R.id.fab_image_button);
        fabImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Fab button clicked", Toast.LENGTH_LONG).show();
            }
        });
        cardView = (android.support.v7.widget.CardView)mRecyclerView.findViewById(R.id.card_view);
        cardViews = new ArrayList<CardView>();
        cardViews.add(new CardView("Song 1"));
        cardViews.add(new CardView("Song 2"));
        cardViews.add(new CardView("Song 3"));

//        fabImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(getActivity().getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
//                cardViews.add(new CardView("New Song"));
////                mAdapter.notifyDataSetChanged();
//            }
//        });
        // specify an adapter (see also next example)
        mAdapter = new SongAdapter(cardViews);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
}
