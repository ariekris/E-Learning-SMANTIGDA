package com.v1.e_learningsmantigda.MateriPelajaran;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.squareup.picasso.Picasso;
import com.v1.e_learningsmantigda.R;

public class matpel_detailactivity extends AppCompatActivity implements View.OnClickListener {

    TextView judulTxt, penulisTxt, tahunTxt;
    ImageView coverImg;
    Button btnBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matpel_activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        judulTxt = findViewById(R.id.tv_detailJudul);
        penulisTxt = findViewById(R.id.tv_detailPenulis);
        tahunTxt = findViewById(R.id.tv_detailTahun);
        coverImg = findViewById(R.id.iv_coverbuku);
        btnBaca = findViewById(R.id.btnBaca);

        //GET INTENT
        Intent i = this.getIntent();

        //RECEIVE DATA
        String judul = i.getExtras().getString("JUDUL_KEY");
        String penulis = i.getExtras().getString("PENULIS_KEY");
        String tahun = i.getExtras().getString("TAHUN_KEY");
        String cover = i.getExtras().getString("COVER_KEY");

        //BIND DATA
        judulTxt.setText(judul);
        penulisTxt.setText(penulis);
        tahunTxt.setText(tahun);
        Picasso.with(getApplicationContext()).load(cover).into(coverImg);

        btnBaca.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(matpel_detailactivity.this, eBookViewer.class);
        startActivity(intent);
    }
}
