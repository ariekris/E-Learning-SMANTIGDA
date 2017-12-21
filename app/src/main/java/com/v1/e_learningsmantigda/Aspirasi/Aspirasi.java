package com.v1.e_learningsmantigda.Aspirasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.v1.e_learningsmantigda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arie Krisnoanto on 11/16/2017.
 */

public class Aspirasi extends AppCompatActivity {
    //we will use these constants later to pass the artist name and id to another activity
    public static final String Aspirasi_Siswa = "com.v1.e_learningsmantigda.Aspirasi.ModelAspirasi";

    //view objects
    EditText txtAspirasi;
    Spinner spinSasaranAspirasi;
    Button tombolAspirasi;
    ListView daftarViewAspirasi;

    //a list to store all the artist from firebase database
    List<ModelAspirasi> aspirasiList;

    //our database reference object
    DatabaseReference databaseAspirasi;

    ListView listViewAspirasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aspirasi);

        //getting the reference of artists node
        databaseAspirasi = FirebaseDatabase.getInstance().getReference("Aspirasi Siswa");

        //getting views
        txtAspirasi = findViewById(R.id.txtAspirasi);
        spinSasaranAspirasi = findViewById(R.id.spinSasaranAspirasi);
        daftarViewAspirasi = findViewById(R.id.listViewAspirasi);

        tombolAspirasi = findViewById(R.id.btnAspirasi);

        listViewAspirasi = findViewById(R.id.listViewAspirasi);

        //list to store aspirasi
        aspirasiList = new ArrayList<>();

        //adding an onclicklistener to button
        tombolAspirasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAspirasi();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseAspirasi.addValueEventListener(new ValueEventListener() {
            @Override
            //dieksekusi tiap kali ada perubahan data pada database
            public void onDataChange(DataSnapshot dataSnapshot) {

                aspirasiList.clear();
                for(DataSnapshot aspirasiSnapshot: dataSnapshot.getChildren()){
                    ModelAspirasi aspirasi = aspirasiSnapshot.getValue(ModelAspirasi.class);

                    aspirasiList.add(aspirasi);
                }

                AspirasiList adapter = new AspirasiList(Aspirasi.this, aspirasiList);
                listViewAspirasi.setAdapter(adapter);

            }

            @Override
            //dieksekusi kalo ada error
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addAspirasi() {
        //getting the values to save
        String isiAspirasi = txtAspirasi.getText().toString().trim();
        String sasaran = spinSasaranAspirasi.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(isiAspirasi)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseAspirasi.push().getKey();

            //creating an Aspirasi Object
            ModelAspirasi aspirasi = new ModelAspirasi(id, isiAspirasi, sasaran);

            //Saving the Artist
            databaseAspirasi.child(id).setValue(aspirasi);

            //setting edittext to blank again
            txtAspirasi.setText("");

            //displaying a success toast
            Toast.makeText(this, "Aspirasi telah ditambahkan", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Masukkan aspirasi terlebih dahulu", Toast.LENGTH_LONG).show();
        }
    }
}