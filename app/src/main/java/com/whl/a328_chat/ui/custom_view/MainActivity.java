package com.whl.a328_chat.ui.custom_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.whl.a328_chat.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MaterialEditText materialEditText = (MaterialEditText) findViewById(R.id.met);
        materialEditText.postDelayed(new Runnable() {
            @Override
            public void run() {
                materialEditText.setUseFloatingLabel(false);
            }
        }, 3000);
    }
}