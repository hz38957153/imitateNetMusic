package com.fs.flacsound.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.fs.flacsound.Listener.ViewPagerListener;
import com.fs.flacsound.R;
import com.fs.flacsound.adapter.PagerAdapters;
import com.fs.flacsound.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KuNn on 2016/12/2.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    private Context mContext;
    private View main;
    private Intent mIntent;
    private RelativeLayout leftMenu;
    private ViewPager pager;
    private LinearLayout pager_music, pager_netmusic, pager_group;
    private List<LinearLayout> pagers;
    private RadioButton rdmusic, rdnetmusic, rdgroup;
    private ImageView menu, search;
    private List<RadioButton> radios;

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = getLayoutInflater().from(this).inflate(R.layout.activity_main, null);
        main.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);//设置虚拟键隐藏
        main.setOnClickListener(this);
        setContentView(main);
        mContext = this;
        pager = (ViewPager) findViewById(R.id.pager);
        rdmusic = (RadioButton) findViewById(R.id.RBone);
        rdnetmusic = (RadioButton) findViewById(R.id.RBtwo);
        rdgroup = (RadioButton) findViewById(R.id.RBthree);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        menu = (ImageView) findViewById(R.id.Btnleft);
        leftMenu = (RelativeLayout) findViewById(R.id.leftMenu);
        search = (ImageView) findViewById(R.id.Btnrigth);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(mContext, SearchActivity.class);
                startActivity(mIntent);
            }
        });
        initDrawerLayout();
        initPager();
        setPagerCurrentItem();
    }

    private void initDrawerLayout() {
        setLeftMatrix();
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void initPager() {
        LayoutInflater inflater = getLayoutInflater();
        pager_music = (LinearLayout) inflater.inflate(R.layout.pager_music, null);
        pager_netmusic = (LinearLayout) inflater.inflate(R.layout.pager_netmusic, null);
        pager_group = (LinearLayout) inflater.inflate(R.layout.pager_group, null);
        pagers = new ArrayList<LinearLayout>();
        radios = new ArrayList<RadioButton>();
        pagers.add(pager_music);
        pagers.add(pager_netmusic);
        pagers.add(pager_group);
        radios.add(rdmusic);
        radios.add(rdnetmusic);
        radios.add(rdgroup);
        pager.setCurrentItem(0);
        pager.setOnPageChangeListener(new ViewPagerListener(radios));
        PagerAdapters adapters = new PagerAdapters(pagers);
        pager.setAdapter(adapters);
    }

    private void setPagerCurrentItem() {
        rdmusic.setOnClickListener(new radiosOnClick(0));
        rdnetmusic.setOnClickListener(new radiosOnClick(1));
        rdgroup.setOnClickListener(new radiosOnClick(2));
    }

    /**
     *
     */
    private class radiosOnClick implements View.OnClickListener {
        private int position;

        public radiosOnClick(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            pager.setCurrentItem(position);
        }
    }

    /**
     * drawerLayout宽度控制
     */
    private void setLeftMatrix() {
        DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) leftMenu.getLayoutParams();
        params.width = ScreenUtils.getScreenWidth(mContext) / 4 * 3;
        params.height = ScreenUtils.getScreenHeight(mContext);
        leftMenu.setLayoutParams(params);
        drawerLayout.setTag("false");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Btnrigth:
                mIntent = new Intent(mContext, SearchActivity.class);
                startActivity(mIntent);
                break;
            default:
                break;

        }

    }

}
