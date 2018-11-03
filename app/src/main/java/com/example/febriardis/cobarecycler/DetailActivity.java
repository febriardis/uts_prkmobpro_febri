package com.example.febriardis.cobarecycler;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView nama_buah_det, harga_det, detail_det;
    ImageView gambar_det;
    String nm_buah, harga_buah, detail_buah, gambar_buah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nama_buah_det = findViewById(R.id.nama_buah_det);
        harga_det = findViewById(R.id.harga_det);
        detail_det = findViewById(R.id.txtdetail);
        gambar_det = findViewById(R.id.gambar_det);

        Intent terima = getIntent();
        //get
        nm_buah = getIntent().getStringExtra("nam");
        harga_buah = getIntent().getStringExtra("hrg");
        detail_buah = getIntent().getStringExtra("det");
        gambar_buah = getIntent().getStringExtra("gam");

        //set
        nama_buah_det.setText(nm_buah);
        harga_det.setText(harga_buah);
        detail_det.setText(detail_buah);
        Picasso.get().load(ApiClient.IMAGE_URL+gambar_buah).
                error(R.mipmap.ic_launcher).into(gambar_det);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings1) {
            Intent intent = new Intent(DetailActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.action_settings2) {
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
