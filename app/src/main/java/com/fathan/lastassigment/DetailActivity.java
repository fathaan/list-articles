package com.fathan.lastassigment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView titleView;
    private TextView descriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Toolbar setup
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Back button action
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Inisialisasi view
        imageView = findViewById(R.id.image);
        titleView = findViewById(R.id.title);
        descriptionView = findViewById(R.id.description);

        // Ambil data dari Intent
        String title = getIntent().getStringExtra("title");
        String overview = getIntent().getStringExtra("overview");
        int imageId = getIntent().getIntExtra("imageId", -1);

        // Set data ke view
        titleView.setText(title);
        descriptionView.setText(overview);
        imageView.setImageResource(imageId);
    }
}
