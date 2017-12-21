package com.v1.e_learningsmantigda.MateriPelajaran;

/**
 * Created by Arie Krisnoanto on 12/21/2017.
 */

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.v1.e_learningsmantigda.R;

public class matpel_picassoclient {

    public  static  void downloading(Context c, String url, ImageView img)
    {
        if (url!=null && url.length()>0)
        {
            Picasso.with(c).load(url).placeholder(R.drawable.placeholder).into(img);

        }else
        {
            Picasso.with(c).load(R.drawable.placeholder).into(img);
        }
    }
}
