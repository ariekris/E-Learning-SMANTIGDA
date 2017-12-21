package com.v1.e_learningsmantigda.MateriPelajaran;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.v1.e_learningsmantigda.R;


import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Oclemy on 6/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * 1. where WE INFLATE OUR MODEL LAYOUT INTO VIEW ITEM
 * 2. THEN BIND DATA
 */
public class matpel_customadapter extends BaseAdapter {
    Context c;
    ArrayList<matpel_spacecraft> matpelspacecrafts;

    public matpel_customadapter(Context c, ArrayList<matpel_spacecraft> matpelspacecrafts) {
        this.c = c;
        this.matpelspacecrafts = matpelspacecrafts;
    }

    @Override
    public int getCount() {
        return matpelspacecrafts.size();
    }

    @Override
    public Object getItem(int pos) {
        return matpelspacecrafts.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.matpel_model,viewGroup,false);
        }

        TextView judulTxt= convertView.findViewById(R.id.tv_judul);
        TextView kelasTxt= convertView.findViewById(R.id.tv_kelas);
        TextView tahunTxt= convertView.findViewById(R.id.tv_tahun);
        TextView penulisTxt = convertView.findViewById(R.id.tv_penulis);
        TextView coverTxt = convertView.findViewById(R.id.tv_cover);
        TextView pdfTxt = convertView.findViewById(R.id.tv_pdf);

        final matpel_spacecraft s= (matpel_spacecraft) this.getItem(position);

        judulTxt.setText(s.getJudul());
        kelasTxt.setText(s.getKelas());
        tahunTxt.setText(s.getTahun());
        penulisTxt.setText(s.getPenulis());
        coverTxt.setText(s.getCover());
        pdfTxt.setText(s.getPdf());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN DETAIL
                openDetailActivity(s.getJudul(),s.getKelas(),s.getTahun(), s.getPenulis(), s.getCover(), s.getPdf());
            }
        });

        MyHolder holder = new MyHolder(convertView);
        matpel_picassoclient.downloading(c,matpelspacecrafts.get(position).getCover(),holder.img);

        return convertView;
    }
    //OPEN DETAIL ACTIVITY
    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(c,matpel_detailactivity.class);
        i.putExtra("JUDUL_KEY",details[0]);
        i.putExtra("KELALS_KEY",details[1]);
        i.putExtra("TAHUN_KEY",details[2]);
        i.putExtra("PENULIS_KEY", details[3]);
        i.putExtra("COVER_KEY", details[4]);
        i.putExtra("PDF_KEY", details[5]);

        c.startActivity(i);
    }
}














