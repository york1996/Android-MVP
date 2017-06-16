package com.york1996.mvp.biz;

import com.york1996.mvp.bean.User;

/**
 * Created by York on 2017/6/16.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
