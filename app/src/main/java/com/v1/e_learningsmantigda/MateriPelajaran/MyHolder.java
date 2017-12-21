package com.v1.e_learningsmantigda.MateriPelajaran;

import android.view.View;
import android.widget.ImageView;

import com.v1.e_learningsmantigda.R;

/**
 * Created by Arie Krisnoanto on 12/21/2017.
 */

public class MyHolder {

    ImageView img;
    public MyHolder(View itemView) {


        img=(ImageView) itemView.findViewById(R.id.iv_coverbuku);


    }
}
