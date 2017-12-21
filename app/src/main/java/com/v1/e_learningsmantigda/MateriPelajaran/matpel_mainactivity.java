package com.v1.e_learningsmantigda.MateriPelajaran;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.v1.e_learningsmantigda.R;

/*
1.INITIALIZE FIREBASE DB
2.INITIALIZE UI
3.DATA INPUT
 */
public class matpel_mainactivity extends AppCompatActivity {

    DatabaseReference db;
    matpel_firebasehelper helper;
    matpel_customadapter adapter;
    ListView lv;
    EditText etJudul, etKelas, etTahun, etPenulis, etCover, etPdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matpel_activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = findViewById(R.id.lv);

        //INITIALIZE FIREBASE DB
        db = FirebaseDatabase.getInstance().getReference();
        helper = new matpel_firebasehelper(db);

        //ADAPTER
        adapter = new matpel_customadapter(this, helper.retrieve());
        lv.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
            }
        });
    }

    //DISPLAY INPUT DIALOG
    private void displayInputDialog() {
        Dialog d = new Dialog(this);
        d.setTitle("Save To Firebase");
        d.setContentView(R.layout.matpel_input_dialog);

        etJudul = d.findViewById(R.id.et_judul);
        etKelas = d.findViewById(R.id.et_kelas);
        etTahun = d.findViewById(R.id.et_tahun);
        etPenulis = d.findViewById(R.id.et_penulis);
        etCover = d.findViewById(R.id.et_urlcover);
        etPdf = d.findViewById(R.id.et_urlpdf);

        Button saveBtn = d.findViewById(R.id.saveBtn);

        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GET DATA
                String judul = etJudul.getText().toString();
                String kelas = etKelas.getText().toString();
                String tahun = etTahun.getText().toString();
                String penulis = etPenulis.getText().toString();
                String cover = etCover.getText().toString();
                String pdf = etPdf.getText().toString();

                //SET DATA
                matpel_spacecraft s = new matpel_spacecraft();
                s.setJudul(judul);
                s.setKelas(kelas);
                s.setTahun(tahun);
                s.setPenulis(penulis);
                s.setCover(cover);
                s.setPdf(pdf);


                //SIMPLE VALIDATION
                if (judul != null && judul.length() > 0) {
                    //THEN SAVE
                    if (helper.save(s)) {
                        //IF SAVED CLEAR EDITXT
                        etJudul.setText("");
                        etKelas.setText("");
                        etTahun.setText("");
                        etPenulis.setText("");
                        etCover.setText("");
                        etPdf.setText("");

                        adapter = new matpel_customadapter(matpel_mainactivity.this, helper.retrieve());
                        lv.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(matpel_mainactivity.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        d.show();
    }
}


