package com.example.artistdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import  com.example.artistdata.*;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.ArtistAdapter;
import Model.Artist;
import Model.ArtistList;
import Network.GetArtistDataService;
import Network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DisplayArtist extends AppCompatActivity {

    private ArtistAdapter adapter;
    private RecyclerView recyclerView;
    String artist_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_artist);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            artist_name = extras.getString("artist_name");
            //The key argument here must match that used in the other activity
        }

        /*Create handle for the RetrofitInstance interface*/
        GetArtistDataService service = RetrofitInstance.getRetrofitInstance().create(GetArtistDataService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<ArtistList> call = service.getArtistData(artist_name);

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ArtistList>() {
            @Override
            public void onResponse(Call<ArtistList> call, Response<ArtistList> response) {
                if (response.isSuccessful()) {
                    generateArtistList(response.body().getArtistArrayList());
                }
            }

            @Override
            public void onFailure(Call<ArtistList> call, Throwable t) {
                Toast.makeText(DisplayArtist.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }


    /*Method to generate List of Artist using RecyclerView with custom adapter*/
    private void generateArtistList(ArrayList<Artist> artistDataList) {
        try {
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view_Artist_list);
            adapter = new ArtistAdapter(artistDataList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DisplayArtist.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        } catch (Exception ex) {
            Log.e("EEXCCEption", "ex.localizedMessage.toString()");
        }
    }


}




