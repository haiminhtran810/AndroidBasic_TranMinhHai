package com.example.hcm_102_0006.android_advance2_facebook_mvp.view.login.ListFriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hcm_102_0006.android_advance2_facebook_mvp.R;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainFriendActivity extends AppCompatActivity  {

    private ListView lstShowFriend;
    private List<String> arrValues ;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_friend);
        lstShowFriend = findViewById(R.id.lstShowFriend);
        arrValues = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainFriendActivity.this,android.R.layout.simple_list_item_1,arrValues);
        lstShowFriend.setAdapter(adapter);
        getFriendsList();
    }

    private void getFriendsList() {
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
                                showValues += usersName + "\n";
                                arrValues.add(usersName);
                            }

                            adapter.notifyDataSetChanged();


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

        ).executeAsync();
    }

}
