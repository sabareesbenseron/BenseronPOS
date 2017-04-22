package com.example.saku1.benseronemv.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by saku1 on 4/2/2017.
 */

public class Tag {
    public static void showToast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
