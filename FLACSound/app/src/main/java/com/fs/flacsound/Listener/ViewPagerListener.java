package com.fs.flacsound.Listener;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;

import java.util.List;

/**
 * Created by KuNn on 2017/5/3.
 */

public class ViewPagerListener implements OnPageChangeListener {

    private List<RadioButton> radios;
    private int _arg2 = 0;
    private int _arg0 = 0;

    public ViewPagerListener(List<RadioButton> radios) {
        this.radios = radios;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        radios.get(position).setChecked(true); //设置对应radiobutton的替换图片
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
