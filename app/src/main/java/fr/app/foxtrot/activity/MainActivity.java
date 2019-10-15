package fr.app.foxtrot.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.card.MaterialCardView;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

import fr.app.foxtrot.R;
import fr.app.foxtrot.adapter.ImageSliderAdapter;
import fr.app.foxtrot.adapter.ListGameAdapter;
import fr.app.foxtrot.data.GameData;
import fr.app.foxtrot.model.Game;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMain;
    private Toolbar toolbar;
    private ImageView ivHeader;
    private SliderView sliderView;
//    private MaterialCardView cardView;
    private ArrayList<Game> listGame = new ArrayList<>();
    private Log log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        ivHeader = findViewById(R.id.iv_head);
//        Glide.with(this).
//                load("https://boygeniusreport.files.wordpress.com/2018/06/screen-shot-2018-06-21-at-2-40-48-pm.png").
//                apply(new RequestOptions()
//                        .placeholder(R.drawable.img_header_placeholder)
//                        .error(R.drawable.img_header_error)).
//                into(ivHeader);

        sliderView = findViewById(R.id.iv_slider);
        ImageSliderAdapter imageSliderAdapter = new ImageSliderAdapter(this);
        sliderView.setSliderAdapter(imageSliderAdapter);

        rvMain = findViewById(R.id.rv_main);
        rvMain.setHasFixedSize(true);

        GameData gameData = new GameData(this);
        listGame.addAll(gameData.getListGame());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvMain.setLayoutManager(new GridLayoutManager(this,2));
        //rvMain.setLayoutManager(new LinearLayoutManager(this));
        ListGameAdapter listGameAdapter = new ListGameAdapter(listGame);
        rvMain.setAdapter(listGameAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selection){
        switch (selection){
            case R.id.action_cardview:
                break;
            case R.id.action_about:
                break;
        }
    }
}
