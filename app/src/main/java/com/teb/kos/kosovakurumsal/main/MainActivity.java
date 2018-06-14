package com.teb.kos.kosovakurumsal.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.teb.kos.kosovakurumsal.R;
import com.teb.kos.kosovakurumsal.databinding.ActivityMainBinding;
import service.model.NetworkResponse;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        mainBinding.tvGetRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.sendContactMessage();
            }
        });
        mainViewModel.getContactResponseObservable().observe(this, new Observer<NetworkResponse>() {
            @Override
            public void onChanged(@Nullable NetworkResponse networkResponse) {
                Log.d("onChanged ","mainActivity observe: "+ networkResponse.getResult().getContactResult().toString());
                mainBinding.tvGetRequest.setText(networkResponse.getResult().getContactResult().toString());
            }
        });
    }

    private void initBinding() {
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
       // mainViewModel = new MainViewModel(this);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.init(this);
    }

}
