package com.example.hcm_102_0006.demomvvm;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hcm_102_0006.demomvvm.viewModel.ClickListener;
import com.example.hcm_102_0006.demomvvm.databinding.DemoBinding;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    private CallbackManager callbackManager;
    private DemoBinding binding;
    private LoginButton loginButton;
    private ClickListener clickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        binding = DataBindingUtil.setContentView(this,R.layout.demo);
        clickListener = new ClickListener(this,callbackManager,loginButton);
        binding.setClickEvent(clickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        clickListener.onActivityResult(requestCode, resultCode, data);
    }
}
