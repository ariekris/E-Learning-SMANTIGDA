package com.v1.e_learningsmantigda.Aspirasi;

import android.app.Activity;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.v1.e_learningsmantigda.R;

import java.util.List;

/**
 * Created by Arie Krisnoanto on 12/17/2017.
 */

public class AspirasiList extends ArrayAdapter<ModelAspirasi> {

    private Activity context;
    private List<ModelAspirasi> daftarAspirasi;

    public AspirasiList(Activity context, List<ModelAspirasi> daftarAspirasi){
        super(context, R.layout.list_asprasi, daftarAspirasi);
        this.context = context;
        this.daftarAspirasi = daftarAspirasi;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_asprasi, null, true);

        TextView textViewAspirasi = listViewItem.findViewById(R.id.textViewAspirasi);
        TextView textViewSasaran = listViewItem.findViewById(R.id.textViewSasaran);

        ModelAspirasi aspirasi = daftarAspirasi.get(position);

        textViewAspirasi.setText(aspirasi.getAspirasi());
        textViewSasaran.setText(aspirasi.getSasaranAspirasi());

        return listViewItem;
    }
}
