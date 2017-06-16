package com.york1996.mvp.view;

import com.york1996.mvp.bean.User;

/**
 * Created by York on 2017/6/16.
 */

public interface IUserLoginView {
    String getUsername();
    String getPassword();
    void cleanUsername();
    void cleanPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
