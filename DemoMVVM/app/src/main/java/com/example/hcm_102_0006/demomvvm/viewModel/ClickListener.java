package com.example.hcm_102_0006.demomvvm.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.hcm_102_0006.demomvvm.MainActivity;
import com.example.hcm_102_0006.demomvvm.MainFriendActivity;
import com.example.hcm_102_0006.demomvvm.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by hcm-102-0006 on 08/11/2017.
 */

public class ClickListener {

    private Activity context;

    private CallbackManager callbackManager;


    private LoginButton loginButton;


    public ClickListener(Activity context, CallbackManager callbackManager, LoginButton loginButton) {
        this.context = context;
        this.callbackManager = callbackManager;
        this.loginButton = loginButton;
    }


    public void onClickedFacebook() {
        loginButton = context.findViewById(R.id.btnAuthFacebook);
        loginButton.setReadPermissions("user_friends");
        loginButton.setReadPermissions("email");
        loginButton.setReadPermissions("public_profile");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(context, "onSuccess", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, MainFriendActivity.class));
            }

            @Override
            public void onCancel() {
                Toast.makeText(context, "onCancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(context, "onError", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
