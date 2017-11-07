package com.example.hcm_102_0006.android_advance2_facebook_mvp.view.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hcm_102_0006.android_advance2_facebook_mvp.R;
import com.example.hcm_102_0006.android_advance2_facebook_mvp.presenter.login.FBSignIn;
import com.example.hcm_102_0006.android_advance2_facebook_mvp.view.login.ListFriend.MainFriendActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity implements LoginView {
    private TextView txtInformation;
    private LoginButton buttonFB;
    private CallbackManager callbackManager;
    private FBSignIn signInFBPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        signInFBPresenter = new FBSignIn(this);
        setContentView(R.layout.activity_main);
        txtInformation = findViewById(R.id.txtInformation);
        buttonFB = findViewById(R.id.btnLogin);
        buttonFB.setReadPermissions("user_friends",
                "email", "public_profile");
        buttonFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInFBPresenter.logIn();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        signInFBPresenter.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showToast(String mssg) {
        Toast.makeText(this, mssg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startProfileActivity() {
        startActivity(new Intent(MainActivity.this, MainFriendActivity.class));
    }
}
