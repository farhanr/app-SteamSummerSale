package fr.app.foxtrot.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import fr.app.foxtrot.R;
import fr.app.foxtrot.model.Game;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity implements BaseActivity {
    private Toolbar toolbar;
    private ImageView ivGameDetail;
    private TextView tvDescription;
    private TextView tvRelease;
    private TextView tvGenre;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.tb_detail);
        ivGameDetail = findViewById(R.id.iv_detail_head);
        tvDescription = findViewById(R.id.tv_detail_description);
        tvRelease = findViewById(R.id.tv_detail_release);
        tvGenre = findViewById(R.id.tv_detail_genre);

        setUpToolbar();
        setUpActivity();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setUpActivity() {
        game = getIntent().getParcelableExtra("GAME");
        getSupportActionBar().setTitle(game.getName());

        Glide.with(this).
                load(game.getPhoto()).
                centerCrop().
                into(ivGameDetail);

        tvDescription.setText(game.getDescription());
        tvRelease.setText("RELEASE: " + game.getRelease());
        tvGenre.setText(game.getDetail());

    }

    @Override
    public void setUpToolbar() {
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
