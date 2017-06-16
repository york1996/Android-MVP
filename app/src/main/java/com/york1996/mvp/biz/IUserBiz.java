package com.york1996.mvp.biz;

/**
 * Created by York on 2017/6/16.
 */

public interface IUserBiz {
    public void login(String username,String password,OnLoginListener loginListener);
}
