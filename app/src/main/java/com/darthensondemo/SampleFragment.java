package com.darthensondemo;

import android.app.Fragment;
import android.content.Context;
import android.util.Log;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;

/**
 * Created by Warren on 2017/7/18.
 */

public class SampleFragment extends Fragment{
    private final String TAG = SampleFragment.class.getSimpleName();
    @InjectExtra String foo;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Dart.inject(this, getActivity());
        Log.i(TAG, foo);
    }
}
