package com.example.admin215.twoactivityextraexample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button settingButton;
    public static final String SIZE_KEY = "size";
    public static final String COLOR_KEY = "color";
    Intent intent;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.text);
        settingButton = (Button) findViewById(R.id.setting_button);

        intent = new Intent(MainActivity.this, SettingActivity.class);

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int reqCode = RESULT_OK;
                startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) return;
        int color = data.getIntExtra(COLOR_KEY, 0);
        int size = data.getIntExtra(SIZE_KEY, 24);
        text.setTextSize(size);
        if (color == 1) text.setTextColor(Color.RED);
        if (color == 2) text.setTextColor(Color.GREEN);
        if (color == 3) text.setTextColor(Color.BLUE);
//        switch (color){
//            case 0:
//                text.setTextColor(Color.BLACK);
//                break;
//            case 1:
//                text.setTextColor(Color.RED);
//                break;
//            case 2:
//                text.setTextColor(Color.GREEN);
//                break;
//            case 3:
//                text.setTextColor(Color.BLUE);
//                break;
//        }

    }
}
