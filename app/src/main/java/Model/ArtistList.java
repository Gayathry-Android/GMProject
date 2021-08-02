package Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class ArtistList {
    @SerializedName("results")
    private ArrayList<Artist> results;

    public ArrayList<Artist> getArtistArrayList() {
        return results;
    }

    /*
    public void setArtistList(ArrayList<Artist> artistArrayList) {
        this.results = artistArrayList;
    } */
}
