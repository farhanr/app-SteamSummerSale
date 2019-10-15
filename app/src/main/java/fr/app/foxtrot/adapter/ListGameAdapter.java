package fr.app.foxtrot.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import fr.app.foxtrot.R;
import fr.app.foxtrot.model.Game;

public class ListGameAdapter extends RecyclerView.Adapter<ListGameAdapter.ListViewHolder> {
    private ArrayList<Game> listGame;

    public ListGameAdapter(ArrayList<Game> listGame) {
        this.listGame = listGame;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_row_game_grid, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Game game = listGame.get(position);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.img_header_placeholder_grid)
                .error(R.drawable.img_header_error_grid);
        Glide.with(
                holder.itemView.getContext()).
                //load("https://steamcdn-a.akamaihd.net/steam/apps/389730/header.jpg").
                load(game.getPhoto()).
                //apply(options).
                into(holder.gamePhoto);
        holder.dicountTitle.setText(" -"+game.getDiscount()+"% ");
    }

    @Override
    public int getItemCount() {
        return listGame.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView gamePhoto;
        TextView dicountTitle;
        TextView tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            gamePhoto = itemView.findViewById(R.id.img_item_photo);
            dicountTitle= itemView.findViewById(R.id.tv_discount);
            //tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

}
