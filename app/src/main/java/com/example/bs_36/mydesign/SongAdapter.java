package com.example.bs_36.mydesign;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by BS-36 on 3/16/2015.
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<CardView> contactList;

    public SongAdapter(List<CardView> contactList) {
        this.contactList = contactList;
    }


    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.my_text_view, parent, false);

        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {

        CardView ci = contactList.get(position);
        holder.circleImageView.setImageResource(R.mipmap.srabon);
        holder.infoTextView.setText(ci.song_name);
    }



    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        private View view;
        protected CircleImageView circleImageView;
        protected TextView infoTextView;

        public SongViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            circleImageView = (CircleImageView)view.findViewById(R.id.circleView);
            infoTextView = (TextView)view.findViewById(R.id.info_text);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

}
