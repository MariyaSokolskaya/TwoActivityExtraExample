package com.example.admin215.twoactivityextraexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SettingActivity extends AppCompatActivity {

    EditText textSize;
    Intent intent;
    int color=0, size=24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textSize = (EditText) findViewById(R.id.text_size);

        intent = new Intent(SettingActivity.this, MainActivity.class);


       // intent.putExtra(MainActivity.COLOR_KEY, color);
    }

    public void changeColor(View v){
        int idColor = v.getId();
        switch (idColor){
            case R.id.color1:
                color = 1; break;
            case R.id.color2:
                color = 2; break;
            case R.id.color3:
                color = 3; break;
        }
        intent.putExtra(MainActivity.COLOR_KEY, color);
        size = Integer.parseInt(textSize.getText().toString());
        intent.putExtra(MainActivity.SIZE_KEY, size);
        setResult(RESULT_OK, intent);
        finish();
    }
}
