package com.fs.flacsound.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by KuNn on 2017/5/3.
 */

public class PagerAdapters extends PagerAdapter {


    private List<LinearLayout> pagers;

    public PagerAdapters(List<LinearLayout> pagers) {
        this.pagers = pagers;
    }

    @Override
    public int getCount() {
        return pagers.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(pagers.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(pagers.get(position));
        return pagers.get(position);
    }

}
