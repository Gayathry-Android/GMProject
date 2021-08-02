package Network;


import Model.ArtistList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.example.artistdata.*;

public interface GetArtistDataService {
    @GET("search")
    Call<ArtistList> getArtistData(@Query("term") String artist_name);
}
