package com.bawei.guoyulei20171204.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.guoyulei20171204.Bean.Bean;
import com.bawei.guoyulei20171204.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/12/4.
 */

public class Vpadapter extends PagerAdapter {
    private Context context;
    private List<Bean.DataBean.Ad1Bean>list;

    public Vpadapter(Context context, List<Bean.DataBean.Ad1Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.vpitem, null);
        SimpleDraweeView sdv= (SimpleDraweeView) view.findViewById(R.id.sdv);
        sdv.setImageURI(list.get(position%list.size()).getImage());
        sdv. setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }
}
