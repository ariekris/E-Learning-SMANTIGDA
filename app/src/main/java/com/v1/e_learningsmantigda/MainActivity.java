package com.v1.e_learningsmantigda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.v1.e_learningsmantigda.Aspirasi.Aspirasi;
import com.v1.e_learningsmantigda.JadwalPelajaran.JadwalPelajaran;
import com.v1.e_learningsmantigda.KalenderAkademik.KalenderAkademik;
import com.v1.e_learningsmantigda.MateriPelajaran.matpel_mainactivity;
import com.v1.e_learningsmantigda.UserAuth.Login;


public class MainActivity extends AppCompatActivity {


    GridView androidGridView;

    String[] gridViewString = {
            "Jadwal Pelajaran",
            "Materi Pelajaran",
            "Tugas",
            "Kalender Akademik",
            "Aspirasi Siswa",
            "Keluar"};

    int[] gridViewImageId = {
            R.drawable.ic_jadwalpelajaran,
            R.drawable.ic_materipelajaran,
            R.drawable.ic_tugas,
            R.drawable.ic_kalenderakademik,
            R.drawable.ic_kritiksaran,
            R.drawable.ic_logout};

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(MainActivity.this, gridViewString, gridViewImageId);
        androidGridView = (GridView) findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);


        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                switch (i) {
                    case 0:
                        Intent a = new Intent(view.getContext(), JadwalPelajaran.class);
                        view.getContext().startActivity(a);
                        break;
                    case 1:
                        Intent b = new Intent(view.getContext(), matpel_mainactivity.class);
                        view.getContext().startActivity(b);
                        break;
                    case 2:
                        Intent c = new Intent(view.getContext(), JadwalPelajaran.class);
                        view.getContext().startActivity(c);
                        break;
                    case 3:
                        Intent d = new Intent(view.getContext(), KalenderAkademik.class);
                        view.getContext().startActivity(d);
                        break;
                    case 4:
                        Intent e = new Intent(view.getContext(), Aspirasi.class);
                        view.getContext().startActivity(e);
                        break;
                    case 5:
                        signOut();
                        Intent f = new Intent(view.getContext(), Login.class);
                        view.getContext().startActivity(f);
                        break;
                }

                Toast.makeText(MainActivity.this, "  " + gridViewString[+i], Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void signOut() {
        auth.signOut();
    }
}


