package com.example.hrd.myapplication.ui.activity.LoginConstrracts;

import com.example.hrd.myapplication.bean.StoreBean;
import com.example.hrd.myapplication.http.Webservice;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginPresenter extends LoginConstracts.LoginPresenter{
    @Override
    public void Login(String url) {
        mModel.Login(url).subscribe(new Observer<Webservice<List<StoreBean>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Webservice<List<StoreBean>> listWebservice) {
                mView.updateData(listWebservice.getMessage());
            }

            @Override
            public void onError(Throwable e) {
                mView.showError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onStart() {

    }
}
