package com.darthensondemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;

/**
 * Created by Warren on 2017/7/18.
 */

public class DartActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "BUNDLE_NAME";
    public static final String EXTRA_PHONE = "BUNDLE_PHONE";
    public static final String EXTRA_ADDRESS = "BUNDLE_ADDRESS";

    @InjectExtra(EXTRA_NAME) String name;
    @InjectExtra(EXTRA_PHONE) String phone;
    @InjectExtra(EXTRA_ADDRESS) String address;

//    @InjectExtra String name;
//    @InjectExtra String phone;
//    @InjectExtra String address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Dart.inject(this);

        TextView nameView = (TextView) findViewById(R.id.textView);
        TextView phoneView = (TextView) findViewById(R.id.textView2);
        TextView addressView = (TextView) findViewById(R.id.textView3);

        nameView.setText(name);
        phoneView.setText(phone);
        addressView.setText(address);
    }
}
