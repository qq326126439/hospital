package com.example.hrd.myapplication.ui.activity.LoginConstrracts;

import com.example.hrd.myapplication.bean.StoreBean;
import com.example.hrd.myapplication.http.Webservice;
import com.example.hrd.myapplication.mvp.BaseModel;
import com.example.hrd.myapplication.mvp.BasePresenter;
import com.example.hrd.myapplication.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface LoginConstracts {
    public abstract class LoginPresenter extends BasePresenter<LoginModel,LoginMview>{
        public abstract void Login(String url);
    }

     interface LoginMview extends BaseView{

    }
     interface LoginModel extends BaseModel{
         Observable<Webservice<List<StoreBean>>> Login(String url);
    }
}
