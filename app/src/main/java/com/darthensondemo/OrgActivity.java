package com.darthensondemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Warren on 2017/7/18.
 */

public class OrgActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "BUNDLE_NAME";
    public static final String EXTRA_PHONE = "BUNDLE_PHONE";
    public static final String EXTRA_ADDRESS = "BUNDLE_ADDRESS";

    private String name, phone, address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Intent intent = getIntent();
        name = intent.getStringExtra(EXTRA_NAME);
        phone = intent.getStringExtra(EXTRA_PHONE);
        address = intent.getStringExtra(EXTRA_ADDRESS);

        TextView nameView = (TextView) findViewById(R.id.textView);
        TextView phoneView = (TextView) findViewById(R.id.textView2);
        TextView addressView = (TextView) findViewById(R.id.textView3);

        nameView.setText(name);
        phoneView.setText(phone);
        addressView.setText(address);

//        if (intent.hasExtra(EXTRA_NAME)) {
//            name = intent.getStringExtra(EXTRA_NAME);
//            nameView.setText(name);
//        }
//        if (intent.hasExtra(EXTRA_PHONE)) {
//            phone = intent.getStringExtra(EXTRA_PHONE);
//            phoneView.setText(phone);
//        }
//        if (intent.hasExtra(EXTRA_ADDRESS)) {
//            address = intent.getStringExtra(EXTRA_ADDRESS);
//            addressView.setText(address);
//        }
    }

    public static void start(Context context, String name, String phone, String address) {
        Intent starter = new Intent(context, OrgActivity.class);
        starter.putExtra(EXTRA_NAME, name);
        starter.putExtra(EXTRA_PHONE, phone);
        starter.putExtra(EXTRA_ADDRESS, address);
        context.startActivity(starter);
    }

}
