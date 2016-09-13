package com.example.admin.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by admin on 2016/9/13.
 */
public class SecondActivity extends Activity {
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);

        button2 = (Button) findViewById(R.id.button_2);
        Intent intent2 = getIntent();
        String data = intent2.getStringExtra("extra_data");
        button2.setText(data);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.mengzicheng.cn"));
                startActivity(intent);

            }
        });
        button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                intent.putExtra("data_return", "HELLO AGAIN");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
