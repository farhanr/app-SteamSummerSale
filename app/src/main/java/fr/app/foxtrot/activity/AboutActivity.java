package fr.app.foxtrot.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import de.hdodenhof.circleimageview.CircleImageView;
import fr.app.foxtrot.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AboutActivity extends AppCompatActivity implements BaseActivity{

    private Toolbar toolbar;
    private CircleImageView ivCircleProfile;
    private TextView tvProfile, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        toolbar = findViewById(R.id.tb_about);
        tvProfile = findViewById(R.id.tv_profile);
        tvEmail= findViewById(R.id.tv_email);
        ivCircleProfile = findViewById(R.id.iv_profile);

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
    public void setUpActivity(){
        Glide.with(this).
                load(R.drawable.fr).
                into(ivCircleProfile);

        tvProfile.setText("Farhan Ramdhani");
        tvEmail.setText("fr150899@gmail.com\n\nComputer Science\nHasanuddin University");
    }

    @Override
    public void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
