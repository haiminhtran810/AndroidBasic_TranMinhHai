package com.example.hcm_102_0006.android_advance2_facebook_mvp.view.login;

import android.content.Context;

/**
 * Created by hcm-102-0006 on 07/11/2017.
 */

public interface LoginView {
    Context getContext();
    void showToast(String mssg);
    void startProfileActivity();
}
