package com.example.hcm_102_0006.demomvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.hcm_102_0006.demomvvm.databinding.ActivityfriendBinding;
import com.example.hcm_102_0006.demomvvm.model.ValueText;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainFriendActivity extends AppCompatActivity {

    private AdapterRecycleView adapterRecycleView;
    private ActivityfriendBinding binding;
    private List<ValueText> arrValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activityfriend);
        arrValues = new ArrayList<>();
        getFriendsList();
    }

    private List<String> getFriendsList() {
        final List<String> arrTemp = new ArrayList<>();
        Bundle params = new Bundle();
        params.putString("fields", "id,name");
        new GraphRequest(
                AccessToken.getCurrentAccessToken(), //loginResult.getAccessToken(),
                "/me/taggable_friends" +
                        "",
                params,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        arrValues.clear();
                        String showValues = "";
                        JSONObject object = response.getJSONObject();
                        try {
                            JSONArray arrayOfUsersInFriendList= object.getJSONArray("data");
                            Log.d("JSON",arrayOfUsersInFriendList.length()+"");
                            for (int i = 0 ; i < arrayOfUsersInFriendList.length(); i++){
                                JSONObject user = arrayOfUsersInFriendList.getJSONObject(i);
                                String usersName = user.getString("name");
                                String id  = user.getString("id");
                                arrValues.add(new ValueText(usersName));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        adapterRecycleView = new AdapterRecycleView(arrValues);
                        binding.recycleview.setLayoutManager(new LinearLayoutManager(MainFriendActivity.this));
                        binding.recycleview.setAdapter(adapterRecycleView);
                    }
                }

        ).executeAsync();

        return arrTemp;
    }
}
