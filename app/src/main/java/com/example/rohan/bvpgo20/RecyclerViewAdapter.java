package com.example.rohan.bvpgo20;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohan.bvpgo20.Models.Event;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rohan on 07-May-16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.EventViewHolder> {

    ArrayList<Event> mEvents;
    Context mContext;

    public RecyclerViewAdapter(ArrayList<Event> events, Context context) {
        mEvents = events;
        mContext = context;
    }

    @Override
    public RecyclerViewAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card, parent, false);
        EventViewHolder vh = new EventViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.EventViewHolder holder, int position) {
        holder.eventTitle.setText(mEvents.get(position).getTitle());
        holder.eventDescription.setText(mEvents.get(position).getDescription());
        Picasso.with(mContext).load(mEvents.get(position).getImage()).into(holder.eventImage);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView eventTitle;
        TextView eventDescription;
        ImageView eventImage;

        EventViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardView);
            eventTitle = (TextView)itemView.findViewById(R.id.CardTitle);
            eventDescription = (TextView)itemView.findViewById(R.id.CardDescription);
            eventImage = (ImageView)itemView.findViewById(R.id.CardImage);
        }
    }

}
