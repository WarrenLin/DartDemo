package com.darthensondemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.HensonNavigable;
import com.f2prateek.dart.InjectExtra;

/**
 * Created by Warren on 2017/7/18.
 */
@HensonNavigable(model = DartFragmentActivity.Model.class)
public class DartFragmentActivity extends AppCompatActivity {

    Model model = new Model();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Dart.inject(model, this);

        TextView nameView = (TextView) findViewById(R.id.textView);
        TextView phoneView = (TextView) findViewById(R.id.textView2);
        TextView addressView = (TextView) findViewById(R.id.textView3);

        nameView.setText(model.name);
        phoneView.setText(model.phone);
        addressView.setText(model.address);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment sampleFragment = getFragmentManager().findFragmentByTag("Fragment");
        if (sampleFragment == null) {
            getFragmentManager().beginTransaction()
                    .add(new SampleFragment(), "Fragment")
                    .commit();
        }
    }

    public static class Model{
        @InjectExtra String name;
        @InjectExtra String phone;
        @InjectExtra String address;
    }
}
