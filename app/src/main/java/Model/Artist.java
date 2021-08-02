package Model;
import com.google.gson.annotations.SerializedName;

public class Artist {
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("trackName")
    private String trackName;
    @SerializedName("trackPrice")
    private String trackPrice;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("primaryGenreName")
    private String primaryGenreName;

    public Artist(String artistName, String trackName, String trackPrice,String releaseDate,String primaryGenreName) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.trackPrice = trackPrice;
        this.releaseDate = releaseDate;
        this.primaryGenreName =primaryGenreName;
    }

    public String getName() {
        return artistName;
    }

    public void setName(String name) {
        this.artistName = name;
    }

    public String getTrackname() {
        return trackName;
    }

    public void setTrackname(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }
}