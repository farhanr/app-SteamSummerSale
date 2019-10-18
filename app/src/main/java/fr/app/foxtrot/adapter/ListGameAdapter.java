package fr.app.foxtrot.adapter;

import android.content.Context;
import android.content.Intent;
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
import fr.app.foxtrot.activity.DetailActivity;
import fr.app.foxtrot.model.Game;

public class ListGameAdapter extends RecyclerView.Adapter<ListGameAdapter.ListViewHolder> {
    private ArrayList<Game> listGame;
    private Context context;


    public ListGameAdapter(ArrayList<Game> listGame, Context context) {
        this.listGame = listGame;
        this.context = context;
    }

    private Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_row_game_grid, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        Game game = listGame.get(position);
        Glide.with(
                holder.itemView.getContext()).
                load(game.getPhoto()).
                into(holder.gamePhoto);
        holder.dicountTitle.setText(" -"+game.getDiscount()+"% ");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("GAME", listGame.get(position));
                getContext().startActivity(intent);
            }
        });
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

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            gamePhoto = itemView.findViewById(R.id.img_item_photo);
            dicountTitle= itemView.findViewById(R.id.tv_discount);
        }
    }

}
