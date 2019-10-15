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

public class GridListGameAdapter extends RecyclerView.Adapter<GridListGameAdapter.GridViewHolder> {
    private ArrayList<Game> listGame;

    public GridListGameAdapter(ArrayList<Game> listGame) {
        this.listGame = listGame;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_row_game, parent, false);
        return new GridListGameAdapter.GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Game game = listGame.get(position);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.img_header_placeholder)
                .error(R.drawable.img_header_error);
        Glide.with(
                holder.itemView.getContext()).
                //load("https://steamcdn-a.akamaihd.net/steam/apps/389730/header.jpg").
                        load(game.getPhoto()).
                apply(options).
                into(holder.gamePhoto);
        holder.tvTitle.setText(game.getName());
        //holder.tvDetail.setText(game.getDetail());
    }

    @Override
    public int getItemCount() {
        return listGame.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView gamePhoto;
        TextView tvTitle;
        TextView tvDetail;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            gamePhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_name);
            //tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}
