package com.bawei.guoyulei20171204.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.guoyulei20171204.Bean.Bean;
import com.bawei.guoyulei20171204.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 猥琐的熊猫 on 2017/12/4.
 */

public class Rlvadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private Bean bean;

    public Rlvadapter(Context context, Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    public static final int TYPE_PULL_IMAGE = 0;
    public static final int TYPE_RIGHT_IMAGE = 1;
    private static final int TYPE=2;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if (viewType==TYPE_PULL_IMAGE ){
           return new VHitem(LayoutInflater.from(context).inflate(R.layout.item1vp,parent,false));
       }else if (viewType== TYPE_RIGHT_IMAGE){
           return new VHitem(LayoutInflater.from(context).inflate(R.layout.item2,parent,false));
       }else{
           return new Vhitem3(LayoutInflater.from(context).inflate(R.layout.item3,parent,false));
       }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
     if (position==0){
         ((VHitem) holder).viewPager.setAdapter(new Vpadapter(context,bean.getData().getAd1()));
     }else if (position==1){

     }else{
         Vhitem3 vhitem3= (Vhitem3) holder;
         vhitem3.sdv.setImageURI(bean.getData().getDefaultGoodsList().get(position-2).getGoods_img());
     }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE_PULL_IMAGE;
        }else if (position==1){
            return TYPE_RIGHT_IMAGE;
        }else {
            return TYPE;
        }

    }

    @Override
    public int getItemCount() {
        return bean.getData().getDefaultGoodsList().size()+2;
    }

    class VHitem extends RecyclerView.ViewHolder{
        ViewPager viewPager;
        public VHitem(View itemView) {
            super(itemView);
            viewPager= (ViewPager) itemView.findViewById(R.id.vp);
        }
    }
    class VHitem2 extends RecyclerView.ViewHolder{
        TextView textView;
        public VHitem2(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.text);
        }
    }
    class Vhitem3 extends RecyclerView.ViewHolder{
        SimpleDraweeView sdv;
        public Vhitem3(View itemView) {
            super(itemView);
            sdv= (SimpleDraweeView) itemView.findViewById(R.id.sdv3);
        }
    }
}
