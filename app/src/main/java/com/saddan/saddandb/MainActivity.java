package com.saddan.saddandb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private  String TAG =getClass().getSimpleName() ;
    private SaddanDB saddanDB;
    List<Movie> movieList=new ArrayList<>();
    List<Movie> list_SaddanDB=new ArrayList<>();

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saddanDB=new SaddanDB(this);

        movieList.add(new Movie("hulk","1995"));
        movieList.add(new Movie("Spider women","1995"));

        saddanDB.setList("movie",movieList);






        list_SaddanDB= (List<Movie>) saddanDB.getList("movie",Movie.class);

        for(Movie movie:list_SaddanDB)
        {
            Log.d(TAG, "onCreate: "+movie.getName());
        }

    }
}
