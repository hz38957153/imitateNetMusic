package com.fs.flacsound.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.fs.flacsound.R;

/**
 * Created by KuNn on 2017/5/3.
 */

public class SearchActivity extends Activity {

    private Context mContext;
    private View main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = getLayoutInflater().from(this).inflate(R.layout.activity_search,null);
        setContentView(main);
        mContext = this;

    }
}
