package com.fathan.lastassigment;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.fathan.lastassigment.adapters.ArticleAdapter;
import com.fathan.lastassigment.models.Article;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private List<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Ambil data dari strings.xml
        String[] titles = getResources().getStringArray(R.array.article_titles);
        String[] overviews = getResources().getStringArray(R.array.article_overviews);

        // Daftar ID drawable
        int[] imageIds = {
                R.drawable.heri_dahlah,
                R.drawable.rahmadi_angkasa,
                R.drawable.surono_berkibar,
                R.drawable.gatot_brendon,
                R.drawable.jo_heri_rahmawati,
                R.drawable.der_hatta,
                R.drawable.kierno_junior,
                R.drawable.roekimin_radja_unggas,
                R.drawable.putra_handoko
        };

        // Mengisi list article
        articles = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            articles.add(new Article(titles[i], overviews[i], imageIds[i]));
        }

        // Set adapter untuk RecyclerView
        adapter = new ArticleAdapter(articles, this);
        recyclerView.setAdapter(adapter);
    }

    // Menambahkan menu untuk ikon account
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Event untuk menu toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_account) {
            // Navigasi ke halaman About
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
