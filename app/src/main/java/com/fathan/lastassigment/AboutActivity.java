package com.fathan.lastassigment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;

import com.fathan.lastassigment.adapters.AboutDetailAdapter;
import com.fathan.lastassigment.models.AboutDetail;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView nameText, emailText;
    private RecyclerView detailRecyclerView;
    private AboutDetailAdapter adapter;
    private List<AboutDetail> aboutDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Menangani komponen UI
        profileImage = findViewById(R.id.profileImage);
        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        detailRecyclerView = findViewById(R.id.detailTable);

        // Toolbar setup
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Back button action
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Mengatur teks jika diperlukan
        nameText.setText("Muhammad Al Fathan");
        emailText.setText("fathangapapa@gmail.com");

        // Menyiapkan data detail
        aboutDetails = new ArrayList<>();
        aboutDetails.add(new AboutDetail("Full Name", "Muhammad Al Fathan"));
        aboutDetails.add(new AboutDetail("Date of Birth", "04 March 2003"));
        aboutDetails.add(new AboutDetail("Campus Name", "Politeknik Negeri Lampung"));
        aboutDetails.add(new AboutDetail("Study Program", "Informatics Management"));
        aboutDetails.add(new AboutDetail("Hobbies", "Bukain Laptop"));
        aboutDetails.add(new AboutDetail("Programming Skills", "Java, JavaScript, PHP, HTML, CSS"));
        aboutDetails.add(new AboutDetail("Preferred Job Role", "Fullstack Development"));


        // Mengatur RecyclerView
        adapter = new AboutDetailAdapter(aboutDetails);
        detailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailRecyclerView.setAdapter(adapter);
    }
}
