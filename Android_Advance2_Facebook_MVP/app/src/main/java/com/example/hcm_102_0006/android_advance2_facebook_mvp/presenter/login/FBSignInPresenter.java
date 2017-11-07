package com.example.hcm_102_0006.android_advance2_facebook_mvp.presenter.login;

import android.content.Intent;

/**
 * Created by hcm-102-0006 on 07/11/2017.
 */

public interface FBSignInPresenter {
    void onActivityResult (int requestCode, int resultCode, Intent data);
    void logIn();
}
