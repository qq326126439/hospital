package com.example.hrd.myapplication.bean;

public class User {
    public static User user=null;
    private String Url;
    private String UserName;


    public static User getUser(){
        if(user==null){
            synchronized (User.class){
                user=new User();
            }
        }
        return user;
    }

    public static void setUser(User user) {
        User.user = user;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

}
