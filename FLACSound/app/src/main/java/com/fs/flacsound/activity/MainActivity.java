package com.fs.flacsound.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.fs.flacsound.Listener.ViewPagerListener;
import com.fs.flacsound.R;
import com.fs.flacsound.adapter.PagerAdapters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KuNn on 2016/12/2.
 */

public class MainActivity extends Activity implements View.OnClickListener{

    private Context mContext;
    private ViewPager pager;
    private LinearLayout pager_one,pager_two,pager_three;
    private List<LinearLayout> pagers;
    private RadioButton rdmusic,rdnetmusic,rdgroup;
    private List<RadioButton> radios;
    private View main;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = getLayoutInflater().from(this).inflate(R.layout.activity_main, null);
        main.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);//设置虚拟键隐藏
        main.setOnClickListener(this);
        setContentView(main);
        mContext = this;
        pager= (ViewPager) findViewById(R.id.pager);
        rdmusic = (RadioButton)findViewById(R.id.RBone);
        rdnetmusic = (RadioButton) findViewById(R.id.RBtwo);
        rdgroup = (RadioButton) findViewById(R.id.RBthree);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        initPager();
        setPagerCurrentItem();
    }

    private void initPager(){
        LayoutInflater inflater =getLayoutInflater();
        pager_one = (LinearLayout) inflater.inflate(R.layout.pager_one,null);
        pager_two = (LinearLayout) inflater.inflate(R.layout.pager_two,null);
        pager_three = (LinearLayout) inflater.inflate(R.layout.pager_three,null);
        pagers = new ArrayList<LinearLayout>();
        radios = new ArrayList<RadioButton>();
        pagers.add(pager_one);
        pagers.add(pager_two);
        pagers.add(pager_three);
        radios.add(rdmusic);
        radios.add(rdnetmusic);
        radios.add(rdgroup);
        pager.setCurrentItem(0);
        pager.setOnPageChangeListener(new ViewPagerListener(radios));
        PagerAdapters adapters = new PagerAdapters(pagers);
        pager.setAdapter(adapters);

    }

    private void setPagerCurrentItem(){
        rdmusic.setOnClickListener(new radiosOnClick(0));
        rdnetmusic.setOnClickListener(new radiosOnClick(1));
        rdgroup.setOnClickListener(new radiosOnClick(2));
    }

    private class radiosOnClick implements View.OnClickListener{

        private int position;
        public radiosOnClick(int position) {
            this.position=position;
        }

        @Override
        public void onClick(View v) {
            pager.setCurrentItem(position);
        }
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){


        }

    }

}
