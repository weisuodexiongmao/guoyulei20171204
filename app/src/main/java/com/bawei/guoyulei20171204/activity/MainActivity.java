package com.bawei.guoyulei20171204.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.guoyulei20171204.Bean.Bean;
import com.bawei.guoyulei20171204.P.Presenter;
import com.bawei.guoyulei20171204.R;
import com.bawei.guoyulei20171204.V.Mvp_V;
import com.bawei.guoyulei20171204.adapter.Rlvadapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Mvp_V{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.Rlv);
        Presenter presenter=new Presenter(this);
        presenter.presen();
    }

    @Override
    public void getData(Bean bean) {

        List<Bean.DataBean.DefaultGoodsListBean> defaultGoodsList = bean.getData().getDefaultGoodsList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Rlvadapter(this,bean));
    }
}
