package com.example.hcm_102_0006.android_retrofit_rxj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hcm_102_0006.android_retrofit_rxj.adapterRecycleView.AdapterRecycleView;
import com.example.hcm_102_0006.android_retrofit_rxj.model.GitHub;
import com.example.hcm_102_0006.android_retrofit_rxj.retrofit.GitHubFactory;
import com.example.hcm_102_0006.android_retrofit_rxj.retrofit.GitHubService;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static List<String> githubList = new ArrayList<String>() {{
        add("linkedin");
        add("tumblr");
        add("square");
        add("google");
        add("stripe");
        add("angular");
        add("facebook");
        add("rails");
    }};
    private Button btnClear, btnFetch;
    private RecyclerView recyclerView;
    private AdapterRecycleView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterRecycleView();
        recyclerView.setAdapter(adapter);
        btnClear = findViewById(R.id.btnClear);
        btnFetch = findViewById(R.id.btnFetch);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clearData();
            }
        });

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clearData();
                GitHubService service = GitHubFactory.createRetrofitService(GitHubService.class, GitHubService.SERVICE_ENDPOINT);
                for (String name : githubList) {
                    service.getUser(name)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<GitHub>() {
                                @Override
                                public void onCompleted() {
                                    Log.e("GitHubDemo", "Ok");
                                }

                                @Override
                                public void onError(Throwable e) {
                                    Log.e("GitHubDemo", e.getMessage());
                                }

                                @Override
                                public void onNext(GitHub gitHub) {
                                    adapter.addData(gitHub);
                                }
                            });
                }
            }
        });
    }
}
