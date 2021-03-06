package com.example.hrd.myapplication.ui.fragment.StoreConstracts;


import android.support.v4.util.SimpleArrayMap;

import com.example.hrd.myapplication.WebService.XWebService;
import com.example.hrd.myapplication.bean.StoreBean;
import com.example.hrd.myapplication.bean.StoreListBean;
import com.example.hrd.myapplication.http.RxSchedulers;
import com.example.hrd.myapplication.http.Webservice;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;

public class StoreModel implements StoreConstracts.StoreModel{
    @Override
    public Observable<Webservice<String>> getList() {
        return Observable.create(new ObservableOnSubscribe<Webservice<String>>() {
            @Override
            public void subscribe(final ObservableEmitter<Webservice<String>> e) throws Exception {
                XWebService.getIntentData(Webservice.class, "getStorageRoomList", null, new XWebService.OnResultListener<Webservice>() {
                    @Override
                    public void onSuccess(Webservice bean) {
                        e.onNext(bean);
                        e.onComplete();
                    }

                    @Override
                    public void onError(Exception exception) {
                        e.onError(exception);
                    }
                });

            }
        });
    }
}
