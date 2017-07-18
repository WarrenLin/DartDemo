package com.darthensondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.darthensondemo.Henson.with;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.button:{
                Intent intent = new Intent(MainActivity.this, OrgActivity.class);
                intent.putExtra(OrgActivity.EXTRA_NAME, "Warren");
                intent.putExtra(OrgActivity.EXTRA_ADDRESS, "Taipei");
                intent.putExtra(OrgActivity.EXTRA_PHONE, "+886");
                startActivity(intent);

//                OrgActivity.start(MainActivity.this, "Warren", "Taipei", "+886");
                break;
            }
            case R.id.button2:{
                startActivity(with(MainActivity.this)
                        .gotoDartActivity()
                        .BUNDLE_ADDRESS("Taipei")
                        .BUNDLE_NAME("Warren")
                        .BUNDLE_PHONE("+886")
                        .build());

//                startActivity(Henson.with(MainActivity.this)
//                        .gotoDartActivity()
//                        .address("Taipei")
//                        .name("Warren")
//                        .phone("+886")
//                        .build());
                break;
            }
            case R.id.button3:{
                Intent intent = with(MainActivity.this)
                        .gotoDartFragmentActivity()
                        .address("Taipei")
                        .name("Warren")
                        .phone("+886")
                        .build();

                Intent intentSampleFragment = with(MainActivity.this)
                        .gotoSampleFragment()
                        .foo("foo String")
                        .build();

                intent.putExtras(intentSampleFragment);
                startActivity(intent);
                break;
            }
            case R.id.button4:{
                Intent serviceIntent = Henson.with(MainActivity.this)
                        .gotoSampleService()
                        .stringExtra("Test String")
                        .build();

                startService(serviceIntent);
                break;
            }
        }
    }
}
