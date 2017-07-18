package com.darthensondemo;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;

/**
 * Created by Warren on 2017/7/18.
 */

public class SampleService extends IntentService {
    private final String TAG = SampleService.class.getSimpleName();

    @InjectExtra String stringExtra;

    public SampleService() {
        super("SampleService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Dart.inject(this, intent.getExtras());
        Log.i(TAG, stringExtra);
    }

}
