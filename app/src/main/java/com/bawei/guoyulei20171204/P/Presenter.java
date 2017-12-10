package com.bawei.guoyulei20171204.P;

import com.bawei.guoyulei20171204.Bean.Bean;
import com.bawei.guoyulei20171204.M.Mod;
import com.bawei.guoyulei20171204.V.Mvp_V;

/**
 * Created by 猥琐的熊猫 on 2017/12/4.
 */

public class Presenter {
    private Mvp_V mvp_v;
   private Mod mod;
    public Presenter(Mvp_V mvp_v) {
        this.mvp_v = mvp_v;
        this.mod=new Mod();
    }
    public void presen(){
        mod.getData(new Mod.showData() {
            @Override
            public void shuju(Bean bean) {
                mvp_v.getData(bean);
            }
        });
    }
}
