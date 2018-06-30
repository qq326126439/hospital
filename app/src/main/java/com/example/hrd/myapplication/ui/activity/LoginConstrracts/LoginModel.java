package com.example.hrd.myapplication.ui.activity.LoginConstrracts;
import com.example.hrd.myapplication.Constracts.NetworkConstracts;
import com.example.hrd.myapplication.Util.TUtil;
import com.example.hrd.myapplication.WebService.WebServiceUtil;
import com.example.hrd.myapplication.WebService.XWebService;
import com.example.hrd.myapplication.bean.StoreBean;
import com.example.hrd.myapplication.http.RxSchedulers;
import com.example.hrd.myapplication.http.Webservice;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import ikidou.reflect.TypeBuilder;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class LoginModel implements LoginConstracts.LoginModel{

    @Override
    public Observable<Webservice<List<StoreBean>>> Login(String url) {
        return WebServiceUtil
                .post()
                .methodName("getStorageRoomList")
                .namespace(NetworkConstracts.WebServiceNameSpace)
                .build()
                .execute().map(new Function<String, Webservice<List<StoreBean>>>() {
                    @Override
                    public Webservice<List<StoreBean>> apply(String s) throws Exception {
                        Webservice o=new Gson().fromJson(s,new TypeToken<Webservice>(){}.getType());
                        List<StoreBean> mlist=new Gson().fromJson(o.getData().toString(),new TypeToken<List<StoreBean>>(){}.getType());
                        o.setData(mlist);
// o.setData((List<StoreBean>) new Gson().fromJson(o.getData().toString(), TypeBuilder.newInstance(List.class).addTypeParam(StoreBean.class).build()));
                        return o;
//                        return null;
                    }
                })
                .compose(RxSchedulers.<Webservice<List<StoreBean>>>applySchedulers());
    }
}
