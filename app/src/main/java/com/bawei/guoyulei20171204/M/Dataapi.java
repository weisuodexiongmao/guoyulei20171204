package com.bawei.guoyulei20171204.M;

import com.bawei.guoyulei20171204.Bean.Bean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 猥琐的熊猫 on 2017/12/4.
 */

public interface Dataapi {
  //http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<Bean> Data();
}
