package com.v1.e_learningsmantigda.MateriPelajaran;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.v1.e_learningsmantigda.R;

/**
 * Created by Arie Krisnoanto on 12/21/2017.
 */

public class eBookViewer extends AppCompatActivity{

    PDFView pdfView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matpel_ebookviewer);

/*        Intent i = this.getIntent();
        String pdf = i.getExtras().getString("PDF_KEY");

        if (pdf.equals("X1")) {
            pdfView.fromAsset("KHS7.pdf").load();
        } else if (pdf.equals("X2")) {
            pdfView.fromAsset("KHS7.pdf").load();
        }*/
    }
}
