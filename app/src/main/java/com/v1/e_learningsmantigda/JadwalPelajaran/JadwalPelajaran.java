package com.v1.e_learningsmantigda.JadwalPelajaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.barteksc.pdfviewer.PDFView;
import com.v1.e_learningsmantigda.R;

public class JadwalPelajaran extends AppCompatActivity {

    Toolbar myToolbar;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwalpelajaran);

        myToolbar = findViewById(R.id.toolbarJadwal);
        mySpinner = findViewById(R.id.pilihankelas);

        myToolbar.setTitle(getResources().getString(R.string.judulmenujadwal));

        final PDFView pdfview;

        final Spinner spin = findViewById(R.id.pilihankelas);
        pdfview = findViewById(R.id.pdfview);

        Spinner dropdown = findViewById(R.id.pilihankelas);
        String[] items = new String[]{
                "X1", "X2",
                "XI IPA", "XI IPS", "XI Bahasa",
                "XII IPA", "XII IPS", "XII Bahasa",
                "XII IPA", "XII IPS", "XIII Bahasa",};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (spin.getSelectedItem().equals("X1")) {
                    pdfview.fromAsset("KHS7.pdf").load();
                } else if (spin.getSelectedItem().equals("X2")) {
                    pdfview.fromAsset("KHS7.pdf").load();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}