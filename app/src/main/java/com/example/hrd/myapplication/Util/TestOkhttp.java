package com.example.hrd.myapplication.Util;

import com.example.hrd.myapplication.bean.User;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TestOkhttp {
    public static TestOkhttp http;


    public static TestOkhttp Create(){
        if(http==null){
            synchronized (TestOkhttp.class){
                http=new TestOkhttp();
            }
        }
        return http;
    }

    public void Call() {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .url(User.getUser().getUrl())
                .post(body)
                .build();

//            Response response = client.newCall(request).execute();
//            return response.body().string();
    }

}
