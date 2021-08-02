package Adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import com.example.artistdata.*;

import Model.Artist;






public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {

    private ArrayList<Artist> dataList;

    public ArtistAdapter(ArrayList<Artist> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_artist, parent, false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArtistViewHolder holder, int position) {
        holder.txtArtistName.setText(dataList.get(position).getName());
        holder.txtTrackName.setText(dataList.get(position).getTrackname());
        holder.txtTrackPrice.setText(dataList.get(position).getTrackPrice());
        holder.txtReleaseDate.setText(dataList.get(position).getReleaseDate());
        holder.txtPrGenName.setText(dataList.get(position).getPrimaryGenreName());
    }

    @Override
    public int getItemCount() {
        return (dataList == null) ? 0 : dataList.size();
    }

    class ArtistViewHolder extends RecyclerView.ViewHolder {

        TextView txtArtistName, txtTrackName, txtTrackPrice,txtReleaseDate,txtPrGenName;

        ArtistViewHolder(View itemView) {
            super(itemView);
            txtArtistName = (TextView) itemView.findViewById(R.id.txt_Artist_name);
            txtTrackName = (TextView) itemView.findViewById(R.id.txt_trackname_name);
            txtTrackPrice = (TextView) itemView.findViewById(R.id.txt_track_price);

            txtReleaseDate = (TextView) itemView.findViewById(R.id.txt_Release_Date);
            txtPrGenName = (TextView) itemView.findViewById(R.id.txt_Primary_GenName);
        }
    }
}