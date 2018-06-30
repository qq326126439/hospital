package com.example.hrd.myapplication.ui.fragment.DetailConstracts;

import com.example.hrd.myapplication.bean.EquipmentBean;
import com.example.hrd.myapplication.http.BaseObserve;

import java.util.List;

public class DetailPresenter extends DetailConstracts.DetailPresenter{


    @Override
    public void onStart() {

    }


    @Override
    public void getList(String StoreId, String DepartmentId,String type,String Search) {
        mModel.getList(StoreId,DepartmentId,type,Search,"0").subscribe(new BaseObserve<List<EquipmentBean>>() {
            @Override
            public void onSuccess(String msg) {

            }

            @Override
            public void onSuccess(List<EquipmentBean> t) {
                mView.Updatea(t);
            }

            @Override
            public void onFailure(String s) {
                mView.showError(s);
            }
        });
    }

    @Override
    public void Search(String StoreId, String DepartmentId, String type, String Search) {
        mModel.getList(StoreId,DepartmentId,type,Search,"0").subscribe(new BaseObserve<List<EquipmentBean>>() {
            @Override
            public void onSuccess(String msg) {

            }

            @Override
            public void onSuccess(List<EquipmentBean> t) {
                mView.GotoDetail(t);
            }

            @Override
            public void onFailure(String s) {
                mView.showError(s);
            }
        });

    }
}
