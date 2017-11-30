package com.vikas.codetest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vikas.codetest.R;
import com.vikas.codetest.model.Movie;
import com.vikas.codetest.model.Result;

import java.util.List;

/**
 * Created by Vikas on 11/28/2017.
 */

public class Movie_List_Adapter extends RecyclerView.Adapter<Movie_List_Adapter.MyViewHolder>  {
    private Context mContext;
    private List<Result> movieList;
    Boolean mAdultFlag;
    public Movie_List_Adapter(Context mContext, List<Result> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public Movie_List_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(Movie_List_Adapter.MyViewHolder holder, int position) {
        holder.mMovieName.setText(movieList.get(position).getTitle());
        holder.mReleaseDate.setText(movieList.get(position).getReleaseDate());
        mAdultFlag=movieList.get(position).getAdult();
        if(mAdultFlag){
         holder.mAdult.setText("(A)");
        }else {
            holder.mAdult.setText("(U/A)");
        }





    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mMovieName,mReleaseDate,mAdult;
        ImageView mImageViewMoviePoster;
        public MyViewHolder(View itemView) {
            super(itemView);
            mMovieName=itemView.findViewById(R.id.txt_movie_name);
            mReleaseDate=itemView.findViewById(R.id.txt_date);
            mAdult=itemView.findViewById(R.id.txt_adult);
            mImageViewMoviePoster=itemView.findViewById(R.id.img_movie_poster);


        }
    }
}
