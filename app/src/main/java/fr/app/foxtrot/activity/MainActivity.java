package fr.app.foxtrot.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import fr.app.foxtrot.R;
import fr.app.foxtrot.adapter.ImageSliderAdapter;
import fr.app.foxtrot.adapter.ListGameAdapter;
import fr.app.foxtrot.data.GameData;
import fr.app.foxtrot.model.Game;

public class MainActivity extends AppCompatActivity implements BaseActivity{
    private RecyclerView rvMain;
    private Toolbar toolbar;
    private SliderView sliderView;
    private ArrayList<Game> listGame = new ArrayList<>();
    private ImageSliderAdapter imageSliderAdapter;
    private GameData gameData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        sliderView = findViewById(R.id.iv_slider);
        rvMain = findViewById(R.id.rv_main);
        imageSliderAdapter = new ImageSliderAdapter(this);

        setUpToolbar();
        setUpActivity();
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                Intent moveIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(moveIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setUpActivity(){
        sliderView.setSliderAdapter(imageSliderAdapter);
        rvMain.setHasFixedSize(true);
        gameData = new GameData(this);
        listGame.addAll(gameData.getListGame());
    }

    @Override
    public void setUpToolbar() {
        setSupportActionBar(toolbar);
    }

    private void showRecyclerList() {
        rvMain.setLayoutManager(new GridLayoutManager(this,2));
        //rvMain.setLayoutManager(new LinearLayoutManager(this));
        ListGameAdapter listGameAdapter = new ListGameAdapter(listGame, this);
        rvMain.setAdapter(listGameAdapter);
    }
}
