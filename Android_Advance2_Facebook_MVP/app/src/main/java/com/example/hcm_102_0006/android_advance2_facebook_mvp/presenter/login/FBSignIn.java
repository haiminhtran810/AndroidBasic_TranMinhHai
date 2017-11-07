package com.example.hcm_102_0006.android_advance2_facebook_mvp.presenter.login;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.example.hcm_102_0006.android_advance2_facebook_mvp.view.login.LoginView;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hcm-102-0006 on 07/11/2017.
 */

public class FBSignIn implements FBSignInPresenter {
    private LoginView viewLogin;
    private CallbackManager callbackManager;
    private static final int RC_SIGN_IN_FB = 1916;
    private List<String> permissionNeeds = Arrays.asList("user_friends",
            "email", "public_profile");

    public FBSignIn(LoginView viewLogin) {
        this.viewLogin = viewLogin;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (FacebookSdk.isFacebookRequestCode(requestCode)) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }


    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

    @Override
    public void logIn() {
        //if(isLoggedIn()){
            FacebookCallback<LoginResult> callback = new CallBack();
            callbackManager = CallbackManager.Factory.create();

            LoginManager.getInstance().logInWithReadPermissions((Activity) viewLogin,
                    permissionNeeds);
            LoginManager.getInstance().registerCallback(callbackManager,callback);
        //}
    }


    private  class  CallBack implements FacebookCallback<LoginResult>{

        public CallBack ( ){
        }

        @Override
        public void onSuccess(LoginResult loginResult) {
            Log.d("JSON","onSuccess");
            viewLogin.showToast("onSuccess");
            viewLogin.startProfileActivity();
        }

        @Override
        public void onCancel() {
            Log.d("JSON","onCancel");
            viewLogin.showToast("onCancel");
        }

        @Override
        public void onError(FacebookException error) {
            Log.d("JSON","onError");
            viewLogin.showToast("onError");
        }
    }
}
