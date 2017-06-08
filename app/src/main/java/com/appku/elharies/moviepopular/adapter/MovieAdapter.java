package com.appku.elharies.moviepopular.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appku.elharies.moviepopular.R;
import com.appku.elharies.moviepopular.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by El Haries on 6/8/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Result> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle,  popularity, mVote;
        ImageView gambar;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.list_item);
            movieTitle = (TextView) v.findViewById(R.id.title);
            popularity = (TextView) v.findViewById(R.id.popularity);
            mVote = (TextView) v.findViewById(R.id.vote);
            gambar = (ImageView) v.findViewById(R.id.gambar);
        }
    }

    public MovieAdapter(List<Result> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(rowLayout,parent,false));
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.movieTitle.setText(movies.get(position).getTitle()+" ("+movies.get(position)
                .getReleaseDate()+")");
        holder.popularity.setText("Popularity   : "+movies.get(position).getPopularity());
        holder.mVote.setText("Vote             : "+movies.get(position).getVoteCount());
        Picasso.with(context).load("https://image.tmdb.org/t/p/w300_and_h450_bestv2"+movies.get(position)
        .getBackdropPath()).resize(200,250).into(holder.gambar);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
