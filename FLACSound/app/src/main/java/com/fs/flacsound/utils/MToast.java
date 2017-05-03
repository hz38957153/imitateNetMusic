package com.fs.flacsound.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by KuNn on 2017/1/11.
 */

public class MToast {
    private static Toast mToast;

    public static void showLong(Context mContext,String str){
        if(mToast!=null){
            mToast.cancel();
        }
        mToast = Toast.makeText(mContext,str,Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void showShort(Context mContext,String str){
        if(mToast!=null){
            mToast.cancel();
        }
        mToast = Toast.makeText(mContext,str,Toast.LENGTH_SHORT);
        mToast.show();
    }
}
