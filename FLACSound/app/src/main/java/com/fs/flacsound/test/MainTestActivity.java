package com.fs.flacsound.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.fs.flacsound.R;
import com.fs.flacsound.adapter.ApaterTest;

/**
 * Created by KuNn on 2016/12/23.
 */

public class MainTestActivity extends Activity {
    private Context mContext;
    private String TAG="MainTestActivity";
    private RecyclerView rv;
    private ApaterTest mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;




    }
}
